using Nhom99.Mis.Model;

namespace Nhom99.Mis.Data;

/// <summary>Kho dữ liệu trong bộ nhớ (thay cho cơ sở dữ liệu). Dùng chung bởi các DAO.</summary>
public class KhoDuLieu
{
    private static KhoDuLieu? _instance;

    public List<GiaSu> DsGiaSu { get; } = new();
    public List<HocVien> DsHocVien { get; } = new();
    public List<LopHoc> DsLopHoc { get; } = new();
    public List<DangKy> DsDangKy { get; } = new();
    public List<ThanhToan> DsThanhToan { get; } = new();

    private KhoDuLieu()
    {
        DuLieuMau.Nap(this);
    }

    public static KhoDuLieu GetInstance()
    {
        _instance ??= new KhoDuLieu();
        return _instance;
    }
}
