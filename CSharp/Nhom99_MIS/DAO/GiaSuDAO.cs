using Nhom99_MIS.Data;
using Nhom99_MIS.Models;

namespace Nhom99_MIS.DAO;

public class GiaSuDAO{
    private readonly KhoDuLieu _kho;
    public GiaSuDAO(KhoDuLieu kho) => _kho = kho;
    public IReadOnlyList<GiaSu> FindAll() => _kho.GiaSus;
}
