package ch.mtbassra.java1.lecture01;

public class Fibonacci {
	public static void main(String[] args) {
		int n = 1;
		int fibo = n;
		System.out.println("1st Fibonacci is: " + n);
		System.out.println("2nd Fibonacci is: " + fibo);
		n = fibo + n;
		System.out.println("3rd Fibonacci is: " + n);
		fibo = fibo + n;
		System.out.println("4th Fibonacci is: " + fibo);
		n = fibo + n;
		System.out.println("5th Fibonacci is: " + n);
		fibo = fibo + n;
		System.out.println("6th Fibonacci is: " + fibo);
		n = fibo + n;
		System.out.println("7th Fibonacci is: " + n);
		fibo = fibo + n;
		System.out.println("8th Fibonacci is: " + fibo);
		n = fibo + n;
		System.out.println("9th Fibonacci is: " + n);
		fibo = fibo + n;
		System.out.println("10th Fibonacci is: " + fibo);
		
		
		
	}

}
