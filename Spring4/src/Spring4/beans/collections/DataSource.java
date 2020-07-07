package Spring4.beans.collections;

import java.util.Properties;

/**
 * @author lhang
 * @create 2020-07-06 10:59
 */
public class DataSource {
    private Properties properties;


    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    @Override
    public String toString() {
        return "DataSource{" +
                "properties=" + properties +
                '}';
    }
}
