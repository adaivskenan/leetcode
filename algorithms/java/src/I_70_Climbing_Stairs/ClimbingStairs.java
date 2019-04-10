package I_70_Climbing_Stairs;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Example 1:
 * 
 * Input: 2 Output: 2 Explanation: There are two ways to climb to the top. 1. 1
 * step + 1 step 2. 2 steps Example 2:
 * 
 * Input: 3 Output: 3 Explanation: There are three ways to climb to the top. 1.
 * 1 step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step
 * 
 * @author adaivskenan
 * @version 2019/04/10
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(new Solution().climbStairs(2));
		System.out.println(new Solution().climbStairs(3));
		System.out.println(new Solution().climbStairs(4));
	}

}

class Solution {
	public int climbStairs(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		int s[] = new int[n+1];
		s[1] = 1;
		s[2] = 2;
		for (int i = 3; i <= n; i++) {
			s[i] = s[i-1] + s[i-2];
		}
		return s[n];
	}
}