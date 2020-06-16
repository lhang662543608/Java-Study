package state;

/**
 * 具体状态类角色：新手状态
 */
public class PrimaryState extends AbstractState {
    public PrimaryState(AbstractState state) {
        this.point = state.point;
        this.stateName = "新手";
        this.acc = state.acc;
    }

    public PrimaryState(ForumAccount acc) {
        this.point = 0;
        this.stateName = "新手";
        this.acc = acc;

    }


    @Override
    public void checkState(int score) {
        if (this.point >= 1000) {
            this.acc.setState(new HighState(this));
        } else if (this.point >= 100 && this.point < 1000) {
            this.acc.setState(new MiddleState(this));
        }
    }

    @Override
    public void downloadFile(int score) {
        System.out.println("您当前等级暂无法下载文件");
    }

    @Override
    public void writeNote(int score) {
        this.point += score;
        System.out.println(this.acc.getName() + " 当前等级为:" + this.getStateName() + " 发表留言。" + "获得积分" + score);
        checkState(this.point);
    }

    @Override
    public void replyNote(int score) {
        this.point += score;
        System.out.println(this.acc.getName() + " 当前等级为:" + this.getStateName() + " 回复留言。" + "获得积分" + score);
        checkState(this.point);
    }
}
