package main;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static int[] findTwoSum(int[] list, int sum) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < list.length; i++) {
			map.put(list[i], i);
		}
		for (int i = 0; i < list.length; i++) {
			int diff = sum - list[i];
			if (map.get(diff)!= null) {
				return new int[] {i, map.get(diff)};
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 20);
		try {
			System.out.println(indices[0] + " " + indices[1]);
		} catch (NullPointerException e) {
			System.out.println("Sum is too large!");
		}
		
	}
}