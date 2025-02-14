package heap;


import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 */
public class KthLargestElementInArray {

    public static void main(String[] args) {
        int [] nums = new int[] { 3,2,1,5,6,4 };
        int k =2;

        System.out.println(new KthLargestElementInArray().findKthLargest(nums,k));
    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i< nums.length ; i++){
            pq.offer(nums[i]);
            if(pq.size() >   k)
                pq.poll();
        }
        return pq.peek();
    }

}
