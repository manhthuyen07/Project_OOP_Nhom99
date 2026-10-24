package vn.nhom99.mis.queries.ThanhVien2;

import vn.nhom99.mis.dao.DangKyDAO;
import vn.nhom99.mis.dao.GiaSuDAO;
import vn.nhom99.mis.dao.LopHocDAO;
import vn.nhom99.mis.dao.ThanhToanDAO;
import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.model.DangKy;
import vn.nhom99.mis.model.LopHoc;
import vn.nhom99.mis.model.ThanhToan;
import vn.nhom99.mis.model.TrangThaiLop;

import java.util.List;
import java.util.stream.Collectors;

/** Thành viên 2 - Câu 11 đến 15 (Java 8 Lambda & Stream API). */
public class TruyVan11_15 {
    private final GiaSuDAO giaSuDAO;
    private final LopHocDAO lopHocDAO;
    private final DangKyDAO dangKyDAO;
    private final ThanhToanDAO thanhToanDAO;

    public TruyVan11_15(KhoDuLieu kho) {
        this.giaSuDAO = new GiaSuDAO(kho);
        this.lopHocDAO = new LopHocDAO(kho);
        this.dangKyDAO = new DangKyDAO(kho);
        this.thanhToanDAO = new ThanhToanDAO(kho);
    }

    /** Câu 11: Tổng tiền đã thanh toán (map lấy số tiền, reduce cộng dồn; không có giao dịch thì trả 0). */
    public double cau11_TongTienDaThanhToan() {
        return thanhToanDAO.getAll().stream()
                .map(ThanhToan::getSoTien)
                .reduce(0.0, Double::sum);
    }

    /** Câu 12: Học phí trung bình của tất cả lớp học (không có lớp nào thì trả 0). */
    public double cau12_HocPhiTrungBinh() {
        return lopHocDAO.getAll().stream()
                .mapToDouble(LopHoc::getHocPhi)
                .average()
                .orElse(0);
    }

    /** Câu 13: Hệ thống có lớp nào đang mở (DANG_MO) hay không? (anyMatch) */
    public boolean cau13_CoLopDangMo() {
        return lopHocDAO.getAll().stream()
                .anyMatch(l -> l.getTrangThai() == TrangThaiLop.DANG_MO);
    }

    /**
     * Câu 14: Mọi lớp của một gia sư đều có ít nhất { toiThieu} học viên? (allMatch)
     * Lưu ý: gia sư không có lớp nào thì allMatch trả true, nên dùng kèm {@link #soLopCuaGiaSu(String)}.
     */
    public boolean cau14_TatCaLopDuHocVien(String maGiaSu, int toiThieu) {
        return lopCuaGiaSu(maGiaSu).stream()
                .allMatch(l -> demHocVien(l) >= toiThieu);
    }

    /** Số lớp của gia sư, để biết kết quả câu 14 có phải "true vì không có lớp nào" hay không. */
    public long soLopCuaGiaSu(String maGiaSu) {
        return lopCuaGiaSu(maGiaSu).size();
    }

    /** Câu 15: Không có gia sư nào trên { mucKinhNghiem} năm kinh nghiệm? (noneMatch) */
    public boolean cau15_KhongCoGiaSuVuotKinhNghiem(int mucKinhNghiem) {
        return giaSuDAO.getAll().stream()
                .noneMatch(g -> g.getSoNamKinhNghiem() > mucKinhNghiem);
    }
    private List<LopHoc> lopCuaGiaSu(String maGiaSu) {
        return lopHocDAO.getAll().stream()
                .filter(l -> maGiaSu.equals(l.getMaGiaSu()))   // lớp chưa có gia sư (null) thì bỏ qua, không lỗi
                .collect(Collectors.toList());
    }
    /** Số học viên (không trùng) đã đăng ký lớp. */
    private long demHocVien(LopHoc lop) {
        return dangKyDAO.getAll().stream()
                .filter(d -> d.getMaLop().equals(lop.getMaLop()))
                .map(DangKy::getMaHocVien)
                .distinct()
                .count();
    }
}
