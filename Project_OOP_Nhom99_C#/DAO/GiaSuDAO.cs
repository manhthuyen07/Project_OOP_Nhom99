using Nhom99.Mis.Data;
using Nhom99.Mis.Model;

namespace Nhom99.Mis.Dao;

public class GiaSuDAO
{
    private readonly List<GiaSu> _ds;

    public GiaSuDAO(KhoDuLieu kho)
    {
        _ds = kho.DsGiaSu;
    }

    public List<GiaSu> GetAll() => _ds;

    /// <summary>Trả về null nếu không tìm thấy (thay cho Optional trong Java).</summary>
    public GiaSu? TimTheoMa(string ma) => _ds.FirstOrDefault(x => x.MaGiaSu == ma);

    public bool Them(GiaSu x)
    {
        if (TimTheoMa(x.MaGiaSu) != null) return false;
        _ds.Add(x);
        return true;
    }

    public bool Xoa(string ma) => _ds.RemoveAll(x => x.MaGiaSu == ma) > 0;
}
