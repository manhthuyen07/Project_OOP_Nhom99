package vn.nhom99.mis.data;

importvn.nhom99.mis.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class DuLieuMau{
    private DuLieuMau(){}

    public static List<GiaSu> taoGiaSu(){
        List<GiaSu> ds= new ArrayList<>();
        ds.add(new GiaSu("GS01", "Nguyễn Văn An", TrinhDo.DAI_HOC, 3, 150_000));
        ds.add(new GiaSu("GS02", "Trần Minh Bình", TrinhDo.THAC_SI, 5, 200_000));
        ds.add(new GiaSu("GS03", "Lê Hoàng Nam", TrinhDo.DAI_HOC, 2, 120_000));
        ds.add(new GiaSu("GS04", "Phạm Thu Hà", TrinhDo.TIEN_SI, 8, 300_000));
        ds.add(new GiaSu("GS05", "Võ Minh Đức", TrinhDo.THAC_SI, 6, 180_000));
        return ds;
    }

    public static List<HocVien> taoHocVien(){
        List<HocVien> ds = new ArrayList();
        ds.add(new HocVien("HV01", "Nguyễn Minh Anh", 2008, "0901000001"));
        ds.add(new HocVien("HV02", "Trần Gia Huy", 2009, "0901000002"));
        ds.add(new HocVien("HV03", "Lê Khánh Linh", 2008, "0901000003"));
        ds.add(new HocVien("HV04", "Phạm Hoàng Long", 2007, "0901000004"));
        ds.add(new HocVien("HV05", "Võ Ngọc Mai", 2009, "0901000005"));
        ds.add(new HocVien("HV06", "Đặng Minh Khang", 2010, "0901000006")); // chưa đăng ký lớp nào
        return ds;
    }

    public static List<LopHoc> taoLopHoc(List<GiaSu> gs){
        List<LopHoc> ds = new ArrayList<>();
        ds.add(new LopHoc("L01", "Toán 10A", "Toán", 1_500_000, TrangThaiLop.DANG_MO, gs.get(0)));
        ds.add(new LopHoc("L02", "Toán 11A", "Toán", 1_700_000, TrangThaiLop.DANG_MO, gs.get(1)));
        ds.add(new LopHoc("L03", "Anh Văn 10A", "Tiếng Anh", 1_400_000, TrangThaiLop.DA_DU, gs.get(2)));
        ds.add(new LopHoc("L04", "Vật Lý 12A", "Vật Lý", 1_800_000, TrangThaiLop.DA_KET_THUC, gs.get(3)));
        ds.add(new LopHoc("L05", "Hóa 11A", "Hóa học", 1_600_000, TrangThaiLop.TAM_NGUNG, gs.get(4)));
        ds.add(new LopHoc("L06", "Toán 12A", "Toán", 1_900_000, TrangThaiLop.DANG_MO, gs.get(0)));
        ds.add(new LopHoc("L07", "Toán 9A", "Toán", 1_300_000, TrangThaiLop.DANG_MO, gs.get(1)));
        return ds;
    }

    public static List<DangKy> taoDangKy(List<HocVien> hv, List<LopHoc> lop ){
        List<DangKy> ds=new ArrayList<>();
        ds.add(new DangKy(hv.get(0), lop.get(0), LocalDate.of(2026, 8, 25)));  // HV01 - L01
        ds.add(new DangKy(hv.get(0), lop.get(1), LocalDate.of(2026, 8, 26)));  // HV01 - L02 (nhiều lớp)
        ds.add(new DangKy(hv.get(1), lop.get(0), LocalDate.of(2026, 8, 27)));  // HV02 - L01
        ds.add(new DangKy(hv.get(1), lop.get(2), LocalDate.of(2026, 9, 1)));   // HV02 - L03
        ds.add(new DangKy(hv.get(2), lop.get(0), LocalDate.of(2026, 9, 2)));   // HV03 - L01
        ds.add(new DangKy(hv.get(2), lop.get(5), LocalDate.of(2026, 9, 3)));   // HV03 - L06
        ds.add(new DangKy(hv.get(3), lop.get(1), LocalDate.of(2026, 9, 5)));   // HV04 - L02
        ds.add(new DangKy(hv.get(3), lop.get(3), LocalDate.of(2026, 5, 10)));  // HV04 - L04
        ds.add(new DangKy(hv.get(4), lop.get(4), LocalDate.of(2026, 6, 15)));  // HV05 - L05
        ds.add(new DangKy(hv.get(4), lop.get(6), LocalDate.of(2026, 9, 10)));  // HV05 - L07
        return ds;
    }

    public static List<ThanhToan> taoThanhToan(List<HocVien> hv,List<LopHoc> lop){
        List<ThanhToan> ds=new ArrayList();
        ds.add(new ThanhToan("TT01", hv.get(0), lop.get(0), 1_500_000, LocalDate.of(2026, 8, 28))); // đủ
        ds.add(new ThanhToan("TT02", hv.get(0), lop.get(1), 1_000_000, LocalDate.of(2026, 9, 1)));  // trả
        ds.add(new ThanhToan("TT03", hv.get(0), lop.get(1), 700_000, LocalDate.of(2026, 9, 20)));   // nhiều lần, đủ
        ds.add(new ThanhToan("TT04", hv.get(1), lop.get(0), 800_000, LocalDate.of(2026, 9, 3)));    // một phần
        ds.add(new ThanhToan("TT05", hv.get(1), lop.get(2), 1_400_000, LocalDate.of(2026, 9, 4)));
        ds.add(new ThanhToan("TT06", hv.get(2), lop.get(0), 1_500_000, LocalDate.of(2026, 10, 2)));
        ds.add(new ThanhToan("TT07", hv.get(2), lop.get(5), 900_000, LocalDate.of(2026, 10, 5)));
        ds.add(new ThanhToan("TT08", hv.get(3), lop.get(1), 1_700_000, LocalDate.of(2026, 9, 8)));
        ds.add(new ThanhToan("TT09", hv.get(3), lop.get(3), 1_800_000, LocalDate.of(2026, 5, 12)));
        ds.add(new ThanhToan("TT10", hv.get(4), lop.get(4), 1_600_000, LocalDate.of(2026, 6, 18)));
        ds.add(new ThanhToan("TT11", hv.get(4), lop.get(6), 650_000, LocalDate.of(2026, 9, 12)));
        return ds;
    }
}