package com.cjwarrior7.stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DemoSlidingWindowMax {
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
        solve(arr);

    }
    public static void solve(int[] arr) {
        int[] nge = new int[arr.length];
        Stack<Integer> st=new Stack<>();
        st.push(arr[arr.length-1]);
        nge[arr.length-1]=arr.length;

        for (int i=arr.length-2; i>=0 ; i--) {
            while( st.size()>0 && arr[i] >= arr[st.peek()] ){
                st.pop();
            }
            if(st.size()==0){
                nge[i]=arr.length;
            }
            else {
                nge[i]=st.peek();
            }
            st.push(i);
        }
        // System.out.println(Arrays.toString(nge));
        int k=4;
        int j=0;
        for (int i =0; i <= arr.length-k; i++) {
            if(j<i){
                j=i;
            }

            while(nge[j] < i + k){
                j=nge[j];
            }
            System.out.println(arr[j]);
        }
    }

}
