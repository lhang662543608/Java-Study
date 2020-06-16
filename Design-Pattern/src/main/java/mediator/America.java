package mediator;

/**
 * 具体同事角色
 */
public class America extends Country {
    @Override
    public void getMessage(String message) {
        System.out.println("美国获取信息：" + message);
    }
}
