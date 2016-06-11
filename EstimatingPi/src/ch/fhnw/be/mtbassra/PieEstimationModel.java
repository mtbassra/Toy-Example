package ch.fhnw.be.mtbassra;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javafx.scene.Group;

public class PieEstimationModel {

	public static final int width = 300;
	public static final int height = 300;
	public static final int R = 212;
	
	

	Point point;
	
	ArrayList<Point> points = new ArrayList<Point>();
	ArrayList<Point> pointsInCircle = new ArrayList<Point>();
	
	double numPoints;

	
	public PieEstimationModel() {

		
	}
	
	/**
	 * Generate points in ArrayList
	 */
	public void generatePoints() {

		point = new Point();
		point.relocate(Math.random() * width, Math.random() * height);
		point.setxValue(point.getLayoutX());
		point.setyValue(point.getLayoutY());
		points.add(point);
		
		if(isInCircle(point)) {
			pointsInCircle.add(point);
		}
		
//	    System.out.println("'" + point + "' has x-value " + point.getxValue());
//	    System.out.println("'" + point + "' has y-value " + point.getyValue());

	}


	/**
	 * Generate points in ArrayList
	 * @throws InterruptedException 
	 */
//	public void generatePoints() {
////		
////		int numPoints = 5; //(int) Math.floor(Math.random() * 101);
////		System.out.println("PointsGenrated: " + numPoints);
////		
////		for (int i = 0; i < numPoints; i++) {
////			
//			while(true) {
//				point.run();
//			
//			points.add(point);
//			
//			try {
//				TimeUnit.SECONDS.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    System.out.println("Points in ArrayList" + points.size());
//			
//		}	    
//	}
	

	/**
	 * number of points in the circle
	 * @return
	 */
	public boolean isInCircle(Point p) {
		double x = 0;
		double y = 0; 
		double result = 0;
		
			x = Math.sqrt(p.getxValue());
			y = Math.sqrt(p.getyValue());
			result = x*y;
			if(result < R)
			return true;
			else return false;
	}
	
	public int getPointsInCircle() {
		
		return pointsInCircle.size();
	}
	public int getTotalPoints() {
		return points.size();
	}
	
	public double getRatio() {

		return ((double)getPointsInCircle()/(double)getTotalPoints());
		
	}
	
	public Point getPoint() {
		return points.get(points.size()-1); 
	}

	/**
	 * estimating pie
	 * @return
	 */
	public double estimatePie() {

		
		return getRatio()*4;
	}

}
