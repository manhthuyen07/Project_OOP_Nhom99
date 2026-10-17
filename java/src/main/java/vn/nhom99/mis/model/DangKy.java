package vn.nhom99.mis.model;

import java.time.LocalDate;

public class DangKy{
    private HocVien hocVien;
    private LopHoc lopHoc;
    private Localdate ngayDangKy;

    public DangKy(HocVien hocVien, LopHoc LopHoc, LocalDate ngayDangKy){
        this.hocVien=hocVien;
        this.lopHoc=lopHoc;
        this.ngayDangKy=ngayDangKy;
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
    public LocalDate getNgayDangKy(){
        return ngayDangKy;
    }
    public void setNgayDangKy(LocalDate ngayDangKy){
        this.ngayDangKy=ngayDangKy;
    }

    @Override
    public String toString(){
        return hocVien.getMaHV() + " -> " + lopHoc.getMaLop()+" ("+ngayDangKy+")";
    }
}