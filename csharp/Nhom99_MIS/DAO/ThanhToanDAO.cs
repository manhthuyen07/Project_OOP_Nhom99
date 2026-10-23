using Nhom99_MIS.Data;
using Nhom99_MIS.Models;

namespace Nhom99_MIS.DAO;

public class ThanhToanDAO{
    private readonly KhoDuLieu _kho;
    public ThanhToanDAO(KhoDuLieu kho) => _kho = kho;
    public IReadOnlyList<ThanhToan> FindAll() => _kho.ThanhToans;
}
