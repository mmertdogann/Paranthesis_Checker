/*
Name: Mert Doğan
ID: 041701041
Date: 02.11.2018
Explanation: This class is the main class whose project name is Mathematical Parenthesis Checker.
This program analyzes parentheses in a mathematical expression by using stack. The parentheses' inputs must given by the user.
It controls parentheses which are "(" , "[" match with ")" , "]" or do not match.
*/

package Assignment1;


import java.util.NoSuchElementException;
import java.util.Scanner;

public class mert_dogan {

    public static void main(String[] args) throws NoSuchElementException {

        myStack<Character> stackParantheses = new myStack<>();  // myStack object for store and match parantheses


        Scanner input = new Scanner(System.in);

        String stringExpressions = new String();   // store parentheses into a string which given by user

        System.out.println("Enter a mathematical expression:");
        stringExpressions = input.next();  // read data in the string
        char[] charExpressions = stringExpressions.toCharArray();  // convert string to char Array and store parentheses into char array which given by user


        for (int i = 0; i < charExpressions.length; i++) { // index starts at zero to charExpressions array's length

            if ((charExpressions[i] == '(' || charExpressions[i] == '[')) { // if the incoming parenthesis is parenthesis lefthand bracket  then push
                stackParantheses.push(charExpressions[i]);

                System.out.print("Stack Contents: [Top] ");
                for (Character stack : stackParantheses) {   //Print stack
                    System.out.print(stack + " ");
                }
                System.out.println(" [bottom]");

            } else if (charExpressions[i] == ')') {  // if the incoming parenthesis is closing parenthesis -> ')'  then pop
                try {
                    Character popped = stackParantheses.pop(); // First try if the stack is not empty then pop
                    if (popped != '(') {
                        System.out.println("\nParentheses do not match!");
                        System.exit(1);
                    }
                } catch (NoSuchElementException ex) {   // if the stack is empty throw an exception
                    System.out.println("\nParentheses do not match!");
                    System.exit(1);

                }
            } else if (charExpressions[i] == ']') {  // if the incoming parenthesis is closing parenthesis -> ')'  then pop
                try {
                    Character popped = stackParantheses.pop();  //First try if the stack is not empty then pop
                    if (popped != '[') {
                        System.out.println("\nParentheses do not match!");
                        System.exit(1);
                    }
                } catch (NoSuchElementException ex) {  //if the stack is empty throw an exception
                    System.out.println("\nParentheses do not match!");
                    System.exit(1);

                }
            }


        }

        if (stackParantheses.size() == 0) {
            System.out.println("\nParantheses are correct!"); // If there is no parenthesis exist then print correct
        } else {
            System.out.println("\nStack's last status: There is such an element in the stack"); // In the end if there is a open parenthesis in the stack then print that is not empty
        }


    }
}
