package ch.mtbassra.lecture01;

import java.util.Scanner;

/**
 * 
 * @author mtbas
 *
 */

public class StopingDistance {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);

		System.out.println("Enter Velocity: ");
		float velocity = userInput.nextFloat(); // 120 km/h
		
		float reactionTime = 0.3f; // in seconds
		
	float reactionDistance = reactionTime * velocity;
	System.out.println("Reaction Distance " + reactionDistance);
	
	float breakingDistance = (velocity * velocity) / 16;
	System.out.println("Breaking Distance " + breakingDistance);
	
	float stopingDistance = reactionDistance + breakingDistance;
	System.out.println("Stoping Distance " + stopingDistance);
	
	userInput.close(); // done reading information
	}

}
