package com.chainsys.practicingtask;

import java.util.Arrays;

public class ProductMaximizer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {3, 7, 8, -1, 0, 2, 9, 4, -5};
        int[] result = findMaxProduct(numbers);
        System.out.println("Two numbers with the largest product: " + result[0] + " and " + result[1]);
        System.out.println("Product: " + result[2]);
    }
	public static int[] findMaxProduct(int[] nums) {
        if (nums == null || nums.length < 2) {
           System.out.print("Array Can't be Null!");
        }
        Arrays.sort(nums);
        int n = nums.length;
        int[] result = new int[3];
        int product1 = nums[n - 1] * nums[n - 2];
        int product2 = nums[0] * nums[1];
        if (product1 > product2) {
            result[0] = nums[n - 1];
            result[1] = nums[n - 2];
            result[2] = product1;
        } else {
            result[0] = nums[0];
            result[1] = nums[1];
            result[2] = product2;
        }

        return result;
    }
}
