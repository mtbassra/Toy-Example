package ch.mtbassra.lecture02;

import java.util.Scanner;


public class PopulationDensity_withErrors {

	/**
	 * Calculate the population density of an area. The area can be square or oval.
	 * If the area is square, the size is width time height. If it is oval,
	 * the area is pi * major-radius * minor-radius.
	 * 
	 * Then read in the population. Calculate the population density as
	 * population density as people per square kilometer.
	 * 
	 * THIS PROGRAM CONTAINS ERRORS - find and fix the errors
	 */
	public static void main(String[] args) {
		double area;
		double answer;
		Scanner userInput = new Scanner(System.in);
		
		// Rectangle or oval?
		System.out.println("If the area is an oval, enter '1'; otherwise it will be a rectangle: ");
		int shape = userInput.nextInt();
		
		// Read width and height (or major/minor radius)
		System.out.println("Enter the width (or major radius): ");
		float x = userInput.nextFloat();
		System.out.print(x);
		System.out.println("Enter the height (or minor radius): ");
		float y = userInput.nextFloat();
		System.out.print(y);
		System.out.println("Enter the population: ");
		int population = userInput.nextInt();
		System.out.print(population);
		
		userInput.close(); // done reading from user
		
		if (shape == 1) { // circle
			area = x * y * Math.PI;
			System.out.print("Area of circle " + area);
		} else { // rectangle
			area = x * x;
			System.out.print("Area of Rectangle " + area);
		}

		answer = population / area;
		System.out.println("Population density: " + answer);
	}

}
