package stock.info.stock.schedules;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import stock.info.stock.constant.StockConstant;
import stock.info.stock.model.SingleStockCfg;
import stock.info.stock.model.SingleStockRealTimeInfo;
import stock.info.stock.service.SingleStockCfgService;
import stock.info.stock.service.SingleStockRealTimeInfoService;
import stock.info.stock.util.ConvertUtils;
import stock.info.stock.util.HttpStockUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
public class StockRealTimeInfoSchedule
{
    @Autowired
    SingleStockCfgService singleStockCfgService;

    @Autowired
    SingleStockRealTimeInfoService singleStockRealTimeInfoService;

    @Scheduled(cron = "30 0/5 9,10,11,13,14,15 * * MON-FRI")
    public void collectStockRealTimeInfo()
    {
        String dateStr = new SimpleDateFormat(StockConstant.DATETIME_FORMAT_HOUR_MIN).format(new Date());
        if (dateStr.compareTo(StockConstant.DATETIME_CLOSE) > 0 || dateStr.compareTo(StockConstant.DATETIME_OPEN) < 0 )
        {
            return;
        }
        List<SingleStockCfg> listSingleStockCfg =
            singleStockCfgService.getSingleStockCfg(null);
        List<SingleStockRealTimeInfo> list =
            new ArrayList<>();
        for (SingleStockCfg singleStockCfg : listSingleStockCfg)
        {
            try
            {
                Document doc =
                    HttpStockUtils.getDocumentFromHtmlUrl(singleStockCfg.getStockUrl());
                SingleStockRealTimeInfo singleStockRealTimeInfo1 =
                    ConvertUtils.getSingleNormalStockRealTimeInfoFromDoc(doc,
                        singleStockCfg);
                list.add(singleStockRealTimeInfo1);
            }
            catch (Exception e)
            {
                continue;
            }
        }
        singleStockRealTimeInfoService.insertSingleStockRealTimeInfo(list);
    }
}
