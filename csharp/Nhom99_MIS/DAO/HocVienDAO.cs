using Nhom99_MIS.Data;
using Nhom99_MIS.Models;

namespace Nhom99_MIS.DAO;

public class HocVienDAO{
    private readonly KhoDuLieu _kho;
    public HocVienDAO(KhoDuLieu kho) => _kho = kho;
    public IReadOnlyList<HocVien> FindAll() => _kho.HocViens;
}
