package vn.nhom99.mis.model;

import java.math.BigDecimal;

/** Thực thể bất biến. giaSu thể hiện liên kết GiaSu 1 - N LopHoc. */
public final class LopHoc {
    private final String maLop;
    private final String tenLop;
    private final String monHoc;
    private final BigDecimal hocPhi;
    private final TrangThaiLop trangThai;
    private final GiaSu giaSu;

    public LopHoc(String maLop, String tenLop, String monHoc, BigDecimal hocPhi, TrangThaiLop trangThai, GiaSu giaSu) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.monHoc = monHoc;
        this.hocPhi = hocPhi;
        this.trangThai = trangThai;
        this.giaSu = giaSu;
    }

    public String getMaLop() { return maLop; }
    public String getTenLop() { return tenLop; }
    public String getMonHoc() { return monHoc; }
    public BigDecimal getHocPhi() { return hocPhi; }
    public TrangThaiLop getTrangThai() { return trangThai; }
    public GiaSu getGiaSu() { return giaSu; }
}
