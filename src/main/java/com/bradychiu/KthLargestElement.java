package com.bradychiu;

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElement {

    /**
     * time: n + k*log(k) ==> n + n*log(n) worst case; put n items in, heap handles k items in log(k) time
     * space: k ==> n worst case; for heap
     */
    public static int findKthLargestMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> (a - b));

        for(int n : nums) {
            minHeap.offer(n);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        return minHeap.poll();
    }

    /**
     * time: n log(n)
     * space: n
     */
    public static int findKithLargestMergeSort(int[] nums, int k) {
        int[] aux = new int[nums.length];
        mergeSort(nums, aux, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private static void mergeSort(int[] nums, int[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, aux, lo, mid);
        mergeSort(nums, aux, mid + 1, hi);
        merge(nums, aux, lo, mid, hi);
    }

    private static void merge(int[] nums, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                nums[k] = aux[j++];
            else if (j > hi)
                nums[k] = aux[i++];
            else if (aux[j] < aux[i]) {
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i++];
            }
        }
    }

    /**
     * time: typically n log(n) but n^2 in worst
     * space: 1
     */
    public static int findKthLargestQuickSort(int[] nums, int k) {
        shuffle(nums);

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int partitionIndex = partition(nums, lo, hi);
            if (partitionIndex < k) {
                lo = partitionIndex + 1;
            } else if (partitionIndex > k) {
                hi = partitionIndex - 1;
            } else {
                break;
            }
        }

        return nums[k];
    }

    private static int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int partitionVal = nums[lo];
        while (true) {
            while (i < hi && nums[++i] < partitionVal);
            while (j > lo && nums[--j] > partitionVal);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);

        return j;
    }

    private static void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int r = random.nextInt(nums.length);
            swap(nums, i, r);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



    public static void main(String[] args) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);

        // Printing the top element of PriorityQueue
        System.out.println(pQueue.peek());

        // Printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(pQueue.poll());

        // Printing the top element again
        System.out.println(pQueue.peek());
    }

}
