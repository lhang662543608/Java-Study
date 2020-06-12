package decorator.ciper;

public class SimpleCipher implements Cipher {
    @Override
    public String encrypt(String plainText) {
        return plainText + " +simpleencrypt ";
    }
}
