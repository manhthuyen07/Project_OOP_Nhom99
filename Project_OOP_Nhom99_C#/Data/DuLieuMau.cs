using Nhom99.Mis.Model;

namespace Nhom99.Mis.Data;

/// <summary>
/// Dữ liệu mẫu. Được thiết kế để cả 10 câu truy vấn đều có kết quả, gồm cả các trường hợp biên:
/// gia sư chưa dạy lớp nào (GS05), học viên chưa đóng tiền (HV06, HV08), lớp đã hủy (L07) chưa có ai đăng ký.
/// </summary>
public static class DuLieuMau
{
    public static void Nap(KhoDuLieu kho)
    {
        // ===== Gia sư =====
        kho.DsGiaSu.Add(new GiaSu("GS01", "Nguyễn Văn An", "Toán", 5, "0901000001"));
        kho.DsGiaSu.Add(new GiaSu("GS02", "Trần Thị Bình", "Tiếng Anh", 3, "0901000002"));
        kho.DsGiaSu.Add(new GiaSu("GS03", "Lê Hoàng Cường", "Vật lý", 8, "0901000003"));
        kho.DsGiaSu.Add(new GiaSu("GS04", "Phạm Thu Dung", "Toán", 2, "0901000004"));
        kho.DsGiaSu.Add(new GiaSu("GS05", "Võ Minh Em", "Hóa học", 4, "0901000005"));

        // ===== Học viên =====
        kho.DsHocVien.Add(new HocVien("HV01", "Đặng Gia Huy", new DateOnly(2010, 3, 12), "Nam", "0912000001"));
        kho.DsHocVien.Add(new HocVien("HV02", "Ngô Bảo Châu", new DateOnly(2009, 7, 25), "Nữ", "0912000002"));
        kho.DsHocVien.Add(new HocVien("HV03", "Bùi Quang Khải", new DateOnly(2008, 11, 2), "Nam", "0912000003"));
        kho.DsHocVien.Add(new HocVien("HV04", "Hoàng Thanh Lam", new DateOnly(2010, 1, 30), "Nữ", "0912000004"));
        kho.DsHocVien.Add(new HocVien("HV05", "Đỗ Minh Nhật", new DateOnly(2009, 5, 18), "Nam", "0912000005"));
        kho.DsHocVien.Add(new HocVien("HV06", "Lý Ngọc Oanh", new DateOnly(2008, 9, 9), "Nữ", "0912000006"));
        kho.DsHocVien.Add(new HocVien("HV07", "Phan Anh Phúc", new DateOnly(2007, 12, 21), "Nam", "0912000007"));
        kho.DsHocVien.Add(new HocVien("HV08", "Trương Mỹ Quyên", new DateOnly(2010, 6, 6), "Nữ", "0912000008"));

        // ===== Lớp học =====
        kho.DsLopHoc.Add(new LopHoc("L01", "Toán 9 Cơ bản", "Toán", TrinhDo.CoBan, "GS01",
                2_000_000, 10, new DateOnly(2026, 9, 1), TrangThaiLop.DangHoc));
        kho.DsLopHoc.Add(new LopHoc("L02", "Toán 12 Luyện thi", "Toán", TrinhDo.NangCao, "GS01",
                3_500_000, 8, new DateOnly(2026, 9, 15), TrangThaiLop.DangMo));
        kho.DsLopHoc.Add(new LopHoc("L03", "IELTS Foundation", "Tiếng Anh", TrinhDo.CoBan, "GS02",
                2_800_000, 12, new DateOnly(2026, 8, 20), TrangThaiLop.DangHoc));
        kho.DsLopHoc.Add(new LopHoc("L04", "IELTS 6.5+", "Tiếng Anh", TrinhDo.NangCao, "GS02",
                4_200_000, 10, new DateOnly(2026, 10, 1), TrangThaiLop.DangMo));
        kho.DsLopHoc.Add(new LopHoc("L05", "Vật lý 11", "Vật lý", TrinhDo.TrungCap, "GS03",
                2_500_000, 10, new DateOnly(2026, 7, 1), TrangThaiLop.DaKetThuc));
        kho.DsLopHoc.Add(new LopHoc("L06", "Toán 10", "Toán", TrinhDo.TrungCap, "GS04",
                2_200_000, 8, new DateOnly(2026, 10, 10), TrangThaiLop.DangMo));
        kho.DsLopHoc.Add(new LopHoc("L07", "Vật lý 12 Nâng cao", "Vật lý", TrinhDo.NangCao, "GS03",
                3_000_000, 6, new DateOnly(2026, 11, 1), TrangThaiLop.DaHuy));

        // ===== Đăng ký =====
        kho.DsDangKy.Add(new DangKy("DK01", "HV01", "L01", new DateOnly(2026, 8, 25)));
        kho.DsDangKy.Add(new DangKy("DK02", "HV02", "L01", new DateOnly(2026, 8, 26)));
        kho.DsDangKy.Add(new DangKy("DK03", "HV03", "L01", new DateOnly(2026, 8, 28)));
        kho.DsDangKy.Add(new DangKy("DK04", "HV01", "L03", new DateOnly(2026, 8, 10)));
        kho.DsDangKy.Add(new DangKy("DK05", "HV04", "L03", new DateOnly(2026, 8, 12)));
        kho.DsDangKy.Add(new DangKy("DK06", "HV05", "L03", new DateOnly(2026, 8, 15)));
        kho.DsDangKy.Add(new DangKy("DK07", "HV02", "L02", new DateOnly(2026, 9, 5)));
        kho.DsDangKy.Add(new DangKy("DK08", "HV06", "L02", new DateOnly(2026, 9, 8)));
        kho.DsDangKy.Add(new DangKy("DK09", "HV07", "L04", new DateOnly(2026, 9, 20)));
        kho.DsDangKy.Add(new DangKy("DK10", "HV08", "L04", new DateOnly(2026, 9, 22)));
        kho.DsDangKy.Add(new DangKy("DK11", "HV03", "L05", new DateOnly(2026, 6, 20)));
        kho.DsDangKy.Add(new DangKy("DK12", "HV05", "L05", new DateOnly(2026, 6, 22)));
        kho.DsDangKy.Add(new DangKy("DK13", "HV01", "L06", new DateOnly(2026, 10, 2)));
        kho.DsDangKy.Add(new DangKy("DK14", "HV06", "L06", new DateOnly(2026, 10, 3)));
        kho.DsDangKy.Add(new DangKy("DK15", "HV07", "L03", new DateOnly(2026, 8, 18)));

        // ===== Thanh toán =====
        kho.DsThanhToan.Add(new ThanhToan("TT01", "DK01", 2_000_000, new DateOnly(2026, 8, 25), "Tiền mặt"));
        kho.DsThanhToan.Add(new ThanhToan("TT02", "DK02", 1_000_000, new DateOnly(2026, 8, 26), "Chuyển khoản"));
        kho.DsThanhToan.Add(new ThanhToan("TT03", "DK02", 1_000_000, new DateOnly(2026, 9, 26), "Chuyển khoản"));
        kho.DsThanhToan.Add(new ThanhToan("TT04", "DK04", 2_800_000, new DateOnly(2026, 8, 10), "Chuyển khoản"));
        kho.DsThanhToan.Add(new ThanhToan("TT05", "DK05", 2_800_000, new DateOnly(2026, 8, 12), "Tiền mặt"));
        kho.DsThanhToan.Add(new ThanhToan("TT06", "DK07", 3_500_000, new DateOnly(2026, 9, 5), "Chuyển khoản"));
        kho.DsThanhToan.Add(new ThanhToan("TT07", "DK09", 4_200_000, new DateOnly(2026, 9, 20), "Chuyển khoản"));
        kho.DsThanhToan.Add(new ThanhToan("TT08", "DK11", 2_500_000, new DateOnly(2026, 6, 20), "Tiền mặt"));
        kho.DsThanhToan.Add(new ThanhToan("TT09", "DK12", 1_500_000, new DateOnly(2026, 6, 22), "Tiền mặt"));
    }
}
