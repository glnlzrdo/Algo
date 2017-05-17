package main;

public class Factorial {
	private static long getFactorial(long num) {
		if (num < 1)
			return 1;
		else
			return num * getFactorial(num - 1);
	}

	public static void main(String[] args) {
		System.out.println(getFactorial(20));
	}
}
