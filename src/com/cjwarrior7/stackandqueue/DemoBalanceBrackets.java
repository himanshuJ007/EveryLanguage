package com.cjwarrior7.stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class DemoBalanceBrackets {
    public static void main(String[] args) {
        System.out.println("Enter the Exp");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> st = new  Stack<Character>();
        for (int i = 0; i <str.length() ; i++) {
            char ch=str.charAt(i);
            if(ch =='('|| ch =='{'||  ch =='['){
                st.push(ch);
            }
            else if(ch ==')'){
               boolean val= handleClosing(st,'(');
                if (val == false) {
                    System.out.println("false");
                    return;
                }

            }
            else if(ch =='}'){
                boolean val =  handleClosing(st,'{');
                if (val == false) {
                    System.out.println("false");
                    return;
                }

            }
            else if(ch ==']'){
                boolean val = handleClosing(st,'[');
                if (val == false) {
                    System.out.println("false");
                    return;
                }
            }



        }
        if(st.size()==0){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }

    }
    public static boolean handleClosing(Stack<Character> st,Character
            corresch){
        if(st.size()==0){
            return false;
        }
        else if(st.peek()!=corresch){
            return false;
        }
        else{
            st.pop();
            return true;


        }

    }
}
