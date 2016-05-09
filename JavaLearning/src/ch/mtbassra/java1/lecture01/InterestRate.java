package ch.mtbassra.java1.lecture01;

public class InterestRate {
	public static void main(String[] args) {
		double balance = 50000;
		double interestrate = 0.5 / 100;
		
		float f = 13.5f;
		long i = 2147483648l;
		
		
		balance = balance + (balance * interestrate);		
		System.out.println("Balance after 1 year: " + balance );
		
		balance = balance + (balance * interestrate);
		System.out.println("Balance after 2 year: " + balance );
		
		balance = balance + (balance * interestrate);		
		System.out.println("Balance after 3 year: " + balance );
		
		balance = balance + (balance * interestrate);		
		System.out.println("Balance after 4 year: " + balance );
		
		balance = balance + (balance * interestrate);		
		System.out.println("Balance after 5 year: " + balance );
		
		balance = balance + (balance * interestrate);		
		System.out.println("Balance after 6 year: " + balance );
	}

}
