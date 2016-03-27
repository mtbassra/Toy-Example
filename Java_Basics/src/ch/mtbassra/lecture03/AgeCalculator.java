package ch.mtbassra.lecture03;

import java.time.LocalDate;
import java.util.Scanner;

public class AgeCalculator {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("enter the year, month and day that someone was born: ");
		int year = userInput.nextInt();
		int month = userInput.nextInt();
		int day = userInput.nextInt();
		userInput.close();
		
		// Get today's date
		LocalDate today = LocalDate.now();
		
		// Check inputs for validity
		boolean valid = true;
		if ((year < 1900) || year > today.getYear() ) valid = false;
		if ((month < 1) || (month > 12)) valid = false;
		if ((day < 1) || (day > 31)) valid = false;
		// Note: this does not account for special cases!!
		
		if (!valid) {
			System.out.println("Invalid birth date");
		} else {
			int age = today.getYear() - year;
			if (month > today.getMonthValue()) {
				age--;
			} else if (month == today.getMonthValue()) {
				if (day > today.getDayOfMonth()) {
					age--;
				}
			}
			System.out.println("This person is " + age + " years old");
		}
	}
}
