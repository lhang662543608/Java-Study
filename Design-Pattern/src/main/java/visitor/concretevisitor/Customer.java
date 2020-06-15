package visitor.concretevisitor;

import visitor.abstractvisitor.Visitor;
import visitor.concreteelements.Apple;
import visitor.concreteelements.Book;

/**
 * 具体访问者（顾客）
 */
public class Customer extends Visitor {
    @Override
    public void visit(Apple apple) {
        System.out.println("顾客检查苹果质量");
    }

    @Override
    public void visit(Book book) {
        System.out.println("顾客检查书本质量");
    }
}
