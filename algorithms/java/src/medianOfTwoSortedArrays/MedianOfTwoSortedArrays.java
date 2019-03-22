/**============================================================
 * question: https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * =============================================================
 * 2019-03-21       adaivskenan@foxmail.com
 * ============================================================*/
package medianOfTwoSortedArrays;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 You may assume nums1 and nums2 cannot be both empty.

 Example 1:

 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 */

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,3},new int[]{2}));
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }

    /**
     * quick sort O((n+m)log(n+m)), still need reduce the cpu time
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[(nums1.length + nums2.length)];
        System.arraycopy(nums1,0, nums, 0,nums1.length);
        System.arraycopy(nums2,0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);
        int mi = nums.length / 2;
        return (nums.length & 1) ==1 ? nums[mi] : (nums[mi - 1] + nums[mi]) / 2.0;
    }
}
