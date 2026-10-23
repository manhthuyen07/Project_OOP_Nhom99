using Nhom99_MIS.Models;

namespace Nhom99_MIS.Data;

public sealed class KhoDuLieu{
    public IReadOnlyList<GiaSu> GiaSus { get; }
    public IReadOnlyList<HocVien> HocViens { get; }
    public IReadOnlyList<LopHoc> LopHocs { get; }
    public IReadOnlyList<DangKy> DangKys { get; }
    public IReadOnlyList<ThanhToan> ThanhToans { get; }

    public KhoDuLieu(){
        GiaSus = DuLieuMau.TaoGiaSu().AsReadOnly();
        HocViens = DuLieuMau.TaoHocVien().AsReadOnly();
        LopHocs = DuLieuMau.TaoLopHoc(GiaSus).AsReadOnly();
        DangKys = DuLieuMau.TaoDangKy(HocViens, LopHocs).AsReadOnly();
        ThanhToans = DuLieuMau.TaoThanhToan(HocViens, LopHocs).AsReadOnly();
    }
}
