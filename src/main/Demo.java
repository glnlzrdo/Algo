package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Demo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("ee");
		list.add("ii");

		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			if (iter.equals("ee")) {
				iter.remove();
			}
			String string = (String) iter.next();			
			System.out.println(string);
		}
		Set<String> set = new TreeSet<>();
		set.add("Fox");
		set.add("Gorilla");
		set.add("Snake");
		set.add("Bear");

		set.add("Fox");
		set.add("Gorillaz");
		System.out.println(set);
	}
}
