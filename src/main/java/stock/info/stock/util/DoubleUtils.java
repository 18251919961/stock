package stock.info.stock.util;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoubleUtils
{
    /**
     * 转换为String为Double
     *
     * @param valueStr
     * @return
     */
    public static Double valueOf(String valueStr)
    {
        try
        {
            if (StringUtils.isEmpty(valueStr))
            {
                return null;
            }
            Pattern decimalPattern = Pattern.compile("-?\\d+(\\.)?\\d+");
            Matcher matcher = decimalPattern.matcher(valueStr.trim());
            if (matcher.find())
            {
                String num = matcher.group(0);
                return getRealNum(Double.valueOf(num), valueStr.trim());

            }
            return null;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    private static Double getRealNum(Double value, String valueStr)
    {
        if (valueStr.contains("亿"))
        {
            return new BigDecimal(value * 10000).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        else if (valueStr.contains("万") || valueStr.contains("%"))
        {
            return value;
        }
        return value;
    }
}
