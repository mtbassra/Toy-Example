package ch.mtbassra.lecture01;

public class Encoding {

	public static void main(String[] args) {
		char encoded = 'a';
		int key = 9;
		encoded = (char) key;
		System.out.println(encoded);
		key = encoded;
		System.out.println(key);

	}

}
