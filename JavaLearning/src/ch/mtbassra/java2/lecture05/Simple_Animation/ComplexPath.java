package ch.mtbassra.java2.lecture05.Simple_Animation;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ComplexPath extends Application {
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
			PathElement pe1 = new MoveTo(200, 100); // Start position
			PathElement pe2 = new LineTo(100, 75);
			PathElement pe3 = new ArcTo(50, 100, 0, 300, 450, false, false);
			
			Path path = new Path();
			path.getElements().add(pe1);
			path.getElements().add(pe2);
			path.getElements().add(pe3);

			PathTransition move = new PathTransition(Duration.millis(4000), path, ellipse);
			move.setAutoReverse(true);
			move.setCycleCount(Animation.INDEFINITE);
			move.play();

			// Display the scene, which contains our object-group
			Scene scene = new Scene(objects, 400, 600, Color.WHITE);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Complex Path");
			primaryStage.show();
		}

	}
