package factorymethod.car.factory;

import factorymethod.car.product.BMW;
import factorymethod.car.product.Car;

/**
 * 具体工厂
 */
public class BMWFactory implements CarFactory {
    @Override
    public Car produceCar() {
        return new BMW();
    }
}