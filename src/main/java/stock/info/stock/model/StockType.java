package stock.info.stock.model;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * 股票类型
 */
@Data
public class StockType
{
    /**
     * 股票类型
     */
    @Column(name = "stock_type")
    private Integer stockType;

    /**
     * 股票类型名称
     */
    @Column(name = "stock_name")
    private String stockName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
}
