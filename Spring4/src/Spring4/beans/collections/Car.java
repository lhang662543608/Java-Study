package Spring4.beans.collections;

public class Car {

    private String brand;
    private String company;
    private float price;
    private int maxSpeed;

    public Car() {
    }

    public Car(String company, String brand, float price) {
        this.company = company;
        this.brand = brand;
        this.price = price;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
