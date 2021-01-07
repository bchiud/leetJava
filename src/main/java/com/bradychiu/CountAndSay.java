package com.bradychiu;

public class CountAndSay {
    /**
     * time: 2^n
     * space: 1
     */
    public static String countAndSaySlidingWindowPointers(int n) {
        if (n == 1)
            return "1";

        String s = countAndSaySlidingWindowPointers(n - 1);
        String ans = "";

        int hold = 0;
        int start = 0;
        while (start < s.length()) {
            char startInt = s.charAt(start);
            int end = start;
            while (end < s.length() && s.charAt(end) == startInt)
                end++;
            ans += String.valueOf(end - start) + startInt;
            start = end;
        }

        return ans;
    }

    public static String countAndSaySlidingWindowStringBuilder(int n) {
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;

        for (int i = 1; i < n; i++) {
            prev = curr;
            prev.append(" ");
            curr = new StringBuilder();

            int count = 1;

            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) == prev.charAt(j - 1)) {
                    count++;
                } else {
                    curr.append(count).append(prev.charAt(j - 1));

                    count = 1;
                }
            }
        }

        return curr.toString();
    }

    public static String countAndSayRecursive(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = say(s);
        }
        return s;
    }

    public static String say(String s) {
        s += " ";
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        return sb.toString();
    }

}
