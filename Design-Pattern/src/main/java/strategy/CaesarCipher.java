package strategy;

/**
 * 具体策略类
 */
public class CaesarCipher implements Cipher {
    @Override
    public String doEncrypt(int key, String plainText) {
        return plainText + " +CaesarCipherEncrypt";
    }
}
