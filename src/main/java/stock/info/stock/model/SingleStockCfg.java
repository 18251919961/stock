package stock.info.stock.model;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.Set;

/**
 * 股票代码信息配置
 */
@Data
public class SingleStockCfg
{
    // 股票代码
    @Column(name = "stock_no")
    private String stockNo;
    // 股票名字
    @Column(name = "stock_name")
    private String stockName;
    // 创建时间
    @Column(name = "create_time")
    private Date createTime;
    // 更新时间
    @Column(name = "update_time")
    private Date updateTime;
    // 每日更新次数
    @Column(name = "statistic_count_cfg")
    private Integer statisticCountCfg;
    // 股票所属
    @Column(name = "stock_classified")
    private String stockClassified;
    // 股票地址
    @Column(name = "stock_url")
    private String stockUrl;
    // 股票类型（etf、大盘、股票）
    @Column(name = "stock_type")
    private Integer stockType;
    // 股票类型集合
    private Set<String> stockTypeSet;

    private Set<String> setStockType()
    {
        String [] stockClassifieds = stockClassified.split(",");
        for (String type : stockClassifieds)
        {
            stockTypeSet.add(type.trim());
        }
        return stockTypeSet;
    }
}
