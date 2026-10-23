package vn.nhom99.mis.data;

import vn.nhom99.mis.model.DangKy;
import vn.nhom99.mis.model.GiaSu;
import vn.nhom99.mis.model.HocVien;
import vn.nhom99.mis.model.LopHoc;
import vn.nhom99.mis.model.ThanhToan;
import vn.nhom99.mis.model.TrangThaiLop;
import vn.nhom99.mis.model.TrinhDo;

import java.time.LocalDate;

/**
 * Dữ liệu mẫu. Được thiết kế để cả 10 câu truy vấn đều có kết quả, gồm cả các trường hợp biên:
 * gia sư chưa dạy lớp nào (GS05), học viên chưa đóng tiền (HV06, HV08), lớp đã hủy (L07) chưa có ai đăng ký.
 */
public final class DuLieuMau {
    private DuLieuMau() {
    }

    public static void nap(KhoDuLieu kho) {
        // ===== Gia sư =====
        kho.getDsGiaSu().add(new GiaSu("GS01", "Nguyễn Văn An", "Toán", 5, "0901000001"));
        kho.getDsGiaSu().add(new GiaSu("GS02", "Trần Thị Bình", "Tiếng Anh", 3, "0901000002"));
        kho.getDsGiaSu().add(new GiaSu("GS03", "Lê Hoàng Cường", "Vật lý", 8, "0901000003"));
        kho.getDsGiaSu().add(new GiaSu("GS04", "Phạm Thu Dung", "Toán", 2, "0901000004"));
        kho.getDsGiaSu().add(new GiaSu("GS05", "Võ Minh Em", "Hóa học", 4, "0901000005"));

        // ===== Học viên =====
        kho.getDsHocVien().add(new HocVien("HV01", "Đặng Gia Huy", LocalDate.of(2010, 3, 12), "Nam", "0912000001"));
        kho.getDsHocVien().add(new HocVien("HV02", "Ngô Bảo Châu", LocalDate.of(2009, 7, 25), "Nữ", "0912000002"));
        kho.getDsHocVien().add(new HocVien("HV03", "Bùi Quang Khải", LocalDate.of(2008, 11, 2), "Nam", "0912000003"));
        kho.getDsHocVien().add(new HocVien("HV04", "Hoàng Thanh Lam", LocalDate.of(2010, 1, 30), "Nữ", "0912000004"));
        kho.getDsHocVien().add(new HocVien("HV05", "Đỗ Minh Nhật", LocalDate.of(2009, 5, 18), "Nam", "0912000005"));
        kho.getDsHocVien().add(new HocVien("HV06", "Lý Ngọc Oanh", LocalDate.of(2008, 9, 9), "Nữ", "0912000006"));
        kho.getDsHocVien().add(new HocVien("HV07", "Phan Anh Phúc", LocalDate.of(2007, 12, 21), "Nam", "0912000007"));
        kho.getDsHocVien().add(new HocVien("HV08", "Trương Mỹ Quyên", LocalDate.of(2010, 6, 6), "Nữ", "0912000008"));

        // ===== Lớp học =====
        kho.getDsLopHoc().add(new LopHoc("L01", "Toán 9 Cơ bản", "Toán", TrinhDo.CO_BAN, "GS01",
                2_000_000, 10, LocalDate.of(2026, 9, 1), TrangThaiLop.DANG_HOC));
        kho.getDsLopHoc().add(new LopHoc("L02", "Toán 12 Luyện thi", "Toán", TrinhDo.NANG_CAO, "GS01",
                3_500_000, 8, LocalDate.of(2026, 9, 15), TrangThaiLop.DANG_MO));
        kho.getDsLopHoc().add(new LopHoc("L03", "IELTS Foundation", "Tiếng Anh", TrinhDo.CO_BAN, "GS02",
                2_800_000, 12, LocalDate.of(2026, 8, 20), TrangThaiLop.DANG_HOC));
        kho.getDsLopHoc().add(new LopHoc("L04", "IELTS 6.5+", "Tiếng Anh", TrinhDo.NANG_CAO, "GS02",
                4_200_000, 10, LocalDate.of(2026, 10, 1), TrangThaiLop.DANG_MO));
        kho.getDsLopHoc().add(new LopHoc("L05", "Vật lý 11", "Vật lý", TrinhDo.TRUNG_CAP, "GS03",
                2_500_000, 10, LocalDate.of(2026, 7, 1), TrangThaiLop.DA_KET_THUC));
        kho.getDsLopHoc().add(new LopHoc("L06", "Toán 10", "Toán", TrinhDo.TRUNG_CAP, "GS04",
                2_200_000, 8, LocalDate.of(2026, 10, 10), TrangThaiLop.DANG_MO));
        kho.getDsLopHoc().add(new LopHoc("L07", "Vật lý 12 Nâng cao", "Vật lý", TrinhDo.NANG_CAO, "GS03",
                3_000_000, 6, LocalDate.of(2026, 11, 1), TrangThaiLop.DA_HUY));

        // ===== Đăng ký =====
        kho.getDsDangKy().add(new DangKy("DK01", "HV01", "L01", LocalDate.of(2026, 8, 25)));
        kho.getDsDangKy().add(new DangKy("DK02", "HV02", "L01", LocalDate.of(2026, 8, 26)));
        kho.getDsDangKy().add(new DangKy("DK03", "HV03", "L01", LocalDate.of(2026, 8, 28)));
        kho.getDsDangKy().add(new DangKy("DK04", "HV01", "L03", LocalDate.of(2026, 8, 10)));
        kho.getDsDangKy().add(new DangKy("DK05", "HV04", "L03", LocalDate.of(2026, 8, 12)));
        kho.getDsDangKy().add(new DangKy("DK06", "HV05", "L03", LocalDate.of(2026, 8, 15)));
        kho.getDsDangKy().add(new DangKy("DK07", "HV02", "L02", LocalDate.of(2026, 9, 5)));
        kho.getDsDangKy().add(new DangKy("DK08", "HV06", "L02", LocalDate.of(2026, 9, 8)));
        kho.getDsDangKy().add(new DangKy("DK09", "HV07", "L04", LocalDate.of(2026, 9, 20)));
        kho.getDsDangKy().add(new DangKy("DK10", "HV08", "L04", LocalDate.of(2026, 9, 22)));
        kho.getDsDangKy().add(new DangKy("DK11", "HV03", "L05", LocalDate.of(2026, 6, 20)));
        kho.getDsDangKy().add(new DangKy("DK12", "HV05", "L05", LocalDate.of(2026, 6, 22)));
        kho.getDsDangKy().add(new DangKy("DK13", "HV01", "L06", LocalDate.of(2026, 10, 2)));
        kho.getDsDangKy().add(new DangKy("DK14", "HV06", "L06", LocalDate.of(2026, 10, 3)));
        kho.getDsDangKy().add(new DangKy("DK15", "HV07", "L03", LocalDate.of(2026, 8, 18)));

        // ===== Thanh toán =====
        kho.getDsThanhToan().add(new ThanhToan("TT01", "DK01", 2_000_000, LocalDate.of(2026, 8, 25), "Tiền mặt"));
        kho.getDsThanhToan().add(new ThanhToan("TT02", "DK02", 1_000_000, LocalDate.of(2026, 8, 26), "Chuyển khoản"));
        kho.getDsThanhToan().add(new ThanhToan("TT03", "DK02", 1_000_000, LocalDate.of(2026, 9, 26), "Chuyển khoản"));
        kho.getDsThanhToan().add(new ThanhToan("TT04", "DK04", 2_800_000, LocalDate.of(2026, 8, 10), "Chuyển khoản"));
        kho.getDsThanhToan().add(new ThanhToan("TT05", "DK05", 2_800_000, LocalDate.of(2026, 8, 12), "Tiền mặt"));
        kho.getDsThanhToan().add(new ThanhToan("TT06", "DK07", 3_500_000, LocalDate.of(2026, 9, 5), "Chuyển khoản"));
        kho.getDsThanhToan().add(new ThanhToan("TT07", "DK09", 4_200_000, LocalDate.of(2026, 9, 20), "Chuyển khoản"));
        kho.getDsThanhToan().add(new ThanhToan("TT08", "DK11", 2_500_000, LocalDate.of(2026, 6, 20), "Tiền mặt"));
        kho.getDsThanhToan().add(new ThanhToan("TT09", "DK12", 1_500_000, LocalDate.of(2026, 6, 22), "Tiền mặt"));
    }
}
