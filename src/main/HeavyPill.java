package main;

import java.text.DecimalFormat;

public class HeavyPill {

	public static void main(String[] args) {
		double[] bottles = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
							1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
							 1.0, 1.0, 1.0, 1.0, 1.0,1.0, 1.0, 1.0, 1.1, 1.0,};
		int heavyBottle = scale(bottles);
		System.out.println(heavyBottle);
	}

	private static int scale(double[] bottles){
		int pills = (bottles.length * (bottles.length + 1) / 2);
		double weight = 0;
		for (int i = 0; i < bottles.length; i++) {
			weight += Double.parseDouble(df.format(bottles[i] * (i + 1)));
		}
		return (int) Math.round((weight - pills) / .1);
	}

	private static DecimalFormat df = new DecimalFormat(".##");
}
