package ch.mtbassra.lecture02;

import java.util.Scanner;

public class AddNumbers {

	public static void main(String[] args) {
		int i, j, k, sum;
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Enter your 1st number: ");
		
		i = userInput.nextInt();
		 
		System.out.println("Enter your 2nd number: ");
		
		j = userInput.nextInt();
		
		System.out.println("Enter your 3rd number: ");
		
		k = userInput.nextInt();
		
		sum = i + j + k;
		
		System.out.println("Here is your sum = " + sum);
		

	}

}
