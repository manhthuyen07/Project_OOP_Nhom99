package vn.nhom99.mis.model;

import java.util.Objects;

/** Thực thể bất biến. equals/hashCode theo mã học viên để distinct() hoạt động đúng. */
public final class HocVien {
    private final String maHV;
    private final String hoTen;
    private final int namSinh;
    private final String soDienThoai;

    public HocVien(String maHV, String hoTen, int namSinh, String soDienThoai) {
        this.maHV = maHV;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.soDienThoai = soDienThoai;
    }
    public String getMaHV() { return maHV; }
    public String getHoTen() { return hoTen; }
    public int getNamSinh() { return namSinh; }
    public String getSoDienThoai() { return soDienThoai; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HocVien)) return false;
        return maHV.equals(((HocVien) o).maHV);
    }

    @Override
    public int hashCode() { return Objects.hash(maHV); }
}
