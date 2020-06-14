package command;

/**
 * 命令发送者
 *
 * @author lhang
 * @create 2020-06-14 17:11
 */
public class RemoteController {

    //开 按钮的命令数组
    Command[] onCommands;
    //关 按钮的命令数组
    Command[] offCommands;

    //执行撤销的命令
    Command undoCommand;

    //构造器，完成对按钮初始化
    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];

        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    public void setCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    //按下开按钮
    public void onButtonWasPush(int no) {
        //找到你按下的按钮，并调用对应的方法
        onCommands[no].execute();
        //记录这次的操作，用于撤销
        undoCommand = onCommands[no];
    }

    //按下关按钮
    public void offButtonWasPush(int no) {
        //找到你按下的按钮，并调用对应的方法
        offCommands[no].execute();
        //记录这次的操作，用于撤销
        undoCommand = offCommands[no];
    }

    //按下撤销按钮
    public void undoCommandWasPush() {
        undoCommand.undo();
    }

    Command[] onCommands() {
        return null;
    }

    Command[] offCommands() {
        return null;
    }
}
