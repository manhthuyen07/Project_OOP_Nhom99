package vn.nhom99.mis.dao;
import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.DangKy;
import vn.nhom99.mis.model.DangKy;

import  java.util.List;
import java.util.Optional;
public class DangKyDAO {
    public final List<DangKy> ds;
    public DangKyDAO(KhoDuLieu Kho) {
        this.ds = Kho.getDsDangKy();
    }
    public List<DangKy> getAll() {
        return ds;
    }
    public Optional<DangKy> TimTheoMa(String ma) {
        return ds.stream().filter(d -> d.getMaDangKy().equals(ma)).findFirst();
    }
    public boolean them(DangKy d){
        if (TimTheoMa(d.getMaDangKy()).isPresent()) return false;
        return ds.add(d);
    }
    public boolean xoa(String ma){
        return ds.removeIf(d -> d.getMaDangKy().equals(ma));
    }
}
