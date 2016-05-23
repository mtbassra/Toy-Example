package ch.mtbassra.java1.lecture01;

public class Boolean {
	public static void main(String[] args) {
		int i = 12;
		int j = 9;
		int k = 5;
		
		boolean i_biggest = (i > j) & (i > k);
		System.out.println("i is Biggest: " + i_biggest);
		
		boolean j_isNotSmallest = (j > i) || (j > k);
		System.out.println("j is not smallest: " + j_isNotSmallest);
		
		boolean k_isBetween = (i > k) && (k < j) || (j > k) && (i < k);
		System.out.println("K is between : " + k_isBetween );
		
		boolean two_HaveSameValue = (i == j) || (j == k) || ( k == i);
		System.out.println("Two have same value: " + two_HaveSameValue );
	}

}
