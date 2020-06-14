package command;

/**
 * 电灯打开命令
 *
 * @author lhang
 * @create 2020-06-14 17:05
 */
public class LightOnComand implements Command {
    //聚合receiver
    private LightReceiver light;

    public LightOnComand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        //调用接收者的方法
        light.on();
    }

    @Override
    public void undo() {
        //调用接收者的方法
        light.off();
    }
}
