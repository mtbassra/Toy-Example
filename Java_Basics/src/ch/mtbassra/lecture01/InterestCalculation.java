package ch.mtbassra.lecture01;

public class InterestCalculation {

	public static void main(String[] args) {
		double b = 50000;
		double iR = 0.25;
		
		b = b + (b * (iR / 100)); 		
		System.out.println("Balance at end of 1stYear: " + b);
		
		b = b + (b * (iR / 100)); 		
		System.out.println("Balance at end of 2stYear: " + b);
		
		b = b + (b * (iR / 100)); 		
		System.out.println("Balance at end of 3rdYear: " + b);
		
		b = b + (b * (iR / 100)); 		
		System.out.println("Balance at end of 4thYear: " + b);
		
		b = b + (b * (iR / 100)); 		
		System.out.println("Balance at end of 5thYear: " + b);

	}

}
