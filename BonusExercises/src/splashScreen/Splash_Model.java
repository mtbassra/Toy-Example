package splashScreen;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import abstractClasses.Model;
import commonClasses.Configuration;
import commonClasses.ServiceLocator;
import commonClasses.Translator;
import javafx.concurrent.Task;

public class Splash_Model extends Model {
	ServiceLocator serviceLocator;
	
	public Splash_Model() {
		super();
	}
	
	//A task is JavaFX class that implements Runnable. Tasks are designed to
	//have attached listeners, which we can use to monitor their progress.
	final Task<Void> initializer = new Task<Void>() {
		@Override
		protected Void call() throws Exception {
			this.updateProgress(1, 6);
			
			//Create the service locator to hold resource
			serviceLocator = serviceLocator.getServiceLocator();
			this.updateProgress(2, 6);
			
			//Initialize the resources in the service locator
			serviceLocator.setLogger(configureLogging());
			this.updateProgress(3, 6);
			
			serviceLocator.setConfiguration(new Configuration());
			this.updateProgress(4, 6);
			
			String language = serviceLocator.getConfiguration().getOption("Language");
			serviceLocator.setTranslator(new Translator(language));
			this.updateProgress(5, 6);
			
			// ... more resources would go here ...
			this.updateProgress(6, 6);
			
			return null;
		}
	};
	
	public void initialize() {
		new Thread(initializer).start();
	}
	
	/**
	 * Create a logger with the name of the application, and attach handler
	 * to it. All logging should be done using this logger. Messages to this logger will also flow up to the root logger, 
	 * and from there to the console-handler.
	 * 
	 * Set the level of the console-handler to "INFO", so that the console only receives the more important messages. The levels of the loggers
	 * and the file-handler are set to "FINEST".
	 */
	private Logger configureLogging() {
		Logger rootLogger = Logger.getLogger("");
		rootLogger.setLevel(Level.FINEST);
		
		//By default there is one handler: the console
		Handler[] defaultHandlers = Logger.getLogger("").getHandlers();
		defaultHandlers[0].setLevel(Level.INFO);
		
		//Add our logger
		Logger ourLogger = Logger.getLogger(serviceLocator.getAPP_NAME());
		ourLogger.setLevel(Level.FINEST);
		
		//ADd a file handler, putting the rotating files in the tmp directory
		try {
			Handler logHanlder = new FileHandler("%t/" + serviceLocator.getAPP_NAME() + "_%u" + "_%g" + ".log", 1000000, 9);
			logHanlder.setLevel(Level.FINEST);
			ourLogger.addHandler(logHanlder);			
		} catch (Exception e) {
			throw new RuntimeException("Unable to initialize log files: " + e.toString());
		}
		return ourLogger;
	}
	

}
