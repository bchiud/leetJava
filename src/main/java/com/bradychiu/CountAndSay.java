package com.bradychiu;

class CountAndSay {
    static void printResults() {
        System.out.println("Count And Say");

        for(int i = 1; i < 15; i++) {
            System.out.println(countAndSayOriginal(i));
        }
    }

    static String countAndSayOriginal(int n) {
        StringBuilder result = new StringBuilder().append(1);

        for(int iter = 1; iter < n; iter++) {
            StringBuilder newResult = new StringBuilder();
            int len = result.length();
            for(int pos = 0; pos < len; pos++) {
                int occurances = 1;
                char curChar = result.charAt(pos);
                while(pos+1 < len && result.charAt(pos+1) == curChar) {
                    occurances++;
                    pos++;
                }
                newResult.append(occurances).append(curChar);
            }

            result = newResult;
        }

        return result.toString();
    }
}
