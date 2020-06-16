package chainofresponsibility;

/**
 * 请求角色
 */
public class Mission {
    private String code;
    private int enemyNumber;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getEnemyNumber() {
        return enemyNumber;
    }

    public void setEnemyNumber(int enemyNumber) {
        this.enemyNumber = enemyNumber;
    }

    public Mission(String code, int enemyNumber) {
        this.code = code;
        this.enemyNumber = enemyNumber;
    }
}
