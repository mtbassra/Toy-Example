package ch.fhnw.richards.lecture10_xml.jaxpDOM.server;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The code for this web server is identical to WebServer_v0, except that we
 * actually send files, rather than just echoing requests. This only involves
 * changes in the Model.
 */
public class Server extends Application {
    private ServerView view;
    private ServerController controller;
    private ServerModel model;

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
        model = new ServerModel();
        view = new ServerView(primaryStage, model, textAreaHandler.getTextArea());
        controller = new ServerController(model, view);

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
