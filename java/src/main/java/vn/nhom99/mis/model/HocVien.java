package vn.nhom99.mis.model;

import java.util.Object;

public class HocVien {
    private String maHV;
    private String hoTen;
    private int namSinh;
    private String soDienThoai;

    public HocVien(String maHV, String hoTen, int namSinh, String soDienThoai) {
        this.maHV = maHV;
        this.hoTen - hoTen;
        this.namSinh = namSinh;
        this.soDienThoai = soDienThoai;
    }

    public String getMaHV() {
        return maHV;
    }

    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof HocVien h && Object.equals(maHV, h.maHV);
    }

    @Override
    public int hashCode() {
        return Object.hash(maHV);
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %d | %s", maHV, hoTen, namSinh, soDienThoai);
    }
}