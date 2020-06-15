package visitor.concreteelements;

import visitor.abstractelement.Product;
import visitor.abstractvisitor.Visitor;

/**
 * 具体元素角色（具体产品、苹果）
 */
public class Apple implements Product {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
