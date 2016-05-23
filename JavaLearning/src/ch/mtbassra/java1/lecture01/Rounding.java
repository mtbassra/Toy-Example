package ch.mtbassra.java1.lecture01;

public class Rounding {

	public static void main(String[] args) {
		
		float currency = 25.97f;
		float rappen;
		int amount;
		
		//Convert to rappens
		rappen = currency * 100;
		System.out.println("Rappens: " + rappen);
		
		//whole Franc
		amount = (int) rappen / 100;
		System.out.println("Whole Francs: " + amount);
		
		//10 rappen
		rappen = (float) ((currency * 100) / 100.10);

		System.out.println("10 Rappens: " + rappen);
		
		
		

	}

}
