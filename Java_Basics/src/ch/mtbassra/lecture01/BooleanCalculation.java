package ch.mtbassra.lecture01;

public class BooleanCalculation {

	public static void main(String[] args) {
		int i, j, k;
		 
		i = 9;
		j = 8;
		k = 8;
		
		boolean j_isNotSmallest = (j > i) | (j > k);
		System.out.println("j is not Smallest; " + j_isNotSmallest);
		
		boolean k_isBetweenIandJ = (k > i) | (k > j);
		System.out.println("K is Between I and J; " + k_isBetweenIandJ);
		
		boolean all_same = (i == j) & (j == k);
		System.out.println("All same Value; " + all_same);
		
		Boolean twoAreEqual = (i == j) || (i == k) || (j == k);
		System.out.println("Two Are Equal; " + twoAreEqual);
	}

}
