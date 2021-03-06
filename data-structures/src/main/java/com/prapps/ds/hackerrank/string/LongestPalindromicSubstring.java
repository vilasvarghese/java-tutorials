package com.prapps.ds.hackerrank.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LongestPalindromicSubstring {
    public static class Student {
        int x;
    }
    public static void main(String[] args) throws InterruptedException {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        List<Student> list = new LinkedList<>();
        for (int i=0;i<1000000000;i++) {
            list.add(new Student());
            System.out.println(lps.longestPalindrome("aacdefcaa"));
            Thread.sleep(10);
        }
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        int start = 0, end = 0;
        for (int i=0;i<s.length();i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start+1) {
                start = i-((len-1)/2);
                end = i+(len/2);
                //System.out.println(i+" len "+len+" "+start+" "+end);
            }
        }

        return s.substring(start, end+1);
    }

    int expandFromMiddle(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
