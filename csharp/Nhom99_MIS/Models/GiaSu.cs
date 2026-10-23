namespace Nhom99_MIS.Models;

public sealed class GiaSu{
    public string MaGS { get; }
    public string HoTen { get; }
    public TrinhDo TrinhDo { get; }
    public int SoNamKinhNghiem { get; }
    public double LuongGio { get; }

    public GiaSu(string maGS, string hoTen, TrinhDo trinhDo, int soNamKinhNghiem, double luongGio){
        MaGS = maGS;
        HoTen = hoTen;
        TrinhDo = trinhDo;
        SoNamKinhNghiem = soNamKinhNghiem;
        LuongGio = luongGio;
    }
}
