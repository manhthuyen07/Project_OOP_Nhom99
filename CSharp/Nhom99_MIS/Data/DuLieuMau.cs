using Nhom99_MIS.Models;

namespace Nhom99_MIS.Data;

internal static class DuLieuMau{
    public static List<GiaSu> TaoGiaSu() => new()
    {
        new GiaSu("GS01", "Nguyễn Văn An", TrinhDo.DaiHoc, 3, 150000),
        new GiaSu("GS02", "Trần Minh Bình", TrinhDo.ThacSi, 5, 200000),
        new GiaSu("GS03", "Lê Hoàng Nam", TrinhDo.DaiHoc, 2, 120000),
        new GiaSu("GS04", "Phạm Thu Hà", TrinhDo.TienSi, 8, 300000),
        new GiaSu("GS05", "Võ Minh Đức", TrinhDo.ThacSi, 6, 180000),
    };
    public static List<HocVien> TaoHocVien() => new(){
        new HocVien("HV01", "Nguyễn Minh Anh", 2008, "0901000001"),
        new HocVien("HV02", "Trần Gia Huy", 2009, "0901000002"),
        new HocVien("HV03", "Lê Khánh Linh", 2008, "0901000003"),
        new HocVien("HV04", "Phạm Hoàng Long", 2007, "0901000004"),
        new HocVien("HV05", "Võ Ngọc Mai", 2009, "0901000005"),
        new HocVien("HV06", "Đặng Minh Khang", 2010, "0901000006"), // chưa đăng ký lớp nào
    };
    public static List<LopHoc> TaoLopHoc(IReadOnlyList<GiaSu> gs) => new(){
        new LopHoc("L01", "Toán 10A", "Toán", 1500000, TrangThaiLop.DangMo, gs[0]),
        new LopHoc("L02", "Toán 11A", "Toán", 1700000, TrangThaiLop.DangMo, gs[1]),
        new LopHoc("L03", "Anh Văn 10A", "Tiếng Anh", 1400000, TrangThaiLop.DaDu, gs[2]),
        new LopHoc("L04", "Vật Lý 12A", "Vật Lý", 1800000, TrangThaiLop.DaKetThuc, gs[3]),
        new LopHoc("L05", "Hóa 11A", "Hóa học", 1600000, TrangThaiLop.TamNgung, gs[4]),
        new LopHoc("L06", "Toán 12A", "Toán", 1900000, TrangThaiLop.DangMo, gs[0]),
        new LopHoc("L07", "Toán 9A", "Toán", 1300000, TrangThaiLop.DangMo, gs[1]),
    };
    public static List<DangKy> TaoDangKy(IReadOnlyList<HocVien> hv, IReadOnlyList<LopHoc> l) => new(){
        new DangKy(hv[0], l[0], new DateOnly(2026, 8, 25)),
        new DangKy(hv[0], l[1], new DateOnly(2026, 8, 26)),
        new DangKy(hv[1], l[0], new DateOnly(2026, 8, 27)),
        new DangKy(hv[1], l[2], new DateOnly(2026, 9, 1)),
        new DangKy(hv[2], l[0], new DateOnly(2026, 9, 2)),
        new DangKy(hv[2], l[5], new DateOnly(2026, 9, 3)),
        new DangKy(hv[3], l[5], new DateOnly(2026, 9, 6)),
        new DangKy(hv[3], l[1], new DateOnly(2026, 9, 5)),
        new DangKy(hv[3], l[3], new DateOnly(2026, 5, 10)),
        new DangKy(hv[4], l[4], new DateOnly(2026, 6, 15)),
        new DangKy(hv[4], l[6], new DateOnly(2026, 9, 10)),
    };
    public static List<ThanhToan> TaoThanhToan(IReadOnlyList<HocVien> hv, IReadOnlyList<LopHoc> l) => new(){
        new ThanhToan("TT01", hv[0], l[0], 1500000, new DateOnly(2026, 8, 28)),
        new ThanhToan("TT02", hv[0], l[1], 1000000, new DateOnly(2026, 9, 1)),
        new ThanhToan("TT03", hv[0], l[1], 700000, new DateOnly(2026, 9, 20)),
        new ThanhToan("TT04", hv[1], l[0], 800000, new DateOnly(2026, 9, 3)),
        new ThanhToan("TT05", hv[1], l[2], 1400000, new DateOnly(2026, 9, 4)),
        new ThanhToan("TT06", hv[2], l[0], 1500000, new DateOnly(2026, 10, 2)),
        new ThanhToan("TT07", hv[2], l[5], 900000, new DateOnly(2026, 10, 5)),
        new ThanhToan("TT08", hv[3], l[1], 1700000, new DateOnly(2026, 9, 8)),
        new ThanhToan("TT09", hv[3], l[3], 1800000, new DateOnly(2026, 5, 12)),
        new ThanhToan("TT10", hv[4], l[4], 1600000, new DateOnly(2026, 6, 18)),
        new ThanhToan("TT11", hv[4], l[6], 650000, new DateOnly(2026, 9, 12)),
    };
}