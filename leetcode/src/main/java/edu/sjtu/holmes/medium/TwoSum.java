package edu.sjtu.holmes.medium;

/**
 * Created by holmes on 7/20/15.
 */
import java.util.HashMap;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p/>
 * The function medium should return indices of the two numbers such that they add up to the target, where index1 must
 * be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p/>
 * You may assume that each input would have exactly one solution.
 * <p/>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && i != map.get(temp)) {
                return new int[]{i + 1, map.get(temp) + 1};
            }
        }

        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int start = target - nums[0];
        map.put(start, 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i != map.get(nums[i])) {
                return new int[]{map.get(nums[i]) + 1, i + 1};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum s = new TwoSum();
        int[] ints = s.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println("num is" + ints[0] + "," + ints[1]);
    }
}
