package factorymethod.chart.factory;

import factorymethod.chart.product.BarChart;
import factorymethod.chart.product.Chart;

public class BarChartFactory implements ChartFactory {
    @Override
    public Chart produceChart() {
        return new BarChart();
    }
}