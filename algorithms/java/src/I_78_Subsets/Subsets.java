//https://leetcode-cn.com/problems/subsets/
package I_78_Subsets;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * Input: nums = [1,2,3] Output: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2],
 * [] ]
 */
public class Subsets {
	public static void main(String[] args) {
		System.out.println(subsets(new int[] { 1, 2, 3 }).toString());
	}

	/**
	 * @param nums
	 * @return List<List<Integer>>
	 */
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> lst = new LinkedList<>();
		/*
		 * Get a Enumerations through bitwise operation there are 2^n p&c(Permutation
		 * and combination). if the length of nums is 3. then there are 2^3=8 p&c we can
		 * use the binary code 000-111(0-7,int decimal system) [0,0,0],[0,0,1]...[1,1,1]
		 * each bit equals 1 , it means the nums[j] need to put in the list
		 */
		for (int i = 0; i < 1 << nums.length; i++) {
			List<Integer> lstItem = new LinkedList<>();
			for (int j = 0; j < nums.length; j++) {
				if ((i & 1 << j) >> j == 1) {
					lstItem.add(nums[j]);
				}
			}
			lst.add(lstItem);

		}
		return lst;
	}
}
