using Nhom99_MIS.Data;
using Nhom99_MIS.Models;

namespace Nhom99_MIS.DAO;

public class DangKyDAO{
    private readonly KhoDuLieu _kho;
    public DangKyDAO(KhoDuLieu kho) => _kho = kho;
    public IReadOnlyList<DangKy> FindAll() => _kho.DangKys;
}
