using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using Vn.Nhom99.Mis.Data;
using Vn.Nhom99.Mis.Queries.ThanhVien1;

namespace Vn.Nhom99.Mis
{
    /// <summary>Chạy trực tiếp bằng Main, không cần framework test.</summary>
    public static class RegressionTest
    {
        public static void Main(string[] args)
        {
            Console.OutputEncoding = System.Text.Encoding.UTF8;

            var kho = KhoDuLieu.GetInstance();
            var q1 = new TruyVan01_05(kho);
            var q2 = new TruyVan06_10(kho);

            var expected = new SortedDictionary<int, List<string>>
            {
                [1] = new List<string> { "L04\t4200000.0", "L02\t3500000.0", "L06\t2200000.0" },
                [2] = new List<string> { "GS03\t8", "GS01\t5", "GS05\t4" },
                [3] = new List<string>
                {
                    "L01 | Toán 9 Cơ bản | Gia sư: Nguyễn Văn An",
                    "L02 | Toán 12 Luyện thi | Gia sư: Nguyễn Văn An",
                    "L03 | IELTS Foundation | Gia sư: Trần Thị Bình",
                    "L04 | IELTS 6.5+ | Gia sư: Trần Thị Bình",
                    "L05 | Vật lý 11 | Gia sư: Lê Hoàng Cường",
                    "L06 | Toán 10 | Gia sư: Phạm Thu Dung",
                    "L07 | Vật lý 12 Nâng cao | Gia sư: Lê Hoàng Cường"
                },
                [4] = new List<string>
                {
                    "Nguyễn Văn An\t2", "Trần Thị Bình\t2", "Lê Hoàng Cường\t2",
                    "Phạm Thu Dung\t1", "Võ Minh Em\t0"
                },
                [5] = new List<string> { "HV01", "HV02", "HV03", "HV06" },
                [6] = new List<string>
                {
                    "IELTS 6.5+\t4200000.0", "IELTS Foundation\t5600000.0", "Toán 10\t0.0",
                    "Toán 12 Luyện thi\t3500000.0", "Toán 9 Cơ bản\t4000000.0",
                    "Vật lý 11\t4000000.0", "Vật lý 12 Nâng cao\t0.0"
                },
                [7] = new List<string> { "HV03", "HV05", "HV06", "HV08" },
                [8] = new List<string> { "L01\t3", "L03\t3" },
                [9] = new List<string>
                {
                    "Tiếng Anh\t3500000.0", "Toán\t2566666.6666666665", "Vật lý\t2750000.0"
                },
                [10] = new List<string>
                {
                    "Ngô Bảo Châu\t5500000.0", "Đặng Gia Huy\t4800000.0", "Phan Anh Phúc\t4200000.0"
                }
            };

            foreach (var e in expected)
            {
                List<string> actual = Execute(e.Key, q1, q2);
                Check(actual.SequenceEqual(e.Value),
                    $"Câu {e.Key}: [{string.Join(", ", actual)}] != [{string.Join(", ", e.Value)}]");
                Console.WriteLine($"PASS câu {e.Key}");
            }
            Console.WriteLine("PASS tất cả câu 01-10.");
        }

        /// <summary>Định dạng double giống Java: 4200000 -> "4200000.0", giữ nguyên phần thập phân khác.</summary>
        private static string Fmt(double d)
        {
            return d == Math.Floor(d) && !double.IsInfinity(d)
                ? d.ToString("0.0", CultureInfo.InvariantCulture)
                : d.ToString("R", CultureInfo.InvariantCulture);
        }

        private static List<string> Execute(int cau, TruyVan01_05 q1, TruyVan06_10 q2)
        {
            switch (cau)
            {
                case 1:
                    return q1.Cau01_LopDangMoTheoHocPhiGiam()
                        .Select(l => l.MaLop + "\t" + Fmt(l.HocPhi)).ToList();
                case 2:
                    return q1.Cau02_GiaSuKinhNghiemTren(3)
                        .Select(g => g.MaGiaSu + "\t" + g.SoNamKinhNghiem).ToList();
                case 3:
                    return q1.Cau03_LopKemTenGiaSu().ToList();
                case 4:
                    // Lưu ý: kết quả phải giữ thứ tự chèn (xem ghi chú bên dưới)
                    return q1.Cau04_SoLopMoiGiaSu()
                        .Select(e => e.Key + "\t" + e.Value).ToList();
                case 5:
                    return q1.Cau05_HocVienDangKyMon("Toán")
                        .Select(h => h.MaHocVien).OrderBy(s => s, StringComparer.Ordinal).ToList();
                case 6:
                    return q2.Cau06_DoanhThuTheoLop()
                        .OrderBy(e => e.Key, StringComparer.Ordinal)
                        .Select(e => e.Key + "\t" + Fmt(e.Value)).ToList();
                case 7:
                    return q2.Cau07_HocVienChuaThanhToan()
                        .Select(h => h.MaHocVien).OrderBy(s => s, StringComparer.Ordinal).ToList();
                case 8:
                    return q2.Cau08_LopDongHocVienNhat()
                        .Select(e => e.Key.MaLop + "\t" + e.Value)
                        .OrderBy(s => s, StringComparer.Ordinal).ToList();
                case 9:
                    return q2.Cau09_HocPhiTrungBinhTheoMon()
                        .Select(e => e.Key + "\t" + Fmt(e.Value)).ToList();
                case 10:
                    return q2.Cau10_Top3HocVienDongNhieuNhat()
                        .Select(e => e.Key + "\t" + Fmt(e.Value)).ToList();
                default:
                    throw new ArgumentException("Không có câu truy vấn " + cau);
            }
        }

        private static void Check(bool condition, string message)
        {
            if (!condition) throw new InvalidOperationException(message);
        }
    }
}