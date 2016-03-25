package ch.mtbassra.lecture02.solutions;

import java.util.Scanner;

public class Francs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double amount = in.nextDouble();
		in.close();
		
		int rappen = (int) (amount * 100);
		int twenty_bills = rappen / 2000;
		System.out.println("Twnety franc bills: "+ twenty_bills);
		rappen = rappen % 2000;

		int ten_bills = rappen / 1000;
		System.out.println("Ten franc bills: "+ ten_bills);
		rappen = rappen % 1000;

		int five_coins = rappen / 500;
		System.out.println("Five franc coins: "+ five_coins);
		rappen = rappen % 500;
		
		int two_coins = rappen / 200;
		System.out.println("Two franc coins: "+ two_coins);
		rappen = rappen % 200;
	}

}
