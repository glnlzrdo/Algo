package main;

public class Fibonacci {

	public static void printFibonacci(int num) {
		int left = 0, right = 1, res = 1;
		System.out.println(res);

		for (int i = 1; i < num; i++) {
			res = left + right;
			System.out.println(res);
			left = right;
			right = res;
		}
	}

	public static void printFibonacciArray(int[] sequence) {
		for (int i = 0; i < sequence.length; i++) {
			if (i == 0 || i == 1) {
				sequence[i] = 1;
			} else {
				sequence[i] = sequence[i - 1] + sequence[i - 2];
			}
		System.out.println(sequence[i]);
		}
	}

	public static void main(String[] args) {
		printFibonacci(10);
		printFibonacciArray(new int[10]);
	}
}
