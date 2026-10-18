package vn.nhom99.mis.model;

import java.time.LocalDate;

public class HocVien {
    private String MaHocVien;
    private String HoTen;
    private LocalDate NgaySinh;
    private String GioiTinh;
    private String SoDienThoai;
    public HocVien(String MaHocVien, String HoTen, LocalDate NgaySinh, String GioiTinh, String SoDienThoai) {
        this.MaHocVien = MaHocVien;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.SoDienThoai = SoDienThoai;
    }
    public String getMaHocVien() {
        return MaHocVien;
    }
    public void setMaHocVien(String MaHocVien) {
        this.MaHocVien = MaHocVien;
    }
    public String getHoTen() {
        return HoTen;
    }
    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }
    public LocalDate getNgaySinh() {
        return NgaySinh;
    }
    public void setNgaySinh(LocalDate NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    public String getGioiTinh() {
        return GioiTinh;
    }
    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    public String getSoDienThoai() {
        return SoDienThoai;
    }
    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }
    @Override
    public String toString() {
        return MaHocVien + " | " + HoTen + " | " + NgaySinh + " | " + GioiTinh;
    }

}
