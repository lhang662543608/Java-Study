package command;

/**
 * 电视机关闭命令
 *
 * @author lhang
 * @create 2020-06-14 17:06
 */
public class TVOffCommand implements Command {
    //聚合receiver
    private TVReceiver tv;

    public TVOffCommand(TVReceiver tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        //调用接收者的方法
        tv.off();
    }

    @Override
    public void undo() {
        //调用接收者的方法
        tv.on();
    }
}
