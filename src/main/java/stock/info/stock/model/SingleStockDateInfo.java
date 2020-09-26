package stock.info.stock.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 单个股票某一天的信息
 */
@Data
public class SingleStockDateInfo implements Comparable
{
    // 股票代码
    private String stockNo;
    // 股票名字
    private String stockName;
    // 当天日期
    private String date;
    // 当天单一股票信息集合(有序的)
    List<SingleStockRealTimeInfo> singleStockRealTimeInfoList;

    @Override
    public int compareTo(Object o)
    {
        if (o instanceof  SingleStockDateInfo)
        {
            SingleStockDateInfo dateInfo = (SingleStockDateInfo)o;
            if (dateInfo.date == null)
            {
                return 1;
            }
            if (this.date == null)
            {
                return -1;
            }
            return this.date.compareTo(dateInfo.date);
        }
        return 1;
    }
}
