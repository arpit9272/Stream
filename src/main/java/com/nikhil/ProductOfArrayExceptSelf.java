package com.nikhil;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Initialize answer array where answer[i] will store the product of all elements to the left of nums[i]
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Now, traverse from the right and multiply each element in the answer array
        // by the product of all elements to the right of nums[i]
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;  // Multiply with the right product
            rightProduct *= nums[i];    // Update right product
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] result = productExceptSelf(nums);

        // Print the result array
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
