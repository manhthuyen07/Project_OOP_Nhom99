package vn.nhom99.mis.model;

import java.time.LocalDate;

public class DangKy {
    private String MaDangKy;
    private String MaHocVien;
    private String MaLop;
    private LocalDate NgayDangKy;
    public DangKy(String MaDangKy, String MaHocVien, String MaLop, LocalDate NgayDangKy) {
        this.MaDangKy = MaDangKy;
        this.MaHocVien = MaHocVien;
        this.MaLop = MaLop;
        this.NgayDangKy = NgayDangKy;
    }
    public String getMaDangKy() {
        return MaDangKy;
    }
    public String getMaHocVien() {
        return MaHocVien;
    }
    public String getMaLop() {
        return MaLop;
    }
    public LocalDate getNgayDangKy() {
        return NgayDangKy;
    }
    @Override
    public String toString() {
        return MaDangKy + " | " + MaHocVien + " -> " + MaLop + " | " + NgayDangKy;
    }
}
