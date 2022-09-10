package com.orbit.code.sort.divid;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: orbit
 * @Date: 2022/09/10/0:45
 * @Description:
 */
public class LC315 {
    private class Pair {
        int val, id;
        Pair(int val, int id) {
            // 记录数组的元素值
            this.val = val;
            // 记录元素在数组中的原始索引
            this.id = id;
        }
    }
    // 归并排序所用的辅助数组
    private Pair[] temp;
    // 记录每个元素后面比自己小的元素个数
    private int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        temp = new Pair[n];
        Pair[] arr = new Pair[n];
        // 记录元素原始的索引位置，以便在count 数组中更新结果
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i],i);
        }
        sort(arr,0,n-1);
        LinkedList<Integer> res = new LinkedList<>();
        for (int c : count) {
            res.add(c);
        }
        return res;
    }

    private void sort(Pair[] arr, int start, int end) {
        if (end <= start)return;
        int mid = start + (end -start)/2;
        sort(arr,start,mid);
        sort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }

    private void merge(Pair[] arr, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        int i = start,j = mid+1;
        for (int k = start; k <= end; k++) {
            if (i == mid+1){
                arr[k] = temp[j++];
            } else if (j == end + 1) {
                arr[k] = temp[i++];
                // 更新 count 数组
                count[arr[k].id] += j - mid - 1;
            }else if (temp[i].val > temp[j].val){
                arr[k] = temp[j++];
            }else {
                arr[k] = temp[i++];
                // 更新 count 数组
                count[arr[k].id] += j - mid - 1;
            }
        }
    }

}
