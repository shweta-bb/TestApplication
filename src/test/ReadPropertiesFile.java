/**
 * 
 */
package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.Document;

import com.bbytes.errzero.logger.util.ErrZeroClient;

/**
 * @author Shweta
 *
 */
public class ReadPropertiesFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(ReadPropertiesFile.class);


		/*DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();*/
		try {
			/*DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse("log4j.xml");*/
			DOMConfigurator.configure("log4j.xml");

			File file = new File("errzero.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();

			Enumeration enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				System.out.println(key + ": " + value);
				
			}
			int c = 1/0;
			System.out.println(c);
			
		} catch (Exception e) {
			ErrZeroClient errZeroClient = ErrZeroClient.getInstance();
			errZeroClient.sendException(e);
			/*e.printStackTrace();*/
		}

	}

}
