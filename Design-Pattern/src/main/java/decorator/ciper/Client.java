package decorator.ciper;

/***
 * 某软件公司要开发一个数据加密模块，可以对字符串进行加密。
 * 最简单的加密算法通过对字母进行移位实现，同时提供了稍微复杂的逆向输出加密，还提供了更加高级的求模加密。
 * 用户最先使用最近简单的加密算法对字符串进行加密，如果觉得还不够可以对加密之后的结构使用其他加密算法进行二次加密，当然也可以进行第三次加密。
 * 试使用装饰模式设计该多重加密系统。
 */
public class Client {
    public static void main(String[] args) {
        Cipher data;
        data = new SimpleCipher();
        String encrypt1 = data.encrypt("明文数据1");
        System.out.println(encrypt1);
        System.out.println("***********************************");
        Cipher c1 = new AdvancedCipher(data);
        String encrypt2 = c1.encrypt("明文数据2");
        System.out.println(encrypt2);
        System.out.println("***********************************");
        Cipher c2 = new ComplexCipher(c1);
        String encrypt3 = c2.encrypt("明文数据3");
        System.out.println(encrypt3);
    }
}