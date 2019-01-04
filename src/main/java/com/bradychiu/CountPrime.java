package com.bradychiu;

class CountPrime {
    public static void printResults() {
        System.out.println(new StringBuilder()
            .append("Count Primes Original: ")
            .append(CountPrime.countPrimesOriginal(151515)));
        System.out.println(new StringBuilder()
                .append("Count Primes Better Math: ")
                .append(CountPrime.countPrimesBetterMath(151515)));
        System.out.println(new StringBuilder()
                .append("Count Primes Optimal: ")
                .append(CountPrime.countPrimesOptimal(151515)));
    }

    static int countPrimesOriginal(int n) {
        int primes = n - 2;  // remove 1 and n

        for(int num = 2; num < n; num++) {
            for(int div = 2; div < num / 2 + 1; div++) {
                // System.out.println(num + ", " + div);
                if(num % div == 0) {
                    primes--;
                    // System.out.println("not prime");
                    break;
                }
            }
        }

        return primes;
    }

    static int countPrimesBetterMath(int n) {
        if(n < 3) return 0; // n = 2 will only test 0 and 1, which returns 0 primes
        boolean[] notPrime = new boolean[n];

        notPrime[0] = true; // 0
        notPrime[1] = true; // 1

        for(int even = 4; even < n; even += 2) { // evens sans 2
            notPrime[even] = true;
        }

        for(int div = 3; div * div < n; div += 2) { // max at div * div so neither div goes down to a prior eval div
            // System.out.println("div: " + div);
            if(notPrime[div]) continue; // skip odd divisors already deemed not prime
            for(int divisibleOdd = div * 2 + div; divisibleOdd < n; divisibleOdd += div * 2){
                if(!notPrime[divisibleOdd]) notPrime[divisibleOdd] = true;
            }
            // System.out.println(Arrays.toString(notPrime));
        }

        int primes = 0;
        for(boolean num : notPrime) if(!num) primes++;
        return primes;
    }

    static int countPrimesOptimal(int n) {
        if (n < 3) return 0;

        boolean[] notPrime = new boolean[n];

        // remove all evens
        int primes = n / 2;

        // end at div * div because going further would result in one of the multipliers being < div, which we have already checked
        for (int div = 3; div * div < n; div += 2) {
            // System.out.println("div: " + div);
            if (notPrime[div]) continue;

            // start at div * div b/c all previous multiples have been checked
            for (int divisibleOdd = div * div; divisibleOdd < n; divisibleOdd += 2 * div) {

                if (!notPrime[divisibleOdd]) {
                    --primes;
                    notPrime[divisibleOdd] = true;
                }
            }
            // System.out.println(Arrays.toString(notPrime));
        }
        return primes;
    }
}
