package stock.info.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import stock.info.stock.service.SingleStockRealTimeInfoService;

@Controller
public class SingleStockInfoController
{
    @Autowired(required = false)
    SingleStockRealTimeInfoService singleStockRealTimeInfoService;


}
