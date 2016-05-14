package ch.fhnw.richards.lecture09_threads.webServer_v2;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The code for this web server is identical to WebServer_v0, except that we
 * actually send files, rather than just echoing requests. This only involves
 * changes in the Model.
 */
public class WebServer_v2 extends Application {
    private WebServerView view;
    private WebServerController controller;
    private WebServerModel model;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Note the dependencies between model, view and controller. Additionally,
     * the view needs the primaryStage created by JavaFX.
     */

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Part of the GUI will contain log output from our own handler
        TextAreaHandler textAreaHandler = new TextAreaHandler();
        textAreaHandler.setLevel(Level.INFO);
        Logger defaultLogger = Logger.getLogger("");
        defaultLogger.addHandler(textAreaHandler);
        
        // Initialize the GUI
        model = new WebServerModel();
        view = new WebServerView(primaryStage, model, textAreaHandler.getTextArea());
        controller = new WebServerController(model, view);

        // Display the GUI after all initialization is complete
        view.start();
    }

    /**
     * The stop method is the opposite of the start method. It provides an
     * opportunity to close down the program gracefully, when the program has
     * been closed.
     */
    @Override
    public void stop() {
        if (view != null)
            view.stop();
    }
}
