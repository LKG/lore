package im.heart.shop.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;

import java.text.DecimalFormat;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by panwang.chengpw on 2018/9/13.
 */
public class OrderHelper {

    private static LongAdder longAdder = new LongAdder();

    /**
     * 生成订单编号
     * @return
     */
    public static String generateOrderNum() {
        if (longAdder.intValue() > 99) {
            longAdder.reset();
        } else {
            longAdder.increment();
        }
        return DateTime.now().toString("yyMMddHHmmss") + new DecimalFormat("00").format(longAdder.intValue())
               + RandomStringUtils.randomNumeric(2);
    }

}
