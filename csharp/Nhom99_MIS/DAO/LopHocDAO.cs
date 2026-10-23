using Nhom99_MIS.Data;
using Nhom99_MIS.Models;

namespace Nhom99_MIS.DAO;

public class LopHocDAO{
    private readonly KhoDuLieu _kho;
    public LopHocDAO(KhoDuLieu kho) => _kho = kho;
    public IReadOnlyList<LopHoc> FindAll() => _kho.LopHocs;
}
