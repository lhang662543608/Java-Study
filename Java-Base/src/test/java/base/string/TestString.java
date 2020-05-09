package base.string;

import org.junit.Test;

public class TestString {
    @Test
    public void testString(){
        String str = "javaHadoop";
//        final String str1 = "java";//常量
         String str1 = "java";

        String str2 = str1+"Hadoop";
        System.out.println(str == str2);//true
    }
}
