package vn.nhom99.mis.dao;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.LopHoc;

import java.util.List;
import java.util.Optional;

public class LopHocDAO {
    private final List<LopHoc> ds;

    public LopHocDAO(KhoDuLieu kho) {
        this.ds = kho.getDsLopHoc();
    }

    public List<LopHoc> getAll() {
        return ds;
    }

    public Optional<LopHoc> timTheoMa(String ma) {
        return ds.stream().filter(l -> l.getMaLop().equals(ma)).findFirst();
    }

    public boolean them(LopHoc l) {
        if (timTheoMa(l.getMaLop()).isPresent()) return false;
        return ds.add(l);
    }

    public boolean xoa(String ma) {
        return ds.removeIf(l -> l.getMaLop().equals(ma));
    }
}
