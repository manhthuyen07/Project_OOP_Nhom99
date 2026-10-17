package vn.nhom99.mis.dao;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.DangKy;

import java.util.List;
public class DangKyDAO{
    public List<DangKy> findAll() {
        return KhoDuLieu.DS_DANG_KY;
    }
}