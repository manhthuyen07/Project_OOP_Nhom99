using Nhom99_MIS.Data;
using Nhom99_MIS.Queries;
using Nhom99_MIS.Util;

namespace Nhom99_MIS.Tests;

public static class QueryTests{
    public static void Run(){
        var q = new TruyVanTongHop(new KhoDuLieu());
        var expected = new Dictionary<int, string[]>{
            [11] = new[] { "13550000" },
            [12] = new[] { "1600000" },
            [13] = new[] { "Có" },
            [14] = new[] { "GS01\t2\t2\tCó" },
            [15] = new[] { "300000\tCó" },
            [16] = new[] { "GS01\tNguyễn Văn An\t2", "GS02\tTrần Minh Bình\t2", "GS03\tLê Hoàng Nam\t1",
                           "GS04\tPhạm Thu Hà\t1", "GS05\tVõ Minh Đức\t1" },
            [17] = new[] { "HV01\tNguyễn Minh Anh\t2008\t0901000001", "HV02\tTrần Gia Huy\t2009\t0901000002",
                           "HV03\tLê Khánh Linh\t2008\t0901000003", "HV04\tPhạm Hoàng Long\t2007\t0901000004" },
            [18] = new[] { "HV06\tĐặng Minh Khang" },
            [19] = new[] { "2026\t5\t1800000", "2026\t6\t1600000", "2026\t8\t1500000", "2026\t9\t6250000", "2026\t10\t2400000" },
            [20] = new[] { "7\t1300000\t1900000\t1600000\t11200000" },
        };
        foreach (var (cau, want) in expected){
            var actual = q.Execute(cau)
                .Select(r => string.Join("\t", r.Values.Select(ConsoleTable.Raw))).ToArray();
            Check(actual.SequenceEqual(want),
                $"Câu {cau}: [{string.Join(" ; ", actual)}] != [{string.Join(" ; ", want)}]");
            Console.WriteLine($"PASS câu {cau}: {actual.Length} dòng");
        }

        Check(q.Execute(11).Count == 1 && q.Execute(11).Count == 1, "Chạy lặp câu 11");
        bool rejected = false;
        try { q.Execute(21); } catch (ArgumentException) { rejected = true; }
        Check(rejected, "Phải từ chối câu 21");
        Console.WriteLine("PASS tất cả câu 11-20; edge cases PASS.");
    }

    private static void Check(bool condition, string message){
        if (!condition) throw new InvalidOperationException(message);
    }
}
