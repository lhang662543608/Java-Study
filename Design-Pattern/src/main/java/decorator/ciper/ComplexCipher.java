package decorator.ciper;

public class ComplexCipher extends CipherDecorator {
    public ComplexCipher(Cipher cipher) {
        super(cipher);
    }


    @Override
    public String encrypt(String plainText) {
        return reverse(super.encrypt(plainText));
    }

    public String reverse(String text) {
        return text + " +reverse ";
    }
}