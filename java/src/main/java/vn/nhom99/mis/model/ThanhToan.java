package vn.nhom99.mis.model;

import java.time.LocalDate;

public class ThanhToan{
    private String maThanhToan;
    private HocVien hocVien;
    private LopHoc lopHoc;
    private double soTien;
    private LocalDate ngayThanhToan;

    public ThanhToan(String maThanhToan,HocVien hocVien,LopHoc lopHoc,double soTien,LocalDate ngayThanhToan){
        this.maThanhToan=maThanhToan;
        this.hocVien=hocVien;
        this.lopHoc=lopHoc;
        this.soTien=soTien;
        this.ngayThanhToan=ngayThanhToan;
    }
    public String getMaThanhToan(){
        return maThanhToan;
    }
    public void setMaThanhToan(String maThanhToan){
        this.maThanhToan=maThanhToan;
    }
    public HocVien getHocVien(){
        return hocVien;
    }
    public void setHocVien(HocVien hocVien){
        this.hocVien=hocVien;
    }
    public LopHoc getLopHoc(){
        return lopHoc;
    }
    public void setLopHoc(LopHoc lopHoc){
        this.lopHoc=lopHoc;
    }
    public double getSotien(){
        return soTien;
    }
    public void setSoTien(double soTien){
        this.soTien=soTien;
    }
    public LocalDate getNgayThanhToan(){
        return ngayThanhToan;
    }
    public void setNgayThanhToan(LocalDate ngayThanhToan){
        this.ngayThanhToan=ngayThanhToan;
    }

    @Override
    public String toString(){
        return String.format("%s | %s | %s | %,.0f | %s", maThanhToan, hocVien.getMaHV(), lopHoc.getMaLop(), soTien, ngayThanhToan);
    }
}