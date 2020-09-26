package stock.info.stock.test;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import stock.info.stock.constant.StockConstant;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DynamicTest
{
    public static void main(String[] args)
    {
        String dateStr = new SimpleDateFormat(StockConstant.DATETIME_FORMAT_HOUR_MIN).format(new Date());
        if (dateStr.compareTo(StockConstant.DATETIME_CLOSE) > 0)
        {

        }
    }
}
