package decorator.beverage;


public class Espresso extends Beverage {
    @Override
    public String getDescription() {
        return "浓缩咖啡";
    }

    @Override
    public int getCost() {
        return 25;
    }
}
