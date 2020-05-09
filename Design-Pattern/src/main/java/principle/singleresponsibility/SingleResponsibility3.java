package principle.singleresponsibility;

/**
 * @author lhang
 * @create 2020-05-09 20:37
 */
public class SingleResponsibility3 {
    public static void main(String[] args) {
        Vehicle2 vehicle = new Vehicle2();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.runAir("飞机");
        vehicle.runWater("轮船");
    }
}

//交通工具类
//方式3：
//1.方式3这种修改方法没有对原来的类做大的修改，只是增加了方法。
//2.这里虽然在类的级别上没有遵守单一职责原则，但是在方法级别上还是遵守了单一职责原则。
class Vehicle2 {
    public void run(String vehicle) {
        System.out.println(vehicle + "run on the road~~");
    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + "fly on the sky~~");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + "swim on the water~~");
    }
}
