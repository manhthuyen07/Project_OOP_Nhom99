package vn.nhom99.mis.data;

import vn.nhom99.mis.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

final class DuLieuMau {
    private DuLieuMau() { }
    static List<GiaSu> giaSu() {
        return Arrays.asList(
                new GiaSu("GS01", "Nguyễn Văn An", TrinhDo.DAI_HOC, 3, new BigDecimal("150000")),
                new GiaSu("GS02", "Trần Minh Bình", TrinhDo.THAC_SI, 5, new BigDecimal("200000")),
                new GiaSu("GS03", "Lê Hoàng Nam", TrinhDo.DAI_HOC, 2, new BigDecimal("120000")),
                new GiaSu("GS04", "Phạm Thu Hà", TrinhDo.TIEN_SI, 8, new BigDecimal("300000")),
                new GiaSu("GS05", "Võ Minh Đức", TrinhDo.THAC_SI, 6, new BigDecimal("180000")));
    }
    static List<HocVien> hocVien() {
        return Arrays.asList(
                new HocVien("HV01", "Nguyễn Minh Anh", 2008, "0901000001"),
                new HocVien("HV02", "Trần Gia Huy", 2009, "0901000002"),
                new HocVien("HV03", "Lê Khánh Linh", 2008, "0901000003"),
                new HocVien("HV04", "Phạm Hoàng Long", 2007, "0901000004"),
                new HocVien("HV05", "Võ Ngọc Mai", 2009, "0901000005"),
                new HocVien("HV06", "Đặng Minh Khang", 2010, "0901000006")); // chưa đăng ký lớp nào
    }
    static List<LopHoc> lopHoc(List<GiaSu> gs) {
        return Arrays.asList(
                new LopHoc("L01", "Toán 10A", "Toán", new BigDecimal("1500000"), TrangThaiLop.DANG_MO, gs.get(0)),
                new LopHoc("L02", "Toán 11A", "Toán", new BigDecimal("1700000"), TrangThaiLop.DANG_MO, gs.get(1)),
                new LopHoc("L03", "Anh Văn 10A", "Tiếng Anh", new BigDecimal("1400000"), TrangThaiLop.DA_DU, gs.get(2)),
                new LopHoc("L04", "Vật Lý 12A", "Vật Lý", new BigDecimal("1800000"), TrangThaiLop.DA_KET_THUC, gs.get(3)),
                new LopHoc("L05", "Hóa 11A", "Hóa học", new BigDecimal("1600000"), TrangThaiLop.TAM_NGUNG, gs.get(4)),
                // Hai lớp thêm để GS01 và GS02 phụ trách nhiều lớp
                new LopHoc("L06", "Toán 12A", "Toán", new BigDecimal("1900000"), TrangThaiLop.DANG_MO, gs.get(0)),
                new LopHoc("L07", "Toán 9A", "Toán", new BigDecimal("1300000"), TrangThaiLop.DANG_MO, gs.get(1)));
    }
    static List<DangKy> dangKy(List<HocVien> hv, List<LopHoc> l) {
        return Arrays.asList(
                new DangKy(hv.get(0), l.get(0), LocalDate.of(2026, 8, 25)),
                new DangKy(hv.get(0), l.get(1), LocalDate.of(2026, 8, 26)), // HV01 học nhiều lớp
                new DangKy(hv.get(1), l.get(0), LocalDate.of(2026, 8, 27)),
                new DangKy(hv.get(1), l.get(2), LocalDate.of(2026, 9, 1)),
                new DangKy(hv.get(2), l.get(0), LocalDate.of(2026, 9, 2)),  // L01 có nhiều học viên
                new DangKy(hv.get(2), l.get(5), LocalDate.of(2026, 9, 3)),
                new DangKy(hv.get(3), l.get(5), LocalDate.of(2026, 9, 6)),
                new DangKy(hv.get(3), l.get(1), LocalDate.of(2026, 9, 5)),
                new DangKy(hv.get(3), l.get(3), LocalDate.of(2026, 5, 10)),
                new DangKy(hv.get(4), l.get(4), LocalDate.of(2026, 6, 15)),
                new DangKy(hv.get(4), l.get(6), LocalDate.of(2026, 9, 10)));
    }
    static List<ThanhToan> thanhToan(List<HocVien> hv, List<LopHoc> l) {
        return Arrays.asList(
                new ThanhToan("TT01", hv.get(0), l.get(0), new BigDecimal("1500000"), LocalDate.of(2026, 8, 28)), // đủ học phí
                new ThanhToan("TT02", hv.get(0), l.get(1), new BigDecimal("1000000"), LocalDate.of(2026, 9, 1)),  // trả nhiều lần
                new ThanhToan("TT03", hv.get(0), l.get(1), new BigDecimal("700000"), LocalDate.of(2026, 9, 20)),
                new ThanhToan("TT04", hv.get(1), l.get(0), new BigDecimal("800000"), LocalDate.of(2026, 9, 3)),   // mới trả một phần
                new ThanhToan("TT05", hv.get(1), l.get(2), new BigDecimal("1400000"), LocalDate.of(2026, 9, 4)),
                new ThanhToan("TT06", hv.get(2), l.get(0), new BigDecimal("1500000"), LocalDate.of(2026, 10, 2)),
                new ThanhToan("TT07", hv.get(2), l.get(5), new BigDecimal("900000"), LocalDate.of(2026, 10, 5)),
                new ThanhToan("TT08", hv.get(3), l.get(1), new BigDecimal("1700000"), LocalDate.of(2026, 9, 8)),
                new ThanhToan("TT09", hv.get(3), l.get(3), new BigDecimal("1800000"), LocalDate.of(2026, 5, 12)),
                new ThanhToan("TT10", hv.get(4), l.get(4), new BigDecimal("1600000"), LocalDate.of(2026, 6, 18)),
                new ThanhToan("TT11", hv.get(4), l.get(6), new BigDecimal("650000"), LocalDate.of(2026, 9, 12)));
    }
}
