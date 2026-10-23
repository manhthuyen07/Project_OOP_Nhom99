using Nhom99_MIS.Data;
using Nhom99_MIS.Queries.ThanhVien2;
using Nhom99_MIS.Util;

namespace Nhom99_MIS.Queries;

public sealed class TruyVanTongHop{
    public const int CauDau = 11;
    public const int CauCuoi = 20;

    private readonly TruyVan11_15 _nhom1;
    private readonly TruyVan16_20 _nhom2;

    public TruyVanTongHop(KhoDuLieu kho){
        _nhom1 = new TruyVan11_15(kho);
        _nhom2 = new TruyVan16_20(kho);
    }

    public static readonly IReadOnlyList<string> Titles = new[]{
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
    };

    public static readonly IReadOnlyList<string> Headers = new[]{
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
    };

    public List<Row> Execute(int number){
        if (number < CauDau || number > CauCuoi)
            throw new ArgumentException("Chọn câu từ 11 đến 20");
        Func<List<Row>>[] queries =
        {
            _nhom1.Cau11, _nhom1.Cau12, _nhom1.Cau13, _nhom1.Cau14, _nhom1.Cau15,
            _nhom2.Cau16, _nhom2.Cau17, _nhom2.Cau18, _nhom2.Cau19, _nhom2.Cau20
        };
        return queries[number - CauDau]();
    }
}
