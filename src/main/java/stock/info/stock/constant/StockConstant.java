package stock.info.stock.constant;

public interface StockConstant
{
    String HTTP = "http";
    String HTTPS = "https";
    String HTML = ".html";
    // 东方财富域名
    String HTTP_STOCK_EAST_DOMAIN = "quote.eastmoney.com";
    // 上市地：深圳
    String HTTP_STOCK_LISTEDLOCATION_SH = "sh";
    // 上市地：上海
    String HTTP_STOCK_LISTEDLOCATION_SZ = "sz";
    // 上证、深圳、创业板
    String HTTP_STOCK_ZS = "zs";
    // 时间日期
    String DATE_FORMAT = "yyyyMMdd";
    // 时间
    String DATETIME_FORMAT = "yyyyMMdd HH:mm:ss";
    // 小时分
    String DATETIME_FORMAT_HOUR_MIN = "HHmm";
    // 定时任务关闭时间(下午3点10分以后)
    String DATETIME_CLOSE = "1510";
    // 定时任务开启时间(上午9点10分以后)
    String DATETIME_OPEN = "0910";
}
