package vn.nhom99.mis.dao;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.GiaSu;

import java.util.List;

public class GiaSuDAO {
    private final KhoDuLieu kho;
    public GiaSuDAO(KhoDuLieu kho) { this.kho = kho; }
    public List<GiaSu> findAll() { return kho.getGiaSus(); }
}