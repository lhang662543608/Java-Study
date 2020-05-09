package base.colllection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        try {
            Properties pros = new Properties();
             inputStream = new FileInputStream("jdbc123.properties");
            pros.load(inputStream);
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            System.out.println(user+"-----"+password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
