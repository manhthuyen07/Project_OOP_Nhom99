package vn.nhom99.mis.queries.ThanhVien1;

import vn.nhom99.mis.dao.DangKyDAO;
import vn.nhom99.mis.dao.GiaSuDAO;
import vn.nhom99.mis.dao.HocVienDAO;
import vn.nhom99.mis.dao.LopHocDAO;
import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.GiaSu;
import vn.nhom99.mis.model.HocVien;
import vn.nhom99.mis.model.LopHoc;
import vn.nhom99.mis.model.TrangThaiLop;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TruyVan01_05 {
    private final GiaSuDAO giaSuDAO;
    private final HocVienDAO hocVienDAO;
    private final LopHocDAO lopHocDAO;
    private final DangKyDAO dangKyDAO;

    public TruyVan01_05(KhoDuLieu kho) {
        this.giaSuDAO = new GiaSuDAO(kho);
        this.hocVienDAO = new HocVienDAO(kho);
        this.lopHocDAO = new LopHocDAO(kho);
        this.dangKyDAO = new DangKyDAO(kho);
    }

    /** Câu 01: Liệt kê các lớp đang mở, sắp xếp theo học phí giảm dần. */
    public List<LopHoc> cau01_LopDangMoTheoHocPhiGiam() {
        return lopHocDAO.getAll().stream()
                .filter(l -> l.getTrangThai() == TrangThaiLop.DANG_MO)
                .sorted(Comparator.comparingDouble(LopHoc::getHocPhi).reversed())
                .collect(Collectors.toList());
    }

    /** Câu 02: Liệt kê gia sư có số năm kinh nghiệm lớn hơn một ngưỡng (mặc định 3), giảm dần theo kinh nghiệm. */
    public List<GiaSu> cau02_GiaSuKinhNghiemTren(int soNam) {
        return giaSuDAO.getAll().stream()
                .filter(g -> g.getSoNamKinhNghiem() > soNam)
                .sorted(Comparator.comparingInt(GiaSu::getSoNamKinhNghiem).reversed())
                .collect(Collectors.toList());
    }

    /** Câu 03: Danh sách lớp học kèm tên gia sư phụ trách (kết bảng LopHoc - GiaSu). */
    public List<String> cau03_LopKemTenGiaSu() {
        return lopHocDAO.getAll().stream()
                .map(l -> l.getMaLop() + " | " + l.getTenLop() + " | Gia sư: "
                        + giaSuDAO.TimTheoMa(l.getMaGiaSu()).map(GiaSu::getHoTen).orElse("(chưa phân công)"))
                .collect(Collectors.toList());
    }

    /** Câu 04: Đếm số lớp mà mỗi gia sư phụ trách (gia sư chưa có lớp vẫn hiện, số lớp = 0). */
    public Map<String, Long> cau04_SoLopMoiGiaSu() {
        return giaSuDAO.getAll().stream()
                .collect(Collectors.toMap(
                        GiaSu::getHoTen,
                        g -> lopHocDAO.getAll().stream()
                                .filter(l -> l.getMaGiaSu().equals(g.getMaGiaSu()))
                                .count(),
                        (a, b) -> a,
                        LinkedHashMap::new));
    }

    /** Câu 05: Liệt kê (không trùng) các học viên đã đăng ký lớp của một môn học (kết bảng DangKy - LopHoc - HocVien). */
    public List<HocVien> cau05_HocVienDangKyMon(String monHoc) {
        Set<String> maLopCuaMon = lopHocDAO.getAll().stream()
                .filter(l -> l.getMonHoc().equalsIgnoreCase(monHoc))
                .map(LopHoc::getMaLop)
                .collect(Collectors.toSet());

        Set<String> maHocVien = dangKyDAO.getAll().stream()
                .filter(d -> maLopCuaMon.contains(d.getMaLop()))
                .map(d -> d.getMaHocVien())
                .collect(Collectors.toSet());

        return hocVienDAO.getAll().stream()
                .filter(h -> maHocVien.contains(h.getMaHocVien()))
                .collect(Collectors.toList());
    }
}
