package com.orbit.code.difference;

public class Difference {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff= new int[n];
        for (int[] booking : bookings) {
            int i = booking[0]-1;
            int j = booking[1]-1;
            int k = booking[2];
            diff[i] += k;
            if (j+1 < n){
                diff[j+1] -= k;
            }
        }
        int[] ans = new int[n];
        ans[0] = diff[0];
        for (int i = 1; i < n; i++) {
            ans[i] = diff[i]+ans[i-1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{1,2,10},{2,3,20},{2,5,25}};

        Difference d = new Difference();
        int[] ints = d.corpFlightBookings(m, 5);


    }

}
