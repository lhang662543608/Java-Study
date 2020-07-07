package Spring4.beans.collections;

import Spring4.beans.Car;

import java.util.Map;

public class Person {

    private String userName;
    private String wifeName;
    private Map<String, Car> cars;

    public Person() {
    }

    public Person(String userName, String wifeName, Map<String, Car> cars) {
        this.userName = userName;
        this.wifeName = wifeName;
        this.cars = cars;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWifeName() {
        return wifeName;
    }

    public void setWifeName(String wifeName) {
        this.wifeName = wifeName;
    }

    public Map<String, Car> getCars() {
        return cars;
    }

    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", wifeName='" + wifeName + '\'' +
                ", cars=" + cars +
                '}';
    }
}
