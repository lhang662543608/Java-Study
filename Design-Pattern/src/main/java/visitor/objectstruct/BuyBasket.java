package visitor.objectstruct;

import visitor.abstractelement.Product;
import visitor.abstractvisitor.Visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 对象结构（购物篮子）
 */
public class BuyBasket {
    private ArrayList<Product> list = new ArrayList<Product>();

    public void accept(Visitor visitor) {
        Iterator<Product> iterator = list.iterator();
        while (iterator.hasNext()) {
            ((Product) iterator.next()).accept(visitor);
        }
    }

    public void addProduct(Product product) {
        list.add(product);
    }

    public void removeProduct(Product product) {
        list.remove(product);
    }

}
