package stock.info.stock.test;

import org.jsoup.nodes.Document;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import stock.info.stock.constant.SingleStockType;
import stock.info.stock.mappper.SingleStockRealTimeInfoMapper;
import stock.info.stock.model.SingleStockRealTimeInfo;
import stock.info.stock.util.ConvertUtils;
import stock.info.stock.util.HttpStockUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = {"stock.info.stock"})
//@MapperScan("spring.mysql.demo.mysql.mapper")
@PropertySource(value = {"classpath:application.properties" })
public class SimpleDateTest
{
    public static void main(String[] args)
        throws IOException
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SimpleDateTest.class);
        SingleStockRealTimeInfoMapper mapper =
            (SingleStockRealTimeInfoMapper)context.getBean("singleStockRealTimeInfoMapper");

        String url = "http://quote.eastmoney.com/sz002415.html";
        String stockNo = "002415";
        List<String> httpUrl = HttpStockUtils.getHttpUrl(stockNo,
            SingleStockType.SingleStockRealTimeInfoType);
        SingleStockRealTimeInfo singleStockRealTimeInfo1 = null;
        List<Document> docs =
            HttpStockUtils.getDocumentListFromHtmlUrls(httpUrl);
        singleStockRealTimeInfo1 =
            ConvertUtils.getSingleNormalStockRealTimeInfoFromList(docs);
        List<SingleStockRealTimeInfo> list =
            new ArrayList<SingleStockRealTimeInfo>();
        list.add(singleStockRealTimeInfo1);

        try
        {
            mapper.insertSingleStockRealTimeInfo(list);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
