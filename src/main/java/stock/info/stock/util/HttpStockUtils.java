package stock.info.stock.util;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import stock.info.stock.constant.SingleStockType;
import stock.info.stock.constant.StockConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpStockUtils
{
    /**
     * 获取url地址
     *
     * @param urlFragment
     * @param stockType
     * @return
     */
    public static List<String> getHttpUrl(String urlFragment,
        SingleStockType stockType)
    {
        List<String> list = new ArrayList<>();
        switch (stockType)
        {
            case SingleStockRealTimeInfoType:
                String backUrlFragmentSz =
                    StockConstant.HTTP_STOCK_EAST_DOMAIN + "/" +
                        StockConstant.HTTP_STOCK_LISTEDLOCATION_SZ +
                        urlFragment + StockConstant.HTML;
                String backUrlFragmentSh =
                    StockConstant.HTTP_STOCK_EAST_DOMAIN + "/" +
                        StockConstant.HTTP_STOCK_LISTEDLOCATION_SH +
                        urlFragment + StockConstant.HTML;
                String urlSz = StockConstant.HTTP + "://" + backUrlFragmentSz;
                String urlSh = StockConstant.HTTP + "://" + backUrlFragmentSh;
                list.add(urlSz);
                list.add(urlSh);
                break;
            case SingleStockCfgETF:
                break;
            case SingleStockComprehensive:
                String backUrlFragmentZs =
                    StockConstant.HTTP_STOCK_EAST_DOMAIN + "/" +
                        StockConstant.HTTP_STOCK_ZS +
                        urlFragment + StockConstant.HTML;
                String url = StockConstant.HTTP + "://" + backUrlFragmentZs;
                list.add(url);
                break;
            default:
                break;
        }
        return list;
    }

    public static List<Document> getDocumentListFromUrls(List<String> httpUrl)
    {
        List<Document> documents = new ArrayList<>();
        for (String url : httpUrl)
        {
            try
            {
                Document doc = Jsoup.connect(url).get();
                documents.add(doc);
            }
            catch (Exception e)
            {
                continue;
            }
        }
        return documents;
    }

    public static List<Document> getDocumentListFromHtmlUrls(
        List<String> httpUrl)
    {
        List<Document> documents = new ArrayList<>();
        for (String url : httpUrl)
        {
            try
            {
                Document doc0 = Jsoup.connect(url).get();
                WebClient browser = new WebClient();
                browser.getOptions().setCssEnabled(false);
                browser.getOptions().setJavaScriptEnabled(true);
                browser.getOptions().setThrowExceptionOnScriptError(false);
                browser.waitForBackgroundJavaScript(500);
                HtmlPage htmlPage = browser.getPage(url);
                Document doc = Jsoup.parse(htmlPage.asXml());
                browser.close();
                documents.add(doc);
            }
            catch (Exception e)
            {
                continue;
            }
        }
        return documents;
    }

    public static Document getDocumentFromHtmlUrl(String url)
    {
        try
        {
            Document doc0 = Jsoup.connect(url).get();
            WebClient browser = new WebClient();
            browser.getOptions().setCssEnabled(false);
            browser.getOptions().setJavaScriptEnabled(true);
            browser.getOptions().setThrowExceptionOnScriptError(false);
            browser.waitForBackgroundJavaScript(500);
            HtmlPage htmlPage = browser.getPage(url);
            Document doc = Jsoup.parse(htmlPage.asXml());
            browser.close();
            return doc;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public static Map<String, Object> getStockMapFromHtmlUrls(
        List<String> httpUrl)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        for (String url : httpUrl)
        {
            try
            {
                Document doc0 = Jsoup.connect(url).get();
                map.put("url", url);
                map.put("doc", doc0);
                return map;
            }
            catch (Exception e)
            {
                continue;
            }
        }
        return map;
    }

}
