namespace Nhom99.Mis.Model;

/// <summary>Trình độ của lớp học.</summary>
public enum TrinhDo
{
    CoBan,
    TrungCap,
    NangCao
}

public static class TrinhDoExtensions
{
    public static string GetTen(this TrinhDo t) => t switch
    {
        TrinhDo.CoBan => "Cơ bản",
        TrinhDo.TrungCap => "Trung cấp",
        TrinhDo.NangCao => "Nâng cao",
        _ => t.ToString()
    };
}
