package command;

/**
 * 命令接口
 *
 * @author lhang
 * @create 2020-06-14 17:04
 */
public interface Command {

    //执行动作
    public void execute();

    //撤销动作
    public void undo();
}
