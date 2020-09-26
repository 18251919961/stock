package stock.info.stock.test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import stock.info.stock.constant.SingleStockType;
import stock.info.stock.model.SingleStockCfg;
import stock.info.stock.model.SingleStockRealTimeInfo;
import stock.info.stock.util.ConvertUtils;
import stock.info.stock.util.HttpStockUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConvertTest
{
    public static void main(String[] args)
        throws IOException
    {
        String url = "http://quote.eastmoney.com/sz002415.html";
        String stockNo = "000001";
        List<String> httpUrl = HttpStockUtils.getHttpUrl(stockNo,
            SingleStockType.SingleStockComprehensive);
        Map<String, Object> map = HttpStockUtils.getStockMapFromHtmlUrls(httpUrl);
        SingleStockCfg singleStockCfg = ConvertUtils.getSingleStockCfgStockNameFromMap(map);
        System.out.println(singleStockCfg);
//
//        SingleStockRealTimeInfo singleStockRealTimeInfo = ConvertUtils.getSingleNormalStockRealTimeInfoFromList(docs);
//        System.out.println(singleStockRealTimeInfo);
//
//        WebClient browser = new WebClient();
//        browser.getOptions().setCssEnabled(false);
//        browser.getOptions().setJavaScriptEnabled(true);
//        browser.getOptions().setThrowExceptionOnScriptError(false);

        SingleStockRealTimeInfo singleStockRealTimeInfo1 = null;
        try
        {
//            HtmlPage htmlPage = browser.getPage("http://quote.eastmoney.com/sh002415.html");
//            browser.waitForBackgroundJavaScript(1000);
//            Document doc = Jsoup.parse(htmlPage.asXml());
            List<Document> docs =
                HttpStockUtils.getDocumentListFromHtmlUrls(httpUrl);
            singleStockRealTimeInfo1 =
                ConvertUtils.getSingleNormalStockRealTimeInfoFromList(docs, singleStockCfg);
            List<SingleStockRealTimeInfo> list =
                new ArrayList<SingleStockRealTimeInfo>();
            list.add(singleStockRealTimeInfo1);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(singleStockRealTimeInfo1);
    }
}
