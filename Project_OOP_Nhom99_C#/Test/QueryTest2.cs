using Nhom99.Mis.Data;
using Nhom99.Mis.Queries.ThanhVien2;
using Nhom99.Mis.Util;

namespace Nhom99.Mis.Test;

public static class QueryTests
{
    public static void Run(KhoDuLieu kho)
    {
        var q1 = new TruyVan11_15(kho);
        var q2 = new TruyVan16_20(kho);

        var actualByCau = new SortedDictionary<int, Func<List<Row>>>
        {
            [11] = q1.Cau11,
            [12] = q1.Cau12,
            [13] = q1.Cau13,
            [14] = q1.Cau14,
            [15] = q1.Cau15,
            [16] = q2.Cau16,
            [17] = q2.Cau17,
            [18] = q2.Cau18,
            [19] = q2.Cau19,
            [20] = q2.Cau20,
        };

        var expected = new Dictionary<int, string[]>
        {
            [11] = new[] { "21300000" },
            [12] = new[] { "2885714.29" },
            [13] = new[] { "Có" },
            [14] = new[] { "GS01\t2\t2\tCó" },
            [15] = new[] { "10\tCó" },
            [16] = new[]
            {
                "GS01\tNguyễn Văn An\t2",
                "GS02\tTrần Thị Bình\t2",
                "GS03\tLê Hoàng Cường\t2",
                "GS04\tPhạm Thu Dung\t1",
                "GS05\tVõ Minh Em\t0"
            },
            [17] = new[]
            {
                "HV01\tĐặng Gia Huy\t12/03/2010\t0912000001",
                "HV02\tNgô Bảo Châu\t25/07/2009\t0912000002",
                "HV03\tBùi Quang Khải\t02/11/2008\t0912000003",
                "HV06\tLý Ngọc Oanh\t09/09/2008\t0912000006"
            },
            [18] = Array.Empty<string>(),
            [19] = new[]
            {
                "2026\t6\t4000000",
                "2026\t8\t8600000",
                "2026\t9\t8700000"
            },
            [20] = new[] { "7\t2000000\t4200000\t2885714.29\t20200000" },
        };

        foreach (var (cau, chay) in actualByCau)
        {
            var actual = chay()
                .Select(r => string.Join("\t", r.Values.Select(ConsoleTable.Raw))).ToArray();
            var want = expected[cau];
            Check(actual.SequenceEqual(want),
                $"Câu {cau}: [{string.Join(" ; ", actual)}] != [{string.Join(" ; ", want)}]");
            Console.WriteLine($"PASS câu {cau}: {actual.Length} dòng");
        }

        Check(q1.Cau11().Count == 1 && q1.Cau11().Count == 1, "Chạy lặp câu 11");
        Console.WriteLine("PASS tất cả câu 11-20.");
    }

    private static void Check(bool condition, string message)
    {
        if (!condition) throw new InvalidOperationException(message);
    }
}