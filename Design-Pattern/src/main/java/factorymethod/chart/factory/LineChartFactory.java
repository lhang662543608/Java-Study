package factorymethod.chart.factory;

import factorymethod.chart.product.Chart;
import factorymethod.chart.product.LineChart;


public class LineChartFactory implements ChartFactory {
    @Override
    public Chart produceChart() {
        return new LineChart();
    }
}