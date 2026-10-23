package vn.nhom99.mis;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.queries.TruyVanTongHop;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // Để console hiển thị đúng tiếng Việt có dấu (Java 8)
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        KhoDuLieu kho = KhoDuLieu.getInstance();
        new TruyVanTongHop(kho).chayTatCa();
    }
}
