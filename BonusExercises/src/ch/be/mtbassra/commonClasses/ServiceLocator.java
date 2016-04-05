package ch.be.mtbassra.commonClasses;

import java.util.Locale;
import java.util.logging.Logger;

import ch.be.mtbassra.Chat;

public class ServiceLocator {
	private static ServiceLocator serviceLocator; // Singleton

	// Application-global constants
	final private Class<?> APP_CLASS = Chat.class;
	final private String APP_NAME = "Chat";

	// Supported locals (for translations)
	final private Locale[] locales = new Locale[] { new Locale("en"), new Locale("de") };

	// Resources
	private Logger logger;
	private Configuration configuration;
	private Translator translator;

	/**
	 * Factory method for returning the singleton
	 * 
	 * @param mainClass
	 *            the main class of this program
	 * @return The Singleton resource locator
	 */
	public static ServiceLocator getServiceLocator() {
		if (serviceLocator == null)
			serviceLocator = new ServiceLocator();
		return serviceLocator;
	}

	/**
	 * Private constructor, because this class is a singleton
	 * 
	 * @param appName
	 *            Name of the class of this program
	 */
	private ServiceLocator() {
		// Define this constructor, otherwise it would be public by default
	}

	public Class<?> getAPP_CLASS() {
		return APP_CLASS;
	}

	public String getAPP_NAME() {
		return APP_NAME;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public Locale[] getLocales() {
		return locales;
	}

	public Translator getTranslator() {
		return translator;
	}

	public void setTranslator(Translator translator) {
		this.translator = translator;
	}

}
