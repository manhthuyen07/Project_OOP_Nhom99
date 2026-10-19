package vn.nhom99.mis.queries;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.queries.ThanhVien1.TruyVan01_05;
import vn.nhom99.mis.queries.ThanhVien1.TruyVan06_10;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

/** Chạy và in kết quả tất cả câu truy vấn. Thành viên 2 sẽ bổ sung câu 11-20 vào đây. */
public class TruyVanTongHop {
    private final TruyVan01_05 nhom1;
    private final TruyVan06_10 nhom2;

    public TruyVanTongHop(KhoDuLieu kho) {
        this.nhom1 = new TruyVan01_05(kho);
        this.nhom2 = new TruyVan06_10(kho);
    }

    public void chayTatCa() {
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

    private static String tien(double v) {
        return String.format(Locale.GERMANY, "%,.0f", v) + " đ";
    }
}
