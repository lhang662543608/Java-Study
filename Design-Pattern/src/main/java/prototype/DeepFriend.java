package prototype;

import java.io.Serializable;

public class DeepFriend implements Serializable, Cloneable {


    private static final long serialVersionUID = 1L;

    private String name;

    private String gender;

    //构造器
    public DeepFriend(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    //因为该类的属性，都是String , 因此我们这里使用默认的clone完成即可
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
