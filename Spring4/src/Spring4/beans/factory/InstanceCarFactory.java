package Spring4.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂方法：实力工厂的方法，即现需要创建工厂本身，再调用工厂的实例方法来返回bean 的实例。
 *
 * @author lhang
 * @create 2020-07-07 8:23
 */
public class InstanceCarFactory {
    private Map<String, Car> cars = null;

    public InstanceCarFactory() {
        cars = new HashMap<>();
        cars.put("audi", new Car("audi", 300000));
        cars.put("ford", new Car("ford", 400000));
    }

    public Car getCar(String brand) {
        return cars.get(brand);
    }


}
