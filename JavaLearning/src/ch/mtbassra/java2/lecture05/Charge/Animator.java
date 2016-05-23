package ch.mtbassra.java2.lecture05.Charge;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;

public class Animator extends AnimationTimer {
	private Group group;

	public Animator(Group group) {
		super();
		this.group = group;
	}

	/**
	 * We assume that we are called on a regular schedule; we ignore the precise
	 * time given.
	 */
	@Override
	public void handle(long now) {
		// Move all particles
		for (Iterator<Node> i = group.getChildren().iterator(); i.hasNext();) {
			Particle particle = (Particle) i.next();
			double newX = particle.getTranslateX() + particle.getxVel();
			double newY = particle.getTranslateY() + particle.getyVel();

			if (newX < 0 || newX > Charge.width) particle.setxVel(0 - particle.getxVel());
			if (newY < 0 || newY > Charge.height) particle.setyVel(0 - particle.getyVel());
			
			accelerate(particle, group.getChildren());
			particle.setTranslateX(newX);
			particle.setTranslateY(newY);
		}
	}

	private void accelerate(Particle particle, ObservableList<Node> particles) {
		final double attraction = 10; // constant determining behavior
		double accelX = 0;
		double accelY = 0;

		for (Node node : particles) {
			Particle p = (Particle) node;
			if (p != particle) {
				double distX = p.getTranslateX() - particle.getTranslateX();
				double distY = p.getTranslateY() - particle.getTranslateY();
				double distance = Math.sqrt(distX * distX + distY * distY);
				double force = attraction / distance; // deliberately wrong, but more interesting
				if (p.isPositive() == particle.isPositive()) force = 0 - force;
				
				double angle = Math.atan(Math.abs(p.getTranslateY() - particle.getTranslateY())
						/ Math.abs(p.getTranslateX() - particle.getTranslateX()));
				double xTmp = force * Math.cos(angle) * Math.signum(p.getTranslateX() - particle.getTranslateX());
				double yTmp = force * Math.sin(angle) * Math.signum(p.getTranslateY() - particle.getTranslateY());
				accelX += xTmp;
				accelY += yTmp;
			}
		}
		
		// Slight inaccuracies in the simulation require a fudge factor
		// to prevent the particles from speeding up (0.995)
		particle.setxVel(0.995 * (particle.getxVel() + accelX));
		particle.setyVel(0.995 * (particle.getyVel() + accelY));
	}
}
