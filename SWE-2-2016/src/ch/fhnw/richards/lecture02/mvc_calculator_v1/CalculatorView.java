package ch.fhnw.richards.lecture02.mvc_calculator_v1;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CalculatorView {
	final private CalculatorModel model;
	final private Stage stage;
	
	protected CalculatorView(Stage stage, CalculatorModel model) {
		this.stage = stage;
		this.model = model;
		
		stage.setTitle("Calculator");
		
		BorderPane root = new BorderPane();
		
		Label helloWorld = new Label("Hello, World!");
		root.setCenter(helloWorld);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("Calculator.css").toExternalForm());
		stage.setScene(scene);
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
}
