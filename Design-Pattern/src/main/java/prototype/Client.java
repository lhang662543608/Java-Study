package prototype;

/**
 * @author lhang
 * @create 2020-05-29 17:28
 */
public class Client {
    public static void main(String[] args) {
        Friend friend = new Friend("喜羊羊", "女");
        //原型模式
        //浅拷贝
        System.out.println("******浅拷贝******");
        Sheep sheep = new Sheep("tom", 12, "黄色");
        sheep.setFriend(friend);

        Sheep clonesheep1 = (Sheep) sheep.clone();//浅克隆
        Sheep clonesheep2 = (Sheep) sheep.clone();//浅克隆
        Sheep clonesheep3 = (Sheep) sheep.clone();//浅克隆

        System.out.println("sheep = " + sheep);
        System.out.println("clonesheep1 = " + clonesheep1);
        System.out.println("clonesheep2 = " + clonesheep2);
        System.out.println("clonesheep3 = " + clonesheep3);

        System.out.println("sheep.getFriend()=" + sheep.getFriend().hashCode());//
        System.out.println("sheep.getFriend()=" + clonesheep1.getFriend().hashCode());//浅拷贝的对象属性的拷贝是拷贝的是对象的引用

        System.out.println(sheep == clonesheep1);//false

        //深拷贝
        System.out.println("******深拷贝******");
        DeepSheep p = new DeepSheep();
        p.name = "懒洋洋";
        p.deepFriend = new DeepFriend("大牛", "男");

        //方式1 完成深拷贝

//		DeepSheep p2 = (DeepSheep) p.clone();
//
//		System.out.println("p.name=" + p.name + "p.deepFriend=" + p.deepFriend.hashCode());
//		System.out.println("p2.name=" + p.name + "p2.deepFriend=" + p2.deepFriend.hashCode());

        //方式2 完成深拷贝
        DeepSheep p2 = (DeepSheep) p.deepClone();

        System.out.println("p.name=" + p.name + "\tp.deepFriend=" + p.deepFriend.hashCode());
        System.out.println("p2.name=" + p.name + "\tp2.deepFriend=" + p2.deepFriend.hashCode());
    }
}
