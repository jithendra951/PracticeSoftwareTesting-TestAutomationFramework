package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyUtility {
	public static String getProperty(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/propertyfiles/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		fis.close();
		return value;
	}
}
