package abstractfactory.product;

/**
 * 具体产品
 */
public class HaierAirConditioner implements AirConditioner {
    @Override
    public void changeTemperature() {
        System.out.println("Haier AirConditioner....");
    }
}
