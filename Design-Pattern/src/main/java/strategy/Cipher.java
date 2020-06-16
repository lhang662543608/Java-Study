package strategy;

/**
 * 抽象策略类
 */
public interface Cipher {
    public abstract String doEncrypt(int key, String plainText);
}
