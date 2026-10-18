package vn.nhom99.mis.model;

public enum TrangThaiLop {
    DANG_MO("Đang mở"),
    DANG_HOC("Đang học"),
    DA_KET_THUC("Đã kết thúc"),
    DA_HUY("Đã hủy");
    private final String ten;
    private TrangThaiLop(String ten) {
        this.ten = ten;
    }
    public String getTen() {
        return ten;
    }
    @Override
    public String toString() {
        return ten;
    }
}
