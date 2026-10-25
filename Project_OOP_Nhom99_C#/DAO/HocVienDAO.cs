using Nhom99.Mis.Data;
using Nhom99.Mis.Model;

namespace Nhom99.Mis.Dao;

public class HocVienDAO
{
    private readonly List<HocVien> _ds;

    public HocVienDAO(KhoDuLieu kho)
    {
        _ds = kho.DsHocVien;
    }

    public List<HocVien> GetAll() => _ds;

    public HocVien? TimTheoMa(string ma) => _ds.FirstOrDefault(x => x.MaHocVien == ma);

    public bool Them(HocVien x)
    {
        if (TimTheoMa(x.MaHocVien) != null) return false;
        _ds.Add(x);
        return true;
    }

    public bool Xoa(string ma) => _ds.RemoveAll(x => x.MaHocVien == ma) > 0;
}
