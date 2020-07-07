package Spring4.beans;

public class User {

    private String userName;
    private String wifeName;
    private Car car;

    public String getWifeName() {
        return wifeName;
    }

    public void setWifeName(String wifeName) {
        System.out.println("setWifhName: " + wifeName);
        this.wifeName = wifeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User() {
        System.out.println("User's Construtor...");
    }

    public User(String userName, Car car, String wifeName) {
        this.userName = userName;
        this.car = car;
        this.wifeName = wifeName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", wifeName='" + wifeName + '\'' +
                ", car=" + car +
                '}';
    }

    public void init() {
        System.out.println("init method...");
    }

    public void destroy() {
        System.out.println("destroy method...");
    }

}
