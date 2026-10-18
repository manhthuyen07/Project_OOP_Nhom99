package vn.nhom99.mis.util;
import java.util.*;
/** Dòng kết quả chiếu (projection), thay cho anonymous object của C#. */
public final class Row {
    private final List<Object> values;
    private Row(Object... values) {
        this.values = Collections.unmodifiableList(new ArrayList<Object>(Arrays.asList(values)));
    }
    public static Row of(Object... values) { return new Row(values); }
    public List<Object> getValues() { return values; }
}
