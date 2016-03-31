package commonClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Logger;

public class Configuration {
	ServiceLocator sl = ServiceLocator.getServiceLocator();// For easy reference
	Logger logger = sl.getLogger();

	private Properties defaultOptions;
	private Properties localOptions;

	public Configuration() {
		// Load default properties from wherever the code is
		defaultOptions = new Properties();
		String defaultFileName = sl.getAPP_NAME() + "_defaults.cfg";
		InputStream inStream = sl.getAPP_CLASS().getResourceAsStream(defaultFileName);
		try {
			defaultOptions.load(inStream);
			logger.config("Defualt configuration file found");
		} catch (Exception e) {
			logger.warning("No defualt configuration file found: " + defaultFileName);
		} finally {
			try {
				inStream.close();
			} catch (Exception e) {
			}
		}
		// Default locally-saved properties; link to the default values
		localOptions = new Properties(defaultOptions);

		// Load local configuration file, if it exists
		try {
			inStream = new FileInputStream(sl.getAPP_NAME() + ".cfg");
			localOptions.load(inStream);
		} catch (Exception e) { // From loading the properties
			logger.warning("Error reading local options file: " + e.toString());
		} finally {
			try {
				inStream.close();
			} catch (Exception e) {
			}
		}

		for (Enumeration<Object> i = localOptions.keys(); i.hasMoreElements();) {
			String key = (String) i.nextElement();
			logger.config("Options: " + key + " = " + localOptions.getProperty(key));
		}
	}

	public void save() {
		FileOutputStream propFile = null;
		try {
			propFile = new FileOutputStream(sl.getAPP_NAME() + ".cfg");
			localOptions.store(propFile, null);
			logger.config("Local configuration file saved");
		} catch (Exception e) {
			logger.warning("Unable to save local options: " + e.toString());
		} finally {
			if (propFile != null) {
				try {
					propFile.close();
				} catch (Exception e) {
				}

			}
		}
	}

	public String getOption(String name) {
		return localOptions.getProperty(name);
	}

	public void setLocalOption(String name, String value) {
		localOptions.setProperty(name, value);
	}

}
