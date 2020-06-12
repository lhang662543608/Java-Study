package decorator.beverage;

public class HouseBlend extends Beverage {
    @Override
    public String getDescription() {
        return "混合咖啡";
    }

    @Override
    public int getCost() {
        return 30;
    }
}