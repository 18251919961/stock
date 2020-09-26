package stock.info.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stock.info.stock.mappper.SingleStockCfgMapper;
import stock.info.stock.model.SingleStockCfg;
import stock.info.stock.service.SingleStockCfgService;

import java.util.List;

@Service
public class SingleStockCfgServiceImpl implements SingleStockCfgService
{
    @Autowired(required = false)
    SingleStockCfgMapper singleStockCfgMapper;

    @Override
    public void insertSingleStockCfg(List<SingleStockCfg> singleStockCfgList)
    {
        singleStockCfgMapper.insertSingleStockCfg(singleStockCfgList);
    }

    @Override
    public List<SingleStockCfg> getSingleStockCfg(SingleStockCfg singleStockCfg)
    {
        return singleStockCfgMapper.getSingleStockCfg(singleStockCfg);
    }

    @Override
    public void updateSingleStockCfg(SingleStockCfg singleStockCfg)
    {
        singleStockCfgMapper.updateSingleStockCfg(singleStockCfg);
    }
}
