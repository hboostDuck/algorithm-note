package com.orbit.code.test;



public class TEST1 {

    public String largestGoodInteger(String num) {
        int j, count = 0;
        String str = "000";
        char temp = ' ';
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (temp == c ) {
                count++;
            }else {
                temp = c;
                count =0;
            }
            if (count ==3){
                if (temp > str.charAt(0)){
                    for (int k = 0; k < 3; k++) {
                        str = new String(new char[]{temp,temp,temp});
                    }
                }
                count =0;
            }
        }
        return "000".equals(str)? "":str;
    }

    public static void main(String[] args) {
        TEST1 test1 = new TEST1();
        String s = test1.largestGoodInteger("6777133339");
    }




}
