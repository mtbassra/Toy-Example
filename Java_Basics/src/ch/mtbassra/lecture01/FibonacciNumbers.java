package ch.mtbassra.lecture01;

public class FibonacciNumbers {

	public static void main(String[] args) {
		int i = 1;
		int fibo = i;
		System.out.println("1 = " + i);
		System.out.println("1 = " + fibo);
		fibo +=i;
		System.out.println("2 = " + fibo);
		i +=fibo;
		System.out.println("3 = " + i);
		fibo +=i;
		System.out.println("5 " + fibo);
		i +=fibo;
		System.out.println("8 " + i);
		fibo +=i;
		System.out.println(fibo);
		i +=fibo;
		System.out.println(i);
		fibo +=i;
		System.out.println(fibo);
		i +=fibo;
		System.out.println(i);
		fibo +=i;
		System.out.println(fibo);
		i +=fibo;
		System.out.println(i);
		fibo +=i;
		System.out.println(fibo);
		i +=fibo;
		System.out.println(i);
		fibo +=i;
		System.out.println(fibo);
		

	}

}
