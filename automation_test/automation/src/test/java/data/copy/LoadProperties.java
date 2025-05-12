package data.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	static String path = System.getProperty("user.dir")+"\\src\\main\\java\\Properties\\testData.properties";
	
	public static Properties userData = loadProperties(path);

	private static Properties loadProperties(String path) {
		Properties pro = new Properties();
		try {
			FileInputStream stream = new FileInputStream(path);
			try {
				pro.load(stream);
			} catch (IOException e) {
				System.out.println("Error Occupied "+e.getMessage());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error Occupied "+e.getMessage());
		}
		
		return pro;
	}
	
	
}
