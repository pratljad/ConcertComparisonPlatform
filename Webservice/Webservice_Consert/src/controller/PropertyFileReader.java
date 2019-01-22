/**
 * 
 */
package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Joulian
 * A reader who reads the important properties from a file
 */
public class PropertyFileReader {
	private Properties prop = new Properties();
	private InputStream input = null;
	private String driver = "";
	private String url = "";
	private String username = "";
	private String password = "";
	private static PropertyFileReader propFileReader;
	
	/**
	 * 
	 */
	private PropertyFileReader() {
		super();
		
		try {
			this.input = new FileInputStream("/usr/local/apache-tomcat9/webapps/dao.properties");
			
			this.prop.load(input);
			
			this.driver = prop.getProperty("driver");
			this.url = prop.getProperty("url");
			this.username = prop.getProperty("username");
			this.password = prop.getProperty("password");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @return the propFileReader
	 */
	public static PropertyFileReader getPropFileReader() {
		if(PropertyFileReader.propFileReader == null) {
			PropertyFileReader.propFileReader = new PropertyFileReader();
		}
		
		return PropertyFileReader.propFileReader;
	}

	/**
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
}
