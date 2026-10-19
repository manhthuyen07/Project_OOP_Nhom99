namespace Nhom99_MIS.Models;

public sealed class LopHoc{
    public string MaLop { get; }
    public string TenLop { get; }
    public string MonHoc { get; }
    public double HocPhi { get; }
    public TrangThaiLop TrangThai { get; }
    public GiaSu GiaSu { get; }

    public LopHoc(string maLop, string tenLop, string monHoc, double hocPhi, TrangThaiLop trangThai, GiaSu giaSu){
        MaLop = maLop;
        TenLop = tenLop;
        MonHoc = monHoc;
        HocPhi = hocPhi;
        TrangThai = trangThai;
        GiaSu = giaSu;
    }
}
