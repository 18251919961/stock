package stock.info.stock.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 股票类型：etf、股票、大盘
 */
public enum SingleStockType
{
    SingleStockCfgETF,SingleStockRealTimeInfoType,SingleStockComprehensive;
    static Map<Integer, Object> mapValues = new HashMap<>();
    static{
        mapValues.put(1, SingleStockComprehensive);
        mapValues.put(2, SingleStockRealTimeInfoType);
        mapValues.put(3, SingleStockCfgETF);
    }
    public static SingleStockType getValue(Integer valueNum)
    {
        Object obj = mapValues.get(valueNum);
        if (obj != null)
        {
            SingleStockType singleStockType = (SingleStockType)obj;
            return singleStockType;
        }
        return null;
    }
}
