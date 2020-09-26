package stock.info.stock.util;

import stock.info.stock.model.SingleStockRealTimeInfo;

import java.util.Date;

/**
 *通用股票提取
 */
public class CommonStockInfoExtractUtils
{
    /**
     * 设置singleStockRealTimeInfo时间信息
     * @param singleStockRealTimeInfo
     */
    public static void createStockRealTimeInfo(
        SingleStockRealTimeInfo singleStockRealTimeInfo)
    {
        // 设置时间
        singleStockRealTimeInfo.setRealTime(new Date());
        singleStockRealTimeInfo.setRealTimeStr(DateConvertUtils.getDateTimeStr(new Date()));
        singleStockRealTimeInfo.setDate(DateConvertUtils.getDateStr(new Date()));
    }
}
