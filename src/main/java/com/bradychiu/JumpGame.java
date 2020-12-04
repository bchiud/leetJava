package com.bradychiu;



public class JumpGame {

    enum Memo {
        GOOD, BAD, UNKNOWN
    }

    /**
     * time: 2^n ??
     * space: n ??
     */
    public static boolean canJumpBacktracking(int[] nums) {
        return backtrackingFromPos(nums, 0);
    }

    private static boolean backtrackingFromPos(int[] nums, int pos) {
        if (pos == nums.length - 1)
            return true;

        int furthestJump = Math.min(pos + nums[pos], nums.length - 1);
        for (int nextPos = furthestJump; nextPos > pos; nextPos--) {
            if(backtrackingFromPos(nums, nextPos))
                return true;
        }

        return false;
    }

    /**
     * time: n^2
     * space: 2n -> n recursions with constant space + n memoizations
     */

    public static boolean canJumpDPBotUp(int[] nums) {
        Memo[] memo = new Memo[nums.length];
        for (int i = 0; i < memo.length; i++)
            memo[i] = Memo.UNKNOWN;
        memo[memo.length - 1] = Memo.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Memo.GOOD) {
                    memo[i] = Memo.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Memo.GOOD;
    }


    /**
     * time: n
     * space: 1
     */

    public static boolean canJumpDPGreedy(int[] nums) {
        int lastPos = nums[nums.length - 1];
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= lastPos)
                lastPos = i;
        }

        return lastPos == 0;
    }
}
