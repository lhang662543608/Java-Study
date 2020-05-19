package factorymethod.chart.factory;

import factorymethod.chart.product.Chart;

/**
 * 抽象工厂
 */
public interface ChartFactory {
    Chart produceChart();
}