package com.bradychiu;

public class ExcelSheetColumnTitle {
    public static void printResults() {
        System.out.println(excelSheetColumnTitleOriginal(5));
        System.out.println(excelSheetColumnTitleOriginal(28));
        System.out.println(excelSheetColumnTitleOriginal(701));
    }

    static String excelSheetColumnTitleOriginal(int n) {
        String result = "";
        while(n > 0){
            result = (char)(--n % 26 + 'A') + result;
            n /= 26;
        }
        return result;
    }
}
