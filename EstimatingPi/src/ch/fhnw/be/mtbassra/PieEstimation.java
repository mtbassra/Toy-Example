package ch.fhnw.be.mtbassra;

import javafx.application.Application;
import javafx.stage.Stage;

public class PieEstimation extends Application  {

	private PieEstimationModel model;
	private PieEstimationView view;
	private PieEstimationController controller;

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) {

		model = new PieEstimationModel();
		view = new PieEstimationView(primaryStage, model);
		controller = new PieEstimationController(model, view);
		
		view.start();
	}

	@Override
	public void stop() {

		if (view != null)
			view.stop();
	}

}
