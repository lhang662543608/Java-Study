package mediator;

/**
 * 具体中介者角色
 */
public class WTO extends UnitedNations {
    private China cn;
    private America us;

    public void setChina(China cn) {
        this.cn = cn;
    }

    public void setAmerica(America us) {
        this.us = us;
    }

    @Override
    public void declare(String message, Country country) {
        if (country == cn) {
            us.getMessage(message);
        } else {
            cn.getMessage(message);
        }
    }
}
