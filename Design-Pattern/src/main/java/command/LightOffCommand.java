package command;

/**
 * 电灯关闭命令
 *
 * @author lhang
 * @create 2020-06-14 17:06
 */
public class LightOffCommand implements Command {
    //聚合receiver
    private LightReceiver light;

    public LightOffCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        //调用接收者的方法
        light.off();
    }

    @Override
    public void undo() {
        //调用接收者的方法
        light.on();
    }
}
