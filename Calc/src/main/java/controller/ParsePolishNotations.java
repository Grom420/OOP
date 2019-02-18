package controller;

import java.util.*;



public class ParsePolishNotations {


    private static String operators = "+-*/";//допустимые операции
    private static String delimiters = "() " + operators;
    public static boolean flag = true;

    private static boolean isDelimiter(String token) {
        if (token.length() != 1) return false;
        for (int i = 0; i < delimiters.length(); i++) {
            if (token.charAt(0) == delimiters.charAt(i)) return true;
        }
        return false;
    }

    private static boolean isOperator(String token) {
        if (token.equals("u-")) return true;
        for (int i = 0; i < operators.length(); i++) {
            if (token.charAt(0) == operators.charAt(i)) return true;
        }
        return false;
    }

    private static boolean isFunction(String token) {//перечисляем допустимые формы написания функций
        if (token.equals("sqrt") || token.equals("ln") || token.equals("lg") || token.equals("cube") || token.equals("pow10") || token.equals("cos") || token.equals("sqr") || token.equals("sin") || token.equals("tg") || token.equals("ctg")) return true;
        return false;
    }

    private static int priority(String token) {//задаём приоритет функций
        if (token.equals("(")) return 1;
        if (token.equals("+") || token.equals("-")) return 2;
        if (token.equals("*") || token.equals("/")) return 3;
        return 4;
    }

    public static List<String> parse(String infix) {
        List<String> postfix = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        StringTokenizer tokenizer = new StringTokenizer(infix, delimiters, true);
        String prev = "";
        String curr = "";
        while (tokenizer.hasMoreTokens()) {
            curr = tokenizer.nextToken();
            if (!tokenizer.hasMoreTokens() && isOperator(curr)) {//если введено некорректное выражение
                flag = false;
                return postfix;
            }
            if (curr.equals(" ")) continue;
            if (isFunction(curr)) stack.push(curr);
            else if (isDelimiter(curr)) {
                if (curr.equals("(")) stack.push(curr);
                else if (curr.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        postfix.add(stack.pop());
                        if (stack.isEmpty()) { //если скобочки хреново расставлены
                            flag = false;
                            return postfix;
                        }
                    }
                    stack.pop();
                    if (!stack.isEmpty() && isFunction(stack.peek())) {
                        postfix.add(stack.pop());
                    }
                }
                else {
                    if (curr.equals("-") && (prev.equals("") || (isDelimiter(prev)  && !prev.equals(")")))) {
                        // унарный минус
                        curr = "u-";
                    }
                    else {
                        while (!stack.isEmpty() && (priority(curr) <= priority(stack.peek()))) {
                            postfix.add(stack.pop());
                        }

                    }
                    stack.push(curr);
                }
            }

            else {
                postfix.add(curr);
            }
            prev = curr;
        }

        while (!stack.isEmpty()) {
            if (isOperator(stack.peek())) postfix.add(stack.pop());
            else {//если скобки хреновые
                flag = false;
                return postfix;
            }
        }
        return postfix;
    }
}