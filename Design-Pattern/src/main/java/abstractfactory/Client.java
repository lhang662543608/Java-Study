package abstractfactory;

import abstractfactory.factory.EFactory;
import abstractfactory.product.AirConditioner;
import abstractfactory.product.Television;

/**
 * 一个电器工厂可以产生多种类型的电器，
 * 如海尔工厂可以生产海尔电视机，海尔空调等，TCL工厂可以生产TCL电视机、TCL空调等，
 * 相同品牌的电器构成了一个产品等级结构一个产品的等级结构，现使用抽象工厂模式模拟该场景。
 */
public class Client {
    public static void main(String[] args) {
        EFactory factory;
        AirConditioner airConditioner;
        Television television;

//        factory = new HaireFactory();
//        factory = new TCLFactory();

        factory = (EFactory) XMLUtil.getBean();
        airConditioner = factory.produceAirCondition();
        television = factory.produceTelevision();
        airConditioner.changeTemperature();
        television.play();




    }
}
