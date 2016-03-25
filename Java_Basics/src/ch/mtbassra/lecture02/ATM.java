package ch.mtbassra.lecture02;

import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		Float amount;
		
		int pin = 2772;
		
		System.out.println("Enter Pin: ");
		
		pin = userInput.nextInt();
			if (pin == 2772) {			
			System.out.println("Enter Amount: ");
			amount = userInput.nextFloat();
			if (amount > 0 && amount % 10 == 0)			
			System.out.println("Here is your amount. Thank you for using ATM! :");
			else
				System.out.println("Wrong Amount");
		} else {
			System.out.println("Pin is wrong, Try again ");
			pin = userInput.nextInt();			
		}

	}

}
