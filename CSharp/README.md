# MIS Quản lý trung tâm gia sư — Nhóm 99 (câu 11-20, C# LINQ)

Bản C# của project Java: cùng model, dữ liệu mẫu, DAO và cùng kết quả cho câu 11-20.

## Chạy bằng Visual Studio hoặc Rider
Mở `Nhom99_MIS.sln` → chạy project `Nhom99_MIS` (.NET 8). Nhập 11–20 để chạy từng câu, A chạy tất cả, M xem danh sách, 0 thoát.

## Chạy bằng dòng lệnh (cần .NET 8 SDK)
```
cd Nhom99_MIS
dotnet run -- --all      # chạy cả 10 câu
dotnet run -- 15         # chạy riêng câu 15
dotnet run -- --test     # kiểm tra kết quả
```

## Cấu trúc
- `Models/`: GiaSu, HocVien, LopHoc, DangKy, ThanhToan, TrinhDo, TrangThaiLop (tiền dùng double như báo cáo)
- `Data/`: DuLieuMau, KhoDuLieu (dữ liệu trong bộ nhớ)
- `DAO/`: lớp trung gian lấy dữ liệu (FindAll)
- `Queries/ThanhVien2/`: TruyVan11_15, TruyVan16_20; `Queries/TruyVanTongHop`: tiêu đề, cột, Execute
- `Util/`: Row, ConsoleTable
- `Tests/QueryTests.cs`: kiểm tra kết quả
