package springdata.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * @author lhang
 * @create 2020-07-22 20:57
 */
@Table(name = "JPA_PERSONS")
@Entity
public class Person {

    private Integer id;
    private String lastName;
    private String email;
    private Date birth;

    private Address address;

    private Integer addressId;

    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @JoinColumn(name = "ADDRESS_ID")
    @ManyToOne
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name = "ADD_ID")
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", lastName=" + lastName + ", email="
                + email + ", brith=" + birth + "]";
    }
}
