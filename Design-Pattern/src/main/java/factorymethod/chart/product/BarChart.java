package factorymethod.chart.product;

public class BarChart implements Chart {
    @Override
    public void display() {
        System.out.println("BarChart display...");
    }
}