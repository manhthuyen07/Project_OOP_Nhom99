package vn.nhom99.mis.queries.ThanhVien1;

import vn.nhom99.mis.dao.DangKyDAO;
import vn.nhom99.mis.dao.HocVienDAO;
import vn.nhom99.mis.dao.LopHocDAO;
import vn.nhom99.mis.dao.ThanhToanDAO;
import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.DangKy;
import vn.nhom99.mis.model.HocVien;
import vn.nhom99.mis.model.LopHoc;
import vn.nhom99.mis.model.ThanhToan;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TruyVan06_10 {
    private final HocVienDAO hocVienDAO;
    private final LopHocDAO lopHocDAO;
    private final DangKyDAO dangKyDAO;
    private final ThanhToanDAO thanhToanDAO;

    public TruyVan06_10(KhoDuLieu kho) {
        this.hocVienDAO = new HocVienDAO(kho);
        this.lopHocDAO = new LopHocDAO(kho);
        this.dangKyDAO = new DangKyDAO(kho);
        this.thanhToanDAO = new ThanhToanDAO(kho);
    }

    /** Câu 06: Tổng doanh thu (tổng tiền đã thanh toán) của từng lớp, giảm dần. Lớp chưa thu đồng nào hiện 0. */
    public Map<String, Double> cau06_DoanhThuTheoLop() {
        Map<String, String> dangKyToLop = dangKyDAO.getAll().stream()
                .collect(Collectors.toMap(DangKy::getMaDangKy, DangKy::getMaLop));

        Map<String, Double> tongTheoMaLop = thanhToanDAO.getAll().stream()
                .collect(Collectors.groupingBy(
                        t -> dangKyToLop.get(t.getMaDangKy()),
                        Collectors.summingDouble(ThanhToan::getSoTien)));

        return lopHocDAO.getAll().stream()
                .sorted(Comparator.comparingDouble(
                        (LopHoc l) -> tongTheoMaLop.getOrDefault(l.getMaLop(), 0.0)).reversed())
                .collect(Collectors.toMap(
                        LopHoc::getTenLop,
                        l -> tongTheoMaLop.getOrDefault(l.getMaLop(), 0.0),
                        (a, b) -> a,
                        LinkedHashMap::new));
    }

    /** Câu 07: Học viên chưa đóng đồng học phí nào (không có bản ghi thanh toán cho bất kỳ đăng ký nào). */
    public List<HocVien> cau07_HocVienChuaThanhToan() {
        Set<String> dangKyDaTra = thanhToanDAO.getAll().stream()
                .map(ThanhToan::getMaDangKy)
                .collect(Collectors.toSet());

        Set<String> hocVienDaTra = dangKyDAO.getAll().stream()
                .filter(d -> dangKyDaTra.contains(d.getMaDangKy()))
                .map(DangKy::getMaHocVien)
                .collect(Collectors.toSet());

        return hocVienDAO.getAll().stream()
                .filter(h -> !hocVienDaTra.contains(h.getMaHocVien()))
                .collect(Collectors.toList());
    }

    /** Câu 08: Lớp có nhiều học viên đăng ký nhất (nếu đồng hạng thì trả về tất cả). */
    public Map<LopHoc, Long> cau08_LopDongHocVienNhat() {
        Map<String, Long> demTheoLop = dangKyDAO.getAll().stream()
                .collect(Collectors.groupingBy(DangKy::getMaLop, Collectors.counting()));

        long max = demTheoLop.values().stream().mapToLong(Long::longValue).max().orElse(0);

        return lopHocDAO.getAll().stream()
                .filter(l -> demTheoLop.getOrDefault(l.getMaLop(), 0L) == max && max > 0)
                .collect(Collectors.toMap(
                        l -> l,
                        l -> demTheoLop.get(l.getMaLop()),
                        (a, b) -> a,
                        LinkedHashMap::new));
    }

    /** Câu 09: Học phí trung bình theo từng môn học (sắp theo tên môn). */
    public Map<String, Double> cau09_HocPhiTrungBinhTheoMon() {
        return lopHocDAO.getAll().stream()
                .collect(Collectors.groupingBy(
                        LopHoc::getMonHoc,
                        TreeMap::new,
                        Collectors.averagingDouble(LopHoc::getHocPhi)));
    }

    /** Câu 10: Top 3 học viên đóng học phí nhiều nhất (tổng tiền các lần thanh toán). */
    public Map<String, Double> cau10_Top3HocVienDongNhieuNhat() {
        Map<String, String> dangKyToHocVien = dangKyDAO.getAll().stream()
                .collect(Collectors.toMap(DangKy::getMaDangKy, DangKy::getMaHocVien));

        Map<String, Double> tongTheoHocVien = thanhToanDAO.getAll().stream()
                .collect(Collectors.groupingBy(
                        t -> dangKyToHocVien.get(t.getMaDangKy()),
                        Collectors.summingDouble(ThanhToan::getSoTien)));

        return tongTheoHocVien.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(
                        e -> hocVienDAO.TimTheoMa(e.getKey()).map(HocVien::getHoTen).orElse(e.getKey()),
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new));
    }
}
