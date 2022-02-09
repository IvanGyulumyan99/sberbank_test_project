package API.ipApi.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
    public String getPropertyValue(String propertyName) throws IOException {
        FileReader reader = new FileReader("src\\main\\resources\\key.properties");
        Properties p = new Properties();
        p.load(reader);
        return p.getProperty(propertyName);
    }
}
