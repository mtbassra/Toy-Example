package ch.fhnw.be.mtbassra;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Point extends Circle {

	private double xValue;
	private double yValue;

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
