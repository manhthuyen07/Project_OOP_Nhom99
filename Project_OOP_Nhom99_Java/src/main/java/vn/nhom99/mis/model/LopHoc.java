package vn.nhom99.mis.model;

import java.time.LocalDate;

public class LopHoc {
    private String MaLop;
    private String TenLop;
    private String MonHoc;
    private TrinhDo TrinhDo;
    private String MaGiaSu;
    private double HocPhi;
    private int SiSoToiDa;
    private LocalDate NgayBatDau;
    private TrangThaiLop TrangThai;
    public LopHoc(String MaLop, String TenLop, String MonHoc, TrinhDo TrinhDo, String MaGiaSu, double HocPhi, int SiSoToiDa, LocalDate NgayBatDau, TrangThaiLop TrangThai) {
        this.MaLop = MaLop;
        this.TenLop = TenLop;
        this.MonHoc = MonHoc;
        this.TrinhDo = TrinhDo;
        this.MaGiaSu = MaGiaSu;
        this.HocPhi = HocPhi;
        this.SiSoToiDa = SiSoToiDa;
        this.NgayBatDau = NgayBatDau;
        this.TrangThai = TrangThai;
    }
    public String getMaLop() {
        return MaLop;
    }
    public void setMaLop(String MaLop) {
        this.MaLop = MaLop;
    }
    public String getTenLop() {
        return TenLop;
    }
    public void setTenLop(String TenLop) {
        this.TenLop = TenLop;
    }
    public String getMonHoc() {
        return MonHoc;
    }
    public void setMonHoc(String MonHoc) {
        this.MonHoc = MonHoc;
    }
    public TrinhDo getTrinhDo(){
        return TrinhDo;
    }
    public void setTrinhDo(TrinhDo TrinhDo){
        this.TrinhDo = TrinhDo;
    }
    public String getMaGiaSu() {
        return MaGiaSu;
    }
    public void setMaGiaSu(String MaGiaSu) {
        this.MaGiaSu = MaGiaSu;
    }
    public double getHocPhi() {
        return HocPhi;
    }
    public void setHocPhi(double HocPhi) {
        this.HocPhi = HocPhi;
    }
    public int getSiSoToiDa() {
        return SiSoToiDa;
    }
    public void setSiSoToiDa(int SiSoToiDa) {
        this.SiSoToiDa = SiSoToiDa;
    }
    public LocalDate getNgayBatDau() {
        return NgayBatDau;
    }
    public void setNgayBatDau(LocalDate NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public TrangThaiLop getTrangThai() {
        return TrangThai;
    }
    public void setTrangThai(TrangThaiLop TrangThai) {
        this.TrangThai = TrangThai;
    }
    @Override
    public String toString() {
        return MaLop + " | " + TenLop + " | " + MonHoc + " | " + TrinhDo + " | " + String.format(java.util.Locale.GERMANY, "%,.0f", HocPhi) + " đ | " + TrangThai;
    }
}