package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.*;

public class MainController implements Initializable {


    @FXML

    public Label input;
    public Label output;
    public ComboBox comboBox;
    public Label polishLabel;

    public StringBuilder inSb;
    public StringBuilder outSb;

    public MainController() {
        this.inSb = new StringBuilder();
        this.outSb = new StringBuilder();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        comboBox.getItems().add("Binary");
        comboBox.getItems().add("Dec");
        comboBox.getItems().add("Hex");
        comboBox.getItems().add("Oct");
    }

    public void oneClick(){

        inSb.append("1");
        input.setText(String.valueOf(inSb));
    }

    public void twoClick(){

        inSb.append("2");
        input.setText(String.valueOf(inSb));
    }
    public void threeClick(){

        inSb.append("3");
        input.setText(String.valueOf(inSb));
    }

    public void fourClick(){

        inSb.append("4");
        input.setText(String.valueOf(inSb));
    }
    public void fiveClick(){

        inSb.append("5");
        input.setText(String.valueOf(inSb));
    }

    public void sixClick(){

        inSb.append("6");
        input.setText(String.valueOf(inSb));
    }

    public void sevenClick(){

        inSb.append("7");
        input.setText(String.valueOf(inSb));
    }

    public void eightClick(){

        inSb.append("8");
        input.setText(String.valueOf(inSb));
    }

    public void nineClick(){

        inSb.append("9");
        input.setText(String.valueOf(inSb));
    }

    public void zeroClick(){

        inSb.append("0");
        input.setText(String.valueOf(inSb));
    }

    public void plusClick(){

        inSb.append("+");
        input.setText(String.valueOf(inSb));
    }

    public void resultClick(){

        Calculate.result(input, polishLabel, output);
    }

    public void pointClick(){

        inSb.append(".");
        input.setText(String.valueOf(inSb));
    }

    public void clearClick(){

        String oldValue = input.getText();
        if (oldValue.length()-1 >= 0){
            input.setText(oldValue.substring(0, oldValue.length()-1));
            inSb.delete(inSb.length()-1, inSb.length());
        }
    }

    public void bracketInClick(){

        inSb.append("(");
        input.setText(String.valueOf(inSb));
    }

    public void bracketOutClick(){

        inSb.append(")");
        input.setText(String.valueOf(inSb));
    }

    public void mulClick(){

        inSb.append("*");
        input.setText(String.valueOf(inSb));
    }

    public void divClick(){

        inSb.append("/");
        input.setText(String.valueOf(inSb));
    }

    public void cosClick(){

        inSb.append("cos(");
        input.setText(String.valueOf(inSb));
    }

    public void sinClick(){

        inSb.append("sin(");
        input.setText(String.valueOf(inSb));
    }

    public void tgClick(){

        inSb.append("tg(");
        input.setText(String.valueOf(inSb));
    }

    public void ctgClick(){

        inSb.append("ctg(");
        input.setText(String.valueOf(inSb));
    }

    public void sqrClick(){

        inSb.append("sqr(");
        input.setText(String.valueOf(inSb));
    }

    public void cubeClick(){

        inSb.append("cube(");
        input.setText(String.valueOf(inSb));
    }

    public void minusClick(){

        inSb.append("-");
        input.setText(String.valueOf(inSb));
    }

    public void sqrtClick(){

        inSb.append("sqrt(");
        input.setText(String.valueOf(inSb));
    }

    public void lnClick(){

        inSb.append("ln(");
        input.setText(String.valueOf(inSb));
    }

    public void lgClick(){

        inSb.append("lg(");
        input.setText(String.valueOf(inSb));
    }

    public void clearAllClick(){

        input.setText("");
        output.setText("");
        polishLabel.setText("");
        inSb.delete(0, inSb.length());
        outSb.delete(0, outSb.length());
    }

    public void toBinaryClick(){

        TransferNumberSystem.toBinary(comboBox, output, input);
    }

    public void toOctClick(){

        TransferNumberSystem.toOct(comboBox, output, input);
    }

    public void toHexClick(){

        TransferNumberSystem.toHex(comboBox, output, input);
    }

    public void toDecClick(){

        TransferNumberSystem.toDec(comboBox, output, input);
    }
}
