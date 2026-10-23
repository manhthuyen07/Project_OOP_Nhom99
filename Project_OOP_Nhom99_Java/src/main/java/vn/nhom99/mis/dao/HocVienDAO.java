package vn.nhom99.mis.dao;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.HocVien;

import java.util.List;
import java.util.Optional;

public class HocVienDAO {
    private final List<HocVien> ds;
    public HocVienDAO(KhoDuLieu Kho) {
        this.ds = Kho.getDsHocVien();
    }
    public List<HocVien> getAll() {
        return ds;
    }
    public Optional<HocVien> TimTheoMa(String ma) {
        return ds.stream().filter(h -> h.getMaHocVien().equals(ma)).findFirst();
    }
    public boolean them(HocVien h) {
        if(TimTheoMa(h.getMaHocVien()).isPresent()) return false;
        return ds.add(h);
    }
    public boolean xoa (String ma){
        return ds.stream().anyMatch(h -> h.getMaHocVien().equals(ma));
    }
}
