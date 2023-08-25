package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		
		int[] numbers = {1,2,3,4};
		int listLength = numbers.length;
		int[] prefixProductList = new int[listLength]; //[1,2,6,4]
		int[] postfixProductList = new int[listLength];//[24,24,12,4]
		int[] productList = new int[listLength];
		
		prefixProductList[0] = numbers[0];
		postfixProductList[listLength - 1] = numbers[listLength - 1];
		int product = 1;
		
		for(int i=1; i<listLength; i++) {
			prefixProductList[i] = numbers[i] * prefixProductList[i-1];
		}
		
		for(int i=listLength-2; i>=0; i--) {
			postfixProductList[i] = numbers[i] * postfixProductList[i+1];
		}
		
		productList[0] = postfixProductList[1];
		productList[listLength-1] = prefixProductList[listLength-2];
		for(int i=1; i<listLength-1; i++) {
			productList[i] = prefixProductList[i-1] * postfixProductList[i+1];
		}
		
		for(int element : productList) {
			System.out.println(element);
		}
	}

}

//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
//Example 2:
//
//Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]