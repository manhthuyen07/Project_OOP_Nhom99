using Nhom99.Mis.Data;
using Nhom99.Mis.Model;

namespace Nhom99.Mis.Dao;

public class DangKyDAO
{
    private readonly List<DangKy> _ds;

    public DangKyDAO(KhoDuLieu kho)
    {
        _ds = kho.DsDangKy;
    }

    public List<DangKy> GetAll() => _ds;

    public DangKy? TimTheoMa(string ma) => _ds.FirstOrDefault(x => x.MaDangKy == ma);

    public bool Them(DangKy x)
    {
        if (TimTheoMa(x.MaDangKy) != null) return false;
        _ds.Add(x);
        return true;
    }

    public bool Xoa(string ma) => _ds.RemoveAll(x => x.MaDangKy == ma) > 0;
}
