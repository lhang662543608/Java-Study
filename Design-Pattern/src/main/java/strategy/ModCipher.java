package strategy;

/**
 * 具体策略类
 */
public class ModCipher implements Cipher {
    @Override
    public String doEncrypt(int key, String plainText) {
        return plainText + " +ModCipherEncrypt";
    }
}
