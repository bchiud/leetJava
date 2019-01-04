package com.bradychiu;

class PalindromeNumber {
    static void printResults() {
        System.out.println(new StringBuilder()
                .append("Palindrome Number Original: ")
                .append(PalindromeNumber.isPalindromeOriginal(2147483647))
                .toString());
        System.out.println(new StringBuilder()
                .append("Palindrone Number Optimal: ")
                .append(PalindromeNumber.isPalindromeOptimal(2147483647))
                .toString());
    }

    static boolean isPalindromeOriginal(int x) {
        if(x < 0) return false;

        long revX = 0;
        long tempX = x;

        while(tempX != 0) {
            revX = revX*10 + tempX%10;
            tempX = tempX/10;
        }

        return revX == x;
    }

    static boolean isPalindromeOptimal(int x) {
        if(x < 0 || (x != 0 || x%10 == 0)) return false;

        int rev = 0;

        while(x > rev) {
            rev = rev*10 + x%10;
            x = x/10;
        }

        return x == rev || x == rev / 10;
    }
}
