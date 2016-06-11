package ch.fhnw.be.mtbassra;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PieEstimationController {

	final private PieEstimationModel model;
	final private PieEstimationView view;
	private boolean paused = false;
	Point latestPoint;

	Thread genPointThread = new Thread();
	Task task = null;

	protected PieEstimationController(PieEstimationModel model, PieEstimationView view) {
		
		this.model = model;
		this.view = view;

		view.btnControl.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				if (view.btnControl.getText().equals("Start")) {
					statGenPointThread();
					view.btnControl.setText("Pause");
					
				} else if (view.btnControl.getText().equals("Pause")) {
					pause();
					latestPoint = model.getLatestPoint();
					view.pane.getChildren().add(latestPoint);
					view.btnControl.setText("Resume");
					paused = true;
				} else if (view.btnControl.getText().equals("Resume")) {
					paused = false;
					resume();
					view.btnControl.setText("Pause");

				}
			}

		});
	}

	protected void statGenPointThread() {

		task = new Task<Void>() {
			@Override
			public void run() {
				while(!paused) {
					model.generatePoints();
				}
			}

			@Override
			protected Void call() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		};
		genPointThread = new Thread(task);
		genPointThread.start();
		System.out.println("thread started");

	}

	public void pause() {

		genPointThread.interrupt();
		System.out.println("Paused");
		view.txtTotalPoints.setText("" + model.getTotalPoints());
		view.txtPointsInCircle.setText("" + model.getPointsInCircle());
		view.txtRatio.setText("" + model.getRatio());
		view.txtPie.setText("" + model.estimatePie());
	}

	public void resume() {

		view.pane.getChildren().remove(latestPoint);
		genPointThread = new Thread(task);
		genPointThread.start();
	}
}
