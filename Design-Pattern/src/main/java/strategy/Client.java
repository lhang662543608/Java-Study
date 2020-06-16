package strategy;

/**
 * 某系统需要对重要数据（如用户密码）进行加密，并提供了几种加密方案（例如凯撒加密、求模加密等），
 * 对该加密模块进行设计，使得用户可以动态的选择加密方式。
 * 要求绘制相应的类图并使用java语言编程模拟实现。
 */
public class Client {
    public static void main(String[] args) {
        String plainText;
        String encrypt;

        DataOperation dataOperation = new DataOperation();

        dataOperation.setCipher(new ModCipher());
        plainText = "Helloworld";
        encrypt = dataOperation.doEncrypt(1, plainText);
        System.out.println("原文为：" + plainText + "   密文为：" + encrypt);

        dataOperation.setCipher(new CaesarCipher());
        plainText = "Helloworld";
        encrypt = dataOperation.doEncrypt(1, plainText);
        System.out.println("原文为：" + plainText + "   密文为：" + encrypt);
    }
}
