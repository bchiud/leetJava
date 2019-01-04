package com.bradychiu;

import java.util.*;

public class LongestSubstring {
    static void printResults() {
        String a = "abcabcbb"; // "abc" -> 3
        String b = "bbbbb"; // "b" -> 1
        String c = "pwwkew"; // "wke" -> 3

        // System.out.println(new StringBuilder()
        //         .append("Longest SubString Original: ")
        //         .append(String.valueOf(lengthOfLongestSubstringOriginal(a)))
        //         .toString());

        // System.out.println(new StringBuilder()
        //         .append("Longest SubString Original Two: ")
        //         .append(String.valueOf(lengthOfLongestSubstringOriginalTwo(a)))
        //         .toString());

        System.out.println(new StringBuilder()
                .append("Longest SubString HashSet: ")
                .append(String.valueOf(lengthOfLongestSubstringHashSet(c)))
                .toString());

        System.out.println(new StringBuilder()
                .append("Longest SubString HashMap: ")
                .append(String.valueOf(lengthOfLongestSubstringHashMap(c)))
                .toString());

        // System.out.println(new StringBuilder()
        //         .append("Longest SubString Optimal: ")
        //         .append(String.valueOf(lengthOfLongestSubstringOptimal(c)))
        //         .toString());
    }


    static int lengthOfLongestSubstringOriginal(String s) {
        // brute force
        // this answer passes 982 of 983 test cases, but fails due to time limit exceeded
        String currentLongest = "";
        String currentTesting = "";

        for(int currentIndex = 0; currentIndex < s.length(); currentIndex++) {
            for(int stringLength = s.length() - currentIndex; stringLength > 0; stringLength--) {
                currentTesting = s.substring(currentIndex, currentIndex + stringLength);
                if(uniqueChars(currentTesting) && currentTesting.length() > currentLongest.length()) {
                    currentLongest = currentTesting;
                }
            }
        }

        return currentLongest.length();
    }

    static int lengthOfLongestSubstringOriginalTwo(String s) {
        // brute force
        // this answer passes 982 of 983 test cases, but fails due to time limit exceeded
        if (s.isEmpty()) return 0;
        int sLen = s.length();
        if (uniqueChars(s)) return sLen;

        int currentLongestLen = 1;
        String currentTesting = "";

        for (int currentIndex = 0; currentIndex < s.length(); currentIndex++) {
            for (int stringLength = s.length() - currentIndex; stringLength > 0; stringLength--) {
                if (stringLength > currentLongestLen) {
                    currentTesting = s.substring(currentIndex, currentIndex + stringLength);
                    if (uniqueChars(currentTesting)) currentLongestLen = stringLength;
                }
            }
        }

        return currentLongestLen;
    }


    static boolean uniqueChars(String s) {
        // this can be done more optimally by using a hashset
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(s.indexOf(String.valueOf(c), i+1) != -1) return false;
        }

        return true;
    }

    static int lengthOfLongestSubstringHashSet(String s) {
        // sliding window
        // iterate through string both position and length wise to produce substring
        // confirm substring is unique by storing in hashset
        // store length of longest substring (hashset size)

        if (s.isEmpty()) return 0;

        Set<Character> currentChars = new HashSet<>();
        int startIndex = 0, endIndex = 0, maxLen = 0;

        while(endIndex < s.length()) {
            if(!currentChars.contains(s.charAt(endIndex))) {
                currentChars.add(s.charAt(endIndex++));
                maxLen = Math.max(maxLen, currentChars.size());
            } else {
                currentChars.remove(s.charAt(startIndex++));
            }
        }

        return maxLen;
    }

    static int lengthOfLongestSubstringHashMap(String s) {
        // sliding window optimized
        // iterate through string by having a pointer at beginning (i) and end (j)
        // instead of iterating i by 1, jump i to next occurance of char when duplicate char is run into at j

        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    static int lengthOfLongestSubstringOptimal(String s) {
        // ???
        char[] characters = s.toCharArray();
        if(characters.length < 2) {
            return characters.length;
        }
        int max = 0;
        int split_at = 0;
        int cur_len = 1;
        for(int i=1; i<characters.length; i++) {
            System.out.println("i: " + characters[i]);
            int j=split_at;
            for(; j<i; j++) {
                System.out.println("j: " + characters[j]);

                if(characters[i] == characters[j]) {
                    break;
                }
            }
            //has duplit
            if(j < i) {
                split_at = j +1;
                cur_len = i - j;
            }else {
                cur_len++;
            }

            if ( cur_len > max) max = cur_len;

        }

        return max;
    }
}
