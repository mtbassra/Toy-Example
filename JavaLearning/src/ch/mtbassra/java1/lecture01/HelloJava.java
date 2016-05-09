package ch.mtbassra.java1.lecture01;

public class HelloJava {
	
	public static void main(String[] args) {
		String world = "Earth";
		String message;
		message = "Hello, " + world + "!";
		System.out.println(message);
		
		int a = 13;
		int b = 6;
		a = a / 2;
		System.out.println(a);
		a = a + b * 3;
		System.out.println(a);
		a = a / b - 3;
		System.out.println(a);
		
		int i = 10;
		int j = 10;
		
		System.out.println("Increment after Variable " + i++);
		System.out.println("New value of i: " + i);
		System.out.println("Increment before Variable " + ++j);
		System.out.println("New value of j: " + j);
		
		char c = 'z';
		System.out.println("This is Character: " + c);
		int l = c;
		System.out.println("This is Integer: " + l);
		
		c = (char) l;
		System.out.println("This is again Character: " + c);
		
		
		
	}

}
