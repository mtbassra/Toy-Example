package ch.mtbassra.lecture02.solutions;

import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Enter PIN");
		int PIN = userInput.nextInt();
		
		if (PIN == 1234) {
			System.out.println("Enter amount");
			int amount = userInput.nextInt();
			if (amount > 0 && amount % 10  == 0) {
				System.out.println("Here you go");	
			} else {
				System.out.println("Bad amount");
			}
		} else {
			System.out.println("Wrong PIN");
		}
		userInput.close();
		
	}

}
