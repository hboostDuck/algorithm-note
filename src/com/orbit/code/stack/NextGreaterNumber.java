package com.orbit.code.stack;



import java.util.Stack;

public class NextGreaterNumber {

}


class Solution2 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] ints = new int[temperatures.length];
        for (int i = temperatures.length-1; i >=0; i--) {
            while (!s.isEmpty() && s.peek() <= temperatures[i]){
                s.pop();
            }
            ints[i] = s.isEmpty() ? 0 : s.peek() -1;
            s.push(i);
        }
        return ints;
    }
}
class RemoveDuplicateLetters{
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        int[] count = new int[256];
        boolean[] inStack = new boolean[256];
        for (char o : s.toCharArray()) {
            count[o]++;
        }
        for (char c : s.toCharArray()) {
            count[c] --;
            if (inStack[c]) continue;
            while (!st.isEmpty() && c < st.peek()){
                if (count[st.peek()] == 0){
                    break;
                }
                inStack[st.pop()] = false;
            }
            st.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}