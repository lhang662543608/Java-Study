package factorymethod.car.product;

/**
 * 具体产品
 */
public class Benz implements Car {
    @Override
    public void run() {
        System.out.println("Benz run...");
    }
}