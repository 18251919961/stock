package stock.info.stock.util;

import org.jsoup.nodes.Document;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import stock.info.stock.model.SingleStockCfg;
import stock.info.stock.model.SingleStockRealTimeInfo;

import java.util.List;

public class ConvertUtils
{
    public static SingleStockRealTimeInfo getSingleNormalStockRealTimeInfoFromList(
        List<Document> docs)
    {
        for (Document doc : docs)
        {

            SingleStockRealTimeInfo singleStockRealTimeInfo =
                getSingleNormalStockRealTimeInfo(doc);
            if (null != singleStockRealTimeInfo)
            {
                return singleStockRealTimeInfo;
            }
        }
        return null;
    }

    public static SingleStockCfg getSingleStockCfgStockNameFromList(
        List<Document> docs)
    {
        for (Document doc : docs)
        {
            SingleStockCfg singleStockCfg =
                SingleStockCfgExtractUtils.getSingleStockCfgStockName(doc);
            if (null != singleStockCfg)
            {
                return singleStockCfg;
            }
        }
        return null;
    }

    public static SingleStockCfg getSingleStockCfgStockNameFromMap(
        Map<String, Object> map)
    {
        SingleStockCfg singleStockCfg =
            SingleStockCfgExtractUtils.getSingleStockCfgStockNameFromMap(map);
        return singleStockCfg;
    }

    public static SingleStockRealTimeInfo getSingleNormalStockRealTimeInfoFromList(
        List<Document> docs,
        SingleStockCfg singleStockCfg)
    {
        SingleStockRealTimeInfo singleStockRealTimeInfo = null;
        for (Document doc : docs)
        {
            getSingleNormalStockRealTimeInfoFromDoc(doc, singleStockCfg);
        }
        return singleStockRealTimeInfo;
    }

    public static SingleStockRealTimeInfo getSingleNormalStockRealTimeInfoFromDoc(
        Document doc,
        SingleStockCfg singleStockCfg)
    {
        SingleStockRealTimeInfo singleStockRealTimeInfo = null;
        switch (singleStockCfg.getStockType())
        {
            case 1:
                singleStockRealTimeInfo =
                    getBroaderMarketStockRealTimeInfo(doc);
                break;
            case 2:
                singleStockRealTimeInfo =
                    getSingleNormalStockRealTimeInfo(doc);
                break;
            case 3:
                singleStockRealTimeInfo =
                    getSingleETFStockRealTimeInfo(doc);
                break;
            default:
                singleStockRealTimeInfo =
                    getSingleNormalStockRealTimeInfo(doc);
                break;
        }
        return singleStockRealTimeInfo;
    }
    /**
     * ETF获取
     *
     * @param doc
     * @return
     */
    private static SingleStockRealTimeInfo getSingleETFStockRealTimeInfo(
        Document doc)
    {
        return null;
    }

    /**
     * 大盘信息获取
     *
     * @param doc
     * @return
     */
    public static SingleStockRealTimeInfo getBroaderMarketStockRealTimeInfo(
        Document doc)
    {
        SingleStockRealTimeInfo singleStockRealTimeInfo =
            getSingleStockBaseInfo(doc);
        if (singleStockRealTimeInfo == null)
        {
            return singleStockRealTimeInfo;
        }
        // 设置大盘指数信息
        NormalStockInfoExtractUtils.convertBroaderIndex(singleStockRealTimeInfo, doc);
        // 获取涨跌幅信息
        NormalStockInfoExtractUtils.convertStockRangeInfo(singleStockRealTimeInfo, doc);
        // 获取大盘其他信息
        NormalStockInfoExtractUtils.convertBroaderIndexOtherInfo(singleStockRealTimeInfo, doc);
        return singleStockRealTimeInfo;
    }

    /**
     * 通过doc网页获取股票基本信息
     * @param doc
     * @return
     */
    public static SingleStockRealTimeInfo getSingleStockBaseInfo(Document doc)
    {
        SingleStockRealTimeInfo singleStockRealTimeInfo =
            new SingleStockRealTimeInfo();
        // 获取基本信息
        SingleStockCfg singleStockCfg =
            SingleStockCfgExtractUtils.getSingleStockCfgStockName(doc);
        if (null == singleStockCfg)
        {
            return null;
        }
        BeanUtils.copyProperties(singleStockCfg, singleStockRealTimeInfo);
        // 设置时间日期
        CommonStockInfoExtractUtils.createStockRealTimeInfo(
            singleStockRealTimeInfo);
        return singleStockRealTimeInfo;
    }

    /**
     * 通过doc网页获取基本股票SingleStockRealTimeInfo
     * @param doc
     * @return
     */
    public static SingleStockRealTimeInfo getSingleNormalStockRealTimeInfo(
        Document doc)
    {
        SingleStockRealTimeInfo singleStockRealTimeInfo =
            getSingleStockBaseInfo(doc);
        if (singleStockRealTimeInfo == null)
        {
            return singleStockRealTimeInfo;
        }
        // 设置价格信息
        NormalStockInfoExtractUtils.convertPricetInfo(singleStockRealTimeInfo,
            doc);
        // 设置涨幅跌幅
        NormalStockInfoExtractUtils.convertStockRangeInfo(singleStockRealTimeInfo,
            doc);
        // 获取其他信息
        NormalStockInfoExtractUtils.convertOtherInfo(singleStockRealTimeInfo,
            doc);
        return singleStockRealTimeInfo;
    }
}
