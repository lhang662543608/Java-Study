package jpa.spring.entities;

import javax.persistence.*;

/**
 * @author lhang
 * @create 2020-07-17 17:41
 */
@Table(name = "JPA_PERSONS")
@Entity
public class Person {
    private Integer id;
    private String lastName;
    private String email;
    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
