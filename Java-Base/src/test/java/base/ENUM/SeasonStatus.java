package base.ENUM;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义了枚举类，默认继承java.lang.Enum类
 *
 * 1.使用enum关键字定义的枚举类实现接口的情况：
 *      ①；实现接口，在enum类中实现抽象方法
 *      ②：让枚举类的对象分别实现接口中的抽象方法
 */
public enum SeasonStatus implements info{
    //1.提供当前枚举类的对象，多个对象之间用,隔开，末尾对象用;结束
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天", "烈日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天夏天，留下小秘密");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来！");
        }
    },
    WINTER("冬天", "北风凌冽"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    //2.声明Season对象的属性：private final
    private final String name;
    private final String desc;

    //3.私有化构造器，并给对象赋值
    private SeasonStatus(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //其他诉求


    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

}
interface info{
    void show();
}
