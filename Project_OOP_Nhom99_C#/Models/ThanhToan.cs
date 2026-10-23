namespace Nhom99.Mis.Model;

/// <summary>Thanh toán học phí. Khóa chính: MaThanhToan. Khóa ngoại: MaDangKy -> DangKy.</summary>
public class ThanhToan
{
    public string MaThanhToan { get; set; }
    public string MaDangKy { get; set; }
    public double SoTien { get; set; }
    public DateOnly NgayThanhToan { get; set; }
    public string PhuongThuc { get; set; }

    public ThanhToan(string maThanhToan, string maDangKy, double soTien, DateOnly ngayThanhToan, string phuongThuc)
    {
        MaThanhToan = maThanhToan;
        MaDangKy = maDangKy;
        SoTien = soTien;
        NgayThanhToan = ngayThanhToan;
        PhuongThuc = phuongThuc;
    }

    public override string ToString()
        => $"{MaThanhToan} | {MaDangKy} | {DinhDang.Tien(SoTien)} | {DinhDang.Ngay(NgayThanhToan)} | {PhuongThuc}";
}
