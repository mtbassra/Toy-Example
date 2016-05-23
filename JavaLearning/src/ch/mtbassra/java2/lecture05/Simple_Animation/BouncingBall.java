package ch.mtbassra.java2.lecture05.Simple_Animation;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BouncingBall extends Application {
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

		// Timeline animation
		Timeline time = new Timeline();
		time.setCycleCount(Animation.INDEFINITE);
		time.setAutoReverse(true);

		KeyValue yPos = new KeyValue(ellipse.translateYProperty(), 450);
		KeyValue width = new KeyValue(ellipse.scaleXProperty(), 1);
		KeyValue height = new KeyValue(ellipse.scaleYProperty(), 1);
		KeyValue fill = new KeyValue(ellipse.fillProperty(), Color.GREEN);
		KeyFrame keyFrame = new KeyFrame(Duration.seconds(2.0),  // Point in time
				yPos, width, height, fill);                      // List all KeyValues 
		time.getKeyFrames().add(keyFrame);

		yPos = new KeyValue(ellipse.translateYProperty(), 475);
		width = new KeyValue(ellipse.scaleXProperty(), 1.5);
		height = new KeyValue(ellipse.scaleYProperty(), 0.5);
		fill = new KeyValue(ellipse.fillProperty(), Color.RED);
		keyFrame = new KeyFrame(Duration.seconds(2.5),  // Point in time
				yPos, width, height, fill);             // List all KeyValues 
		time.getKeyFrames().add(keyFrame);

		time.play();

		// Display the scene, which contains our object-group
		Scene scene = new Scene(objects, 400, 600, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Bouncing Ball");
		primaryStage.show();
	}

}
