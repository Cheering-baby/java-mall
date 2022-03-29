package com.example.javamall.test;

import com.alibaba.druid.sql.visitor.functions.Char;
import io.swagger.models.auth.In;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List<Integer> a= findAnagrams("ababa", "ab") ;
      for(int b: a) {
          System.out.println(b);
      }
    }

    public static List<Integer> findAnagrams(String a, String p) {
        int len = p.length();
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i < a.length() - len;i++) {
            String b = a.substring(i, i + len);
            if(afterSort(b).equals(afterSort(p))) {
                arr.add(i);
            }
        }
        return arr;
    }

    public static String afterSort(String s) {
        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        return String.valueOf(ss);
    }

    public static int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {
            int c = min + (max - min) / 2;
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

    public static char findTheDifference(String s, String t) {
        int a = 0;
        int b = 0;
        for (int i = 0;i < s.length(); i++) {
            char cn = s.charAt(i);
            a += cn;
        }
        for(int i = 0; i < t.length(); i++) {
            char cn = t.charAt(i);
            b += cn;
        }

        return (char)(b-a);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] intersection = new int[Math.min(nums1.length, nums2.length)];
        int index = 0, index1 = 0, index2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        while(index1 < length1 && index2 < length2) {
            if(nums1[index1] > nums2[index2]) {
                index2++;
            } else if(nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                intersection[index] = nums1[index1];
                index++;
                index1++;
                index2++;
            }
        }

        return Arrays.copyOfRange(intersection, 0 ,index);
    }

}
