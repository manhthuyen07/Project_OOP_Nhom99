package vn.nhom99.mis.model;

import java.util.Objects;

public class LopHoc{
    private String maLop;
    private String tenLop;
    private String monHoc;
    private double hocPhi;
    private TrangThaiLop trangThai;
    private GiaSu giaSu;

    public LopHoc(String maLop, String tenLop,String monHoc,double hocPhi, TrangThaiLop trangThai,GiaSu giaSu){
        this.maLop=maLop;
        this.tenLop=tenLop;
        this.monHoc=monHoc;
        this.hocPhi=hocPhi;
        this.trangThai=trangThai;
        this.giaSu=giaSu;
    }

    public String getMaLop(){
        return maLop;
    }
    public void setMaLop(String maLop){
        this.maLop=maLop;
    }
    public String getTenLop(){
        return tenLop;
    }
    public void setTenLop(String tenLop){
        this.maLop=maLop;
    }
    public String getMonHoc(){
        return monHoc;
    }
    public void setMonHoc(String monHoc){
        this.monHoc=monHoc;
    }
    public double getHocPhi(){
        return hocPhi;
    }
    public void setHocPhi(double hocPhi){
        this.hocPhi=hocPhi;
    }
    public TrangThaiLop getTrangThai(){
        return trangThai;
    }
    public void setTrangThai(TrangThaiLop trangThai){
        this.trangThai=trangThai;
    }
    public GiaSu getGiaSu(){
        return giaSu;
    }
    public void setGiaSu(GiaSu giaSu){
        this.giaSu=giaSu;
    }
    @Override
    public boolean equals(Object o) {
        return o instanceof LopHoc l &&Objects.equalsUmaLop,l.maLop);
    }

    @Override
    public int hashCode(){
        return Objects.hash(maLop);
    }
    @Override
    public String toString(){
        return String.format("%s | %s | %s | %,.0f | %s | %s", maLop, tenLop, monHoc, hocPhi, trangThai, giaSu.getMaGS());
    }
}
