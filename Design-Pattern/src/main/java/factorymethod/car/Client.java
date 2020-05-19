package factorymethod.car;

import factorymethod.car.factory.CarFactory;
import factorymethod.car.product.Car;

/**
 * 宝马（BMW）工厂制造宝马汽车，奔驰（Benz）工厂制造奔驰汽车。
 * 使用工厂方法模式模拟该场景，要求绘制相应的类图并用java语言模拟实现。
 */
public class Client {
    public static void main(String[] args) {
        CarFactory factory;
        Car car;
        factory = (CarFactory) XMLUtil.getBean();
        car = factory.produceCar();
        car.run();

    }
}