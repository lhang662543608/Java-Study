package prototype;

/**
 * @author lhang
 * @create 2020-05-30 8:39
 */
public class Friend {
    private String name;
    private String gender;


    public Friend() {
    }

    public Friend(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
