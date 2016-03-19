package ch.mtbassra.lecture01;

public class HelloWorld {

	public static void main(String[] args) {
		String world = "Earth";
		String message;
		
		message = "Hello, " + world + "!";
		System.out.println(message);
		
		int a = 13;
		int b = 6;
		a = a / 2;
		System.out.println("Result Shall be 6 =" + a);
		a = a + b * 3;
		System.out.println("Result Shall be 24 = " + a);
		a = a / b - 3;
		System.out.println("Result here will be 1 = " + a);
		
		int i = 10;
		System.out.println("Here it should be 10 = " + i++);
		int j = 10;
		System.out.println("Here it should be 11 = " + ++j);
		i = 10 % 3; // Modulo gives remainder back!
		System.out.println("Here it should be 1 = " + i);
		
	}

}
