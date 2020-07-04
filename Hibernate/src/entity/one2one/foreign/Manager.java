package entity.one2one.foreign;

/**
 * @author lhang
 * @create 2020-07-04 10:02
 */
public class Manager {
    private Integer mgrId;
    private String mgrName;
    private Department department;

    public Integer getMgrId() {
        return mgrId;
    }

    public void setMgrId(Integer mgrId) {
        this.mgrId = mgrId;
    }

    public String getMgrName() {
        return mgrName;
    }

    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
