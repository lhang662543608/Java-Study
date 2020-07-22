package spring4.aop;

/**
 * @author lhang
 * @create 2020-07-22 15:26
 */
public class MathCalculator {
    public int div(int i, int j) {
        System.out.println("MathCalculator...div...");
        return i / j;
    }
}
