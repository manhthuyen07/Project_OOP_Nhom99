using Nhom99_MIS.DAO;
using Nhom99_MIS.Data;
using Nhom99_MIS.Models;
using Nhom99_MIS.Util;

namespace Nhom99_MIS.Queries.ThanhVien2;

public sealed class TruyVan16_20{
    private readonly GiaSuDAO _giaSuDAO;
    private readonly HocVienDAO _hocVienDAO;
    private readonly LopHocDAO _lopHocDAO;
    private readonly DangKyDAO _dangKyDAO;
    private readonly ThanhToanDAO _thanhToanDAO;

    public TruyVan16_20(KhoDuLieu kho){
        _giaSuDAO = new GiaSuDAO(kho);
        _hocVienDAO = new HocVienDAO(kho);
        _lopHocDAO = new LopHocDAO(kho);
        _dangKyDAO = new DangKyDAO(kho);
        _thanhToanDAO = new ThanhToanDAO(kho);
    }

    // Câu 16 - Đếm số lớp của từng gia sư
    public List<Row> Cau16(){
        var soLop = _lopHocDAO.FindAll()
            .GroupBy(l => l.GiaSu.MaGS)
            .ToDictionary(g => g.Key, g => g.Count());
        int Dem(GiaSu gs) => soLop.GetValueOrDefault(gs.MaGS, 0);
        return _giaSuDAO.FindAll()
            .OrderByDescending(Dem).ThenBy(gs => gs.MaGS, StringComparer.Ordinal)
            .Select(gs => Row.Of(gs.MaGS, gs.HoTen, Dem(gs))).ToList();
    }

    // Câu 17 - Tất cả học viên đang học các lớp do gia sư GS01 phụ trách
    public List<Row> Cau17(){
        const string maGS = "GS01";
        return _lopHocDAO.FindAll()
            .Where(l => l.GiaSu.MaGS == maGS)
            .SelectMany(l => _dangKyDAO.FindAll()
                .Where(dk => dk.LopHoc.MaLop == l.MaLop)
                .Select(dk => dk.HocVien))
            .Distinct()
            .OrderBy(hv => hv.MaHV, StringComparer.Ordinal)
            .Select(hv => Row.Of(hv.MaHV, hv.HoTen, hv.NamSinh, hv.SoDienThoai)).ToList();
    }
    // Câu 18 - Học viên chưa đăng ký bất kỳ lớp nào
    public List<Row> Cau18(){
        var daDangKy = _dangKyDAO.FindAll().Select(dk => dk.HocVien.MaHV).ToHashSet();
        return _hocVienDAO.FindAll()
            .Where(hv => !daDangKy.Contains(hv.MaHV))
            .OrderBy(hv => hv.MaHV, StringComparer.Ordinal)
            .Select(hv => Row.Of(hv.MaHV, hv.HoTen)).ToList();
    }
    // Câu 19 - Doanh thu theo tháng
    public List<Row> Cau19(){
        return _thanhToanDAO.FindAll()
            .GroupBy(tt => (tt.NgayThanhToan.Year, tt.NgayThanhToan.Month))
            .Select(g => new { g.Key.Year, g.Key.Month, Tong = g.Sum(tt => tt.SoTien) })
            .OrderBy(x => x.Year).ThenBy(x => x.Month)
            .Select(x => Row.Of(x.Year, x.Month, x.Tong)).ToList();
    }
    // Câu 20 - Thống kê học phí: số lớp, thấp nhất, cao nhất, trung bình, tổng
    public List<Row> Cau20(){
        var hocPhis = _lopHocDAO.FindAll().Select(l => l.HocPhi).ToList();
        if (hocPhis.Count == 0) return new List<Row>();
        return new List<Row>
        {
            Row.Of(hocPhis.Count, hocPhis.Min(), hocPhis.Max(), hocPhis.Average(), hocPhis.Sum())
        };
    }
}
