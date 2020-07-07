package Spring4.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author lhang
 * @create 2020-07-07 8:43
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 返回bean的对象
     *
     * @return
     * @throws Exception
     */
    @Override
    public Car getObject() throws Exception {
        return new Car("BMW", 500000);
    }

    /**
     * 返回bean的类型
     *
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    /**
     * 是否是单实例
     *
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
