package vn.nhom99.mis.dao;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.ThanhToan;

import java.util.List;

/** Lớp trung gian lấy dữ liệu ThanhToan từ kho dữ liệu. */
public class ThanhToanDAO {
    private final KhoDuLieu kho;
    public ThanhToanDAO(KhoDuLieu kho) { this.kho = kho; }
    public List<ThanhToan> findAll() { return kho.getThanhToans(); }
}