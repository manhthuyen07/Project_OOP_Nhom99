package vn.nhom99.mis.queries.ThanhVien2;

import vn.nhom99.mis.dao.*;
import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.*;
import vn.nhom99.mis.util.ConsoleTable;
import vn.nhom99.mis.util.Row;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/** Thành viên 2 - Câu 11 đến 15 (Java 8 Lambda & Stream API). */
public final class TruyVan11_15 {
    private final GiaSuDAO giaSuDAO;
    private final LopHocDAO lopHocDAO;
    private final DangKyDAO dangKyDAO;
    private final ThanhToanDAO thanhToanDAO;

    public TruyVan11_15(KhoDuLieu kho) {
        giaSuDAO = new GiaSuDAO(kho);
        lopHocDAO = new LopHocDAO(kho);
        dangKyDAO = new DangKyDAO(kho);
        thanhToanDAO = new ThanhToanDAO(kho);
    }

    // Câu 11 - Tính tổng tiền đã thanh toán
    // map lấy số tiền, reduce cộng BigDecimal (identity ZERO trả 0 khi không có giao dịch). Tiền không dùng double.
    public List<Row> cau11() {
        BigDecimal tong = thanhToanDAO.findAll().stream()
            .map(ThanhToan::getSoTien).reduce(BigDecimal.ZERO, BigDecimal::add);
        return Collections.singletonList(Row.of(tong));
    }

    // Câu 12 - Tính học phí trung bình của tất cả lớp học
    // BigDecimal không có average(): lấy tổng chia số lớp, làm tròn 2 chữ số HALF_UP; không có lớp thì trả 0.
    public List<Row> cau12() {
        List<LopHoc> lopHocs = lopHocDAO.findAll();
        BigDecimal tong = lopHocs.stream().map(LopHoc::getHocPhi).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal trungBinh = lopHocs.isEmpty() ? BigDecimal.ZERO
            : tong.divide(BigDecimal.valueOf(lopHocs.size()), 2, RoundingMode.HALF_UP);
        return Collections.singletonList(Row.of(trungBinh));
    }

    // Câu 13 - Kiểm tra hệ thống có lớp đang mở (DANG_MO)
    // anyMatch dừng ngay khi gặp phần tử đầu tiên thỏa; tương đương Any của LINQ.
    public List<Row> cau13() {
        boolean coLopDangMo = lopHocDAO.findAll().stream()
            .anyMatch(l -> l.getTrangThai() == TrangThaiLop.DANG_MO);
        return Collections.singletonList(Row.of(ConsoleTable.coKhong(coLopDangMo)));
    }

    // Câu 14 - Mọi lớp của gia sư GS01 đều có ít nhất 2 học viên?
    // allMatch tương đương All của LINQ. Gia sư không có lớp nào thì allMatch trả true, nên in kèm số lớp để thấy rõ.
    public List<Row> cau14() {
        String maGS = "GS01";
        int toiThieu = 2;
        List<LopHoc> lopCuaGiaSu = lopHocDAO.findAll().stream()
            .filter(l -> l.getGiaSu().getMaGS().equals(maGS)).collect(toList());
        boolean tatCaDat = lopCuaGiaSu.stream().allMatch(l -> demHocVien(l) >= toiThieu);
        return Collections.singletonList(Row.of(maGS, lopCuaGiaSu.size(), toiThieu, ConsoleTable.coKhong(tatCaDat)));
    }

    private long demHocVien(LopHoc lop) {
        return dangKyDAO.findAll().stream()
            .filter(dk -> dk.getLopHoc().getMaLop().equals(lop.getMaLop())).count();
    }

    // Câu 15 - Không có gia sư nào lương theo giờ vượt 300.000?
    // noneMatch tương đương !Any; so sánh BigDecimal bằng compareTo, không dùng > hay equals.
    public List<Row> cau15() {
        BigDecimal mucLuong = new BigDecimal("300000");
        boolean khongAiVuot = giaSuDAO.findAll().stream()
            .noneMatch(gs -> gs.getLuongGio().compareTo(mucLuong) > 0);
        return Collections.singletonList(Row.of(mucLuong, ConsoleTable.coKhong(khongAiVuot)));
    }
}
