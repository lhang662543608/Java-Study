package factorymethod.car.factory;

import factorymethod.car.product.Car;

/**
 * 抽象工厂
 */
public interface CarFactory {
    Car produceCar();
}