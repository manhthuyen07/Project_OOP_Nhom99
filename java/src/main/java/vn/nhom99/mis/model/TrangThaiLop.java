package vn.nhom99.mis.model;

public enum TrangThaiLop{
    DANG_MO("Đang mở"),
    DA_DU("Đã đủ"),
    DA_KET_THUC("Đã kết thúc"),
    TAM_NGUNG("Tạm ngưng");

    private final String moTa;
    TrangThaiLop(String moTa){
        this.moTa=moTa;
    }

    @Override
    public String toString(){
        return moTa;
    }
}