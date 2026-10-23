using Nhom99.Mis.Dao;
using Nhom99.Mis.Data;
using Nhom99.Mis.Model;
using Nhom99.Mis.Util;

namespace Nhom99.Mis.Queries.ThanhVien2;

public sealed class TruyVan11_15
{
    private readonly GiaSuDAO _giaSuDAO;
    private readonly LopHocDAO _lopHocDAO;
    private readonly DangKyDAO _dangKyDAO;
    private readonly ThanhToanDAO _thanhToanDAO;

    public TruyVan11_15(KhoDuLieu kho)
    {
        _giaSuDAO = new GiaSuDAO(kho);
        _lopHocDAO = new LopHocDAO(kho);
        _dangKyDAO = new DangKyDAO(kho);
        _thanhToanDAO = new ThanhToanDAO(kho);
    }

    // Câu 11 - Tổng tiền đã thanh toán
    public List<Row> Cau11()
    {
        double tong = _thanhToanDAO.GetAll().Sum(tt => tt.SoTien);
        return new List<Row> { Row.Of(tong) };
    }

    // Câu 12 - Học phí trung bình của tất cả lớp học
    public List<Row> Cau12()
    {
        double trungBinh = _lopHocDAO.GetAll().Select(l => l.HocPhi).DefaultIfEmpty(0).Average();
        return new List<Row> { Row.Of(trungBinh) };
    }

    // Câu 13 - Có lớp đang mở (DangMo) không
    public List<Row> Cau13()
    {
        bool coLopDangMo = _lopHocDAO.GetAll().Any(l => l.TrangThai == TrangThaiLop.DangMo);
        return new List<Row> { Row.Of(ConsoleTable.CoKhong(coLopDangMo)) };
    }

    // Câu 14 - Mọi lớp của gia sư GS01 đều có ít nhất 2 học viên?
    public List<Row> Cau14()
    {
        const string maGS = "GS01";
        const int toiThieu = 2;
        var lopCuaGiaSu = _lopHocDAO.GetAll().Where(l => l.MaGiaSu == maGS).ToList();
        bool tatCaDat = lopCuaGiaSu.All(l => DemHocVien(l) >= toiThieu);
        return new List<Row> { Row.Of(maGS, lopCuaGiaSu.Count, toiThieu, ConsoleTable.CoKhong(tatCaDat)) };
    }

    private int DemHocVien(LopHoc lop) =>
        _dangKyDAO.GetAll().Count(dk => dk.MaLop == lop.MaLop);

    // Câu 15 - Không có gia sư nào trên 10 năm kinh nghiệm?
    public List<Row> Cau15()
    {
        const int mucKinhNghiem = 10;
        bool khongAiVuot = !_giaSuDAO.GetAll().Any(gs => gs.SoNamKinhNghiem > mucKinhNghiem);
        return new List<Row> { Row.Of(mucKinhNghiem, ConsoleTable.CoKhong(khongAiVuot)) };
    }
}