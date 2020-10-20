package com.cjwarrior7.stackandqueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class DemoInfixEvaluation {
    public static void main(String[] args){
        String exp="2*3-(6+5)+8";
        char[] chararray=exp.toCharArray();
        for (int i = 0; i < chararray.length; i++) {
            System.out.println(chararray[i]);
        }
        System.out.println("end");
        Stack<Integer> operands=new Stack<Integer>();
        Stack<Character> operators=new   Stack<Character>();
        for (int i = 0; i < chararray.length; i++) {
            //char ch=exp.charAt(i);
            if(chararray[i] =='('){
                operators.push(chararray[i]);
            }
           else if(Character.isDigit(chararray[i])){
                operands.push(chararray[i]-'0');// char to int
            }
            else if(chararray[i] ==')'){
                while (operators.peek() != '(') {
                    char optor=operators.pop();
                    int v2=operands.pop();
                    int v1=operands.pop();
                    int opv=operation(v1,v2,optor);
                    System.out.println(opv);
                    operands.push(opv);
                }
                operators.pop();
            }
            else if(chararray[i]=='*'||chararray[i]=='/'||chararray[i]=='+'||chararray[i]=='-'){
                //ch is waiting for higher property operators to solve first
                while(operators.size() > 0 && operators.peek()!='(' && precedence(chararray[i])<=precedence(operators.peek())){
                    char optor=operators.pop();
                    int v2=operands.pop();
                    int v1=operands.pop();
                    int opv=operation(v1,v2,optor);
                    System.out.println(opv);
                    operands.push(opv);

                }
                operators.push(chararray[i]);

            }

        }
        while (operators.size() != 0) {
            char optor=operators.pop();
            int v2=operands.pop();
            int v1=operands.pop();
            int opv=operation(v1,v2,optor);
            System.out.println(opv);
            operands.push(opv);
        }
        System.out.println("ans:"+operands.peek());
    }
    public static int precedence(char optor){
        if (optor == '+') {
            return 1;
        }
        else if (optor == '-') {
            return 1;
        }
       else if (optor == '*') {
            return 2;
        }
       else{
           return 2;
        }
    }
    public static int operation(int v1, int v2,char optor){
        if (optor == '+') {
            return v1 + v2;
        }
        else if (optor == '-') {
            return v1 - v2;
        }
        else if (optor == '*') {
            return v1 * v2;
        }
        else{
            return v1 / v2;
        }
    }
}
