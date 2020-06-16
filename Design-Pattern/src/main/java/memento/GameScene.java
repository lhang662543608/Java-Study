package memento;

/**
 * 游戏场景类：原发器角色。用于保存历史状态的类
 */
public class GameScene {
    private String scene;
    private int lifeValue;

    public void setScene(String scene) {
        this.scene = scene;
    }

    public void setLifeValue(int lifeValue) {
        this.lifeValue = lifeValue;
    }

    public String getScene() {
        return (this.scene);
    }

    public int getLifeValue() {
        return (this.lifeValue);
    }

    public void restore(SceneMemento m) {
        this.scene = m.getScene();
        this.lifeValue = m.getLifeValue();
    }

    public SceneMemento save() {
        return new SceneMemento(this.scene, this.lifeValue);
    }

    public void display() {
        System.out.print("当前游戏场景为：" + this.scene + "，");
        System.out.println("您还有" + this.lifeValue + "条命！");
    }
}
