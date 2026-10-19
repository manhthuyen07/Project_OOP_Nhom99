package vn.nhom99.mis.dao;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.LopHoc;

import java.util.List;

public class LopHocDAO {
    private final KhoDuLieu kho;
    public LopHocDAO(KhoDuLieu kho) { this.kho = kho; }
    public List<LopHoc> findAll() { return kho.getLopHocs(); }
}
