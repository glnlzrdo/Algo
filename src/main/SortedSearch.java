package main;

import java.util.Map;
import java.util.TreeMap;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        if(lessThan <= 0)
            return 0;
    	Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
    		for (int i = 0; i < sortedArray.length; i++) {
				map.put(sortedArray[i], i);
			}
    	if (map.containsKey(lessThan)) {
    		return map.get(lessThan);
		} else{
			if ((lessThan - 1) > 0) {
				return countNumbers(sortedArray, lessThan - 1) + 1;
			}
		}
			return 0;

    	/*int remaining = sortedArray.length -1;
    	for (remaining = 0; remaining < sortedArray.length; remaining--) {
			if (sortedArray[remaining] > lessThan) {

			}
		}
    	for(; remaining >= 0; remaining++){
    	            if(sortedArray[remaining] > lessThan){
    	                remaining--;
    	            }else
    	                break;

    	        return remaining - 1;
    	    }*/
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 2, 3, 3, 4, 5, 5 }, 4));
    }
}
