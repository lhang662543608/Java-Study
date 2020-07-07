package Spring4.beans;

/**
 * @author lhang
 * @create 2020-07-06 8:54
 */
public class HelloWorld {
    private String name;

    public void setName(String name) {
        System.out.println("setName()"+name);
        this.name = name;
    }

    public void hello() {
        System.out.println("hello:" + name);
    }

    public HelloWorld() {
        System.out.println("HelloWorld构造器...");
    }
}
