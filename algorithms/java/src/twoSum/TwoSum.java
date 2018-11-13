/**============================================================
 * question: https://leetcode.com/problems/two-sum/description/
 * 
 * =============================================================
 * 2018-11-13       adaivskenan        
 * ============================================================*/

package twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Two Sum
 * </p>
 *
 * <p>
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * </p>
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 * @author adaivskenan
 */

public class TwoSum {

	/**
	 * 
	 * @param args void
	 */
	public static void main(String[] args) {

	}

	/*
	 * ======================Brute Force=====================
	 */

	/*
	 * Loop through each element xx and find if there is another value that equals
	 * to target - xtarget−x. Complexity Analysis
	 * 
	 * Time complexity : O(n^2)O(n 2 ). For each element, we try to find its
	 * complement by looping through the rest of array which takes O(n)O(n) time.
	 * Therefore, the time complexity is O(n^2)O(n 2 ).
	 * 
	 * Space complexity : O(1)O(1).
	 */
//	public int[] twoSum(int[] nums, int target) {
//		for (int i = 0; i < nums.length; i++) {
//			for (int j = i + 1; j < nums.length; j++) {
//				if ((nums[i] + nums[j]) == target) {
//					return new int[] { i, j };
//				}
//			}
//		}
//		throw new IllegalArgumentException("No two sum solution");
//	}

	/*
	 * ======================Approach 2: Two-pass Hash Table=====================
	 */

	/*
	 * A simple implementation uses two iterations. In the first iteration, we add
	 * each element's value and its index to the table. Then, in the second
	 * iteration we check if each element's complement (target -
	 * nums[i]target−nums[i]) exists in the table. Beware that the complement must
	 * not be nums[i]nums[i] itself!
	 * 
	 * Complexity Analysis:
	 * 
	 * Time complexity : O(n). We traverse the list containing n elements exactly
	 * twice. Since the hash table reduces the look up time to O(1), the time
	 * complexity is O(n).
	 * 
	 * Space complexity : O(n). The extra space required depends on the number of
	 * items stored in the hash table, which stores exactly n elements.
	 */
//	public int[] twoSum(int[] nums, int target) {
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int i = 0; i < nums.length; i++) {
//			map.put(nums[i], i);
//		}
//		for (int i = 0; i < nums.length; i++) {
//			int complement = target - nums[i];
//			if (map.containsKey(complement) && map.get(complement) != i) {
//				return new int[] { i, map.get(complement) };
//			}
//		}
//		throw new IllegalArgumentException("No two sum solution");
//	}

	/*
	 * ======================Approach 3: One-pass HashTable=====================
	 */

	/*
	 * While we iterate and inserting elements into the table, we also look back to
	 * check if current element's complement already exists in the table. If it
	 * exists, we have found a solution and return immediately.
	 * 
	 * Complexity Analysis:
	 * 
	 * Time complexity : O(n). We traverse the list containing n elements only once.
	 * Each look up in the table costs only O(1) time.
	 * 
	 * Space complexity : O(n). The extra space required depends on the number of
	 * items stored in the hash table, which stores at most n elements.
	 */

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int t = target - nums[i];
			if (map.containsKey(t)) {
				return new int[] { map.get(t), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

}
