package vn.nhom99.mis.dao;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.HocVien;

import java.util.List;

public class HocVienDAO{
    public List<HocVien> findAll(){
        return KhoDuLieu.DS_HOC_VIEN;
    }
}