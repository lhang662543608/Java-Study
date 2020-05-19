package abstractfactory.factory;

import abstractfactory.product.AirConditioner;
import abstractfactory.product.HaierAirConditioner;
import abstractfactory.product.HaierTelevision;
import abstractfactory.product.Television;

/**
 * 具体工厂
 */
public class HaireFactory implements EFactory {
    @Override
    public Television produceTelevision() {
        return new HaierTelevision();
    }

    @Override
    public AirConditioner produceAirCondition() {
        return new HaierAirConditioner();
    }
}
