package ch.mtbassra.java2.lecture05.Simple_Animation;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BouncingBall2 extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create new object with initial position and size
		Ellipse ellipse = new Ellipse(200, 100, 50, 50);
		ellipse.setStroke(Color.BLUE);
		ellipse.setStrokeWidth(4);
		ellipse.setFill(Color.GREEN);

		// Create a group to hold our animated objects
		Group objects = new Group();
		objects.getChildren().add(ellipse);

		// Transition animation
		TranslateTransition fall = new TranslateTransition(Duration.millis(2000));
		fall.setByY(450);
		
		FillTransition fill = new FillTransition(Duration.millis(500));
		fill.setToValue(Color.RED);
		TranslateTransition fall2 = new TranslateTransition(Duration.millis(500));
		fall2.setByY(25);
		ScaleTransition shape = new ScaleTransition(Duration.millis(500));
		shape.setToX(1.5);
		shape.setToY(0.5);
		
		ParallelTransition squash = new ParallelTransition(fill, fall2, shape);

		SequentialTransition sequence = new SequentialTransition(ellipse, fall, squash);
		sequence.setCycleCount(Animation.INDEFINITE);
		sequence.setAutoReverse(true);
					
		sequence.play();

		// Display the scene, which contains our object-group
		Scene scene = new Scene(objects, 400, 600, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Bouncing Ball");
		primaryStage.show();
	}

}
