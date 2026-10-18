package vn.nhom99.mis.dao;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.GiaSu;

import java.util.List;
import java.util.Optional;

public class GiaSuDAO {
    private final List<GiaSu> ds;

    public GiaSuDAO(KhoDuLieu kho) {
        this.ds = kho.getDsGiaSu();
    }

    public List<GiaSu> getAll() {
        return ds;
    }

    public Optional<GiaSu> TimTheoMa(String ma) {
        return ds.stream().filter(g -> g.getMaGiaSu().equals(ma)).findFirst();
    }

    public boolean them(GiaSu g) {
        if (TimTheoMa(g.getMaGiaSu()).isPresent()) return false;
        return ds.add(g);
    }

    public boolean xoa(String ma) {
        return ds.removeIf(g -> g.getMaGiaSu().equals(ma));
    }
}