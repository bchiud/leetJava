package com.bradychiu;

class ReverseInteger {
    public static void printResults() {
        System.out.println(new StringBuilder()
                .append("Reverse Integer Original: ")
                .append(ReverseInteger.reverseIntegerOriginal(-2147483648))
                .toString());
        System.out.println(new StringBuilder()
                .append("Reverse Integer Optimal : ")
                .append(ReverseInteger.reverseIntegerOptimal(-2147483648))
                .toString());
    }

    static int reverseIntegerOriginal(int x) {
        Boolean negative = false;
        long oldLong = (long) x;
        if(oldLong < 0) {
            negative = true;
            oldLong = oldLong * -1;
        }

        String oldS = String.valueOf(oldLong);
        StringBuilder newSB = new StringBuilder();

        int l = oldS.length();
        for(int i = l-1; i >= 0; i--) {
            newSB.append(String.valueOf(oldS.charAt(i)));
        }

        if(negative) newSB.insert(0, "-");

        long newLong = Long.valueOf(newSB.toString());
        if(newLong > Integer.MAX_VALUE || newLong < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) newLong;
        }
    }

    static int reverseIntegerOptimal(int x) {
        long result = 0;

        while(x != 0) {
            result = result*10 + x%10;
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
            x = x/10;
        }

        return (int) result;
    }
}
