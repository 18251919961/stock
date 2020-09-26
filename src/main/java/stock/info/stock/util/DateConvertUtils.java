package stock.info.stock.util;

import stock.info.stock.constant.StockConstant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class DateConvertUtils
{
    private static ReentrantLock dateLock = new ReentrantLock();
    private static ReentrantLock dateTimeLock = new ReentrantLock();
    // 日期转换
    private static SimpleDateFormat sdfDate = new SimpleDateFormat(StockConstant.DATE_FORMAT);
    // 日期时间转换
    private static SimpleDateFormat sdfDateTime = new SimpleDateFormat(StockConstant.DATETIME_FORMAT);

    public static String getDateStr(Date date)
    {
        dateLock.lock();
        String dateStr;
        try
        {
            dateStr = sdfDate.format(date);
        }
        finally
        {
            dateLock.unlock();
        }
        return dateStr;
    }

    public static String getDateTimeStr(Date date)
    {
        dateTimeLock.lock();
        String dateTimeStr;
        try
        {
            dateTimeStr = sdfDateTime.format(date);
        }
        finally
        {
            dateTimeLock.unlock();
        }
        return dateTimeStr;
    }
}
