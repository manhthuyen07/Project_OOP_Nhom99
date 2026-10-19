namespace Nhom99_MIS.Util;

public sealed class Row{
    public IReadOnlyList<object?> Values { get; }

    private Row(object?[] values) => Values = Array.AsReadOnly(values);

    public static Row Of(params object?[] values) => new(values);
}
