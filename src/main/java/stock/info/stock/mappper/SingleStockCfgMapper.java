package stock.info.stock.mappper;

import org.apache.ibatis.annotations.Mapper;
import stock.info.stock.model.SingleStockCfg;

import java.util.List;
@Mapper
public interface SingleStockCfgMapper
{
    /**
     * 新加入的股票代码
     * @param singleStockCfgList
     */
    void insertSingleStockCfg(List<SingleStockCfg> singleStockCfgList);

    /**
     * 根据条件查询股票信息
     * @param singleStockCfg
     * @return
     */
    List<SingleStockCfg> getSingleStockCfg(SingleStockCfg singleStockCfg);

    /**
     * 更改股票信息
     * @param singleStockCfg
     */
    void updateSingleStockCfg(SingleStockCfg singleStockCfg);
}
