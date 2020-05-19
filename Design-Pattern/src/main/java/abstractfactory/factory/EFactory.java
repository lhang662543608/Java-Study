package abstractfactory.factory;

import abstractfactory.product.AirConditioner;
import abstractfactory.product.Television;

/**
 * 抽象工厂
 */
public interface EFactory {
    Television produceTelevision();
    AirConditioner produceAirCondition();
}
