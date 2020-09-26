package stock.info.stock.model;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * 单个股票实时信息
 */
@Data
public class SingleStockRealTimeInfo implements Comparable
{
    // 自增id
    @Column(name = "stock_id")
    private String stockId;
    // 股票代码
    @Column(name = "stock_no")
    private String stockNo;
    // 股票名字
    @Column(name = "stock_name")
    private String stockName;
    // 当前时间
    @Column(name = "real_time")
    private Date realTime;
    // 当前时间字符
    @Column(name = "real_time_str")
    private String realTimeStr;
    // 当天日期
    @Column(name = "date")
    private String date;
    // 昨天收盘价
    @Column(name = "yesterday_closing_price")
    private Double yesterdayClosingPrice;
    // 今日收盘价
    @Column(name = "closing_price")
    private Double closingPrice;
    // 开市价
    @Column(name = "opening_price")
    private Double openingPrice;
    // 当前价格
    @Column(name = "real_time_price")
    private Double realTimePrice;
    // 当前最高价
    @Column(name = "real_max_price")
    private Double realMaxPrice;
    // 当前最低价
    @Column(name = "real_min_price")
    private Double realMinPrice;
    // 涨停价
    @Column(name = "limit_max_price")
    private Double limitMaxPrice;
    // 跌停价
    @Column(name = "limit_min_price")
    private Double limitMinPrice;
    // 均价
    @Column(name = "avg_price")
    private Double avgPrice;
    // 涨幅
    @Column(name = "amount_of_increase")
    private Double amountOfIncrease;
    // 涨跌金额
    @Column(name = "change_price")
    private Double changePrice;
    // 换手率
    @Column(name = "turn_over_rate")
    private Double turnOverRate;
    // 量比
    @Column(name = "quantity_relative_ratio")
    private Double quantityRelativeRatio;
    // 委比
    @Column(name = "order_ratio")
    private Double orderRatio;
    // 委差
    @Column(name = "order_diff")
    private Double orderDiff;
    // 成交量
    @Column(name = "volume")
    private Double volume;
    // 成交额
    @Column(name = "volume_of_transaction")
    private Double volumeOfTransaction;
    // 内盘（主动卖）
    @Column(name = "inside_dish")
    private Double insideDish;
    // 外盘（主动买）
    @Column(name = "out_side_dish")
    private Double outSideDish;
    // 60日均线
    @Column(name = "avg_60_price")
    private Double avg60Price;
    // 30日均线
    @Column(name = "avg_30_price")
    private Double avg30Price;
    // 10日均线
    @Column(name = "avg_10_price")
    private Double avg10Price;
    // 5日均线
    @Column(name = "avg_5_price")
    private Double avg5Price;
    // 评论
    @Column(name = "comments")
    private String comments;

    @Override
    public int compareTo(Object o)
    {
        if (o instanceof SingleStockRealTimeInfo)
        {
            SingleStockRealTimeInfo infoOld = (SingleStockRealTimeInfo)o;
            if (infoOld.realTime == null)
            {
                return 1;
            }
            if (this.realTime == null)
            {
                return -1;
            }
            return this.realTime.compareTo(infoOld.realTime);
        }
        return 1;
    }
}
