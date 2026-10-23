using System.Globalization;

namespace Nhom99.Mis.Util;

public static class ConsoleTable
{
    private static readonly NumberFormatInfo Vi = new()
    {
        NumberGroupSeparator = ".",
        NumberDecimalSeparator = ","
    };

    public static string Raw(object? value) => value switch
    {
        null => "NULL",
        double d => d.ToString("0.##", CultureInfo.InvariantCulture),
        DateOnly date => date.ToString("dd/MM/yyyy", CultureInfo.InvariantCulture),
        _ => Convert.ToString(value, CultureInfo.InvariantCulture) ?? ""
    };

    public static string CoKhong(bool value) => value ? "Có" : "Không";

    public static void Print(string header, IReadOnlyList<Row> rows)
    {
        Console.WriteLine(header.Replace("|", " | "));
        foreach (var row in rows)
        {
            Console.WriteLine(string.Join(" | ", row.Values.Select(v =>
                v is double d ? d.ToString("#,##0.##", Vi) : Raw(v))));
        }
        if (rows.Count == 0) Console.WriteLine("(Không có dữ liệu)");
        Console.WriteLine("Số dòng: " + rows.Count);
    }
}