package base;

import org.junit.Test;

public class TestMain {
    @Test
    public void test() {
        String[] strs = {"a", "b", "c", "d", "e", "f"};
        for (int i = 0; i < strs.length >> 1; i++) {
            String temp = strs[i];
            strs[i] = strs[strs.length - i - 1];
            strs[strs.length - i - 1] = temp;
        }
        for (String temp :
                strs) {
            System.out.print(temp + '\t');
        }
        System.out.println();
        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i] + "\t");
        }


    }


}
