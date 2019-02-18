package controller;

import javafx.scene.control.Label;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Calculate {



    public static BigDecimal operations(List<String> postfix) {//производим операции

        Deque<Double> stack = new ArrayDeque<>();//создаем экземпляр stack очереди
        for (String x : postfix) {
            switch (x) {

                case "lg":
                    stack.push(Math.log10(stack.pop()));
                    break;

                case "ln":
                    stack.push(Math.log(stack.pop()));
                    break;

                case "ctg":
                    stack.push(1.0 / (Math.tan(stack.pop())));
                    break;

                case "tg":
                    stack.push(Math.tan(stack.pop()));
                    break;

                case "sin":
                    stack.push(Math.sin(stack.pop()));
                    break;

                case "sqr":
                    Double tmp = stack.pop();
                    stack.push(tmp * tmp);
                    break;

                case "cos":
                    stack.push(Math.cos(stack.pop()));
                    break;

                case "sqrt":
                    stack.push(Math.sqrt(stack.pop()));
                    break;

                case "cube":
                    Double tmp1 = stack.pop();
                    stack.push(tmp1 * tmp1 * tmp1);
                    break;

                case "pow10":
                    stack.push(Math.pow(10, stack.pop()));
                    break;

                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-":
                    Double b = stack.pop(), a = stack.pop();
                    stack.push(a - b);
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    Double c = stack.pop(), d = stack.pop();
                    stack.push(d / c);
                    break;

                case "u-":
                    stack.push(-stack.pop());
                    break;

                default:
                    stack.push(Double.valueOf(x));
                    break;
            }
        }
        return BigDecimal.valueOf(stack.pop());
    }

    public static void result(Label input, Label polishLabel, Label output) {

        MainController mainController = new MainController();

        if (!input.getText().equals("")) {
            ParsePolishNotations pn = new ParsePolishNotations();
            List<String> expression = pn.parse(input.getText());
            boolean flag = pn.flag;
            mainController.outSb.delete(0, mainController.outSb.length());
            if (flag) {
                for (String x : expression)
                    mainController.outSb.append(x).append(" ");
                polishLabel.setText(String.valueOf(mainController.outSb));
                output.setText(String.valueOf(Calculate.operations(expression)));
            }
        }
    }
}