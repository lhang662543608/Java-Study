package commonmapper.entities;

import javax.persistence.*;

/**
 * @author lhang
 * @create 2020-07-27 10:16
 */
@Table(name = "tabple_emp")
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer empId;
    private String empName;
    @Column(name = "emp_salary")
    private Double empSalary;
    private Integer empAge;
    @Transient // This annotation specifies that the property or field is not persistent.
    private String info;

    public Employee() {

    }

    public Employee(Integer empId, String empName, Double empSalary, Integer empAge) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empAge = empAge;
    }


    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public String getInfo() {
        return empName+"-:-"+empAge;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", empAge=" + empAge +
                '}';
    }
}
