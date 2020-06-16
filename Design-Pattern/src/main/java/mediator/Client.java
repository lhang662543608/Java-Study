package mediator;

/**
 * 使用中介者模式来说明联合国的作用，要求绘制相应的类图并分析每个类的总用
 * （注：可以将联合国定义为抽象中介者类，联合国下属机构如（WTO、WHO等）作为具体中介者类，
 * 国家作为抽象同事类，而将中国、美国等国家作为具体同事类）。
 */
public class Client {
    public static void main(String[] args) {
        WTO wto = new WTO();
        China cn = new China();
        America us = new America();
        cn.setUnitedNations(wto);
        us.setUnitedNations(wto);
        wto.setChina(cn);
        wto.setAmerica(us);
        cn.declare("中国是一个爱好和平的国家！");
        us.declare("美国将会为世界和平而努力！");
    }
}
