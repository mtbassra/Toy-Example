package ch.mtbassra.java2.lecture05.GUI_Animation;

import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TicTacToe_Animation extends Application {
	enum TTT_Moves {
		X, O
	};

	private TTT_Moves nextMove = TTT_Moves.X;
	private ParallelTransition onClick;

	// Array to hold 9 buttons
	Button[][] buttons = new Button[3][3];

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() {
		ScaleTransition t1 = new ScaleTransition(Duration.millis(200));
		t1.setToX(1.5);
		t1.setToY(1.5);
		t1.setAutoReverse(true);
		t1.setCycleCount(4);

		RotateTransition t2 = new RotateTransition(Duration.millis(800));
		t2.setByAngle(360);
		t2.setCycleCount(1);

		onClick = new ParallelTransition(t1, t2);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new GridPane();

		// Create the buttons: 3 columns & 3 rows
		for (int col = 0; col < 3; col++) {
			for (int row = 0; row < 3; row++) {
				buttons[col][row] = new Button(); // Create button
				root.add(buttons[col][row], col, row); // Add to layout
				buttons[col][row].setPrefSize(120, 120); // Format

				// Initial movement of controls
				Path path = new Path();
				// Random start position, relative to normal location in each cell
				path.getElements().add(new MoveTo(Math.random() * 240 + 60 - col * 120, Math.random() * 240 + 60 - row * 120));
				path.getElements().add(new LineTo(60, 60)); // Move to center of cell in grid, size 120x120
				PathTransition move = new PathTransition(Duration.millis(2000), path, buttons[col][row]);
				move.play();
				
				// Add event handling
				buttons[col][row].setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						changeButtonText(e);
					}
				});
			}
		}

		// Create the scene using our layout; then display it
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("TicTacToe_Animation.css")
						.toExternalForm());
		primaryStage.setTitle("Tic-Tac-Toe");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void changeButtonText(ActionEvent e) {
		Button btn = (Button) e.getSource();
		btn.setText(nextMove.toString());
		if (nextMove.equals(TTT_Moves.X)) {
			nextMove = TTT_Moves.O;
		} else {
			nextMove = TTT_Moves.X;
		}
		onClick.setNode(btn);
		onClick.play();
	}
}
