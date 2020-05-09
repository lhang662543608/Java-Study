package base.datetime;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
    /**
     * System.currentTimeMillis()的使用
     * java.util.Date的使用
     * java.sql.Date的使用
     */
    @Test
    public void testDate() {

        System.out.println(System.currentTimeMillis());//1586908128674
        System.out.println(new Date().getTime());//1586908128674

        Date date = new Date();
        System.out.println(date.toString());//Wed Apr 15 07:48:48 CST 2020

        Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1.toString());//2020-04-15
    }

    /**
     * SimpleDateFormat的使用
     */
    @Test
    public void testSimpleDateFormat() {
        //实例化SimpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //格式化
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);


        try {
            //解析
            Date parse = simpleDateFormat.parse("2019-02-15 15:25:12");
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    /**
     *
     */
    @Test
    public void testCalender() {
        //实例化
        //1.方式一：创建其子类的对象。GregorianCalendar
        //2.方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());//class java.util.GregorianCalendar

        //常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,12);
        days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,2);
        days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);

        //getTime()
        Date time = calendar.getTime();
        System.out.println(time);

        //setTime()
        Date date = new Date();
        calendar.setTime(date);
        days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);

    }

    /**
     * 相识
     */
    @Test
    public void testComMemoration(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = format.parse("2020-01-17");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            int start = calendar.get(Calendar.DAY_OF_YEAR);
            Date date = new Date();
            calendar.setTime(date);
            int now = calendar.get(Calendar.DAY_OF_YEAR);
            System.out.println(now - start);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
