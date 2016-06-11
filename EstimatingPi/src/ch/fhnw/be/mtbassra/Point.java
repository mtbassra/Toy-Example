package ch.fhnw.be.mtbassra;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
//import ch.fhnw.be.mtbassra.PieEstimationModel;

public class Point extends Circle {
	
	PieEstimationModel model;
	
	private Thread pThread;
	private double xValue;
	private double yValue;

	public static final int width = 300;
	public static final int height = 300;


	/**
	 * Creating a new point with random position
	 */
	public Point() {
		this.setRadius(2);
		this.setFill(Color.RED);

	}

	public double getxValue() {
		return xValue;
	}

	public void setxValue(double xValue) {
		this.xValue = xValue;
	}

	public double getyValue() {
		return yValue;
	}

	public void setyValue(double yValue) {
		this.yValue = yValue;
	}

}
