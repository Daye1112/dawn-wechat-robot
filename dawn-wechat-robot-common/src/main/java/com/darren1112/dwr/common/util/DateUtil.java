package com.darren1112.dwr.common.util;

import com.darren1112.dwr.common.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author darren
 * @since 19/12/15 21:32
 */
@Slf4j
public class DateUtil extends cn.hutool.core.date.DateUtil {

    /**
     * 把String解析格式的时间转化为date
     *
     * @param stringTime 时间字符串
     * @return 日期对象
     */
    public static Date parseDate(String stringTime) {
        Date date = null;
        if (!StringUtils.isEmpty(stringTime)) {
            String[] pattern = new String[]{"yyyyMM", "yyyy/MM", "yyyy-MM",
                    "yyyyMMdd", "yyyy/MM/dd", "yyyy-MM-dd",
                    "yyyyMMdd HH:mm", "yyyy/MM/dd HH:mm", "yyyy-MM-dd HH:mm",
                    "yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss",
                    "yyyy年MM月dd日", "yyyy年MM月dd",
                    "MM", "MMdd",
                    "MM-dd", "/MM/dd", "MM月dd日", "MM月dd",
                    "MM-dd HH:mm", "MMddHHmmss", "MM/dd HH:mm:ss", "MM-dd HH:mm:ss"
            };
            try {
                date = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).parse(stringTime);
            } catch (ParseException e1) {
                try {
                    date = DateUtils.parseDate(stringTime, pattern);
                } catch (ParseException e2) {
                    log.error("日期转换失败——未知时间类型");
                }
            }
        }
        return date;

    }

    /**
     * 计算两个时间的分钟差
     *
     * @return 分钟数
     */
    public static int diffDateMin(Date date1, Date date2) {
        try {
            long mill = betweenMs(date1, date2);
            return (int) (mill / 60000);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BadRequestException("日期计算错误");
        }
    }

    /**
     * 计算两个时间的秒数差
     *
     * @return 秒数
     */
    public static int diffDateSec(Date date1, Date date2) {
        try {
            long mill = betweenMs(date1, date2);
            return (int) (mill / 1000);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new BadRequestException("日期计算错误");
        }
    }
}
