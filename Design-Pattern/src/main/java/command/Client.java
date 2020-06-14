package command;

/**
 * @author lhang
 * @create 2020-06-14 17:12
 */
public class Client {
    public static void main(String[] args) {
        //使用命令设计模式，完成通过遥控器，对电灯的操作

        //创建电灯的对象（接受者）
        LightReceiver lightReceiver = new LightReceiver();
        TVReceiver tvReceiver = new TVReceiver();

        //创建一个电灯相关的开关命令
        LightOnComand lightOnComand = new LightOnComand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);
        TVOnComand tvOnComand = new TVOnComand(tvReceiver);
        TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);

        //需要一个遥控器
        RemoteController remoteController = new RemoteController();

        //给我们的遥控器设置命令，比如 no = 0 是 电灯的开和关操作
        remoteController.setCommand(0, lightOnComand, lightOffCommand);
        remoteController.setCommand(1, tvOnComand, tvOffCommand);

        System.out.println("----------------按下灯的开按钮--------------------");
        remoteController.onButtonWasPush(0);
        System.out.println("----------------按下灯的关按钮--------------------");
        remoteController.offButtonWasPush(0);
        System.out.println("----------------按下撤销按钮--------------------");
        remoteController.undoCommandWasPush();

        remoteController.onButtonWasPush(1);
        remoteController.offButtonWasPush(1);

    }
}
