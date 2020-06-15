package visitor.abstractelement;

import visitor.abstractvisitor.Visitor;

/**
 * 抽象元素角色(抽象产品)
 */
public interface Product {
    public void accept(Visitor visitor);
}
