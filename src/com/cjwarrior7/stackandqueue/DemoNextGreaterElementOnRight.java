package com.cjwarrior7.stackandqueue;

import java.util.Stack;

public class DemoNextGreaterElementOnRight {
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
    Stack<Integer> st=new Stack<>();
    st.push(arr[arr.length-1]);
    System.out.println("stack:"+st.peek());
    nge[arr.length-1]=-1;
    for (int i=arr.length-2; i>=0 ; i--) {
       while( st.size()>0 && arr[i]>=st.peek() ){
           st.pop();
       }
       if(st.size()==0){
           nge[i]=-1;
       }
       else {
           nge[i]=st.peek();
       }
       st.push(arr[i]);
    }
    return nge ;
}
}
