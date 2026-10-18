package vn.nhom99.mis.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class ThanhToan {
    private final String maThanhToan;
    private final HocVien hocVien;
    private final LopHoc lopHoc;
    private final BigDecimal soTien;
    private final LocalDate ngayThanhToan;

    public ThanhToan(String maThanhToan, HocVien hocVien, LopHoc lopHoc, BigDecimal soTien, LocalDate ngayThanhToan) {
        this.maThanhToan = maThanhToan;
        this.hocVien = hocVien;
        this.lopHoc = lopHoc;
        this.soTien = soTien;
        this.ngayThanhToan = ngayThanhToan;
    }
    public String getMaThanhToan() { return maThanhToan; }
    public HocVien getHocVien() { return hocVien; }
    public LopHoc getLopHoc() { return lopHoc; }
    public BigDecimal getSoTien() { return soTien; }
    public LocalDate getNgayThanhToan() { return ngayThanhToan; }
}
