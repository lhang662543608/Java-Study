package principle.dependenceinversion;

/**
 * @author lhang
 * @create 2020-05-09 22:19
 */
public class DependenceInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email {
    public String getInfo(){
        return "电子邮件信息：hello world！";
    }
}

//完成person接收消息的功能。
//方式一分析：
//1.简单，容易想到
//2.如果我们获取的对象是微信短信等等，则新增类，同时person也要增加相应的接收方法。
//3.解决思路：引入一个抽象的接口IReceiver，表示接受者，这样Person类与IReceiver发生依赖
//   因为Email，WeinXin 等等属于接收的范围，他们各自实现IReceiver的接口即可，这样我们就符合依赖倒转原则。
class Person{
    public void receive(Email email){
        System.out.println(email.getInfo());
    }

}
