package abstractfactory.product;

/**
 * 具体产品
 */
public class HaierTelevision implements Television{
    @Override
    public void play() {
        System.out.println("Haier Television...");
    }
}
