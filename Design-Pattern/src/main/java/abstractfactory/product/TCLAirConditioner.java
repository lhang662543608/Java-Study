package abstractfactory.product;

/**
 * 具体产品
 */
public class TCLAirConditioner implements AirConditioner {
    @Override
    public void changeTemperature() {
        System.out.println("TCL  AirCondition.....");
    }
}
