package vn.nhom99.mis.dao;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.DangKy;

import java.util.List;

/** Lớp trung gian lấy dữ liệu DangKy từ kho dữ liệu. */
public class DangKyDAO {
    private final KhoDuLieu kho;
    public DangKyDAO(KhoDuLieu kho) { this.kho = kho; }
    public List<DangKy> findAll() { return kho.getDangKys(); }
}
