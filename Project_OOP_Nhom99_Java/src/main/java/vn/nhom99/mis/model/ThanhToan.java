package vn.nhom99.mis.model;

import java.time.LocalDate;

public class ThanhToan {
    private String MaThanhToan;
    private String MaDangKy;
    private double SoTien;
    private LocalDate NgayThanhToan;
    private String PhuongThuc;

    public ThanhToan(String MaThanhToan, String MaDangKy, double SoTien, LocalDate NgayThanhToan, String PhuongThuc) {
        this.MaThanhToan = MaThanhToan;
        this.MaDangKy = MaDangKy;
        this.SoTien = SoTien;
        this.NgayThanhToan = NgayThanhToan;
        this.PhuongThuc = PhuongThuc;
    }
    public String getMaThanhToan() {
        return MaThanhToan;
    }
    public void setMaThanhToan(String MaThanhToan) {
        this.MaThanhToan = MaThanhToan;
    }
    public String getMaDangKy() {
        return MaDangKy;
    }
    public void setMaDangKy(String MaDangKy) {
        this.MaDangKy = MaDangKy;
    }
    public double getSoTien() {
        return SoTien;
    }
    public void setSoTien(double SoTien) {
        this.SoTien = SoTien;
    }
    public LocalDate getNgayThanhToan() {
        return NgayThanhToan;
    }
    public void setNgayThanhToan(LocalDate NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }
    public String getPhuongThuc() {
        return PhuongThuc;
    }
    public void setPhuongThuc(String PhuongThuc) {
        this.PhuongThuc = PhuongThuc;
    }
    @Override
    public String toString() {
        return MaThanhToan + " | " + MaDangKy + " | " + String.format(java.util.Locale.GERMANY, "%,.0f", SoTien) + " đ | " + NgayThanhToan + " | " + PhuongThuc;
    }
}
