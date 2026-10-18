package vn.nhom99.mis.data;

import vn.nhom99.mis.model.DangKy;
import vn.nhom99.mis.model.GiaSu;
import vn.nhom99.mis.model.HocVien;
import vn.nhom99.mis.model.LopHoc;
import vn.nhom99.mis.model.ThanhToan;

import java.util.ArrayList;
import java.util.List;

/** Kho dữ liệu trong bộ nhớ (thay cho cơ sở dữ liệu). Dùng chung bởi các DAO. */
public class KhoDuLieu {
    private static KhoDuLieu instance;

    private final List<GiaSu> dsGiaSu = new ArrayList<>();
    private final List<HocVien> dsHocVien = new ArrayList<>();
    private final List<LopHoc> dsLopHoc = new ArrayList<>();
    private final List<DangKy> dsDangKy = new ArrayList<>();
    private final List<ThanhToan> dsThanhToan = new ArrayList<>();

    private KhoDuLieu() {
        DuLieuMau.nap(this);
    }

    public static KhoDuLieu getInstance() {
        if (instance == null) {
            instance = new KhoDuLieu();
        }
        return instance;
    }

    public List<GiaSu> getDsGiaSu() { return dsGiaSu; }
    public List<HocVien> getDsHocVien() { return dsHocVien; }
    public List<LopHoc> getDsLopHoc() { return dsLopHoc; }
    public List<DangKy> getDsDangKy() { return dsDangKy; }
    public List<ThanhToan> getDsThanhToan() { return dsThanhToan; }
}
