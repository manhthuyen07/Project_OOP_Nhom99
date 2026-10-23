namespace Nhom99.Mis.Model;

/// <summary>Trạng thái của lớp học.</summary>
public enum TrangThaiLop
{
    DangMo,
    DangHoc,
    DaKetThuc,
    DaHuy
}

public static class TrangThaiLopExtensions
{
    public static string GetTen(this TrangThaiLop t) => t switch
    {
        TrangThaiLop.DangMo => "Đang mở",
        TrangThaiLop.DangHoc => "Đang học",
        TrangThaiLop.DaKetThuc => "Đã kết thúc",
        TrangThaiLop.DaHuy => "Đã hủy",
        _ => t.ToString()
    };
}
