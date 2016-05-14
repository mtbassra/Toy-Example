package ch.fhnw.richards.lecture04.sampleSolution.optionsWindow;

import java.util.logging.Logger;

import ch.fhnw.richards.lecture04.sampleSolution.ServiceLocator;
import ch.fhnw.richards.lecture04.sampleSolution.commonClasses.Configuration;
import ch.fhnw.richards.lecture04.sampleSolution.commonClasses.Translator;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class WebValidator_View {
	ServiceLocator sl = ServiceLocator.getServiceLocator();
	Logger logger = sl.getLogger();
	Translator t = sl.getTranslator();
	Configuration config = sl.getConfiguration();
	
    private WebValidator_Model model;
    private Stage stage;

    protected Label lblIpAddress = new Label(t.getString("options.address"));
    protected TextField txtIpAddress = new TextField();
    protected Label lblPort = new Label(t.getString("options.port"));
    protected TextField txtPort = new TextField();
    protected Button btnCancel = new Button(t.getString("options.cancel"));
    protected Button btnSave = new Button(t.getString("options.save"));

    public WebValidator_View(Stage stage, WebValidator_Model model) {
        this.stage = stage;
        this.model = model;
        
        stage.setTitle(t.getString("options.title"));
        
        HBox root = new HBox();
        Region spacer1 = new Region();
        Region spacer2 = new Region();
        root.getChildren().addAll(lblIpAddress, txtIpAddress, spacer1, lblPort, txtPort, spacer2, btnCancel, btnSave);

        // Get current values
        txtIpAddress.setText(config.getOption("WebServer"));
        txtPort.setText(config.getOption("Port"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);;
    }
    
    public void start() {
        stage.show();
    }
    
    /**
     * Stopping the view - just make it invisible
     */
    public void stop() {
        stage.hide();
    }
    
    /**
     * Getter for the stage, so that the controller can access window events
     */
    public Stage getStage() {
        return stage;
    }
}
