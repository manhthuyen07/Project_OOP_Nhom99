using Nhom99.Mis.Data;
using Nhom99.Mis.Model;

namespace Nhom99.Mis.Dao;

public class ThanhToanDAO
{
    private readonly List<ThanhToan> _ds;

    public ThanhToanDAO(KhoDuLieu kho)
    {
        _ds = kho.DsThanhToan;
    }

    public List<ThanhToan> GetAll() => _ds;

    public ThanhToan? TimTheoMa(string ma) => _ds.FirstOrDefault(x => x.MaThanhToan == ma);

    public bool Them(ThanhToan x)
    {
        if (TimTheoMa(x.MaThanhToan) != null) return false;
        _ds.Add(x);
        return true;
    }

    public bool Xoa(string ma) => _ds.RemoveAll(x => x.MaThanhToan == ma) > 0;
}
