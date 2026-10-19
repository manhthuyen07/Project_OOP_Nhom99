package vn.nhom99.mis.dao;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.ThanhToan;

import java.util.List;
import java.util.Optional;

public class ThanhToanDAO {
    private final List<ThanhToan> ds;

    public ThanhToanDAO(KhoDuLieu kho) {
        this.ds = kho.getDsThanhToan();
    }

    public List<ThanhToan> getAll() {
        return ds;
    }

    public Optional<ThanhToan> timTheoMa(String ma) {
        return ds.stream().filter(t -> t.getMaThanhToan().equals(ma)).findFirst();
    }

    public boolean them(ThanhToan t) {
        if (timTheoMa(t.getMaThanhToan()).isPresent()) return false;
        return ds.add(t);
    }

    public boolean xoa(String ma) {
        return ds.removeIf(t -> t.getMaThanhToan().equals(ma));
    }
}
