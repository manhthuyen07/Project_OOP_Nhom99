using System.Collections;
using Nhom99.Mis.Data;
using Nhom99.Mis.Queries.ThanhVien1;
using Nhom99.Mis.Queries.ThanhVien2;
using Nhom99.Mis.Util;

namespace Nhom99.Mis.Queries;

/// <summary>Chạy và in kết quả tất cả câu truy vấn 01-20.</summary>
public class TruyVanTongHop
{
    private readonly TruyVan01_05 _nhom1;
    private readonly TruyVan06_10 _nhom2;
    private readonly TruyVan11_15 _nhom3;
    private readonly TruyVan16_20 _nhom4;

    public TruyVanTongHop(KhoDuLieu kho)
    {
        _nhom1 = new TruyVan01_05(kho);
        _nhom2 = new TruyVan06_10(kho);
        _nhom3 = new TruyVan11_15(kho);
        _nhom4 = new TruyVan16_20(kho);
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

        TieuDe("Câu 11: Tổng tiền đã thanh toán");
        ConsoleTable.Print("TongTien", _nhom3.Cau11());

        TieuDe("Câu 12: Học phí trung bình của tất cả lớp");
        ConsoleTable.Print("HocPhiTrungBinh", _nhom3.Cau12());

        TieuDe("Câu 13: Có lớp đang mở không");
        ConsoleTable.Print("CoLopDangMo", _nhom3.Cau13());

        TieuDe("Câu 14: Mọi lớp của gia sư GS01 có ít nhất 2 học viên");
        ConsoleTable.Print("MaGS|SoLop|ToiThieu|KetQua", _nhom3.Cau14());

        TieuDe("Câu 15: Không có gia sư nào trên 10 năm kinh nghiệm");
        ConsoleTable.Print("MucKinhNghiem|KetQua", _nhom3.Cau15());

        TieuDe("Câu 16: Số lớp của từng gia sư");
        ConsoleTable.Print("MaGS|HoTen|SoLop", _nhom4.Cau16());

        TieuDe("Câu 17: Học viên đang học lớp của gia sư GS01");
        ConsoleTable.Print("MaHV|HoTen|NgaySinh|SDT", _nhom4.Cau17());

        TieuDe("Câu 18: Học viên chưa đăng ký lớp nào");
        ConsoleTable.Print("MaHV|HoTen", _nhom4.Cau18());

        TieuDe("Câu 19: Doanh thu theo tháng");
        ConsoleTable.Print("Nam|Thang|DoanhThu", _nhom4.Cau19());

        TieuDe("Câu 20: Thống kê học phí");
        ConsoleTable.Print("SoLop|ThapNhat|CaoNhat|TrungBinh|Tong", _nhom4.Cau20());
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