package vn.nhom99.mis.model;

import java.time.LocalDate;

/** Liên kết N-N giữa HocVien và LopHoc. */
public final class DangKy {
    private final HocVien hocVien;
    private final LopHoc lopHoc;
    private final LocalDate ngayDangKy;

    public DangKy(HocVien hocVien, LopHoc lopHoc, LocalDate ngayDangKy) {
        this.hocVien = hocVien;
        this.lopHoc = lopHoc;
        this.ngayDangKy = ngayDangKy;
    }
    public HocVien getHocVien() { return hocVien; }
    public LopHoc getLopHoc() { return lopHoc; }
    public LocalDate getNgayDangKy() { return ngayDangKy; }
}
