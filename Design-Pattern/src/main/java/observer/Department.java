package observer;

import java.util.ArrayList;

/**
 * 观察目标
 */
public class Department {
    protected ArrayList<Observer> observers = new ArrayList<Observer>();
    private String departmentName;

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
        changeName();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    private void changeName() {
        for (Observer obs : observers) {
            obs.change();
        }
    }
}
