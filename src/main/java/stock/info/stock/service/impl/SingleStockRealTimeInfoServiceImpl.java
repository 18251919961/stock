package stock.info.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stock.info.stock.mappper.SingleStockRealTimeInfoMapper;
import stock.info.stock.model.SingleStockRealTimeInfo;
import stock.info.stock.service.SingleStockRealTimeInfoService;

import java.util.List;

@Service
public class SingleStockRealTimeInfoServiceImpl implements
    SingleStockRealTimeInfoService
{
    @Autowired(required = false)
    SingleStockRealTimeInfoMapper singleStockRealTimeInfoMapper;

    @Override
    public List<SingleStockRealTimeInfo> getSingleStockRealTimeInfoList(
        SingleStockRealTimeInfo singleStockRealTimeInfo)
    {
        return singleStockRealTimeInfoMapper.getSingleStockRealTimeInfoList(singleStockRealTimeInfo);
    }

    @Override
    public void insertSingleStockRealTimeInfo(
        List<SingleStockRealTimeInfo> singleStockRealTimeInfoList)
    {
        singleStockRealTimeInfoMapper.insertSingleStockRealTimeInfo(singleStockRealTimeInfoList);
    }
}
