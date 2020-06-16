package chainofresponsibility;

/**
 * 在军队中一般根据战争规模的大小和重要性由不同级别的长官(Officer)来下达作战命令，情报人员向上级递交军情，作战命令需要上级批准，
 * 如果直接上级不具备下达命令的权利，则又传给他的上级，直到有人可以决定为止。
 * 先使用职责链模式来模拟该过程，客户类模拟情报人员，首相向班长(BanZhang)递交任务书(Misssion)，即军情，如果超出班长的权利范围，则递交给排长(Paizhang)，
 * 如果排长不能处理则递交给营长（Yingzhang）,如果营长也不能处理则需要开会讨论。
 * 设置这几级长官的权利范围分别如下：
 * 1）敌人数量<10,班长下达作战命令
 * 2）10<=敌人数量<50,排长下达作战命令
 * 3）50<=敌人数量<200,营长下达作战命令
 * 4)敌人数量>=200,现需要开会讨论下再下达作战命令。
 * 要求绘制相应的类图并使用java语言编程模拟实现。
 */
public class Client {
    public static void main(String[] args) {
        Officer banZhang,paiZhang,yingZhang;
        banZhang = new Banzhang("小班");
        paiZhang = new Paizhang("小排");
        yingZhang = new Yingzhang("小营");

        //创建职责链
        banZhang.setSuccessor(paiZhang);
        paiZhang.setSuccessor(yingZhang);

        //创建情报
        Mission mission = new Mission("110",300);
        banZhang.handleRequest(mission);
    }
}
