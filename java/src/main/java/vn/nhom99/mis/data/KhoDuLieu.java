package vn.nhom99.mis.data;

import vn.nhom99.mis.model.*;
import java.util.List;

public final class KhoDuLieu{
    public static final List<GiaSu> DS_GIA_SU= DuLieuMau.taoGiaSu();
    public static final List<HocVien> DS_HOC_VIEN= DuLieuMau.taoHocVien();
    public static final List<lopHoc> DS_LOP_HOC= DuLieuMau.taoLopHoc(DS_GIA_SU);
    public static final List<DangKy> DS_DANG_KY = DuLieuMau.taoDangKy(DS_HOC_VIEN,DS_LOPHOC);
    public static final List<ThanhToan> DS_THANH_TOAN= DuLieuMau.taoThanhToan(DS_HOC_VIEN,DS_LOPHOC);

    private KhoDuLieu(){}
}