package visitor.concretevisitor;

import visitor.abstractvisitor.Visitor;
import visitor.concreteelements.Apple;
import visitor.concreteelements.Book;

/**
 * 具体访问者（收银员）
 */
public class Saler extends Visitor {
    @Override
    public void visit(Apple apple) {
        System.out.println("苹果过秤计价");
    }

    @Override
    public void visit(Book book) {
        System.out.println("书本计价");
    }
}
