package com.cjwarrior7.stackandqueue;

import java.util.Stack;

public class DemoInfixConversions {
    public static void main(String[] args) {
        String exp="2*3-(6+5)+8";
        char[] chararray=exp.toCharArray();
        Stack<Character> operators=new Stack<Character>();
        Stack<String> prefix=new   Stack<String>();
        Stack<String> postfix=new   Stack<String>();
        for (int i = 0; i < chararray.length; i++) {
            if(chararray[i]=='('){
             operators.push(chararray[i]);
            }
            if(chararray[i]==')'){
                while (operators.peek() != '(') {
                    char optor=operators.pop();
                    String postv2=postfix.pop();
                    String postv1=postfix.pop();
                    String postopv=postv1+postv2+optor;

                    postfix.push(postopv);

                    String prev2=prefix.pop();
                    String prev1=prefix.pop();
                    String preopv=optor+prev1+prev2;

                    postfix.push(preopv);
                }
                operators.pop();

            }
            if((chararray[i]>='a' && chararray[i]<='z')||(chararray[i]>='A' && chararray[i]<='Z')||(chararray[i]>='0' && chararray[i]<='9')){
                while (operators.size()>0 && operators.peek() != '(' && precedence(chararray[i])<= precedence(operators.peek())) {
                    char optor=operators.pop();
                    String postv2=postfix.pop();
                    String postv1=postfix.pop();
                    String postopv=postv1+postv2+optor;

                    postfix.push(postopv);

                    String prev2=prefix.pop();
                    String prev1=prefix.pop();
                    String preopv=optor+prev1+prev2;

                    postfix.push(preopv);
                }
                operators.push(chararray[i]);
            }
            while (operators.size() > 0) {
                char optor=operators.pop();
                String postv2=postfix.pop();
                String postv1=postfix.pop();
                String postopv=postv1+postv2+optor;

                postfix.push(postopv);

                String prev2=prefix.pop();
                String prev1=prefix.pop();
                String preopv=optor+prev1+prev2;

                postfix.push(preopv);
            }
        }

    }
    public static int precedence(char optor){
        if (optor == '+' || optor == '-') {
            return 1;
        }
        else if (optor == '*'|| optor =='/') {
            return 2;
        }
        else{
            return 0;
        }

    }
}
