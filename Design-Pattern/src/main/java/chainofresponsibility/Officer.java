package chainofresponsibility;

/**
 * 抽象传递者角色
 */
public abstract class Officer {
    protected String name;
    protected Officer successor;

    public Officer(String name) {
        this.name = name;
    }

    public void setSuccessor(Officer successor) {
        this.successor = successor;
    }
    public abstract void handleRequest(Mission request);
}
