package vn.nhom99.mis.queries;

import vn.nhom99.mis.data.KhoDuLieu;
import vn.nhom99.mis.queries.ThanhVien2.TruyVan11_15;
import vn.nhom99.mis.queries.ThanhVien2.TruyVan16_20;
import vn.nhom99.mis.util.Row;

import java.util.*;
import java.util.function.Supplier;

/**
 * Tổng hợp các câu truy vấn. Hiện có câu 11-20 (Thành viên 2).
 * Khi ghép với Thành viên 1: thêm câu 1-10 vào TITLES, HEADERS và execute().
 */
public final class TruyVanTongHop {
    public static final int CAU_DAU = 11;
    public static final int CAU_CUOI = 20;

    private final TruyVan11_15 nhom1;
    private final TruyVan16_20 nhom2;

    public TruyVanTongHop(KhoDuLieu kho) {
        nhom1 = new TruyVan11_15(kho);
        nhom2 = new TruyVan16_20(kho);
    }

    public static final List<String> TITLES = Collections.unmodifiableList(Arrays.asList(
            "Tính tổng tiền đã thanh toán",
            "Tính học phí trung bình",
            "Kiểm tra hệ thống có lớp đang mở",
            "Kiểm tra tất cả lớp của gia sư GS01 có đủ 2 học viên",
            "Kiểm tra không có gia sư vượt mức lương 300.000",
            "Đếm số lớp của từng gia sư",
            "Tìm tất cả học viên của gia sư GS01",
            "Tìm học viên chưa đăng ký lớp",
            "Doanh thu theo tháng",
            "Thống kê học phí"
    ));

    public static final List<String> HEADERS = Collections.unmodifiableList(Arrays.asList(
            "Tổng tiền đã thanh toán",
            "Học phí trung bình",
            "Có lớp đang mở",
            "Mã GS|Số lớp|Số học viên tối thiểu|Tất cả lớp đạt",
            "Mức lương|Không có gia sư vượt mức",
            "Mã GS|Họ tên|Số lớp",
            "Mã HV|Họ tên|Năm sinh|SĐT",
            "Mã HV|Họ tên",
            "Năm|Tháng|Doanh thu",
            "Số lớp|Thấp nhất|Cao nhất|Trung bình|Tổng học phí"
    ));

    /** Mỗi lần get() tạo kết quả mới, không tái sử dụng Stream đã đóng. */
    public List<Row> execute(int number) {
        if (number < CAU_DAU || number > CAU_CUOI) throw new IllegalArgumentException("Chọn câu từ 11 đến 20");
        List<Supplier<List<Row>>> queries = Arrays.asList(
                nhom1::cau11, nhom1::cau12, nhom1::cau13, nhom1::cau14, nhom1::cau15,
                nhom2::cau16, nhom2::cau17, nhom2::cau18, nhom2::cau19, nhom2::cau20);
        return queries.get(number - CAU_DAU).get();
    }
}
