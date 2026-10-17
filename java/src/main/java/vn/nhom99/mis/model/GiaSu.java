package vn.nhom99.mis.model;

import java.util.Objects;

public class GiaSu{
    private String maGS;
    private String hoTen;
    private TrinhDo trinhDo;
    private int soNamKinhNghiem;
    private double luongGio;

    public GiaSu(String maGS, String hoTen,TrinhDo trinhDo,int soNamKinhNghiem, double luongGio){
        this.maGS=maGS;
        this.hoTen=hoTen;
        this.trinhDo=trinhDo;
        this.soNamKinhNghiem=soNamKinhNghiem;
        this.luongGio=luongGio;
    }
    public String getMaGS(){
        return maGS;
    }
    public void setMaGS(String maGS){
        this.maGS=maGS;
    }
    public String getHoTen(){
        return hoTen;
    }
    public void setHoTen(String hoTen){
        this.hoTen=hoTen;
    }
    public TrinhDo getTrinhDo(){
        return trinhDo;
    }
    public void setTrinhDo(TrinhDo trinhDo){
        this.trinhDo-trinhDo;
    }
    public int getSoNamKinhNghiem(){
        return soNamKinhNghiem;
    }
    public void setSoNamKinhNghiem(int soNamKinhNghiem){
        this.soNamKinhNghiem=soNamKinhNghiem;
    }
    public double getLuongGio(){
        return luongGio;
    }
    public void setLuongGio(double luongGio){
        this.luongGio=luongGio;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof GiaSu g && Object.equals(maGS,g.maGS)
    }

    @Override
    public int hashCode(){
        return Objects.hash(maGS);
    }

    @Override
    public String toString(){
        return String.format("%s | %s | %s | %d năm | %,.0f/giờ", maGS, hoTen, trinhDo, soNamKinhNghiem, luongGio);
    }
}