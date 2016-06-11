package ch.fhnw.be.mtbassra;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PieEstimationView {

	final private Stage stage;

	public static final int width = 300;
	public static final int height = 300;

	Rectangle rect;
	Arc arc;
	Pane pane = new Pane();

	Button btnControl;
	Region spacer;

	Label lblTotalPoints;
	Label lblPointsInCircle;
	Label lblRatio;
	Label lblPie;

	TextField txtTotalPoints;
	TextField txtPointsInCircle;
	TextField txtRatio;
	TextField txtPie;

	protected PieEstimationView(Stage stage, PieEstimationModel model) {

		this.stage = stage;
		lblTotalPoints = new Label("Total Points Generated: ");
		lblPointsInCircle = new Label("Points in the Circle: ");
		lblRatio = new Label("Ratio of Points in circle: ");
		lblPie = new Label("Estimated Pie: ");

		txtTotalPoints = new TextField();
		txtPointsInCircle = new TextField();
		txtRatio = new TextField();
		txtPie = new TextField();

		btnControl = new Button("Start");

		// creating pane for labels and text fields
		GridPane fields = new GridPane();

		fields.add(lblTotalPoints, 1, 0);
		fields.add(txtTotalPoints, 2, 0);

		fields.add(lblPointsInCircle, 1, 1);
		fields.add(txtPointsInCircle, 2, 1);

		fields.add(lblRatio, 1, 2);
		fields.add(txtRatio, 2, 2);

		fields.add(lblPie, 1, 3);
		fields.add(txtPie, 2, 3);

		Label space = new Label(" ");
		fields.add(space, 3, 0);
		fields.add(btnControl, 4, 0);

		// creating square as rectangle

		Rectangle rect = new Rectangle();
		rect.setWidth(width);
		rect.setHeight(height);
		rect.setFill(Color.BLUEVIOLET);

		// creating quarter circle as arc
		arc = new Arc();
		arc.setRadiusX(width);
		arc.setRadiusY(height);
		arc.setLength(90.0f);
		arc.setType(ArcType.ROUND);
		arc.setFill(Color.ORANGE);
		arc.relocate(0, 0);

		// pane for placing rectangle and circle and Later Points
		pane.setPrefSize(width, height);
		pane.setStyle("-fx-background-color: WHITE;");
		pane.getChildren().addAll(rect, arc);

		Group group = new Group();
		group.getChildren().add(pane);

		BorderPane root = new BorderPane();
		root.setPrefSize(350, 350);
		root.setCenter(group);
		root.setBottom(fields);

		Scene scene = new Scene(root);
		stage.setTitle("Estimation of Pie");
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	}

	public void start() {
		stage.show();
	}

	public void stop() {
		stage.hide();
	}

}
