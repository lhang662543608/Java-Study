package base.datetime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class TestJava8Time {

    /**
     * LocalDate,LocalTime,LocalDateTime
     * 1.LocalDateTime常用
     */
    @Test
    public void testLcoalDateTime() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        System.out.println();

        //of()
        LocalDateTime dateTime = LocalDateTime.of(1995, 2, 9, 0, 0);
        System.out.println(dateTime);

        //getXxx()
        System.out.println(dateTime.getDayOfMonth());
        System.out.println(dateTime.getDayOfWeek());
        System.out.println(dateTime.getDayOfYear());
        System.out.println(dateTime.getMonth());
        System.out.println(dateTime.getYear());
        System.out.println(dateTime.getMinute());

        //体现了不可变性
        //withXxx
        LocalDateTime dateTime1 = dateTime.withDayOfMonth(15);
        System.out.println(dateTime);
        System.out.println(dateTime1);
        //plusXxx
        LocalDateTime dateTime2 = dateTime.plusDays(1);
        System.out.println(dateTime);
        System.out.println(dateTime2);
    }

    /**
     * Instant
     */
    @Test
    public void testInstant() {
        //获取本初子午线的时间
        Instant instant = Instant.now();
        System.out.println(instant);
        //atOffset():添加时间偏移量
        OffsetDateTime dateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(dateTime);
        //toEpochMilli():获取自1970年1月1日0时0分0秒开始的毫秒数
        long epochMilli = instant.toEpochMilli();
        System.out.println(epochMilli);
        //ofEpochMilli()；通过毫秒数，获取Instant实例
        Instant instant1 = Instant.ofEpochMilli(1586919209633L);
        System.out.println(instant1);
    }

    /**
     * DateTimeFormatter：格式化或解析日期、时间
     */
    @Test
    public void testDateTimeFormatter() {
        //方式一：预定义的标准格式:如ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(format);
        //解析：字符串-->日期
        TemporalAccessor parse = formatter.parse("2020-04-15T11:34:32.336");
        System.out.println(parse);


        //方式二：本地化相关格式.如：ofLocalizedDateTime()
        //FormatStyle.LONG|FormatStyle.MEDIUM|FormatStyle.SHORT
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化:日期-->字符串
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);
        //解析：字符串-->日期


        //本地化相关格式.如：ofLocalizedDate()
        //FormatStyle.FULL|FormatStyle.LONG|FormatStyle.MEDIUM|FormatStyle.SHORT
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        //格式化:日期-->字符串
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);
        //解析：字符串-->日期


        //重点
        //方式三：自定义的格式。如：ofPattern("yyyy-MM-dd hh:mm:ss")
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化:日期-->字符串
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);//2020-04-15 03:07:44

        //解析：字符串-->日期
        TemporalAccessor parse1 = formatter3.parse("2020-04-15 03:07:44");
        System.out.println(parse1);

    }


    /**
     * Duration
     */
    @Test
    public void testDuration() {
        LocalDateTime start = LocalDateTime.of(2020, 1, 17, 0, 0, 0);
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);


        long millis = duration.toMillis();
        System.out.println("millis:" + millis);

        long seconds = duration.getSeconds();
        System.out.println("seconds:" + seconds);


        long minutes = duration.toMinutes();
        System.out.println("minutes:" + minutes);

        long hours = duration.toHours();
        System.out.println("hours:" + hours);

        long days = duration.toDays();
        System.out.println("days:" + days);
    }

    /**
     *
     */
    @Test
    public void testPeriod() {
        Period between = Period.between(LocalDate.of(1995, 2, 9), LocalDate.now());

        int years = between.getYears();
        System.out.println("years:"+years);

        int months = between.getMonths();
        System.out.println("months:"+months);

        int days = between.getDays();
        System.out.println("days:"+days);


        System.out.println("---"+between.toString());

        long toTotalMonths = between.toTotalMonths();
        System.out.println("toTotalMonths:"+toTotalMonths);
    }

    @Test
    public void test(){
        LocalDateTime start = LocalDateTime.of(2020, 1, 17,0,0);
//         start = LocalDateTime.of(1995, 2, 9,0,0);
//         start = LocalDateTime.of(2019, 12, 28,0,0);
//         start = LocalDateTime.of(2020, 2, 14,0,0);
        LocalDateTime now = LocalDateTime.now();

        Duration duration = Duration.between(start, now);
        long days = duration.toDays();

        System.out.println("days："+days);
    }

}
