package stock.info.stock.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import stock.info.stock.constant.SingleStockType;
import stock.info.stock.model.SingleStockCfg;
import stock.info.stock.service.SingleStockCfgService;
import stock.info.stock.util.ConvertUtils;
import stock.info.stock.util.HttpStockUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = {"stock.info.stock"})
//@MapperScan("spring.mysql.demo.mysql.mapper")
@PropertySource(value = {"classpath:application.properties" })
public class SimpleDateTest1
{
    public static void main(String[] args)
        throws IOException
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            SimpleDateTest1.class);
        SingleStockCfgService mapper =
            (SingleStockCfgService)context.getBean("singleStockCfgServiceImpl");
        List<SingleStockCfg> list1 =
            new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("000001");
        list.add("399001");
        list.add("399006");
//        list.add("000063");
//        list.add("002234");
//        list.add("002415");
//        list.add("002475");
//        list.add("002555");
//        list.add("300059");
//        list.add("300313");
//        list.add("600360");
//        list.add("600527");
//        list.add("603301");
//        list.add("603697");
//        for (String stockNo : list)
//        {
//            try
//            {
//                List<String> httpUrl = HttpStockUtils.getHttpUrl(stockNo,SingleStockType.SingleStockRealTimeInfoType);
//                Map<String, Object> map = HttpStockUtils.getStockMapFromHtmlUrls(httpUrl);
//                SingleStockCfg singleStockCfg = ConvertUtils.getSingleStockCfgStockNameFromMap(map);
//                singleStockCfg.setStatisticCountCfg(1);
//                singleStockCfg.setStockType(2);
//                list1.add(singleStockCfg);
//            }
//            catch (Exception e)
//            {
//                System.out.println(e);
//            }
//        }
        for (String stockNo : list)
        {
            try
            {
                List<String> httpUrl = HttpStockUtils.getHttpUrl(stockNo,SingleStockType.SingleStockComprehensive);
                Map<String, Object> map = HttpStockUtils.getStockMapFromHtmlUrls(httpUrl);
                SingleStockCfg singleStockCfg = ConvertUtils.getSingleStockCfgStockNameFromMap(map);
                singleStockCfg.setStatisticCountCfg(1);
                singleStockCfg.setStockType(1);
                list1.add(singleStockCfg);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        mapper.insertSingleStockCfg(list1);

    }
}
