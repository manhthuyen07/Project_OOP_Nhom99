namespace Nhom99.Mis.Model;

public class LopHoc
{
    public string MaLop { get; set; }
    public string TenLop { get; set; }
    public string MonHoc { get; set; }
    public TrinhDo TrinhDo { get; set; }
    public string MaGiaSu { get; set; }
    public double HocPhi { get; set; }
    public int SiSoToiDa { get; set; }
    public DateOnly NgayBatDau { get; set; }
    public TrangThaiLop TrangThai { get; set; }

    public LopHoc(string maLop, string tenLop, string monHoc, TrinhDo trinhDo, string maGiaSu,
                  double hocPhi, int siSoToiDa, DateOnly ngayBatDau, TrangThaiLop trangThai)
    {
        MaLop = maLop;
        TenLop = tenLop;
        MonHoc = monHoc;
        TrinhDo = trinhDo;
        MaGiaSu = maGiaSu;
        HocPhi = hocPhi;
        SiSoToiDa = siSoToiDa;
        NgayBatDau = ngayBatDau;
        TrangThai = trangThai;
    }

    public override string ToString()
        => $"{MaLop} | {TenLop} | {MonHoc} | {TrinhDo.GetTen()} | {DinhDang.Tien(HocPhi)} | {TrangThai.GetTen()}";
}
