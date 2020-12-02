package com.bradychiu;

public class UniquePaths {

    /**
     * time: 2 ^ (m * n)
     * space: m * n
     */
    public static int uniquePathsRecursive(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        return uniquePathsRecursive(m - 1, n) + uniquePathsRecursive(m, n - 1);
    }

    /**
     * time: m * n -> m + n + m * n
     * space: m * n
     */
    public static int uniquePathsDP(int m, int n) {
        int[][] pathsToCell = new int[m][n];

        for (int mIndex = 0; mIndex < m; ++mIndex)
            pathsToCell[mIndex][0] = 1;
        for (int nIndex = 0; nIndex < n; ++nIndex)
            pathsToCell[0][nIndex] = 1;

        for (int mIndex = 1; mIndex < m; ++mIndex) {
            for (int nIndex = 1; nIndex < n; ++nIndex) {
                pathsToCell[mIndex][nIndex] = pathsToCell[mIndex - 1][nIndex] + pathsToCell[mIndex][nIndex - 1];
            }
        }

        return pathsToCell[m - 1][n-1];
    }
}
