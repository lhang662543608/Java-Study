package entity.inheritance.subclass;

/**
 * @author lhang
 * @create 2020-07-04 18:12
 */
public class Student extends Person {
    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
