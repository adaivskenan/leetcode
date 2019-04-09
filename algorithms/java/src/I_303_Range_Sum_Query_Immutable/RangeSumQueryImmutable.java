package I_303_Range_Sum_Query_Immutable;


/**
 * @author adaivskenan
 * @date 2019/04/09
 */
public class RangeSumQueryImmutable {
    public static void main(String[] args) {

        int nums[] = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        // 1
        System.out.println(obj.sumRange(0, 2));
        // -1
        System.out.println(obj.sumRange(2, 5));
        // -3
        System.out.println(obj.sumRange(0, 5));
    }


}

/**
 * 21.91%
 * */
//class NumArray {
//
//    private int[] nums;
//
//    public NumArray(int[] nums) {
//        this.nums = nums;
//    }
//
//    public int sumRange(int i, int j) {
//        int r = 0;
//        for(;i<=j;i++){
//            r += nums[i];
//        }
//        return r;
//    }
//}


/**
 * 98.56%
 * */
class NumArray {

    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        if (nums.length == 0) {
            return;
        }
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] += sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i - 1];
        }
    }
}