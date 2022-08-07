package com.orbit.code.backtrack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;

public class LC698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int res =0;
        for (int num : nums) {
            res+= num;
        }
        if (res%k!=0) return false;
//        boolean[] used = new boolean[nums.length];
        int used = 0;
        int target = res/k;
        return  backtrack(k, 0, nums, 0, used, target);
    }
    Map<Integer,Boolean> memo =  new HashMap<Integer,Boolean>();
    private boolean backtrack(int k, int bucket, int[] nums, int start, int used, int target) {
        if (k == 0) return true;

        if (bucket == target){
            boolean res =  backtrack(k-1,0,nums,0,used,target);
            memo.put(used, res);
            return res;
        }
        if (memo.containsKey(used)){
            return memo.get(used);
        }
        for (int i = start; i < nums.length; i++) {
            if ((used>> i &1) == 1 )continue;
            if (bucket+nums[i]>target)continue;
            used |= 1 << i;
            bucket+=nums[i];
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            used ^= 1 << i;
            bucket-=nums[i];
        }
        return false;
    }
    private boolean backtrack(int k, int bucket, int[] nums, int start, boolean[] used, int target) {
        if (k == 0) return true;
        if (bucket == target){
            return backtrack(k-1,0,nums,0,used,target);
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i])continue;
            if (bucket+nums[i]>target)continue;
            used[i]=true;
            bucket+=nums[i];
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            used[i] = false;
            bucket-=nums[i];
        }
        return false;
    }

    private boolean backtrack(int[] nums, int index, int[] bucket, int target) {
        if (index ==nums.length){
            for (int i : bucket) {
                if (i!=target){
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] + nums[index] > target){
                continue;
            }
            bucket[i]+=nums[index];
            if (backtrack(nums,index+1,bucket,target))return true;
            bucket[i]-= nums[index];
        }
        return false;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

            }
//            System.out.println(Thread.currentThread());
//            Thread.interrupted();
            while (true){

            }
        });
        t1.start();


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        LockSupport.park();
        t1.interrupt();
        System.out.println(t1.isInterrupted());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t1.interrupt();
        System.out.println(t1.isInterrupted());
    }
}
