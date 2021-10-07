package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    private double valueOne=0,valueTwo=0;
    @FXML
    private TextField textField;
    @FXML
    private Button oneB;
    @FXML
    private Button twoB;
    @FXML
    private Button treeB;
    @FXML
    private Button fourB;
    @FXML
    private Button fiveB;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eit;
    @FXML
    private Button nine;
    @FXML
    private Button zero;
    @FXML
    private  Button dot;
     @FXML
    private Button clear;

     private String operand="", s="";
     private int flag=0;



    public void digitClickedHandler(ActionEvent e){
        if (e.getSource().equals(oneB)) {
            textField.appendText("1");
        }else if (e.getSource().equals(twoB)){
            textField.appendText("2");
        }else if (e.getSource().equals(treeB)){
            textField.appendText("3");
        }else if (e.getSource().equals(fourB)){
            textField.appendText("4");
        }else if (e.getSource().equals(fiveB)){
            textField.appendText("5");
        }else if (e.getSource().equals(six)){
            textField.appendText("6");
        }else if (e.getSource().equals(seven)){
            textField.appendText("7");
        }else if (e.getSource().equals(eit)){
            textField.appendText("8");
        }else if (e.getSource().equals(nine)){
            textField.appendText("9");
        }else if (e.getSource().equals(zero)) {
            textField.appendText("0");
        }else if (e.getSource().equals(dot)){
            String s=textField.getText();
            if (!(s.contains("."))){
            textField.appendText(".");}
        }else if (e.getSource().equals(clear)){
            textField.clear();
            flag=0;
            valueTwo=0;
            valueOne=0;
            operand="";
        }
        System.out.println(e.getSource()+", "+textField.getText());
    }

    public void operatorClickHandler(ActionEvent ae) {
        double temp=0;
        Button button = (Button) ae.getTarget();

        String string=textField.getText();
        if (string.isEmpty()) return;

        if (flag == 0) {
            valueOne = Double.parseDouble(textField.getText());
        } else {
            valueTwo = Double.parseDouble(textField.getText());
        }

        if (button.getText().equals("+")) {
            temp=operations(valueOne,valueTwo,operand);
            operand = "+";
            textField.setText("");
            flag = 1;
            valueOne=temp;
        } else if (button.getText().equals("-")) {
             temp=operations(valueOne,valueTwo,operand);
            operand = "-";
            textField.setText("");
            flag = 1;
            valueOne=temp;
        } else if (button.getText().equals("*")) {
           temp= operations(valueOne,valueTwo,operand);
            operand = "*";
            textField.setText("");
            flag = 1;
            valueOne=temp;
        } else if (button.getText().equals("/")) {
            temp=operations(valueOne,valueTwo,operand);
            operand = "/";
            textField.setText("");
            flag = 1;
            valueOne=temp;
        } else if (button.getText().equals("%")) {
           temp= operations(valueOne,valueTwo,operand);
            operand = "%";
            textField.setText("");
            flag = 1;
            valueOne=temp;
        } else if (button.getText().equals("=")) {
            if (flag == 1) {
                System.out.println("=->" + valueOne + "->" + valueTwo);
                 temp = operations(valueOne, valueTwo, operand);
                System.out.println("Equals->" + valueOne);
                textField.setText(temp + "");
                flag = 0;
                valueTwo = 0;
            } else {
                System.out.println("Enter second number");
            }
        }}

        public double operations( double valueOne,double valueTwo, String ope){
            if (ope.equals("+")) {
                valueOne += valueTwo;
            } else if (ope.equals("-")) {
                valueOne = valueOne - valueTwo;
            } else if (ope.equals("*")) {
                valueOne = valueOne * valueTwo;
            } else if (ope.equals("/")) {
                if (valueOne == 0 || valueTwo == 0) {
                    valueOne = 0;
                } else {
                    valueOne = valueOne / valueTwo;
                }
            } else if (ope.equals("%")) {
                valueOne = valueOne % valueTwo;
            }
            System.out.println("Operation()->" + valueOne + "->" + valueTwo);
            return valueOne;
        }

    }

