package controller;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class TransferNumberSystem {

    public static void toBinary(ComboBox comboBox, Label output, Label input){

        if(comboBox.getSelectionModel().isSelected(1)){
            int oldvalue = Integer.parseInt(input.getText());
            output.setText(Integer.toBinaryString(oldvalue));
        }
        if(comboBox.getSelectionModel().isSelected(2)){
            String oldValue = input.getText();
            int dec = Integer.parseInt(oldValue, 16);
            output.setText(Integer.toBinaryString(dec));
        }
        if(comboBox.getSelectionModel().isSelected(3)){
            String oldValue = input.getText();
            int dec = Integer.parseInt(oldValue, 8);
            output.setText(Integer.toBinaryString(dec));
        }
    }

    public static void toOct(ComboBox comboBox, Label output, Label input){

        if(comboBox.getSelectionModel().isSelected(0)){
            String oldValue = input.getText();
            int dec = Integer.parseInt(oldValue, 2);
            output.setText(Integer.toOctalString(dec));
        }
        if(comboBox.getSelectionModel().isSelected(1)){
            int oldvalue = Integer.parseInt(input.getText());
            output.setText(Integer.toOctalString(oldvalue));
        }
        if(comboBox.getSelectionModel().isSelected(2)){
            String oldValue = input.getText();
            int dec = Integer.parseInt(oldValue, 16);
            output.setText(Integer.toOctalString(dec));
        }
    }

    public static void toHex(ComboBox comboBox, Label output, Label input){

        if(comboBox.getSelectionModel().isSelected(0)){
            String oldValue = input.getText();
            int dec = Integer.parseInt(oldValue, 2);
            output.setText(Integer.toHexString(dec));
        }
        if(comboBox.getSelectionModel().isSelected(1)){
            int oldvalue = Integer.parseInt(input.getText());
            output.setText(Integer.toHexString(oldvalue));
        }
        if(comboBox.getSelectionModel().isSelected(3)){
            String oldValue = input.getText();
            int dec = Integer.parseInt(oldValue, 8);
            output.setText(Integer.toHexString(dec));
        }
    }

    public static void toDec(ComboBox comboBox, Label output, Label input){

        if(comboBox.getSelectionModel().isSelected(0)){
            String oldValue = input.getText();
            int dec = Integer.parseInt(oldValue, 2);
            output.setText(String.valueOf(dec));
        }
        if(comboBox.getSelectionModel().isSelected(2)){
            String oldValue = input.getText();
            int dec = Integer.parseInt(oldValue, 8);
            output.setText(String.valueOf(dec));
        }
        if(comboBox.getSelectionModel().isSelected(3)){
            String oldValue = input.getText();
            int dec = Integer.parseInt(oldValue, 16);
            output.setText(String.valueOf(dec));
        }
    }
}
