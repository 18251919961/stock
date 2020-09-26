package stock.info.stock.service;

import org.springframework.stereotype.Service;
import stock.info.stock.model.SingleStockRealTimeInfo;

import java.util.List;

public interface SingleStockRealTimeInfoService
{
    /**
     * 获取相关集合
     * @param singleStockRealTimeInfo
     * @return
     */
    List<SingleStockRealTimeInfo> getSingleStockRealTimeInfoList(SingleStockRealTimeInfo singleStockRealTimeInfo);

    /**
     * 插入获取到的数据
     * @param singleStockRealTimeInfoList
     */
    void insertSingleStockRealTimeInfo(List<SingleStockRealTimeInfo> singleStockRealTimeInfoList);
}
