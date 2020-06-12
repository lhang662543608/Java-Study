package decorator.ciper;

public class AdvancedCipher extends CipherDecorator {
    public AdvancedCipher(Cipher cipher) {
        super(cipher);
    }

    @Override
    public String encrypt(String plainText) {
        return mod(super.encrypt(plainText));
    }

    public String mod(String Text) {
        return Text + " +mod ";
    }
}