package ch.mtbassra.java2.lecture05.Charge;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Particle extends Circle {
	private double xVel;
	private double yVel;
	private boolean positive;

	/**
	 * Create a new particle with random position and velocity
	 */
	public Particle(int width, int height, boolean positive) {
		super(3);
		this.positive = positive;
		if (positive) {
			this.setFill(Color.BLUE);
		} else {
			this.setFill(Color.RED);
		}
		this.setTranslateX(Math.random() * width);
		this.setTranslateY(Math.random() * height);
		xVel = Math.random() * 3;
		yVel = Math.random() * 3;
	}

	public double getxVel() {
		return xVel;
	}

	public void setxVel(double xVel) {
		this.xVel = xVel;
	}

	public double getyVel() {
		return yVel;
	}

	public void setyVel(double yVel) {
		this.yVel = yVel;
	}

	public boolean isPositive() {
		return positive;
	}
}