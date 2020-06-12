package decorator.beverage;

/**
 * 某咖啡店在卖咖啡时可以根据顾客的要求在其中加入各种配料，咖啡店会根据锁甲的配料来计算总费用。
 * 咖啡店所供应的咖啡及配料的种类和价格如表所示：
 * 咖啡          价格/杯(￥)   配料      价格/份(￥)
 * 浓缩咖啡        25         摩卡       10
 * 混合咖啡        30         奶泡       8
 * 重烘焙咖啡       20        牛奶       6
 * 现使用装饰模式为该咖啡店设计一个程序以实现计算费用的功能，输出每种饮料的详细描述及花费。
 * 输出结果实例如下：
 * 浓缩咖啡，摩卡，牛奶，￥41
 * 饮料类Beverage的代码如下：
 * public abstract class Beverage{
 * public abstract String getDescription();
 * public abstract int getCost();
 * }
 * 要求画出对应的类图，并使用java语言编程实现。
 */
public class Client {
    public static void main(String[] args) {
        Beverage coffee, ingredient;
        coffee = new Espresso();//浓缩咖啡

        ingredient = new Mocha(coffee);//摩卡
        ingredient = new Milk(ingredient);//牛奶

        String description = ingredient.getDescription();
        int cost = ingredient.getCost();
        System.out.println(description + " ￥" + Integer.toString(cost));
    }
}
