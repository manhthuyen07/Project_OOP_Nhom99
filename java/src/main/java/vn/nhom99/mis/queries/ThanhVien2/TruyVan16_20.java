package vn.nhom99.mis.queries.ThanhVien2;

import vn.nhom99.mis.dao.*;
import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.*;
import vn.nhom99.mis.util.Row;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.YearMonth;
import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public final class TruyVan16_20 {
    private final GiaSuDAO giaSuDAO;
    private final HocVienDAO hocVienDAO;
    private final LopHocDAO lopHocDAO;
    private final DangKyDAO dangKyDAO;
    private final ThanhToanDAO thanhToanDAO;

    public TruyVan16_20(KhoDuLieu kho) {
        giaSuDAO = new GiaSuDAO(kho);
        hocVienDAO = new HocVienDAO(kho);
        lopHocDAO = new LopHocDAO(kho);
        dangKyDAO = new DangKyDAO(kho);
        thanhToanDAO = new ThanhToanDAO(kho);
    }

    // Câu 16 - Đếm số lớp của từng gia sư
    public List<Row> cau16() {
        Map<String, Long> soLop = lopHocDAO.findAll().stream()
                .collect(groupingBy(l -> l.getGiaSu().getMaGS(), counting()));
        Function<GiaSu, Long> dem = gs -> soLop.getOrDefault(gs.getMaGS(), 0L);
        return giaSuDAO.findAll().stream()
                .sorted(Comparator.comparing(dem).reversed().thenComparing(GiaSu::getMaGS))
                .map(gs -> Row.of(gs.getMaGS(), gs.getHoTen(), dem.apply(gs))).collect(toList());
    }

    // Câu 17 - Tất cả học viên đang học các lớp do gia sư GS01 phụ trách
    public List<Row> cau17() {
        String maGS = "GS01";
        return lopHocDAO.findAll().stream()
                .filter(l -> l.getGiaSu().getMaGS().equals(maGS))
                .flatMap(l -> dangKyDAO.findAll().stream()
                        .filter(dk -> dk.getLopHoc().getMaLop().equals(l.getMaLop()))
                        .map(DangKy::getHocVien))
                .distinct()
                .sorted(Comparator.comparing(HocVien::getMaHV))
                .map(hv -> Row.of(hv.getMaHV(), hv.getHoTen(), hv.getNamSinh(), hv.getSoDienThoai())).collect(toList());
    }

    // Câu 18 - Học viên chưa đăng ký bất kỳ lớp nào
    public List<Row> cau18() {
        Set<String> daDangKy = dangKyDAO.findAll().stream()
                .map(dk -> dk.getHocVien().getMaHV()).collect(toSet());
        return hocVienDAO.findAll().stream()
                .filter(hv -> !daDangKy.contains(hv.getMaHV()))
                .sorted(Comparator.comparing(HocVien::getMaHV))
                .map(hv -> Row.of(hv.getMaHV(), hv.getHoTen())).collect(toList());
    }

    // Câu 19 - Doanh thu theo tháng
    public List<Row> cau19() {
        Map<YearMonth, BigDecimal> theoThang = thanhToanDAO.findAll().stream()
                .collect(groupingBy(tt -> YearMonth.from(tt.getNgayThanhToan()), TreeMap::new,
                        reducing(BigDecimal.ZERO, ThanhToan::getSoTien, BigDecimal::add)));
        return theoThang.entrySet().stream()
                .map(e -> Row.of(e.getKey().getYear(), e.getKey().getMonthValue(), e.getValue())).collect(toList());
    }

    // Câu 20 - Thống kê học phí: số lớp, thấp nhất, cao nhất, trung bình, tổng
    public List<Row> cau20() {
        LongSummaryStatistics st = lopHocDAO.findAll().stream()
                .mapToLong(l -> l.getHocPhi().longValueExact()).summaryStatistics();
        if (st.getCount() == 0) return Collections.emptyList();
        BigDecimal tong = BigDecimal.valueOf(st.getSum());
        BigDecimal trungBinh = tong.divide(BigDecimal.valueOf(st.getCount()), 2, RoundingMode.HALF_UP);
        return Collections.singletonList(Row.of(st.getCount(), BigDecimal.valueOf(st.getMin()),
                BigDecimal.valueOf(st.getMax()), trungBinh, tong));
    }
}
