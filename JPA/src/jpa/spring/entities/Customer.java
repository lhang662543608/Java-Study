package jpa.spring.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lhang
 * @create 2020-07-17 20:12
 */
@NamedQuery(name="testNamedQuery", query="FROM Customer c WHERE c.id = ?")
@Cacheable(true)
@Table(name = "JPA_CUSTOMERS")
@Entity
public class Customer {
    private Integer id;
    private String lastName;
    private Integer age;
    private String email;
    private Date createTime;
    private Date birth;

    public Customer() {
    }

    public Customer(String lastName, int age) {
        super();
        this.lastName = lastName;
        this.age = age;
    }


    private Set<Order> orders = new HashSet<>();


    /* @TableGenerator(name = "id_generate",
             table = "jpa_id_generate",
             pkColumnName = "pk_name",
             pkColumnValue = "customer_id",
             valueColumnName = "pk_value",
             allocationSize = 100  //步长
         )
     @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generate")*/
    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "last_name", length = 50, nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Temporal(TemporalType.DATE)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }


    //映射单向 1-n 的关联关系
    //使用 @OneToMany 来映射 1-n 的关联关系
    //使用 @JoinColumn 来映射外键列的名称
    //可以使用 @OneToMany 的 fetch 属性来修改默认的加载策略
    //可以通过 @OneToMany 的 cascade 属性来修改默认的删除策略.
    //注意: 若在 1 的一端的 @OneToMany 中使用 mappedBy 属性, 则 @OneToMany 端就不能再使用 @JoinColumn 属性了.
//	@JoinColumn(name="CUSTOMER_ID")
    @OneToMany(fetch=FetchType.LAZY,cascade={CascadeType.REMOVE},mappedBy="customer")
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }


    /**
     * 工具方法不需要映射为表的一列。
     *
     * @Transient 表示该属性并非一个到数据库表的字段的映射。
     */
    @Transient
    public String getInfo() {
        return "lastName" + lastName + "email" + email;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", birth=" + birth +
                '}';
    }
}
