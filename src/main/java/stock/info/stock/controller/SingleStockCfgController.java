package stock.info.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import stock.info.stock.service.SingleStockCfgService;

@RestController
public class SingleStockCfgController
{
    @Autowired(required = false)
    SingleStockCfgService singleStockCfgService;

}
