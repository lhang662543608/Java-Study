package entity.n21;

/**
 * @author lhang
 * @create 2020-07-03 8:41
 */
public class Customer {
    private Integer customerId;
    private String customerName;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
