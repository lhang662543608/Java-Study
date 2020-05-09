package base.ENUM;

/**
 * 自定义枚举类：JDK5.0之前
 */
public class Season {
    //1.声明Season对象的属性：private final
    private final String name;
    private final String desc;
    //2.私有化构造器，并给对象赋值
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    //3.提供当前枚举类的多个对象：public static final
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","烈日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","北风凌冽");

    //其他诉求
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
