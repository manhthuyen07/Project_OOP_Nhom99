package vn.nhom99.mis.dao;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.GiaSu;

import java.util.List;

public class GiaSuDAO{
    public List<GiaSu> findAll(){
        return KhoDuLieu.DS_GIA_SU;
    }
}