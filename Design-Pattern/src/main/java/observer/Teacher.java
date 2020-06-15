package observer;

/**
 * 具体观察者
 */
public class Teacher implements Observer {
    private String teacherName;
    private Department department;

    public Teacher(String teacherName, Department department) {
        this.teacherName = teacherName;
        this.department = department;
        department.attach(this);
    }

    @Override
    public void change() {
        System.out.println(teacherName + department.getDepartmentName());
    }
}
