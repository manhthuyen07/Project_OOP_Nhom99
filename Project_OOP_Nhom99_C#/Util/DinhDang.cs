using System.Globalization;

namespace Nhom99.Mis;

/// <summary>Định dạng số tiền và ngày giống bản Java (Locale.GERMANY: 2.000.000).</summary>
public static class DinhDang
{
    private static readonly NumberFormatInfo Nfi = new NumberFormatInfo
    {
        NumberGroupSeparator = ".",
        NumberDecimalSeparator = ","
    };

    public static string Tien(double v) => v.ToString("#,##0", Nfi) + " đ";

    public static string Ngay(DateOnly d) => d.ToString("yyyy-MM-dd", CultureInfo.InvariantCulture);
}
