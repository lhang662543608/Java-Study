package abstractfactory.product;

/**
 * 具体产品
 */
public class TCLTelevision  implements Television{

    @Override
    public void play() {
        System.out.println("TCL Television.....");
    }
}
