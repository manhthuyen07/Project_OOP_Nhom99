package vn.nhom99.mis.model;

public enum TrinhDo {
    CO_BAN("Cơ Bản"),
    TRUNG_CAP("Trung cấp"),
    NANG_CAO("Nâng cao");
    private final String ten;
    private TrinhDo(String ten) {
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
