namespace Nhom99_MIS.Models;

public sealed class HocVien{
    public string MaHV { get; }
    public string HoTen { get; }
    public int NamSinh { get; }
    public string SoDienThoai { get; }

    public HocVien(string maHV, string hoTen, int namSinh, string soDienThoai){
        MaHV = maHV;
        HoTen = hoTen;
        NamSinh = namSinh;
        SoDienThoai = soDienThoai;
    }

    public override bool Equals(object? obj) => obj is HocVien other && MaHV == other.MaHV;

    public override int GetHashCode() => MaHV.GetHashCode();
}
