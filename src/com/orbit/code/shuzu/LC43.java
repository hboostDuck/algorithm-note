package com.orbit.code.shuzu;

/**
 * @Author: orbit
 * @Date: 2022/08/30/20:16
 * @Description:
 */
public class LC43 {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] arr = new int[m + n];
        for (int i = m-1; i >= 0 ; i--) {
            for (int j = n-1; j >= 0; j--) {
                int sum = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int p1 = i+j,p2 =i+j+1;
                sum += arr[p2];
                arr[p2] = sum%10;
                arr[p1] += sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (arr[i] == 0){
            i++;
            if(i >= m+n) return "0";
        }
        for (; i <m+n ; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
