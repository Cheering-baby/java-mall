package com.example.javamall.test;

public class Solution {

    public static void main(String[] args) {
        System.out.println(myPow(2.0000, 10));
    }

    public static int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {
            int c = min + (max - min) / 2;
            System.out.println(c);
            if(nums[c] > target) {
               max = c - 1;
            } else if(nums[c] < target) {
               min = c + 1;
            } else if(nums[c] == target) {
               return c;
            }
        }

        return -1;
    }

    public static int sqrt(int x) {
        int min = 0;
        int max = x;
        int ans = -1;
        while(min <= max) {
            int c = min + (max -min) / 2;
            if(c * c <= x) {
                ans = c;
                min = c + 1;
            } else {
                max = c - 1;
            }
        }

        return ans;
    }

    public static double myPow(double x, int n) {
        long N = n;
        return n > 0 ? quickMul(x, N) : 1 / quickMul(x, -N);
    }

    public static double quickMul(double x, long N) {
        if(N == 0) {
            return 1.0;
        }

        double y = quickMul(x,  N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
