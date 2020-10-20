package com.cjwarrior7.stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class DemoDuplicateBrackets {
    public static void main(String[] args) {
        System.out.println("Enter the Exp");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                if (st.peek() == '(') {
                    System.out.println("true");
                    return;
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }

            } else {
                st.push(ch);
            }
        }
        System.out.println("false");

    }


}
