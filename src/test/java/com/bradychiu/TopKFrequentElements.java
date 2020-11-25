package com.bradychiu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class TopKFrequentElements {

    /**
     * time: n log(n)
     * space: n
     */
    public static int[] topKFrequentTreeMap(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> freqMapList = new TreeMap<>();
        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            if (!freqMapList.containsKey(freq))
                freqMapList.put(freq, new ArrayList<>());
            freqMapList.get(freq).add(num);
        }

        List<Integer> result = new ArrayList<>();
        while (result.size() < k)
            result.addAll(freqMapList.pollLastEntry().getValue());

        return result.stream().mapToInt(i -> i).toArray();
    }


    /**
     * time: n log(k)
     * space: n + k; counts + heap
     */
    public static int[] topKFrequentHeap(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        // TODO: review
        Queue<Integer> heap = new PriorityQueue<>(
                // least frequent element first
                // see psvm for proof
                (newInt, oldInt) -> freqMap.get(newInt) - freqMap.get(oldInt)
        );

        for (int key : freqMap.keySet()) {
            heap.add(key);
            if (heap.size() > k)
                heap.poll();
        }

        int[] top = new int[k];
        for (int j = 0; j < k; j++) {
            top[j] = heap.poll();
        }

        return top;
    }



    /**
     * time: 2n
     * space: 2n
     */
    public static int[] topKFrequentBucketSort(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1]; // max freq is n -> need array of size n+1 to store at freq n
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for (int pos = bucket.length - 1; pos >= 0 && result.size() < k; pos--) {
            if (bucket[pos] != null)
                result.addAll(bucket[pos]);
        }

        // TODO: review
        // converting List<Integer> to int[]: https://stackoverflow.com/a/23945015/3195226
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Queue<Integer> heap = new PriorityQueue<>((newInt, oldInt) -> compare(newInt, oldInt));

        heap.add(4);
        heap.add(3);
        System.out.println(heap.peek());
        heap.add(2);
        System.out.println(heap.peek());
        heap.add(1);
        System.out.println(heap.peek());
    }

    private static int compare(int a, int b) {
        // int comp = Integer.compare(a, b);
        int comp = a - b;
        System.out.println("a: " + a + "; b: " + b + "; comp: " + comp);
        return comp;
    }
}
