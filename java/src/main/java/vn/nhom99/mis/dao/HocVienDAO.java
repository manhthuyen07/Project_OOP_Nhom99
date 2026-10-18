package vn.nhom99.mis.dao;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.HocVien;

import java.util.List;

/** Lớp trung gian lấy dữ liệu HocVien từ kho dữ liệu. */
public class HocVienDAO {
    private final KhoDuLieu kho;
    public HocVienDAO(KhoDuLieu kho) { this.kho = kho; }
    public List<HocVien> findAll() { return kho.getHocViens(); }
}
