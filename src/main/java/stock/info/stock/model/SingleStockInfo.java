package stock.info.stock.model;

import lombok.Data;

import java.util.List;

/**
 * 单个股票信息
 */
@Data
public class SingleStockInfo implements Comparable
{
    // 股票代码
    private String stockNo;
    // 股票名字
    private String stockName;
    // 当天单一股票信息集合(有序的)
    List<SingleStockDateInfo> singleStockDateInfoList;

    @Override
    public int compareTo(Object o)
    {
        if (o instanceof SingleStockInfo)
        {
            SingleStockInfo dateInfo = (SingleStockInfo)o;
            if (dateInfo.stockNo == null)
            {
                return 1;
            }
            if (this.stockNo == null)
            {
                return -1;
            }
            return this.stockNo.compareTo(dateInfo.stockNo);
        }
        return 1;
    }
}
