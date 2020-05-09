package principle.singleresponsibility;

/**
 * @author lhang
 * @create 2020-05-09 20:37
 */
public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }
}

//交通工具类
//方式一：
//1.方式一的run方法中，违反了单一职责原则
//2.解决方案是：根据交通工具的不同，分解成不同的类
class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "run on the road~~");
    }
}
