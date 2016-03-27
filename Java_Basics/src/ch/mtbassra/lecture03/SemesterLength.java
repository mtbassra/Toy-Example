package ch.mtbassra.lecture03;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class SemesterLength {

	public static void main(String[] args) {
		LocalDate semesterStart = LocalDate.of(2015,  9,  14);
		LocalDate semesterEnd = LocalDate.of(2015, 12, 19);
		Period semesterLength = semesterStart.until(semesterEnd);
		
		// First solution, answer in months and days
		int numberOfMonths = semesterLength.getMonths();
		int numberOfDays = semesterLength.getDays();
		System.out.println("The semester is " + numberOfMonths + " months and " + numberOfDays + " days long");
		
		// Second solution, answer only in total days
		long totalDays = semesterStart.until(semesterEnd, ChronoUnit.DAYS);
		System.out.println("The semester is " + totalDays + " days long");
	}

}
