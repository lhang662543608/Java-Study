package factorymethod.chart.product;

public class LineChart implements Chart {
    @Override
    public void display() {
        System.out.println("LineChart display...");
    }
}