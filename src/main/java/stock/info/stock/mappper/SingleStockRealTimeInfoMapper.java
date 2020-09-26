package stock.info.stock.mappper;

import org.apache.ibatis.annotations.Mapper;
import stock.info.stock.model.SingleStockRealTimeInfo;

import java.util.List;

@Mapper
public interface SingleStockRealTimeInfoMapper
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
