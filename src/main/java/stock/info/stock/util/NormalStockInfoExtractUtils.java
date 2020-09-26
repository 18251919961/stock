package stock.info.stock.util;

import org.jsoup.nodes.Document;
import stock.info.stock.model.SingleStockRealTimeInfo;

/**
 * 一般股票提取
 */
public class NormalStockInfoExtractUtils
{
    /**
     * 设置涨跌幅度（正常股票）
     * @param singleStockRealTimeInfo
     * @param doc
     */
    public static void convertStockRangeInfo(
        SingleStockRealTimeInfo singleStockRealTimeInfo, Document doc)
    {
        // 涨跌幅度
        String amountOfIncreaseStr = doc.select("#km1").text();
        singleStockRealTimeInfo.setAmountOfIncrease(DoubleUtils.valueOf(amountOfIncreaseStr));
        // 涨跌额
        String changePriceStr = doc.select("#km2").text();
        singleStockRealTimeInfo.setChangePrice(DoubleUtils.valueOf(changePriceStr));
    }

    /**
     * 根据doc获取价格信息(正常股票)
     * @param singleStockRealTimeInfo
     * @param doc
     */
    public static void convertPricetInfo(SingleStockRealTimeInfo singleStockRealTimeInfo, Document doc)
    {
        // 开市价
        String openingPrice = doc.select("#gt1").text();
        singleStockRealTimeInfo.setOpeningPrice(DoubleUtils.valueOf(openingPrice));
        // 最高价
        String realMaxPriceStr = doc.select("#gt2").text();
        singleStockRealTimeInfo.setRealMaxPrice(DoubleUtils.valueOf(realMaxPriceStr));
        // 涨停价
        String limitMaxPriceStr = doc.select("#gt3").text();
        singleStockRealTimeInfo.setLimitMaxPrice(DoubleUtils.valueOf(limitMaxPriceStr));
        // 昨日收盘价
        String yesterdayClosingPriceStr = doc.select("#gt8").text();
        singleStockRealTimeInfo.setYesterdayClosingPrice(DoubleUtils.valueOf(yesterdayClosingPriceStr));
        // 最低价
        String realMinPrice = doc.select("#gt9").text();
        singleStockRealTimeInfo.setRealMinPrice(DoubleUtils.valueOf(realMinPrice));
        // 跌停价
        String limitMinPrice = doc.select("#gt10").text();
        singleStockRealTimeInfo.setLimitMinPrice(DoubleUtils.valueOf(limitMinPrice));
    }

    /**
     * 获取其他信息
     * @param singleStockRealTimeInfo
     * @param doc
     */
    public static void convertOtherInfo(SingleStockRealTimeInfo singleStockRealTimeInfo, Document doc)
    {
        // 当前价格
        String realTimePriceStr = doc.select("#rgt1").text();
        singleStockRealTimeInfo.setRealTimePrice(DoubleUtils.valueOf(realTimePriceStr));
        // 获取均价
        String avgPriceStr = doc.select("#rgt2").text();
        singleStockRealTimeInfo.setAvgPrice(DoubleUtils.valueOf(avgPriceStr));
        // 总手数
        String volume = doc.select("#rgt5").text();
        singleStockRealTimeInfo.setVolume(DoubleUtils.valueOf(volume));
        // 总金额
        String volumeOfTransactionStr = doc.select("#rgt6").text();
        singleStockRealTimeInfo.setVolumeOfTransaction(DoubleUtils.valueOf(volumeOfTransactionStr));
        // 换手率
        String turnOverRateStr = doc.select("#rgt7").text();
        singleStockRealTimeInfo.setTurnOverRate(DoubleUtils.valueOf(turnOverRateStr));
        // 量比
        String quantityRelativeRatioStr = doc.select("#rgt8").text();
        singleStockRealTimeInfo.setQuantityRelativeRatio(DoubleUtils.valueOf(quantityRelativeRatioStr));
        // 外盘
        String outSideDishStr = doc.select("#rgt15").text();
        singleStockRealTimeInfo.setOutSideDish(DoubleUtils.valueOf(outSideDishStr));
        // 内盘
        String insideDishStr = doc.select("#rgt16").text();
        singleStockRealTimeInfo.setInsideDish(DoubleUtils.valueOf(insideDishStr));
        // 委比
        String orderRatioStr = doc.select("#irwb").text();
        singleStockRealTimeInfo.setOrderRatio(DoubleUtils.valueOf(orderRatioStr));
        // 委差
        String orderDiffStr = doc.select("#irwc").text();
        singleStockRealTimeInfo.setOrderDiff(DoubleUtils.valueOf(orderDiffStr));

    }

    /**
     * 设置大盘指数信息
     * @param singleStockRealTimeInfo
     * @param doc
     */
    public static void convertBroaderIndex(SingleStockRealTimeInfo singleStockRealTimeInfo, Document doc)
    {
        // 开市价
        String openingPrice = doc.select("#gt1").text();
        singleStockRealTimeInfo.setOpeningPrice(DoubleUtils.valueOf(openingPrice));
        // 最高价
        String realMaxPriceStr = doc.select("#gt2").text();
        singleStockRealTimeInfo.setRealMaxPrice(DoubleUtils.valueOf(realMaxPriceStr));
        // 昨日收盘价
        String yesterdayClosingPriceStr = doc.select("#gt7").text();
        singleStockRealTimeInfo.setYesterdayClosingPrice(DoubleUtils.valueOf(yesterdayClosingPriceStr));
        // 最低价
        String realMinPrice = doc.select("#gt8").text();
        singleStockRealTimeInfo.setRealMinPrice(DoubleUtils.valueOf(realMinPrice));
    }

    /**
     * 设置大盘指数其他信息
     * @param singleStockRealTimeInfo
     * @param doc
     */
    public static void convertBroaderIndexOtherInfo(SingleStockRealTimeInfo singleStockRealTimeInfo, Document doc)
    {
        // 当前价格
        String realTimePriceStr = doc.select("#rgt1").text();
        singleStockRealTimeInfo.setRealTimePrice(DoubleUtils.valueOf(realTimePriceStr));
        // 总手数
        String volume = doc.select("#rgt7").text();
        singleStockRealTimeInfo.setVolume(DoubleUtils.valueOf(volume));
        // 总金额
        String volumeOfTransactionStr = doc.select("#rgt8").text();
        singleStockRealTimeInfo.setVolumeOfTransaction(DoubleUtils.valueOf(volumeOfTransactionStr));
        // 换手率
        String turnOverRateStr = doc.select("#rgt9").text();
        singleStockRealTimeInfo.setTurnOverRate(DoubleUtils.valueOf(turnOverRateStr));
        // 外盘
        String outSideDishStr = doc.select("#rgt12").text();
        singleStockRealTimeInfo.setOutSideDish(DoubleUtils.valueOf(outSideDishStr));
        // 内盘
        String insideDishStr = doc.select("#rgt11").text();
        singleStockRealTimeInfo.setInsideDish(DoubleUtils.valueOf(insideDishStr));
    }
}
