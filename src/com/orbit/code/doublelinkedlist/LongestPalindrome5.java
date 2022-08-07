package com.orbit.code.doublelinkedlist;

public class LongestPalindrome5 {
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length()-1; i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            ans = ans.length()>s1.length()?ans:s1;
            ans = ans.length()>s2.length()?ans:s2;
        }
        return ans;
    }

    private String palindrome(String s,int l,int r){
        while (l>=0 && r <s.length()&&s.charAt(l) == s.charAt(r)){
            l--;r++;
        }
        return s.substring(l,r);
    }
}
