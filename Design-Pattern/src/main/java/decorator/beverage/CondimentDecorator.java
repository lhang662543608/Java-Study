package decorator.beverage;

/**
 * 装饰者类
 */
public class CondimentDecorator extends Beverage {
    private Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public int getCost() {
        return beverage.getCost();
    }
}