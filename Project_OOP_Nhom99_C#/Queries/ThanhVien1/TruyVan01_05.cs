using Nhom99.Mis.Dao;
using Nhom99.Mis.Data;
using Nhom99.Mis.Model;

namespace Nhom99.Mis.Queries.ThanhVien1;

/// <summary>Thành viên 1 - Câu 01 đến 05 (LINQ, tương đương Java Lambdas / Stream API).</summary>
public class TruyVan01_05
{
    private readonly GiaSuDAO _giaSuDAO;
    private readonly HocVienDAO _hocVienDAO;
    private readonly LopHocDAO _lopHocDAO;
    private readonly DangKyDAO _dangKyDAO;

    public TruyVan01_05(KhoDuLieu kho)
    {
        _giaSuDAO = new GiaSuDAO(kho);
        _hocVienDAO = new HocVienDAO(kho);
        _lopHocDAO = new LopHocDAO(kho);
        _dangKyDAO = new DangKyDAO(kho);
    }

    /// <summary>Câu 01: Liệt kê các lớp đang mở, sắp xếp theo học phí giảm dần.</summary>
    public List<LopHoc> Cau01_LopDangMoTheoHocPhiGiam()
    {
        return _lopHocDAO.GetAll()
                .Where(l => l.TrangThai == TrangThaiLop.DangMo)
                .OrderByDescending(l => l.HocPhi)
                .ToList();
    }

    /// <summary>Câu 02: Liệt kê gia sư có số năm kinh nghiệm lớn hơn một ngưỡng (mặc định 3), giảm dần theo kinh nghiệm.</summary>
    public List<GiaSu> Cau02_GiaSuKinhNghiemTren(int soNam)
    {
        return _giaSuDAO.GetAll()
                .Where(g => g.SoNamKinhNghiem > soNam)
                .OrderByDescending(g => g.SoNamKinhNghiem)
                .ToList();
    }

    /// <summary>Câu 03: Danh sách lớp học kèm tên gia sư phụ trách (kết bảng LopHoc - GiaSu).</summary>
    public List<string> Cau03_LopKemTenGiaSu()
    {
        return _lopHocDAO.GetAll()
                .Select(l => $"{l.MaLop} | {l.TenLop} | Gia sư: "
                        + (_giaSuDAO.TimTheoMa(l.MaGiaSu)?.HoTen ?? "(chưa phân công)"))
                .ToList();
    }

    /// <summary>Câu 04: Đếm số lớp mà mỗi gia sư phụ trách (gia sư chưa có lớp vẫn hiện, số lớp = 0).</summary>
    public List<(string HoTen, long SoLop)> Cau04_SoLopMoiGiaSu()
    {
        return _giaSuDAO.GetAll()
                .Select(g => (
                        g.HoTen,
                        SoLop: (long)_lopHocDAO.GetAll().Count(l => l.MaGiaSu == g.MaGiaSu)))
                .DistinctBy(x => x.HoTen) // giữ phần tử đầu khi trùng tên (như merge (a, b) -> a)
                .ToList();
    }

    /// <summary>Câu 05: Liệt kê (không trùng) các học viên đã đăng ký lớp của một môn học (kết bảng DangKy - LopHoc - HocVien).</summary>
    public List<HocVien> Cau05_HocVienDangKyMon(string monHoc)
    {
        var maLopCuaMon = _lopHocDAO.GetAll()
                .Where(l => string.Equals(l.MonHoc, monHoc, StringComparison.OrdinalIgnoreCase))
                .Select(l => l.MaLop)
                .ToHashSet();

        var maHocVien = _dangKyDAO.GetAll()
                .Where(d => maLopCuaMon.Contains(d.MaLop))
                .Select(d => d.MaHocVien)
                .ToHashSet();

        return _hocVienDAO.GetAll()
                .Where(h => maHocVien.Contains(h.MaHocVien))
                .ToList();
    }
}
