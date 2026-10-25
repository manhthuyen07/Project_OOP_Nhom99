namespace Nhom99.Mis.Model;

public class HocVien
{
    public string MaHocVien { get; set; }
    public string HoTen { get; set; }
    public DateOnly NgaySinh { get; set; }
    public string GioiTinh { get; set; }
    public string SoDienThoai { get; set; }

    public HocVien(string maHocVien, string hoTen, DateOnly ngaySinh, string gioiTinh, string soDienThoai)
    {
        MaHocVien = maHocVien;
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        GioiTinh = gioiTinh;
        SoDienThoai = soDienThoai;
    }

    public override string ToString()
        => $"{MaHocVien} | {HoTen} | {DinhDang.Ngay(NgaySinh)} | {GioiTinh}";
}
