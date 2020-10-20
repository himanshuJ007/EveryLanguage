package com.cjwarrior7.stackandqueue;

import java.util.Stack;

public class DemoStockPlan {
    public static void main(String[] args) {

            int[] arr= new int[9];
            arr[0]=2;
            arr[1]=5;
            arr[2]=9;
            arr[3]=3;
            arr[4]=1;
            arr[5]=12;
            arr[6]=6;
            arr[7]=8;
            arr[8]=7;
            //2 5 9 3 1 12 6 8 7
            int[] res=solve(arr);
            for (int i = 0; i < res.length ; i++) {
                System.out.println(res[i]);
            }

    }
    public static int[] solve(int[] arr) {
        int[] span = new int[arr.length];
        Stack<Integer> st = new Stack<Integer>();
        st.push(0);
        span[0]=1;
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] > arr[st.peek()]) {
                st.pop();
            }
            if(st.size()==0){
             span[i]=i+1;
            }else{
               span[i]=i-st.peek();
            }
            st.push(i);

        }

        return span;
    }

}
