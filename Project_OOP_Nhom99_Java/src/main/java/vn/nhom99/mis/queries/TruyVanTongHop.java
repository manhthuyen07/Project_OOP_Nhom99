package vn.nhom99.mis.queries;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.queries.ThanhVien1.TruyVan01_05;
import vn.nhom99.mis.queries.ThanhVien1.TruyVan06_10;
import vn.nhom99.mis.queries.ThanhVien2.TruyVan11_15;
import vn.nhom99.mis.queries.ThanhVien2.TruyVan16_20;

import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.Locale;

/** Chạy và in kết quả tất cả 20 câu truy vấn (câu 01-10: Thành viên 1, câu 11-20: Thành viên 2). */
public class TruyVanTongHop {
    private final TruyVan01_05 nhom1;
    private final TruyVan06_10 nhom2;
    private final TruyVan11_15 nhom3;
    private final TruyVan16_20 nhom4;

    public TruyVanTongHop(KhoDuLieu kho) {
        this.nhom1 = new TruyVan01_05(kho);
        this.nhom2 = new TruyVan06_10(kho);
        this.nhom3 = new TruyVan11_15(kho);
        this.nhom4 = new TruyVan16_20(kho);
    }

    public void chayTatCa() {
        chayThanhVien1();
        chayThanhVien2();
    }

    public void chayThanhVien1() {
        tieuDe("Câu 01: Các lớp đang mở, học phí giảm dần");
        in(nhom1.cau01_LopDangMoTheoHocPhiGiam());

        tieuDe("Câu 02: Gia sư có hơn 3 năm kinh nghiệm");
        in(nhom1.cau02_GiaSuKinhNghiemTren(3));

        tieuDe("Câu 03: Lớp học kèm tên gia sư");
        in(nhom1.cau03_LopKemTenGiaSu());

        tieuDe("Câu 04: Số lớp của mỗi gia sư");
        nhom1.cau04_SoLopMoiGiaSu().forEach((ten, soLop) -> System.out.println(ten + ": " + soLop + " lớp"));

        tieuDe("Câu 05: Học viên đã đăng ký lớp môn Toán");
        in(nhom1.cau05_HocVienDangKyMon("Toán"));

        tieuDe("Câu 06: Doanh thu theo lớp");
        nhom2.cau06_DoanhThuTheoLop().forEach((lop, tien) -> System.out.println(lop + ": " + tien(tien)));

        tieuDe("Câu 07: Học viên chưa đóng học phí");
        in(nhom2.cau07_HocVienChuaThanhToan());

        tieuDe("Câu 08: Lớp đông học viên nhất");
        nhom2.cau08_LopDongHocVienNhat().forEach((lop, sl) -> System.out.println(lop + " -> " + sl + " học viên"));

        tieuDe("Câu 09: Học phí trung bình theo môn");
        nhom2.cau09_HocPhiTrungBinhTheoMon().forEach((mon, tb) -> System.out.println(mon + ": " + tien(tb)));

        tieuDe("Câu 10: Top 3 học viên đóng nhiều nhất");
        nhom2.cau10_Top3HocVienDongNhieuNhat().forEach((ten, tien) -> System.out.println(ten + ": " + tien(tien)));
    }

    public void chayThanhVien2() {
        tieuDe("Câu 11: Tổng tiền đã thanh toán");
        System.out.println("Tổng: " + tien(nhom3.cau11_TongTienDaThanhToan()));

        tieuDe("Câu 12: Học phí trung bình của các lớp");
        System.out.println("Trung bình: " + tien(nhom3.cau12_HocPhiTrungBinh()));

        tieuDe("Câu 13: Có lớp đang mở không?");
        System.out.println(coKhong(nhom3.cau13_CoLopDangMo()));

        tieuDe("Câu 14: Mọi lớp của gia sư GS01 có ít nhất 2 học viên?");
        System.out.println("GS01 có " + nhom3.soLopCuaGiaSu("GS01") + " lớp -> "
                + coKhong(nhom3.cau14_TatCaLopDuHocVien("GS01", 2)));
        System.out.println("(với mức tối thiểu 3: " + coKhong(nhom3.cau14_TatCaLopDuHocVien("GS01", 3)) + ")");

        tieuDe("Câu 15: Không có gia sư nào lương theo giờ vượt 300.000?");
        System.out.println(nhom3.cau15_KhongCoGiaSuVuotLuong(300_000)
                ? "Đúng (không ai vượt)" : "Sai (có gia sư vượt)");

        tieuDe("Câu 16: Học viên đăng ký từ 2 lớp trở lên");
        nhom4.cau16_HocVienDangKyTuNLop(2).forEach((hv, soLop) -> System.out.println(hv + " -> " + soLop + " lớp"));

        tieuDe("Câu 17: Học viên đang học các lớp của gia sư GS01");
        in(nhom4.cau17_HocVienCuaGiaSu("GS01"));

        tieuDe("Câu 18: Học viên chưa đăng ký lớp nào");
        in(nhom4.cau18_HocVienChuaDangKy());

        tieuDe("Câu 19: Doanh thu theo tháng");
        nhom4.cau19_DoanhThuTheoThang().forEach((thang, tien) -> System.out.println(thang + ": " + tien(tien)));

        tieuDe("Câu 20: Thống kê học phí");
        DoubleSummaryStatistics st = nhom4.cau20_ThongKeHocPhi();
        if (st.getCount() == 0) {
            System.out.println("(không có lớp nào)");
        } else {
            System.out.println("Số lớp      : " + st.getCount());
            System.out.println("Thấp nhất   : " + tien(st.getMin()));
            System.out.println("Cao nhất    : " + tien(st.getMax()));
            System.out.println("Trung bình  : " + tien(st.getAverage()));
            System.out.println("Tổng học phí: " + tien(st.getSum()));
        }
    }

    private static void tieuDe(String s) {
        System.out.println();
        System.out.println("=== " + s + " ===");
    }

    private static void in(Collection<?> ds) {
        if (ds.isEmpty()) {
            System.out.println("(không có kết quả)");
        } else {
            ds.forEach(System.out::println);
        }
    }

    private static String coKhong(boolean b) {
        return b ? "Có" : "Không";
    }

    private static String tien(double v) {
        return String.format(Locale.GERMANY, "%,.0f", v) + " đ";
    }
}
