package abstractfactory.factory;

import abstractfactory.product.AirConditioner;
import abstractfactory.product.TCLAirConditioner;
import abstractfactory.product.TCLTelevision;
import abstractfactory.product.Television;

/**
 * 具体工厂
 */
public class TCLFactory implements EFactory {
    @Override
    public Television produceTelevision() {
        return new TCLTelevision();
    }

    @Override
    public AirConditioner produceAirCondition() {
        return new TCLAirConditioner();
    }
}
