package memento;

/**
 * 负责人，用于管理备忘录。
 */
public class Caretaker {
    private SceneMemento memento;

    public SceneMemento getSceneMemento() {
        return this.memento;
    }

    public void setSceneMemento(SceneMemento memento) {
        this.memento = memento;
    }
}
