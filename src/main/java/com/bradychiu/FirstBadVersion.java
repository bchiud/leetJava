package com.bradychiu;

public class FirstBadVersion {
    /**
     * time: log n
     * space: 1
     */
    public int firstBadVersion(int n) {
        int i = 0;
        int j = n;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (isBadVersion(mid)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return j;
    }

    private boolean isBadVersion(int version) {
        return version >= 10;
    }
}
