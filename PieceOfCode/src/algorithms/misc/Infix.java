package algorithms.misc;

import java.util.Stack;

/**
 * System.out.println(EvaluateString.evaluate("10 + 2 * 6"));
 *         System.out.println(EvaluateString.evaluate("100 * 2 + 12"));
 *         System.out.println(EvaluateString.evaluate("100 * ( 2 + 12 )"));
 *         System.out.println(EvaluateString.evaluate("100 * ( 2 + 12 ) / 14"));
 *
 *         22
 *         212
 *         1400
 *         100
 */

public class Infix {


    public static void main(String[] args) {
        System.out.println(evalInfix(""));
    }
    
    
    public static int evalInfix(String str){

        Stack<Character> operators = new Stack<>();
        Stack<Integer> operand =  new Stack<>();

        for (int i=0; i<str.length();  i++){


            char ch = str.charAt(i);

            if (ch == ' ')
                continue;

            if (ch >='0' && ch<='9'){

                StringBuilder val = new StringBuilder();
                while (ch>='0' && ch <='9'){
                   val.append(ch);
                   ch = str.charAt(++i);
              }

              i--;
              operand.push(Integer.parseInt(val.toString()));
            }
            else if (ch == '(')
                 operators.push(ch);
            else if (isOperator(ch)){
                
                while (!operators.isEmpty() && Precedence(operators.peek()) >  Precedence(ch))
                {
                    operand.push(evaluate(operators.pop(), operand.pop(), operand.pop()));
                }

                operators.push(ch);
                
            }
            else if ( ch == ')')
            {
                while (operators.peek()!='(')
                    operand.push(evaluate(operators.pop(), operand.pop(), operand.pop()));

                operators.pop();
            }
        }


        while (!operators.isEmpty()){
            operand.push(evaluate(operators.pop(), operand.pop(), operand.pop()));
        }
        

        return operand.pop();
    }

    private static Integer evaluate(Character op, Integer b, Integer a) {

        switch (op){
            case '+' : return a+b;

            case '-' : return a-b;

            case '*' : return a*b;

            case '/' : return a/b;

            default: return 0;
        }
    }

    private static int Precedence(Character ch) {

        if ( ch == '+' || ch == '-')
            return 1;

        if (ch == '*' || ch == '/')
            return 2;

        return 0;

    }

    private static boolean isOperator(char ch) {

        if (ch == '+' || ch == '-' || ch == '/' || ch == '*')
            return true;

        return false;

    }

}
