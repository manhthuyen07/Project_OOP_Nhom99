namespace Nhom99.Mis.Model;

public class DangKy
{
    public string MaDangKy { get; set; }
    public string MaHocVien { get; set; }
    public string MaLop { get; set; }
    public DateOnly NgayDangKy { get; set; }

    public DangKy(string maDangKy, string maHocVien, string maLop, DateOnly ngayDangKy)
    {
        MaDangKy = maDangKy;
        MaHocVien = maHocVien;
        MaLop = maLop;
        NgayDangKy = ngayDangKy;
    }

    public override string ToString()
        => $"{MaDangKy} | {MaHocVien} -> {MaLop} | {DinhDang.Ngay(NgayDangKy)}";
}
