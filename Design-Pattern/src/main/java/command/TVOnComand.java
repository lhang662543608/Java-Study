package command;

/**
 * 电视机开启命令
 *
 * @author lhang
 * @create 2020-06-14 17:05
 */
public class TVOnComand implements Command {
    //聚合receiver
    private TVReceiver tv;

    public TVOnComand(TVReceiver tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        //调用接收者的方法
        tv.on();
    }

    @Override
    public void undo() {
        //调用接收者的方法
        tv.off();
    }
}
