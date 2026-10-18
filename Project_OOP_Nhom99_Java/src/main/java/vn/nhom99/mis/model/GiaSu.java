package vn.nhom99.mis.model;

public class GiaSu {
    private String MaGiaSu;
    private String HoTen;
    private String MonDay;
    private int SoNamKinhNghiem;
    private String SoDienThoai;

    public GiaSu(String MaGiaSu, String HoTen, String MonDay, int SoNamKinhNghiem, String SoDienThoai) {
        this.MaGiaSu = MaGiaSu;
        this.HoTen = HoTen;
        this.MonDay = MonDay;
        this.SoNamKinhNghiem = SoNamKinhNghiem;
        this.SoDienThoai = SoDienThoai;
    }

    public String getMaGiaSu() {
        return MaGiaSu;
    }

    public void setMaGiaSu(String MaGiaSu) {
        this.MaGiaSu = MaGiaSu;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getMonDay() {
        return MonDay;
    }
    public void setMonDay(String MonDay) {
        this.MonDay = MonDay;
    }
    public int getSoNamKinhNghiem() {
        return SoNamKinhNghiem;
    }
    public void setSoNamKinhNghiem(int SoNamKinhNghiem) {
        this.SoNamKinhNghiem = SoNamKinhNghiem;
    }
    public String getSoDienThoai() {
        return SoDienThoai;
    }
    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }
    @Override
    public String toString() {
        return MaGiaSu + " | " + HoTen + " | " + MonDay + " | " + SoNamKinhNghiem + " năm";
    }
}
