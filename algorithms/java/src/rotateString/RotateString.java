/**============================================================
 * question: https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * =============================================================
 * 2019-04-01       adaivskenan@foxmail.com
 * ============================================================*/
package rotateString;

/**
 * We are given two strings, A and B.
 * 
 * A shift on A consists of taking string A and moving the leftmost character to
 * the rightmost position. For example, if A = 'abcde', then it will be 'bcdea'
 * after one shift on A. Return True if and only if A can become B after some
 * number of shifts on A.
 * 
 * Example 1: Input: A = 'abcde', B = 'cdeab' Output: true
 * 
 * Example 2: Input: A = 'abcde', B = 'abced' Output: false Note:
 * 
 * A and B will have length at most 100.
 */
public class RotateString {

	public static void main(String[] args) {
		System.out.println(rotateString("abcde", "cdeab"));
		System.out.println(rotateString("abcde", "abced"));
		System.out.println(rotateString("aa", "a"));
		System.out.println(rotateString("", ""));
	}

	public static boolean rotateString(String A, String B) {
		char[] charA = A.toCharArray();
		char[] charB = B.toCharArray();
		if(charA.length != charB.length) return false;
		boolean flag = true;
		for (int i = 0; i < charA.length; i++) {
			flag = true;
			out: for (int j = 0; j < charA.length; j++) {
				if (charA[j] != charB[j]) {
					flag = false;
					break out;
				}
			}
			if(flag) {
				return true;
			}else {
			char t =charA[0];
			System.arraycopy(charA, 1, charA, 0, charA.length-1);
			charA[charA.length-1] = t;
			}
		}
		return flag;
	}

}
