package vn.nhom99.mis.data;

import vn.nhom99.mis.model.*;

import java.util.Collections;
import java.util.List;

/** Kho dữ liệu trong bộ nhớ (thay cơ sở dữ liệu). List là unmodifiable, entity bất biến. */
public final class KhoDuLieu {
    private final List<GiaSu> giaSus;
    private final List<HocVien> hocViens;
    private final List<LopHoc> lopHocs;
    private final List<DangKy> dangKys;
    private final List<ThanhToan> thanhToans;
    public KhoDuLieu() {
        giaSus = Collections.unmodifiableList(DuLieuMau.giaSu());
        hocViens = Collections.unmodifiableList(DuLieuMau.hocVien());
        lopHocs = Collections.unmodifiableList(DuLieuMau.lopHoc(giaSus));
        dangKys = Collections.unmodifiableList(DuLieuMau.dangKy(hocViens, lopHocs));
        thanhToans = Collections.unmodifiableList(DuLieuMau.thanhToan(hocViens, lopHocs));
    }
    public List<GiaSu> getGiaSus() { return giaSus; }
    public List<HocVien> getHocViens() { return hocViens; }
    public List<LopHoc> getLopHocs() { return lopHocs; }
    public List<DangKy> getDangKys() { return dangKys; }
    public List<ThanhToan> getThanhToans() { return thanhToans; }
}
