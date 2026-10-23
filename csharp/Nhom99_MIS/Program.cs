using System.Text;
using Nhom99_MIS.Data;
using Nhom99_MIS.Queries;
using Nhom99_MIS.Tests;
using Nhom99_MIS.Util;

namespace Nhom99_MIS;

public static class Program{
    public static void Main(string[] args){
        Console.OutputEncoding = Encoding.UTF8;
        Console.InputEncoding = Encoding.UTF8;
        var truyVan = new TruyVanTongHop(new KhoDuLieu());

        if (args.Length > 0){
            if (args[0] == "--all") { ChayTatCa(truyVan); return; }
            if (args[0] == "--test") { QueryTests.Run(); return; }
            if (int.TryParse(args[0], out int so) && so >= TruyVanTongHop.CauDau && so <= TruyVanTongHop.CauCuoi){
                Chay(truyVan, so);
                return;
            }
            Console.Error.WriteLine("Cách dùng: --all, --test hoặc 11..20");
            Environment.Exit(1);
        }

        Console.WriteLine("QUẢN LÝ TRUNG TÂM GIA SƯ — C# LINQ (CÂU 11-20)");
        while (true){
            Console.WriteLine("\n11–20: chạy câu; A: tất cả; M: danh sách; 0: thoát");
            string? choice = Console.ReadLine()?.Trim();
            if (choice == null || choice == "0") return;
            if (choice.Equals("A", StringComparison.OrdinalIgnoreCase)) { ChayTatCa(truyVan); continue; }
            if (choice.Equals("M", StringComparison.OrdinalIgnoreCase)){
                for (int i = TruyVanTongHop.CauDau; i <= TruyVanTongHop.CauCuoi; i++)
                    Console.WriteLine($"{i}. {TruyVanTongHop.Titles[i - TruyVanTongHop.CauDau]}");
                continue;
            }
            if (int.TryParse(choice, out int cau) && cau >= TruyVanTongHop.CauDau && cau <= TruyVanTongHop.CauCuoi)
                Chay(truyVan, cau);
            else
                Console.WriteLine("Vui lòng chọn 11–20, A, M hoặc 0.");
        }
    }

    private static void ChayTatCa(TruyVanTongHop t){
        for (int i = TruyVanTongHop.CauDau; i <= TruyVanTongHop.CauCuoi; i++) Chay(t, i);
    }

    private static void Chay(TruyVanTongHop t, int i){
        Console.WriteLine($"\nCÂU {i}: {TruyVanTongHop.Titles[i - TruyVanTongHop.CauDau]}");
        ConsoleTable.Print(TruyVanTongHop.Headers[i - TruyVanTongHop.CauDau], t.Execute(i));
    }
}
