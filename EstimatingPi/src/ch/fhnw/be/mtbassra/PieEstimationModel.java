package ch.fhnw.be.mtbassra;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Group;

public class PieEstimationModel {

	public static final int width = 300;
	public static final int height = 300;
	public static final int R = 212;
	Point point;
	ArrayList<Point> points = new ArrayList<Point>();
	ArrayList<Point> pointsInCircle = new ArrayList<Point>();

	public PieEstimationModel() {

	}

	/**
	 * Generate points
	 */
	public void generatePoints() {

		point = new Point();
		// locate point within the square
		point.relocate(Math.random() * width, Math.random() * height);
		// setting x & y-axis values of point in
		point.setxValue(point.getLayoutX());
		point.setyValue(point.getLayoutY());
		// add in the ArrayList
		points.add(point);
		// points that lies in circle is stored in added ArrayList
		if (isInCircle(point)) {
			pointsInCircle.add(point);
		}
	}

	/**
	 * check if point lies in the circle
	 * @param Point
	 * @return boolean true or false
	 */
	public boolean isInCircle(Point p) {

		double x = 0;
		double y = 0;
		double result = 0;
		x = Math.sqrt(p.getxValue());
		y = Math.sqrt(p.getyValue());
		result = x * y;
		if (result < R)
			return true;
		else
			return false;
	}
	
	public int getTotalPoints() {
		return points.size();
	}	

	public int getPointsInCircle() {

		return pointsInCircle.size();
	}



	public double getRatio() {

		return ((double) getPointsInCircle() / (double) getTotalPoints());
	}

	public Point getLatestPoint() {
		return points.get(points.size() - 1);
	}

	/**
	 * estimating pie
	 */
	public double estimatePie() {
		return getRatio()*4;
	}

}
