package vn.nhom99.mis.queries.ThanhVien2;

import vn.nhom99.mis.dao.DangKyDAO;
import vn.nhom99.mis.dao.GiaSuDAO;
import vn.nhom99.mis.dao.HocVienDAO;
import vn.nhom99.mis.dao.LopHocDAO;
import vn.nhom99.mis.dao.ThanhToanDAO;
import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.DangKy;
import vn.nhom99.mis.model.GiaSu;
import vn.nhom99.mis.model.HocVien;
import vn.nhom99.mis.model.LopHoc;
import vn.nhom99.mis.model.ThanhToan;

import java.time.YearMonth;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/** Thành viên 2 - Câu 16 đến 20 (Java 8 Lambda & Stream API). */
public class TruyVan16_20 {
    private final GiaSuDAO giaSuDAO;
    private final HocVienDAO hocVienDAO;
    private final LopHocDAO lopHocDAO;
    private final DangKyDAO dangKyDAO;
    private final ThanhToanDAO thanhToanDAO;

    public TruyVan16_20(KhoDuLieu kho) {
        this.giaSuDAO = new GiaSuDAO(kho);
        this.hocVienDAO = new HocVienDAO(kho);
        this.lopHocDAO = new LopHocDAO(kho);
        this.dangKyDAO = new DangKyDAO(kho);
        this.thanhToanDAO = new ThanhToanDAO(kho);
    }
    //Câu 16: Học viên đăng ký từ {@code toiThieu} lớp (khác nhau) trở lên, kèm số lớp, giảm dần theo số lớp rồi theo mã.
    public Map<HocVien, Long> cau16_HocVienDangKyTuNLop(int toiThieu) {
        Map<String, Long> soLop = dangKyDAO.getAll().stream()
                .collect(Collectors.groupingBy(
                        DangKy::getMaHocVien,
                        Collectors.mapping(DangKy::getMaLop,
                                Collectors.collectingAndThen(Collectors.toSet(), set -> (long) set.size()))));
        return hocVienDAO.getAll().stream()
                .filter(h -> soLop.getOrDefault(h.getMaHocVien(), 0L) >= toiThieu)
                .sorted(Comparator.comparing((HocVien h) -> soLop.get(h.getMaHocVien())).reversed()
                        .thenComparing(HocVien::getMaHocVien))
                .collect(Collectors.toMap(
                        h -> h,
                        h -> soLop.get(h.getMaHocVien()),
                        (a, b) -> a,
                        LinkedHashMap::new));
    }

    //Câu 17: Tất cả học viên (không trùng) đang học các lớp do một gia sư phụ trách.
    public List<HocVien> cau17_HocVienCuaGiaSu(String maGiaSu) {
        Set<String> maHocVien = lopHocDAO.getAll().stream()
                .filter(l -> maGiaSu.equals(l.getMaGiaSu()))
                .flatMap(l -> dangKyDAO.getAll().stream()
                        .filter(d -> d.getMaLop().equals(l.getMaLop())))
                .map(DangKy::getMaHocVien)
                .collect(Collectors.toSet());

        return hocVienDAO.getAll().stream()
                .filter(h -> maHocVien.contains(h.getMaHocVien()))
                .sorted(Comparator.comparing(HocVien::getMaHocVien))
                .collect(Collectors.toList());
    }

    /** Câu 18: Học viên chưa đăng ký bất kỳ lớp nào. */
    public List<HocVien> cau18_HocVienChuaDangKy() {
        Set<String> daDangKy = dangKyDAO.getAll().stream()
                .map(DangKy::getMaHocVien)
                .collect(Collectors.toSet());
        return hocVienDAO.getAll().stream()
                .filter(h -> !daDangKy.contains(h.getMaHocVien()))
                .sorted(Comparator.comparing(HocVien::getMaHocVien))
                .collect(Collectors.toList());
    }

    /** Câu 19: Doanh thu theo tháng. groupingBy theo YearMonth, TreeMap giữ thứ tự thời gian. */
    public Map<YearMonth, Double> cau19_DoanhThuTheoThang() {
        return thanhToanDAO.getAll().stream()
                .collect(Collectors.groupingBy(
                        t -> YearMonth.from(t.getNgayThanhToan()),
                        TreeMap::new,
                        Collectors.summingDouble(ThanhToan::getSoTien)));
    }

    /** Câu 20: Thống kê học phí (số lớp, thấp nhất, cao nhất, trung bình, tổng) bằng summaryStatistics. */
    public DoubleSummaryStatistics cau20_ThongKeHocPhi() {
        return lopHocDAO.getAll().stream()
                .mapToDouble(LopHoc::getHocPhi)
                .summaryStatistics();
    }
}