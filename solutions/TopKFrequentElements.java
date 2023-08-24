package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TopKFrequentElements {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1,1,2,2,2,3,3,3,3);
		int k = 2;
		List<Integer> resultList = new ArrayList<>();
		
		//Create a hashmap with elements as it key and their repetition as values
		Map<Integer, Integer> repetitionMap = new HashMap<>();
		
		for (Integer element : nums) {
			if(!repetitionMap.containsKey(element)) {
				repetitionMap.put(element, 1);
			} else {
				Integer value = repetitionMap.get(element);
				repetitionMap.put(element, value+1);
			}
		}
		
		//Create a list that contains nums.size() number of empty arrays
		List<ArrayList<Integer>> sortedRepeatingElements = new ArrayList<>();
		for(int i = 0; i <= nums.size(); i++) {
			sortedRepeatingElements.add(new ArrayList<Integer> ());
		}
		
		//Fill the list with the keys. Index of the keys will be their associated values(their repetition) ([[], [3], [], [1, 2]])
		for(Integer key : repetitionMap.keySet()) {
			int index = repetitionMap.get(key);
			sortedRepeatingElements.get(index).add(key);
		}

		//Iterate through the list from last index and get the elements
		//iterate through the elements and add them to our result list while checking for the size(k)
		for(int i=sortedRepeatingElements.size() - 1; i>0; i--) {
			for(Integer element : sortedRepeatingElements.get(i)) {
				resultList.add(element);
				if(resultList.size() == k) {
					System.out.println(resultList);
				}
			}
		}		
	}

}
//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
/*
 * Example 1:
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2]
 */