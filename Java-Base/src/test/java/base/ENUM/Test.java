package base.ENUM;

/**
 * Enum类常用方法：
 *
 */
public class Test {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
        System.out.println("=====================");
        SeasonStatus autumn = SeasonStatus.AUTUMN;
        //toString
        System.out.println(autumn.toString());
        System.out.println("=====================");
        //values()
        SeasonStatus[] values = SeasonStatus.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }
        System.out.println("=====================");
        //valueOf()
        SeasonStatus winter = SeasonStatus.valueOf("WINTER");
        System.out.println(winter);
    }
}
