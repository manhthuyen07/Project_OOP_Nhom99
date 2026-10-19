package vn.nhom99.mis;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.HocVien;
import vn.nhom99.mis.queries.ThanhVien1.TruyVan01_05;
import vn.nhom99.mis.queries.ThanhVien1.TruyVan06_10;

import java.util.*;
import java.util.stream.Collectors;

/** Chạy trực tiếp bằng main, không cần JUnit. */
public final class RegressionTest {
    public static void main(String[] args) {
        KhoDuLieu kho = KhoDuLieu.getInstance();
        TruyVan01_05 q1 = new TruyVan01_05(kho);
        TruyVan06_10 q2 = new TruyVan06_10(kho);

        Map<Integer, List<String>> expected = new LinkedHashMap<>();
        expected.put(1, Arrays.asList("L04\t4200000.0", "L02\t3500000.0", "L06\t2200000.0"));
        expected.put(2, Arrays.asList("GS03\t8", "GS01\t5", "GS05\t4"));
        expected.put(3, Arrays.asList(
                "L01 | Toán 9 Cơ bản | Gia sư: Nguyễn Văn An",
                "L02 | Toán 12 Luyện thi | Gia sư: Nguyễn Văn An",
                "L03 | IELTS Foundation | Gia sư: Trần Thị Bình",
                "L04 | IELTS 6.5+ | Gia sư: Trần Thị Bình",
                "L05 | Vật lý 11 | Gia sư: Lê Hoàng Cường",
                "L06 | Toán 10 | Gia sư: Phạm Thu Dung",
                "L07 | Vật lý 12 Nâng cao | Gia sư: Lê Hoàng Cường"));
        expected.put(4, Arrays.asList(
                "Nguyễn Văn An\t2", "Trần Thị Bình\t2", "Lê Hoàng Cường\t2",
                "Phạm Thu Dung\t1", "Võ Minh Em\t0"));
        expected.put(5, Arrays.asList("HV01", "HV02", "HV03", "HV06"));
        expected.put(6, Arrays.asList(
                "IELTS 6.5+\t4200000.0", "IELTS Foundation\t5600000.0", "Toán 10\t0.0",
                "Toán 12 Luyện thi\t3500000.0", "Toán 9 Cơ bản\t4000000.0",
                "Vật lý 11\t4000000.0", "Vật lý 12 Nâng cao\t0.0"));
        expected.put(7, Arrays.asList("HV03", "HV05", "HV06", "HV08"));
        expected.put(8, Arrays.asList("L01\t3", "L03\t3"));
        expected.put(9, Arrays.asList(
                "Tiếng Anh\t3500000.0", "Toán\t2566666.6666666665", "Vật lý\t2750000.0"));
        expected.put(10, Arrays.asList(
                "Ngô Bảo Châu\t5500000.0", "Đặng Gia Huy\t4800000.0", "Phan Anh Phúc\t4200000.0"));

        for (Map.Entry<Integer, List<String>> e : expected.entrySet()) {
            List<String> actual = execute(e.getKey(), q1, q2);
            check(actual.equals(e.getValue()), "Câu " + e.getKey() + ": " + actual + " != " + e.getValue());
            System.out.println("PASS câu " + e.getKey());
        }
        System.out.println("PASS tất cả câu 01-10.");
    }

    private static List<String> execute(int cau, TruyVan01_05 q1, TruyVan06_10 q2) {
        switch (cau) {
            case 1:
                return q1.cau01_LopDangMoTheoHocPhiGiam().stream()
                        .map(l -> l.getMaLop() + "\t" + l.getHocPhi()).collect(Collectors.toList());
            case 2:
                return q1.cau02_GiaSuKinhNghiemTren(3).stream()
                        .map(g -> g.getMaGiaSu() + "\t" + g.getSoNamKinhNghiem()).collect(Collectors.toList());
            case 3:
                return q1.cau03_LopKemTenGiaSu();
            case 4:
                return q1.cau04_SoLopMoiGiaSu().entrySet().stream()
                        .map(e -> e.getKey() + "\t" + e.getValue()).collect(Collectors.toList());
            case 5:
                return q1.cau05_HocVienDangKyMon("Toán").stream()
                        .map(HocVien::getMaHocVien).sorted().collect(Collectors.toList());
            case 6:
                return q2.cau06_DoanhThuTheoLop().entrySet().stream()
                        .sorted(Comparator.comparing((Map.Entry<String, Double> e) -> e.getKey()))
                        .map(e -> e.getKey() + "\t" + e.getValue()).collect(Collectors.toList());
            case 7:
                return q2.cau07_HocVienChuaThanhToan().stream()
                        .map(HocVien::getMaHocVien).sorted().collect(Collectors.toList());
            case 8:
                return q2.cau08_LopDongHocVienNhat().entrySet().stream()
                        .map(e -> e.getKey().getMaLop() + "\t" + e.getValue())
                        .sorted().collect(Collectors.toList());
            case 9:
                return q2.cau09_HocPhiTrungBinhTheoMon().entrySet().stream()
                        .map(e -> e.getKey() + "\t" + e.getValue()).collect(Collectors.toList());
            case 10:
                return q2.cau10_Top3HocVienDongNhieuNhat().entrySet().stream()
                        .map(e -> e.getKey() + "\t" + e.getValue()).collect(Collectors.toList());
            default:
                throw new IllegalArgumentException("Không có câu truy vấn " + cau);
        }
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}

