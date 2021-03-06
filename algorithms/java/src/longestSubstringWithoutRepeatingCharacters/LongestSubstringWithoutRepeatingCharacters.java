/**============================================================
 * question: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 
 * =============================================================
 * 2018-11-13       adaivskenan@foxmail.com        
 * ============================================================*/

package longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Example 1:
 * 
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length
 * of 3. Example 2:
 * 
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of
 * 1. Example 3:
 * 
 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length
 * of 3. Note that the answer must be a substring, "pwke" is a subsequence and
 * not a substring.
 * 
 * @author adaivskenan
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("aab"));
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bwf"));
		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abca"));
	}
	
	/*
	 * ======================Approach 1: use two loop=====================
	 * this mehtod use too much memory and cpu time
	 */
	public int lengthOfLongestSubstring1(String s) {
		char[] result = s.toCharArray();
		int subStrLen = 0;
		Set<Character> strSet = new HashSet<>(result.length);
		for(int i=0; i<result.length; i++) {
			if(subStrLen+i>result.length) {
				break;
			}
			strSet.clear();
			strSet.add(result[i]);
			out:for(int j=i+1; j<result.length; j++) {
				if(strSet.contains(result[j])) {
					break out;
				}
				strSet.add(result[j]);
			}
			subStrLen = strSet.size() < subStrLen ? subStrLen : strSet.size();
		}
		return subStrLen;
	}
	
	/*
	 * ======================Approach 2: use one loop=====================
	 * this mehtod is better
	 */
	public int lengthOfLongestSubstring2(String s) {
		int i = 0, j = 0, max = 0;
		Set<Character> set = new HashSet<>();
		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				max = Math.max(max, set.size());
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return max;
	}
	
	/*
	 * ======================Approach 3: use one loop and hashset=====================
	 */
	public int lengthOfLongestSubstring3(String s) {
		int max = 0;
		Set<Character> set = new HashSet<>(s.length());
		int i=0;
		for(int j=0; j<s.length();) {
			//if (max + i) is bigger than the length of the rest characters,
			// the rest can not be the max sub string
			if(max+i>s.length()) { 
				break;
			}
			if(set.contains(s.charAt(j))) {
				set.remove(s.charAt(i++));
			}else {
				set.add(s.charAt(j++)); //j++ when actually put the element 
				max = Math.max(max, set.size());
			}
		}
		return max;
	}
	
	/*
	 * ======================Approach 3: do not use set=====================
	 * the fast
	 */
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		int left = 0;
		int right = 0;
		for (; right < s.length(); right++) {
			if(max+left>=s.length()) {
				break;
			}
			char rc = s.charAt(right);
			for (int j = left; j < right; j++) {
				if (s.charAt(j) == rc) {
					max = Math.max(max, (right - left));
					left = j + 1;
					break;
				}
			}
		}
		return Math.max(max, (right - left));
	}
	
}
