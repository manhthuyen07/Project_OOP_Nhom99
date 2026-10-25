using Nhom99.Mis.Data;
using Nhom99.Mis.Model;

namespace Nhom99.Mis.Dao;

public class LopHocDAO
{
    private readonly List<LopHoc> _ds;

    public LopHocDAO(KhoDuLieu kho)
    {
        _ds = kho.DsLopHoc;
    }

    public List<LopHoc> GetAll() => _ds;

    public LopHoc? TimTheoMa(string ma) => _ds.FirstOrDefault(x => x.MaLop == ma);

    public bool Them(LopHoc x)
    {
        if (TimTheoMa(x.MaLop) != null) return false;
        _ds.Add(x);
        return true;
    }

    public bool Xoa(string ma) => _ds.RemoveAll(x => x.MaLop == ma) > 0;
}
