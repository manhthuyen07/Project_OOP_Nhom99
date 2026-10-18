package vn.nhom99.mis;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.queries.TruyVanTongHop;
import vn.nhom99.mis.util.ConsoleTable;

import java.util.*;
import java.util.stream.Collectors;

/** Chạy trực tiếp bằng main, không cần JUnit. Kết quả kỳ vọng tính tay từ dữ liệu mẫu. */
public final class RegressionTest {
    public static void main(String[] args) throws Exception {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        TruyVanTongHop q = new TruyVanTongHop(new KhoDuLieu());
        Map<Integer, List<String>> expected = new LinkedHashMap<>();
        expected.put(11, Arrays.asList("13550000"));
        expected.put(12, Arrays.asList("1600000"));
        expected.put(13, Arrays.asList("Có"));
        expected.put(14, Arrays.asList("GS01\t2\t2\tCó"));
        expected.put(15, Arrays.asList("300000\tCó"));
        expected.put(16, Arrays.asList("GS01\tNguyễn Văn An\t2", "GS02\tTrần Minh Bình\t2",
                "GS03\tLê Hoàng Nam\t1", "GS04\tPhạm Thu Hà\t1", "GS05\tVõ Minh Đức\t1"));
        expected.put(17, Arrays.asList("HV01\tNguyễn Minh Anh\t2008\t0901000001", "HV02\tTrần Gia Huy\t2009\t0901000002",
                "HV03\tLê Khánh Linh\t2008\t0901000003", "HV04\tPhạm Hoàng Long\t2007\t0901000004"));
        expected.put(18, Arrays.asList("HV06\tĐặng Minh Khang"));
        expected.put(19, Arrays.asList("2026\t5\t1800000", "2026\t6\t1600000", "2026\t8\t1500000",
                "2026\t9\t6250000", "2026\t10\t2400000"));
        expected.put(20, Arrays.asList("7\t1300000\t1900000\t1600000\t11200000"));
        for (Map.Entry<Integer, List<String>> e : expected.entrySet()) {
            List<String> actual = q.execute(e.getKey()).stream()
                    .map(r -> r.getValues().stream().map(ConsoleTable::raw).collect(Collectors.joining("\t")))
                    .collect(Collectors.toList());
            check(actual.equals(e.getValue()), "Câu " + e.getKey() + ": " + actual + " != " + e.getValue());
            System.out.println("PASS câu " + e.getKey() + ": " + actual.size() + " dòng");
        }
        // Chạy lặp để bắt lỗi dùng lại Stream đã đóng
        check(q.execute(11).equals(q.execute(11)) || q.execute(11).size() == 1, "Chạy lặp câu 11");
        boolean rejected = false;
        try { q.execute(21); } catch (IllegalArgumentException ex) { rejected = true; }
        check(rejected, "Phải từ chối câu 21");
        System.out.println("PASS tất cả câu 11-20; edge cases PASS.");
    }

    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}