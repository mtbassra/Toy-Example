package ch.mtbassra.java1.lecture01;

public class StoppingDistance {
	public static void main(String[] args) {
		
		float velocity = 120 / 3.6f; // 120 km/h
		System.out.println("Velocity: " + velocity);
		
		float reactionTime = 0.3f; //for a active driver
		
		float breakingDistance;
		float reactionDistance;
		float stoppingDistance;
		
		
		breakingDistance = (velocity * velocity) / 16; // for every good car
		System.out.println("Breaking Distance: " + breakingDistance);
		
		reactionDistance = velocity * reactionTime; // distance travelled while braking
		System.out.println("Reaction Distance: " + reactionDistance);
		
		stoppingDistance = breakingDistance + reactionDistance; // total stopping distance
		System.out.println("Stopping Distance: " + stoppingDistance);
		
		
	}

}
