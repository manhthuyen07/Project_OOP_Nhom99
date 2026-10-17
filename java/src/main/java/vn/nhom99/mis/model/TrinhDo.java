package vn.nhom99.mis.model;

public enum TrinhDo{
    DAI_HOC("Đại học"),
    THAC_SI("Thạc sĩ"),
    TIEN_SI("Tiến sĩ");

    private final String moTa;
    TrinhDo(String moTa){
        this.moTa=moTa;
    }

    @Override
    public String toString(){
        return moTa;
    }
}