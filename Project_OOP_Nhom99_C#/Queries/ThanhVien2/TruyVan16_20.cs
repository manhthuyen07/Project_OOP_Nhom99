using Nhom99.Mis.Dao;
using Nhom99.Mis.Data;
using Nhom99.Mis.Model;
using Nhom99.Mis.Util;

namespace Nhom99.Mis.Queries.ThanhVien2;

public sealed class TruyVan16_20
{
    private readonly GiaSuDAO _giaSuDAO;
    private readonly HocVienDAO _hocVienDAO;
    private readonly LopHocDAO _lopHocDAO;
    private readonly DangKyDAO _dangKyDAO;
    private readonly ThanhToanDAO _thanhToanDAO;

    public TruyVan16_20(KhoDuLieu kho)
    {
        _giaSuDAO = new GiaSuDAO(kho);
        _hocVienDAO = new HocVienDAO(kho);
        _lopHocDAO = new LopHocDAO(kho);
        _dangKyDAO = new DangKyDAO(kho);
        _thanhToanDAO = new ThanhToanDAO(kho);
    }

    // Câu 16 - Đếm số lớp của từng gia sư
    public List<Row> Cau16()
    {
        var soLop = _lopHocDAO.GetAll()
            .GroupBy(l => l.MaGiaSu)
            .ToDictionary(g => g.Key, g => g.Count());
        int Dem(GiaSu gs) => soLop.GetValueOrDefault(gs.MaGiaSu, 0);
        return _giaSuDAO.GetAll()
            .OrderByDescending(Dem).ThenBy(gs => gs.MaGiaSu, StringComparer.Ordinal)
            .Select(gs => Row.Of(gs.MaGiaSu, gs.HoTen, Dem(gs))).ToList();
    }

    // Câu 17 - Học viên đang học các lớp của gia sư GS01
    public List<Row> Cau17()
    {
        const string maGS = "GS01";
        var maLopCuaGS = _lopHocDAO.GetAll()
            .Where(l => l.MaGiaSu == maGS)
            .Select(l => l.MaLop)
            .ToHashSet();
        var maHocVien = _dangKyDAO.GetAll()
            .Where(dk => maLopCuaGS.Contains(dk.MaLop))
            .Select(dk => dk.MaHocVien)
            .ToHashSet();
        return _hocVienDAO.GetAll()
            .Where(hv => maHocVien.Contains(hv.MaHocVien))
            .OrderBy(hv => hv.MaHocVien, StringComparer.Ordinal)
            .Select(hv => Row.Of(hv.MaHocVien, hv.HoTen, hv.NgaySinh, hv.SoDienThoai)).ToList();
    }

    // Câu 18 - Học viên chưa đăng ký lớp nào
    public List<Row> Cau18()
    {
        var daDangKy = _dangKyDAO.GetAll().Select(dk => dk.MaHocVien).ToHashSet();
        return _hocVienDAO.GetAll()
            .Where(hv => !daDangKy.Contains(hv.MaHocVien))
            .OrderBy(hv => hv.MaHocVien, StringComparer.Ordinal)
            .Select(hv => Row.Of(hv.MaHocVien, hv.HoTen)).ToList();
    }

    // Câu 19 - Doanh thu theo tháng
    public List<Row> Cau19()
    {
        return _thanhToanDAO.GetAll()
            .GroupBy(tt => (tt.NgayThanhToan.Year, tt.NgayThanhToan.Month))
            .Select(g => new { g.Key.Year, g.Key.Month, Tong = g.Sum(tt => tt.SoTien) })
            .OrderBy(x => x.Year).ThenBy(x => x.Month)
            .Select(x => Row.Of(x.Year, x.Month, x.Tong)).ToList();
    }

    // Câu 20 - Thống kê học phí: số lớp, thấp nhất, cao nhất, trung bình, tổng
    public List<Row> Cau20()
    {
        var hocPhis = _lopHocDAO.GetAll().Select(l => l.HocPhi).ToList();
        if (hocPhis.Count == 0) return new List<Row>();
        return new List<Row>
        {
            Row.Of(hocPhis.Count, hocPhis.Min(), hocPhis.Max(), hocPhis.Average(), hocPhis.Sum())
        };
    }
}