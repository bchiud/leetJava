package com.bradychiu;

public class LongestPalindrome {
    public static void main(String[] args) {
        printResults();
    }

    static void printResults() {


        String a = "abcba",
                b = "abcdefedcba",
                c = "twtrabcbaqrtsvstre",
                d = "artsvstraqtwtrabcbae",
                e = "bb",
                f = "aabbaa";

        System.out.println("Longest Palindrome ");

        // System.out.println(new StringBuilder()
        //         .append("Original:")
        //         .append("\n").append(longestPalindromeOriginal(a))
        //         .append("\n").append(longestPalindromeOriginal(b))
        //         .append("\n").append(longestPalindromeOriginal(c))
        //         .append("\n").append(longestPalindromeOriginal(d))
        //         .append("\n").append(longestPalindromeOriginal(e))
        //         .append("\n").append(longestPalindromeOriginal(f))
        //         .toString());
        //
        // System.out.println(new StringBuilder()
        //         .append("Original Two:")
        //         .append("\n").append(longestPalindromeOriginalTwo(a))
        //         .append("\n").append(longestPalindromeOriginalTwo(b))
        //         .append("\n").append(longestPalindromeOriginalTwo(c))
        //         .append("\n").append(longestPalindromeOriginalTwo(d))
        //         .append("\n").append(longestPalindromeOriginalTwo(e))
        //         .append("\n").append(longestPalindromeOriginalTwo(f))
        //         .toString());

        // System.out.println(new StringBuilder()
                // .append("Longest Palindrome Original Three:")
                // .append("\n").append(longestPalindromeOriginalThree(a))
                // .append("\n").append(longestPalindromeOriginalThree(b))
                // .append("\n").append(longestPalindromeOriginalThree(c))
                // .append("\n").append(longestPalindromeOriginalThree(d))
                // .append("\n").append(longestPalindromeOriginalThree(e))
                // .append("\n").append(longestPalindromeOriginalThree(f))
                // .toString());

        System.out.println(new StringBuilder()
                .append("Dynamic Programming:")
                .append("\n").append(longestPalindromeDynamicProgramming(a))
                // .append("\n").append(longestPalindromeDynamicProgramming(b))
                // .append("\n").append(longestPalindromeDynamicProgramming(c))
                // .append("\n").append(longestPalindromeDynamicProgramming(d))
                // .append("\n").append(longestPalindromeDynamicProgramming(e))
                // .append("\n").append(longestPalindromeDynamicProgramming(f))
                .toString());
    }

    static String longestPalindromeOriginal(String s) {
        // exceeds time limit
        // brute force
        // for every char at i, increase wing j by 1 until not palindrome
        // never check substrings shorter than current longest palindrome

        int sLen = s.length();
        int longestPalindromeLen = 1;
        String longestPalindrome = String.valueOf(s.charAt(0));

        for(int index = 1; index < sLen; index++) {
            int wing = Math.max(longestPalindromeLen / 2, 1);

            while(wing <= index && wing <= sLen - index) {
                String leftSubS = s.substring(index - wing, index);
                String rightSubSOdd = "";
                if(index + 1 + wing <= sLen) rightSubSOdd = s.substring(index + 1, index + 1 + wing);
                String rightSubSEven = s.substring(index, index + wing);

                int subSLenEven = wing * 2;

                // confirm if palindrome
                boolean oddResult = leftSubS.equals(new StringBuilder(rightSubSOdd).reverse().toString());
                boolean evenResult = leftSubS.equals(new StringBuilder(rightSubSEven).reverse().toString());

                if(!oddResult && !evenResult) {
                    break;
                } else if(oddResult) {
                    if (longestPalindromeLen < subSLenEven + 1) {
                        longestPalindromeLen = subSLenEven + 1;
                        longestPalindrome = s.substring(index - wing, index + 1 + wing);
                    }
                } else if(evenResult) {
                    if(longestPalindromeLen < subSLenEven) {
                        longestPalindromeLen = subSLenEven;
                        longestPalindrome = s.substring(index - wing, index + wing);
                    }
                }

                wing++;
            }
        }

        return longestPalindrome;
    }

    static String longestPalindromeOriginalTwo(String s) {
        // for char at index i, find last occurance of char at index j
        // if length (j + 1 - i) > longestPalindromeLen, loop inwards on substring(i, j+1) to check if palindrome
        // if loop fails to find palindrome, proceed to previous occurance of char before j and repeat

        int longestPalindromeLen = 1, sLen = s.length();
        if(sLen > 1000) return new StringBuilder(s).toString();
        String longestPlaindromeString = String.valueOf(s.charAt(0));

        for(int i = 0, j = 0; i < sLen; i++) {
            j = s.lastIndexOf(s.charAt(i));

            int subSLen = j + 1 - i, subi = i + 1, subj = j - 1;
            while(j > i && subSLen > longestPalindromeLen) {
                while(subi < subj && s.charAt(subi) == s.charAt(subj)) {
                    subi++; subj--;
                }
                if(subi >= subj) {
                    longestPalindromeLen = subSLen;
                    longestPlaindromeString = s.substring(i, j + 1);
                }

                j = s.lastIndexOf(s.charAt(i), j - 1);
            }
        }

        return longestPlaindromeString;
    }

    static String longestPalindromeOriginalThree(String s) {
        // for char at index i, find last occurance of char at index j
        // divide string in half, reverse 2nd half, and compare
        // if not palindrome, proceed to previous occurance of char before j and repeat

        int longestPalindromeLen = 1, sLen = s.length();
        if(sLen > 1000) return new StringBuilder(s).toString();
        String longestPlaindromeString = String.valueOf(s.charAt(0));

        for(int i = 0; i < sLen; i++) {
            int j = s.lastIndexOf(s.charAt(i));

            int subSLen = j + 1 - i;
            while(i < j && subSLen > longestPalindromeLen) {
                String left = s.substring(i, i + subSLen / 2),
                        right = s.substring(j + 1 - subSLen / 2, j + 1);
                if(left.equals(new StringBuilder(right).reverse().toString())) {
                    longestPalindromeLen = subSLen;
                    longestPlaindromeString = s.substring(i, j + 1);
                } else {
                    j = s.lastIndexOf(s.charAt(i), j - 1);
                    subSLen = j + 1 - i;
                }
            }
        }

        return longestPlaindromeString;
    }



    static String longestPalindromeDynamicProgramming(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
