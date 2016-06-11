package ch.fhnw.be.mtbassra;

import java.util.concurrent.TimeUnit;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PieEstimationController {

	final private PieEstimationModel model;
	final private PieEstimationView view;
	boolean paused = false;
	Point latestPoint;


	Thread genThread = new Thread();
	Task task = null;
	
	protected PieEstimationController(PieEstimationModel model, PieEstimationView view) {
		this.model = model;
		this.view = view;

		view.btnControl.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				
				if (view.btnControl.getText().equals("Start")) {
					
					btnConrol();
					view.btnControl.setText("Pause");
					
				} else if (view.btnControl.getText().equals("Pause")) {
					
					pause();
					latestPoint = model.getPoint();
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

	protected void btnConrol() {

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

		genThread = new Thread(task);

		genThread.start();


		// model.getNumPointInCircle();
		//// view.txtPointsInCircle.setText(model.getNumPointInCircle());

		// view.btnControl.setDisable(true);

	}

	public String totalPoints() {

		return "" + model.points.size();
	}
//	public String pointsinCircle() {
		

//	
//		Task t = new Task<Void>() {
//			public void run() {
//			model.PointsInCircle();
//		
//			}
//
//			@Override
//			protected Void call() throws Exception {
//				// TODO Auto-generated method stub
//				return null;
//			}
//
//		};
//		
//		return "" + model.getPointsInCircle();
//	}

	public void pause() {
		
		genThread.interrupt();
		
		System.out.println("Paused");
		
		view.txtTotalPoints.setText(totalPoints());
		
		view.txtPointsInCircle.setText("" + model.getPointsInCircle());

		view.txtRatio.setText("" + model.getRatio());
		
		view.txtPie.setText("" + model.estimatePie());
		
	}
	public void resume() {

		view.pane.getChildren().remove(latestPoint);
		genThread = new Thread(task);
		genThread.start();
		
	}

	private void estimatePie() {
		model.estimatePie();

	}


}
