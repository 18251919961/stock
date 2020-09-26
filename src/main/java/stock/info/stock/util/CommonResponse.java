package stock.info.stock.util;

import lombok.Data;

@Data
public class CommonResponse
{
    // 返回码
    String resultCode;
    // 返回msg
    String msg;

    public CommonResponse(String resultCode, String msg)
    {
        this.resultCode = resultCode;
        this.msg = msg;
    }

    public CommonResponse()
    {
    }
}
