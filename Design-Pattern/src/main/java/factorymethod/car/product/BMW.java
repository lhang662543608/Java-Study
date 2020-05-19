package factorymethod.car.product;

/**
 * 具体产品
 */
public class BMW implements Car {
    @Override
    public void run() {
        System.out.println("BMW run...");
    }
}