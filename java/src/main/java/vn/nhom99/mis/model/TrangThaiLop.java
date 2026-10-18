package vn.nhom99.mis.model;

public enum TrangThaiLop {
    DANG_MO("Đang mở"), DA_DU("Đã đủ"), DA_KET_THUC("Đã kết thúc"), TAM_NGUNG("Tạm ngưng");

    private final String label;

    TrangThaiLop(String label) { this.label = label; }

    @Override
    public String toString() { return label; }
}