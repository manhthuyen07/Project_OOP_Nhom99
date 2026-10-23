using Nhom99_MIS.DAO;
using Nhom99_MIS.Data;
using Nhom99_MIS.Models;
using Nhom99_MIS.Util;

namespace Nhom99_MIS.Queries.ThanhVien2;

public sealed class TruyVan11_15{
    private readonly GiaSuDAO _giaSuDAO;
    private readonly LopHocDAO _lopHocDAO;
    private readonly DangKyDAO _dangKyDAO;
    private readonly ThanhToanDAO _thanhToanDAO;

    public TruyVan11_15(KhoDuLieu kho){
        _giaSuDAO = new GiaSuDAO(kho);
        _lopHocDAO = new LopHocDAO(kho);
        _dangKyDAO = new DangKyDAO(kho);
        _thanhToanDAO = new ThanhToanDAO(kho);
    }

    // Câu 11 - Tính tổng tiền đã thanh toán
    public List<Row> Cau11(){
        double tong = _thanhToanDAO.FindAll().Sum(tt => tt.SoTien);
        return new List<Row> { Row.Of(tong) };
    }

    // Câu 12 - Tính học phí trung bình của tất cả lớp học
    public List<Row> Cau12(){
        double trungBinh = _lopHocDAO.FindAll().Select(l => l.HocPhi).DefaultIfEmpty(0).Average();
        return new List<Row> { Row.Of(trungBinh) };
    }

    // Câu 13 - Kiểm tra hệ thống có lớp đang mở (DangMo)
    public List<Row> Cau13(){
        bool coLopDangMo = _lopHocDAO.FindAll().Any(l => l.TrangThai == TrangThaiLop.DangMo);
        return new List<Row> { Row.Of(ConsoleTable.CoKhong(coLopDangMo)) };
    }

    // Câu 14 - Mọi lớp của gia sư GS01 đều có ít nhất 2 học viên?
    public List<Row> Cau14(){
        const string maGS = "GS01";
        const int toiThieu = 2;
        var lopCuaGiaSu = _lopHocDAO.FindAll().Where(l => l.GiaSu.MaGS == maGS).ToList();
        bool tatCaDat = lopCuaGiaSu.All(l => DemHocVien(l) >= toiThieu);
        return new List<Row> { Row.Of(maGS, lopCuaGiaSu.Count, toiThieu, ConsoleTable.CoKhong(tatCaDat)) };
    }

    private int DemHocVien(LopHoc lop) =>
        _dangKyDAO.FindAll().Count(dk => dk.LopHoc.MaLop == lop.MaLop);

    // Câu 15 - Không có gia sư nào lương theo giờ vượt 300.000?
    public List<Row> Cau15(){
        const double mucLuong = 300_000;
        bool khongAiVuot = !_giaSuDAO.FindAll().Any(gs => gs.LuongGio > mucLuong);
        return new List<Row> { Row.Of(mucLuong, ConsoleTable.CoKhong(khongAiVuot)) };
    }
}
