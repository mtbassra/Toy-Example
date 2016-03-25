package ch.mtbassra.lecture01;

/**
 * 
 * @author mtbas
 *
 */

public class StopingDistance {

	public static void main(String[] args) {
		
		float velocity = 33.333f; // 120 km/h
		float reactionTime = 0.3f; // in seconds
		
	float reactionDistance = reactionTime * velocity;
	System.out.println("Reaction Distance " + reactionDistance);
	
	float breakingDistance = (velocity * velocity) / 16;
	System.out.println("Breaking Distance " + breakingDistance);
	
	float stopingDistance = reactionDistance + breakingDistance;
	System.out.println("Stoping Distance " + stopingDistance);
	
	
	}

}
