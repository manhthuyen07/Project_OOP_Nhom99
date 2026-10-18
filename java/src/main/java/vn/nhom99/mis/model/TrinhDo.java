package vn.nhom99.mis.model;

public enum TrinhDo {
    DAI_HOC("Đại học"), THAC_SI("Thạc sĩ"), TIEN_SI("Tiến sĩ");

    private final String label;

    TrinhDo(String label) { this.label = label; }

    @Override
    public String toString() { return label; }
}