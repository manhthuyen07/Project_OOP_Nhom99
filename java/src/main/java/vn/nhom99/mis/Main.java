package vn.nhom99.mis;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.queries.TruyVanTongHop;
import vn.nhom99.mis.util.ConsoleTable;

import java.util.Scanner;
import java.util.stream.IntStream;

public final class Main {
    public static void main(String[] args) throws Exception {
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        TruyVanTongHop truyVan = new TruyVanTongHop(new KhoDuLieu());
        if (args.length > 0) {
            if ("--all".equals(args[0])) { runAll(truyVan); return; }
            try { run(truyVan, Integer.parseInt(args[0])); }
            catch (IllegalArgumentException e) { System.err.println("Cách dùng: --all hoặc 11..20"); System.exit(1); }
            return;
        }
        System.out.println("QUẢN LÝ TRUNG TÂM GIA SƯ — JAVA 8 LAMBDA & STREAM API (CÂU 11-20)");
        Scanner input = new Scanner(System.in, "UTF-8");
        while (true) {
            System.out.println("\n11–20: chạy câu; A: tất cả; M: danh sách; 0: thoát");
            if (!input.hasNextLine()) return;
            String choice = input.nextLine().trim();
            if ("0".equals(choice)) return;
            if ("A".equalsIgnoreCase(choice)) { runAll(truyVan); continue; }
            if ("M".equalsIgnoreCase(choice)) {
                IntStream.rangeClosed(TruyVanTongHop.CAU_DAU, TruyVanTongHop.CAU_CUOI)
                        .forEach(i -> System.out.println(i + ". " + TruyVanTongHop.TITLES.get(i - TruyVanTongHop.CAU_DAU)));
                continue;
            }
            try { run(truyVan, Integer.parseInt(choice)); }
            catch (IllegalArgumentException e) { System.out.println("Vui lòng chọn 11–20, A, M hoặc 0."); }
        }
    }

    private static void runAll(TruyVanTongHop t) {
        IntStream.rangeClosed(TruyVanTongHop.CAU_DAU, TruyVanTongHop.CAU_CUOI).forEach(i -> run(t, i));
    }

    private static void run(TruyVanTongHop t, int i) {
        if (i < TruyVanTongHop.CAU_DAU || i > TruyVanTongHop.CAU_CUOI) throw new IllegalArgumentException("Câu không hợp lệ");
        System.out.println("\nCÂU " + i + ": " + TruyVanTongHop.TITLES.get(i - TruyVanTongHop.CAU_DAU));
        ConsoleTable.print(TruyVanTongHop.HEADERS.get(i - TruyVanTongHop.CAU_DAU), t.execute(i));
    }
}
