/**============================================================
 * question: https://leetcode.com/problems/add-two-numbers/description
 * 
 * =============================================================
 * 2018-11-13       adaivskenan@foxmail.com        
 * ============================================================*/

package addTwoNumbers;

/**
 * <p>
 * Add Two Numbers
 * </p>
 *
 * <p>
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * </p>
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 *
 * @author adaivskenan
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
//		ListNode l1 = new ListNode(2);
//		ListNode l2 = new ListNode(4);
//		ListNode l3 = new ListNode(3);
//		l1.next = l2;
//		l2.next = l3;
//		
//		ListNode r1 = new ListNode(5);
//		ListNode r2 = new ListNode(6);
//		ListNode r3 = new ListNode(4);
//		r1.next = r2;
//		r2.next = r3;
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(8);
		l1.next = l2;
		
		ListNode r1 = new ListNode(0);
		
		ListNode r = new AddTwoNumbers().addTwoNumbers(l1,r1);
		while(r.next != null) {
			System.out.println(r.val);
			r = r.next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int x = 0, y = 0, carry = 0, sum = 0;
		ListNode tmpNode = null;
		ListNode cNode = null;
		while (l1 != null || l2 != null) {
			x = l1 == null ? 0 : l1.val;
			y = l2 == null ? 0 : l2.val;
			sum = carry + x + y;
			l1 = (l1 != null ? l1.next : null);
			l2 = (l2 != null ? l2.next : null);
			carry = (sum < 10 ? 0 : sum / 10);
			ListNode node = new ListNode(sum % 10);
			if (tmpNode == null) {
				tmpNode = node;
				cNode = node;
			} else {
				tmpNode.next = node;
				tmpNode = tmpNode.next;
			}
		}
		if (carry > 0) {
			ListNode node = new ListNode(carry % 10);
			tmpNode.next = node;
			tmpNode = tmpNode.next;
		}
		return cNode;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
