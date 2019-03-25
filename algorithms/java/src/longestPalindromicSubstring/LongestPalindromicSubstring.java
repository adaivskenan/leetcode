/**============================================================
 * question: https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * =============================================================
 * 2019-03-21       adaivskenan@foxmail.com
 * ============================================================*/

package longestPalindromicSubstring;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer. Example 2:
 * 
 * Input: "cbbd" Output: "bb"
 */
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("\"a\""));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("\"aa\""));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("\"babad\""));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("\"cbbd\""));
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("\"dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd\""));
	}

	/**
	 * this method use too much memory and cpu time 
	 * @param s
	 * @return String
	 */
	public String longestPalindrome1(String s) {
		if(s.length()==1) {
			return s;
		}
		String max = "";
		for(int left=0; left<s.length(); left++) {
			if((left + max.length())>s.length()) {
				return max;
			}
			for(int right=left; right<=s.length(); right++) {
				String tmp = s.substring(left, right);
				if(tmp.length()>max.length() && isPalindrome(tmp)) {
					max = tmp;
				}
			}
		}
		return max;
	}
	
	private boolean isPalindrome(String s) {
		int mid = s.length()/2;
		for(int i=0; i<mid; i++) {
			if(s.charAt(i)!=s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	
	
	/**
	 * time O(n^3)
	 * space O(1)
	 *  ======================Brute Force===================== 
	 */
	public String longestPalindrome(String s) {
		String max = "";
		for(int left=0; left<s.length(); left++) {
			if((left + max.length())>s.length()) {
				return max;
			}
			out:for(int right=s.length(); right>left; right--) {
				String tmp = s.substring(left, right);
				if(tmp.length()>max.length() && isPalindrome(tmp)) {
					max = tmp;
					break out;
				}
			}
		}
		return max;
	}
	
}
