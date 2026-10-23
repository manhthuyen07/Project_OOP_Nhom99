namespace Nhom99_MIS.Models;

public sealed class ThanhToan{
    public string MaThanhToan { get; }
    public HocVien HocVien { get; }
    public LopHoc LopHoc { get; }
    public double SoTien { get; }
    public DateOnly NgayThanhToan { get; }

    public ThanhToan(string maThanhToan, HocVien hocVien, LopHoc lopHoc, double soTien, DateOnly ngayThanhToan){
        MaThanhToan = maThanhToan;
        HocVien = hocVien;
        LopHoc = lopHoc;
        SoTien = soTien;
        NgayThanhToan = ngayThanhToan;
    }
}
