package com.cjwarrior7.stackandqueue;

import java.util.Stack;

public class DemoNextGreaterElementOnRightAlter {
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
        int[] res=solve(arr);
        for (int i = 0; i < res.length ; i++) {
            System.out.println(res[i]);
        }

    }
    public static int[] solve(int[] arr){
        int[] nge = new int[arr.length];
        Stack<Integer> st=new Stack<Integer>();
        st.push(0);
        for (int i = 1; i <arr.length ; i++) {
           while (st.size() > 0 && arr[i] >arr[st.peek()]){
               int pos=st.peek();
               nge[pos]=arr[i];
               st.pop();
           }
           st.push(i);

        }
        while (st.size()>0) {
            int pos=st.peek();
            nge[pos] = -1;
            st.pop();
            
        }
        return nge;
    }
}
