namespace Nhom99_MIS.Models;

public sealed class DangKy
{
    public HocVien HocVien { get; }
    public LopHoc LopHoc { get; }
    public DateOnly NgayDangKy { get; }

    public DangKy(HocVien hocVien, LopHoc lopHoc, DateOnly ngayDangKy)
    {
        HocVien = hocVien;
        LopHoc = lopHoc;
        NgayDangKy = ngayDangKy;
    }
}
