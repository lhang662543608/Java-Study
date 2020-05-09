package principle.singleresponsibility;

/**
 * @author lhang
 * @create 2020-05-09 20:37
 */
public class SingleResponsibility2 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("摩托车");
        roadVehicle.run("汽车");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
    }
}

//交通工具类
//方式2：
//1.方式2的run方法中，遵守了单一职责原则。但这样做的花销很大，即将类分解，同时修改客户端。
//2.解决方案是：直接修改Vehicle类，改动的代码会比较少。==》方案3
class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "run on the road~~");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "fly on the sky~~");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "swam in thw water~~");
    }
}
