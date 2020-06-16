package mediator;

/**
 * 抽象同事角色
 */
public abstract class Country {
    protected UnitedNations un;

    public void setUnitedNations(UnitedNations un) {
        this.un = un;
    }

    public void declare(String message) {
        un.declare(message, this);
    }

    public abstract void getMessage(String message);
}
