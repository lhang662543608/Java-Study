package observer;

/**
 * 某高校教学管理系统需要实现以下功能：如果某个系的系名发生变化，则该系所有教师和学生的所属系名称也将发生变化。
 * 试使用观察者模式实现该功能，要求绘制相应的类图并使用java语言编程模拟实现。
 */
public class Client {
    public static void main(String[] args) {
        Department department = new Department("信息科学与工程学院");
        Student zStu = new Student("张三", department);
        Student lStu = new Student("李四", department);
        Teacher kTea = new Teacher("孔子", department);
        Teacher mTea = new Teacher("孟子", department);
        department.setDepartmentName("信息院");

        department.detach(kTea);
        department.setDepartmentName("自动化院");


    }
}
