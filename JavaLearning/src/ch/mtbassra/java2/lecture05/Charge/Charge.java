package ch.mtbassra.java2.lecture05.Charge;

import java.awt.Panel;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Charge extends Application {
	public static final int width = 800;
	public static final int height = 600;
	private ComboBox<Integer> cmbNumber;
	Animator animator;
	Button btnStart;
	Pane canvas;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() {
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		ObservableList<Integer> options = 
			    FXCollections.observableArrayList( 2, 4, 6, 8, 10, 12 );
		cmbNumber = new ComboBox<>(options);	
		cmbNumber.setValue(8);
		
		Region spacer = new Region();
		
		btnStart = new Button("Start");
		btnStart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				startCharge();
			}
		});
	   
		HBox.setHgrow(spacer, Priority.ALWAYS);
		HBox topBox = new HBox();
		topBox.getChildren().addAll(cmbNumber, spacer, btnStart);
		
		canvas = new Pane();
		canvas.setPrefSize(width, height);
		canvas.setStyle("-fx-background-color: white;");
		
		BorderPane root = new BorderPane();
		root.setTop(topBox);
		root.setCenter(canvas);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Charge!");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	@Override
	public void stop() {
		if (animator != null) animator.stop();
	}
	
	private void startCharge() {
		btnStart.setDisable(true);
		
		// Create equal numbers of positive and negative particles
		int numParticles = cmbNumber.getValue();
		Group group = new Group();
		for (int i = 0; i < numParticles; i++) {
			Particle particle = new Particle(width, height, i%2==0);
			group.getChildren().add(particle);
		}
		canvas.getChildren().add(group);
		
		// Create AnimationTimer
		Animator animator = new Animator(group);
		animator.start();
	}
}
