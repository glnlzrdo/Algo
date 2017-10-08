package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaTesting2 {

	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<Integer>();
		for (int i = 1; i < 1000; i++) {
			ints.add(i);
		}

		System.out.println(
				ints.stream()
					.mapToInt(in -> in)
					.reduce(0, (x, y) -> x - y)
			);


		String[] str = {"A", "b", "c", "d", "E"};
		List<String> string = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			string.addAll(Arrays.asList(str));
		}

		long start = System.currentTimeMillis();
		String s =
		string.stream()
				.reduce("", (a, b) -> a + b + "\n");
		long end = System.currentTimeMillis();

		System.out.println("Stream Reduce Total Time : " + ((double)(end - start) / 1000) + " seconds");

		start = System.currentTimeMillis();
		s =
		string.parallelStream()
				.reduce("", (a, b) -> a + b + "\n");
		end = System.currentTimeMillis();

		System.out.println("Parallel Reduce Total Time : " + ((double)(end - start) / 1000) + " seconds");

		start = System.currentTimeMillis();
		s =
		string.stream()
				.collect(StringBuilder::new,
						(StringBuilder sb1, String s1) -> sb1.append(s1),
						(StringBuilder sb1, StringBuilder sb2) -> sb1.append(sb2))
						.toString();
		end = System.currentTimeMillis();

		System.out.println("Stream Collect Total Time : " + ((double)(end - start) / 1000) + " seconds");

		start = System.currentTimeMillis();
		s =
		string.parallelStream()
				.collect(StringBuilder::new,
						(StringBuilder sb1, String s1) -> sb1.append(s1),
						(StringBuilder sb1, StringBuilder sb2) -> sb1.append(sb2))
						.toString();
		end = System.currentTimeMillis();

		System.out.println("Parallel Stream Collect Total Time : " + ((double)(end - start) / 1000) + " seconds");
	}

}
