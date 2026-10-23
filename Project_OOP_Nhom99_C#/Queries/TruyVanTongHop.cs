using System.Collections;
using Nhom99.Mis.Data;
using Nhom99.Mis.Queries.ThanhVien1;

namespace Nhom99.Mis.Queries;

/// <summary>Chạy và in kết quả tất cả câu truy vấn. Thành viên 2 sẽ bổ sung câu 11-20 vào đây.</summary>
public class TruyVanTongHop
{
    private readonly TruyVan01_05 _nhom1;
    private readonly TruyVan06_10 _nhom2;

    public TruyVanTongHop(KhoDuLieu kho)
    {
        _nhom1 = new TruyVan01_05(kho);
        _nhom2 = new TruyVan06_10(kho);
    }

    public void ChayTatCa()
    {
        TieuDe("Câu 01: Các lớp đang mở, học phí giảm dần");
        In(_nhom1.Cau01_LopDangMoTheoHocPhiGiam());

        TieuDe("Câu 02: Gia sư có hơn 3 năm kinh nghiệm");
        In(_nhom1.Cau02_GiaSuKinhNghiemTren(3));

        TieuDe("Câu 03: Lớp học kèm tên gia sư");
        In(_nhom1.Cau03_LopKemTenGiaSu());

        TieuDe("Câu 04: Số lớp của mỗi gia sư");
        foreach (var (ten, soLop) in _nhom1.Cau04_SoLopMoiGiaSu())
            Console.WriteLine($"{ten}: {soLop} lớp");

        TieuDe("Câu 05: Học viên đã đăng ký lớp môn Toán");
        In(_nhom1.Cau05_HocVienDangKyMon("Toán"));

        TieuDe("Câu 06: Doanh thu theo lớp");
        foreach (var (lop, tien) in _nhom2.Cau06_DoanhThuTheoLop())
            Console.WriteLine($"{lop}: {DinhDang.Tien(tien)}");

        TieuDe("Câu 07: Học viên chưa đóng học phí");
        In(_nhom2.Cau07_HocVienChuaThanhToan());

        TieuDe("Câu 08: Lớp đông học viên nhất");
        foreach (var (lop, sl) in _nhom2.Cau08_LopDongHocVienNhat())
            Console.WriteLine($"{lop} -> {sl} học viên");

        TieuDe("Câu 09: Học phí trung bình theo môn");
        foreach (var (mon, tb) in _nhom2.Cau09_HocPhiTrungBinhTheoMon())
            Console.WriteLine($"{mon}: {DinhDang.Tien(tb)}");

        TieuDe("Câu 10: Top 3 học viên đóng nhiều nhất");
        foreach (var (ten, tien) in _nhom2.Cau10_Top3HocVienDongNhieuNhat())
            Console.WriteLine($"{ten}: {DinhDang.Tien(tien)}");
    }

    private static void TieuDe(string s)
    {
        Console.WriteLine();
        Console.WriteLine("=== " + s + " ===");
    }

    private static void In(IEnumerable ds)
    {
        bool coKetQua = false;
        foreach (var item in ds)
        {
            coKetQua = true;
            Console.WriteLine(item);
        }
        if (!coKetQua) Console.WriteLine("(không có kết quả)");
    }
}
