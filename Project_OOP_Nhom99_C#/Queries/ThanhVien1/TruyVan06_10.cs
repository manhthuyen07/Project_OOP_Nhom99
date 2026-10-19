using Nhom99.Mis.Dao;
using Nhom99.Mis.Data;
using Nhom99.Mis.Model;

namespace Nhom99.Mis.Queries.ThanhVien1;

/// <summary>Thành viên 1 - Câu 06 đến 10 (LINQ, tương đương Java Lambdas / Stream API).</summary>
public class TruyVan06_10
{
    private readonly HocVienDAO _hocVienDAO;
    private readonly LopHocDAO _lopHocDAO;
    private readonly DangKyDAO _dangKyDAO;
    private readonly ThanhToanDAO _thanhToanDAO;

    public TruyVan06_10(KhoDuLieu kho)
    {
        _hocVienDAO = new HocVienDAO(kho);
        _lopHocDAO = new LopHocDAO(kho);
        _dangKyDAO = new DangKyDAO(kho);
        _thanhToanDAO = new ThanhToanDAO(kho);
    }

    /// <summary>Câu 06: Tổng doanh thu (tổng tiền đã thanh toán) của từng lớp, giảm dần. Lớp chưa thu đồng nào hiện 0.</summary>
    public List<(string TenLop, double DoanhThu)> Cau06_DoanhThuTheoLop()
    {
        var dangKyToLop = _dangKyDAO.GetAll().ToDictionary(d => d.MaDangKy, d => d.MaLop);

        var tongTheoMaLop = _thanhToanDAO.GetAll()
                .GroupBy(t => dangKyToLop[t.MaDangKy])
                .ToDictionary(g => g.Key, g => g.Sum(t => t.SoTien));

        double Tong(LopHoc l) => tongTheoMaLop.GetValueOrDefault(l.MaLop, 0.0);

        return _lopHocDAO.GetAll()
                .OrderByDescending(Tong)
                .Select(l => (l.TenLop, Tong(l)))
                .DistinctBy(x => x.TenLop)
                .ToList();
    }

    /// <summary>Câu 07: Học viên chưa đóng đồng học phí nào (không có bản ghi thanh toán cho bất kỳ đăng ký nào).</summary>
    public List<HocVien> Cau07_HocVienChuaThanhToan()
    {
        var dangKyDaTra = _thanhToanDAO.GetAll().Select(t => t.MaDangKy).ToHashSet();

        var hocVienDaTra = _dangKyDAO.GetAll()
                .Where(d => dangKyDaTra.Contains(d.MaDangKy))
                .Select(d => d.MaHocVien)
                .ToHashSet();

        return _hocVienDAO.GetAll()
                .Where(h => !hocVienDaTra.Contains(h.MaHocVien))
                .ToList();
    }

    /// <summary>Câu 08: Lớp có nhiều học viên đăng ký nhất (nếu đồng hạng thì trả về tất cả).</summary>
    public List<(LopHoc Lop, long SoHocVien)> Cau08_LopDongHocVienNhat()
    {
        var demTheoLop = _dangKyDAO.GetAll()
                .GroupBy(d => d.MaLop)
                .ToDictionary(g => g.Key, g => (long)g.Count());

        long max = demTheoLop.Values.DefaultIfEmpty(0).Max();

        return _lopHocDAO.GetAll()
                .Where(l => max > 0 && demTheoLop.GetValueOrDefault(l.MaLop, 0L) == max)
                .Select(l => (l, demTheoLop[l.MaLop]))
                .ToList();
    }

    /// <summary>Câu 09: Học phí trung bình theo từng môn học (sắp theo tên môn).</summary>
    public SortedDictionary<string, double> Cau09_HocPhiTrungBinhTheoMon()
    {
        var kq = new SortedDictionary<string, double>(StringComparer.Ordinal);
        foreach (var g in _lopHocDAO.GetAll().GroupBy(l => l.MonHoc))
            kq[g.Key] = g.Average(l => l.HocPhi);
        return kq;
    }

    /// <summary>Câu 10: Top 3 học viên đóng học phí nhiều nhất (tổng tiền các lần thanh toán).</summary>
    public List<(string HoTen, double TongTien)> Cau10_Top3HocVienDongNhieuNhat()
    {
        var dangKyToHocVien = _dangKyDAO.GetAll().ToDictionary(d => d.MaDangKy, d => d.MaHocVien);

        var tongTheoHocVien = _thanhToanDAO.GetAll()
                .GroupBy(t => dangKyToHocVien[t.MaDangKy])
                .ToDictionary(g => g.Key, g => g.Sum(t => t.SoTien));

        return tongTheoHocVien
                .OrderByDescending(e => e.Value)
                .Take(3)
                .Select(e => (_hocVienDAO.TimTheoMa(e.Key)?.HoTen ?? e.Key, e.Value))
                .DistinctBy(x => x.Item1)
                .ToList();
    }
}
