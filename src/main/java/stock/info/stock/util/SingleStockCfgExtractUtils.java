package stock.info.stock.util;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.Map;
import org.springframework.util.StringUtils;
import stock.info.stock.model.SingleStockCfg;

public class SingleStockCfgExtractUtils
{
    /**
     * 通过doc获取SingleStockCfg
     * @param doc
     * @return
     */
    public static SingleStockCfg getSingleStockCfgStockName(Document doc)
    {
        Elements elementName = doc.select("#name");
        Elements elementNo = doc.select("#code");
        String stockName = elementName.text();
        String stockNo = elementNo.text();
        if (StringUtils.isEmpty(stockName) || StringUtils.isEmpty(stockNo))
        {
            return null;
        }
        SingleStockCfg cfg = new SingleStockCfg();
        cfg.setStockNo(stockNo.trim());
        cfg.setStockName(stockName.trim());
        return cfg;
    }

    /**
     * 通过map获取SingleStockCfg
     * @param map
     * @return
     */
    public static SingleStockCfg getSingleStockCfgStockNameFromMap(Map<String, Object> map)
    {
        SingleStockCfg cfg;
        try
        {
            Document doc = (Document)map.get("doc");
            Elements elementName = doc.select("#name");
            Elements elementNo = doc.select("#code");
            String stockName = elementName.text();
            String stockNo = elementNo.text();
            if (StringUtils.isEmpty(stockName) || StringUtils.isEmpty(stockNo))
            {
                return null;
            }
            cfg = new SingleStockCfg();
            cfg.setStockNo(stockNo.trim());
            cfg.setStockName(stockName.trim());
            cfg.setStockUrl((String)map.get("url"));
        }
        catch (Exception e)
        {
            return null;
        }
        return cfg;
    }

}
