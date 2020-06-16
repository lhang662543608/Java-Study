package state;

/**
 * 具体状态类角色：高手状态
 */
public class MiddleState extends AbstractState {
    public MiddleState(AbstractState state) {
        this.point = state.point;
        this.stateName = "高手";
        this.acc = state.acc;
    }


    @Override
    public void checkState(int score) {
        if (this.point >= 1000) {
            this.acc.setState(new HighState(this));
        } else if (this.point < 100) {
            this.acc.setState(new PrimaryState(this));
        }
    }

    @Override
    public void downloadFile(int score) {

        if ((this.point - score) < 0) {
            System.out.println("积分不足，无法下载！");
        } else {
            this.point -= score;
            System.out.println(this.acc.getName() + " 当前等级为" + this.getStateName() + "下载文件。 " + " 消耗积分" + score);
            checkState(this.point);
        }
    }

    @Override
    public void writeNote(int score) {
        int dScore;
        dScore = score * 2;
        this.point += dScore;
        System.out.println(this.acc.getName() + "当前等级为" + this.getStateName() + "发表留言。" + "获得积分" + dScore);
        checkState(this.point);
    }

    @Override
    public void replyNote(int score) {
        this.point += score;
        System.out.println(this.acc.getName() + "当前等级为" + this.getStateName() + "回复留言。" + "获得积分" + score);
        checkState(this.point);
    }
}
