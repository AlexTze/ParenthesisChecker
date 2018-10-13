
// Author: Alex Tze
// Date: 10 Oct. 2018
// License: GNU General Public License V3.0
// This utility checks if all parentheses in a string are properly matched.

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Scanner;
import java.util.ArrayList;

class Checker {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
        ArrayList<String> arrList = new ArrayList<>();
        String str;
        while (reader.hasNext()) {
            str = reader.nextLine();
            arrList.add(str);
        }
        reader.close();
        for (String temp : arrList) {
            System.out.println(checkParentheses(temp));
        }
    }

    private static boolean isMatchingParenthesis(char ch1, char ch2) {
        switch (ch1) {
        case '(':
            return (ch2 == ')');
        case '[':
            return (ch2 == ']');
        case '{':
            return (ch2 == '}');
        default:
            return false;
        }
    }

    private static String checkParentheses(String expr) {
        Stack<Character> chrStack = new Stack<>();
        char[] chrArray = expr.toCharArray();
        try {
            for (char temp : chrArray) {
                if (temp == '(' || temp == '[' || temp == '{')
                    chrStack.push(temp);
                else if (temp == ')' || temp == ']' || temp == '}') {
                    if (!isMatchingParenthesis(chrStack.pop(), temp)) {
                        return "NO";// type of parenthesis not matching
                    }
                }
            }
            if (!chrStack.isEmpty())
                return "NO";// open parentheses > close parentheses
        } catch (EmptyStackException e) {
            return "NO";// open parentheses < close parentheses
        }
        return "YES";
    }
}