package ch.mtbassra.lecture02;

import java.util.Scanner;

public class StoppingDistance {

	public static void main(String[] args) {
		  Scanner userInput = new Scanner(System.in);

		  System.out.print("Enter the velocity in m/s: ");
		  float velocity = userInput.nextFloat();
		  System.out.println("Velocity entered " + velocity);

		  float reactionTime = 0.3f; // in seconds

		  // Calculate reaction distance
		  float reactionDistance = reactionTime * velocity;
		  System.out.println("Reaction distance: " + reactionDistance);

		  // Calculate braking distance
		  float brakingDistance = velocity * velocity / 16.0f;
		  System.out.println("Braking distance: " + brakingDistance);

		  // Calculate the stopping distance
		  float stoppingDistance = reactionDistance + brakingDistance;
		  System.out.println("Stopping distance: " + stoppingDistance);
		  
		  userInput.close(); // Done reading information
		}
}
