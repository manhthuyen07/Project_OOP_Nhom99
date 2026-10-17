package vn.nhom99.mis.dao;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.ThanhToan;

import java.util.List;

public class ThanhToanDAO{
    public List<ThanhToan> findAll(){
        return KhoDuLieu.DS_THANH_TOAN;
    }
}