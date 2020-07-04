package entity.one2one.foreign;

/**
 * @author lhang
 * @create 2020-07-04 10:02
 */
public class Department {
    private Integer deptId;
    private String deptName;

    private Manager mgr;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Manager getMgr() {
        return mgr;
    }

    public void setMgr(Manager mgr) {
        this.mgr = mgr;
    }
}
