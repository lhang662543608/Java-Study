package factorymethod.car.factory;

import factorymethod.car.product.Benz;
import factorymethod.car.product.Car;

/**
 * 具体工厂
 */
public class BenzFactory implements CarFactory {
    @Override
    public Car produceCar() {
        return new Benz();
    }
}