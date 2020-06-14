package template.improve;

/**
 * @author lhang
 * @create 2020-06-14 15:27
 */
public class Client {
    public static void main(String[] args) {
        //制作黑豆豆浆
        System.out.println("-----制作黑豆豆浆-----");
        BlackBeanSoyaMilk blackBeanSoyaMilk = new BlackBeanSoyaMilk();
        blackBeanSoyaMilk.make();

        //制作花生豆浆
        System.out.println("~~~~~制作纯豆浆~~~~~");
        pennutSoyaMilk pennutSoyaMilk = new pennutSoyaMilk();
        pennutSoyaMilk.make();

        //制作纯豆浆
        System.out.println("~~~~~制作花生豆浆~~~~~");
        PureSoyaMilk pureSoyaMilk = new PureSoyaMilk();
        pureSoyaMilk.make();
    }
}
