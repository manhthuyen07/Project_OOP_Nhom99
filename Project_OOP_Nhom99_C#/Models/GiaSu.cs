namespace Nhom99.Mis.Model;

public class GiaSu
{
    public string MaGiaSu { get; set; }
    public string HoTen { get; set; }
    public string ChuyenMon { get; set; }
    public int SoNamKinhNghiem { get; set; }
    public string SoDienThoai { get; set; }
    public double LuongGio { get; set; }

    public GiaSu(string maGiaSu, string hoTen, string chuyenMon, int soNamKinhNghiem, string soDienThoai,
                 double luongGio = 0)
    {
        MaGiaSu = maGiaSu;
        HoTen = hoTen;
        ChuyenMon = chuyenMon;
        SoNamKinhNghiem = soNamKinhNghiem;
        SoDienThoai = soDienThoai;
        LuongGio = luongGio;
    }

    public override string ToString()
        => $"{MaGiaSu} | {HoTen} | {ChuyenMon} | {SoNamKinhNghiem} năm";
}