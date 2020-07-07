package Spring4.beans.collections;

import Spring4.beans.Car;

import java.util.List;

public class User {

    private String userName;
    private String wifeName;
    private List<Car> cars;

    public User() {
    }

    public User(String userName, List<Car> cars, String wifeName) {
        this.userName = userName;
        this.cars = cars;
        this.wifeName = wifeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getWifeName() {
        return wifeName;
    }

    public void setWifeName(String wifeName) {
        this.wifeName = wifeName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", wifeName='" + wifeName + '\'' +
                ", cars=" + cars +
                '}';
    }
}
