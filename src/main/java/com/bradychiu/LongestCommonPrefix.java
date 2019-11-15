package com.bradychiu;

public class LongestCommonPrefix {
    public static void printReuslts() {
        System.out.println("Longest Common Prefix");

        System.out.println(new StringBuilder()
                .append("Original: ")
                .append(LongestCommonPrefix.longestCommonPrefixOriginal(new String[] {
                        "asdf", "asdfasdf", "asdfasdfasdf", "asasdfasdfasdf"
                })));
        System.out.println(new StringBuilder()
                .append("Optimal: ")
                .append(LongestCommonPrefix.longestCommonPrefixOptimal(new String[] {
                        "asdf", "asdfasdf", "asdfasdfasdf", "asasdfasdfasdf"
                })));
    }

    public static String longestCommonPrefixOriginal(String[] strs) {
        if(strs.length == 0) return "";

        StringBuilder currentPrefix = new StringBuilder();

        int numWords = strs.length;

        String shortestWord = strs[0];
        for(int i = 1; i < numWords; i++) {
            if(shortestWord.length() > strs[i].length()) shortestWord = strs[i];
        }

        for(int i = 0; i < shortestWord.length(); i++) {
            currentPrefix.append(shortestWord.charAt(i));

            for(int j = 0; j < strs.length; j++) {
                if(!strs[j].substring(0, i + 1).equals(currentPrefix.toString())) {
                    currentPrefix.setLength(currentPrefix.length() - 1);
                    return currentPrefix.toString();
                }
            }
        }

        return currentPrefix.toString();
    }

    public static String longestCommonPrefixOptimal(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
