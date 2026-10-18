package vn.nhom99.mis.model;

import java.math.BigDecimal;

/** Thực thể bất biến: dữ liệu chỉ được thiết lập qua constructor. */
public final class GiaSu {
    private final String maGS;
    private final String hoTen;
    private final TrinhDo trinhDo;
    private final int soNamKinhNghiem;
    private final BigDecimal luongGio;

    public GiaSu(String maGS, String hoTen, TrinhDo trinhDo, int soNamKinhNghiem, BigDecimal luongGio) {
        this.maGS = maGS;
        this.hoTen = hoTen;
        this.trinhDo = trinhDo;
        this.soNamKinhNghiem = soNamKinhNghiem;
        this.luongGio = luongGio;
    }
    public String getMaGS() { return maGS;}
    public String getHoTen() { return hoTen; }
    public TrinhDo getTrinhDo() { return trinhDo; }
    public int getSoNamKinhNghiem() { return soNamKinhNghiem; }
    public BigDecimal getLuongGio() { return luongGio; }
}
