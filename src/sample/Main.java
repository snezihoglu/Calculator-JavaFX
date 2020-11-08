package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class Main extends Application {

    TextField text,hint;

    double memory;
    double result;

    int choice;

    boolean clearText;
    boolean dotUsed;
    boolean power10;

    public Main() {

        memory = 0.0;
        result = 0.0;

        choice = 0;

        clearText = true;
        dotUsed = false;
        power10 = false;

        text = new TextField("0");
        hint = new TextField("0");

    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        File file = new File("C:/Users/User/IdeaProjects/calc/src/sample/text.txt");
        Scanner scan = new Scanner(file);
        primaryStage.setTitle(scan.nextLine());

        text.setDisable(true);
        hint.setDisable(true);
        hint.getStyleClass().add("text-field-hint");

        //Buttons

        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");
        Button button0 = new Button("0");
        Button buttonDot = new Button(".");

        Button buttonSign = new Button("\u00B1");
        Button buttonAdd = new Button("+");
        Button buttonDivide = new Button("\u00F7");
        Button buttonMultiply = new Button("\u002A");
        Button buttonSubtract = new Button("-");
        Button buttonResult = new Button("=");
        Button buttonSquareRoot = new Button("\u221A");
        Button buttonClear = new Button("C");
        Button buttonPi = new Button("\u03C0");
        Button buttonCubeRoot = new Button("\u221B");
        Button buttonPower = new Button("x\u00B2");
        Button buttonBack = new Button("\u00AB");
        Button button10power = new Button("10\u207F");
        Button buttonPower3 = new Button("x\u00B3");

        // Buttons set On Action

        button1.setOnAction((ActionEvent e) -> buttonClicked("1"));
        button2.setOnAction((ActionEvent e) -> buttonClicked("2"));
        button3.setOnAction((ActionEvent e) -> buttonClicked("3"));
        button4.setOnAction((ActionEvent e) -> buttonClicked("4"));
        button5.setOnAction((ActionEvent e) -> buttonClicked("5"));
        button6.setOnAction((ActionEvent e) -> buttonClicked("6"));
        button7.setOnAction((ActionEvent e) -> buttonClicked("7"));
        button8.setOnAction((ActionEvent e) -> buttonClicked("8"));
        button9.setOnAction((ActionEvent e) -> buttonClicked("9"));
        button0.setOnAction((ActionEvent e) -> buttonClicked("0"));
        buttonDot.setOnAction((ActionEvent e) -> buttonDotClicked());

        buttonAdd.setOnAction((ActionEvent e) -> buttonAddClicked());
        buttonMultiply.setOnAction((ActionEvent e) -> buttonMultiplyClicked());
        buttonSubtract.setOnAction((ActionEvent e) -> buttonSubtractClicked());
        buttonResult.setOnAction((ActionEvent e) -> buttonResultClicked());
        buttonClear.setOnAction((ActionEvent e) -> buttonClearClicked());
        buttonPi.setOnAction((ActionEvent e)-> buttonPiClicked());
        buttonDivide.setOnAction((ActionEvent e) -> buttonDivideClicked());
        buttonSquareRoot.setOnAction((ActionEvent e) -> buttonSquareRootClicked());
        buttonCubeRoot.setOnAction((ActionEvent e) -> buttonCubeRootClicked());
        buttonSign.setOnAction((ActionEvent e) -> buttonSignClicked());
        buttonPower.setOnAction((ActionEvent e) -> buttonPowerClicked());
        buttonBack.setOnAction((ActionEvent e) -> buttonBackClicked());
        button10power.setOnAction((ActionEvent e) -> button10powerClicked());
        buttonPower3.setOnAction((ActionEvent e) -> buttonPower3Clicked());

        // Buttons style

        buttonAdd.getStyleClass().add("button-orange");
        buttonDivide.getStyleClass().add("button-orange");
        buttonMultiply.getStyleClass().add("button-orange");
        buttonSubtract.getStyleClass().add("button-orange");
        buttonSquareRoot.getStyleClass().add("button-orange");
        buttonPi.getStyleClass().add("button-orange");
        buttonCubeRoot.getStyleClass().add("button-orange");
        buttonPower.getStyleClass().add("button-orange");
        button10power.getStyleClass().add("button-orange");
        buttonPower3.getStyleClass().add("button-orange");

        buttonBack.getStyleClass().add("button-red");
        buttonResult.getStyleClass().add("button-red");
        buttonClear.getStyleClass().add("button-red");

        // Layout

        VBox layoutVertical = new VBox();

        HBox layoutHorizontal = new HBox();
        HBox layoutHorizontal0 = new HBox();
        HBox layoutHorizontal1 = new HBox();
        HBox layoutHorizontal2 = new HBox();
        HBox layoutHorizontal3 = new HBox();
        HBox layoutHorizontal4 = new HBox();
        HBox layoutHorizontal5 = new HBox();

        layoutHorizontal.getChildren().addAll(hint);
        layoutHorizontal0.getChildren().addAll(text);
        layoutHorizontal1.getChildren().addAll(buttonClear,buttonBack,buttonResult,buttonSquareRoot,buttonPower);
        layoutHorizontal2.getChildren().addAll(button7,button8,button9,buttonDivide,buttonPower3);
        layoutHorizontal3.getChildren().addAll(button4,button5,button6,buttonMultiply,buttonCubeRoot);
        layoutHorizontal4.getChildren().addAll(button1,button2,button3,buttonSubtract,button10power);
        layoutHorizontal5.getChildren().addAll(buttonSign,button0,buttonDot,buttonAdd,buttonPi);

        layoutVertical.getChildren().addAll(layoutHorizontal,layoutHorizontal0,layoutHorizontal1,layoutHorizontal2,
                layoutHorizontal3,layoutHorizontal4,layoutHorizontal5);

        //Scene

        Scene scene = new Scene(layoutVertical,460,530);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }

    // Buttons Methods

    public void buttonClicked(String number) {

        if(clearText) text.clear();

        if(power10) {
            setTextField(Calculator.powerOf10(Double.parseDouble(number)));
            power10 = false;
        }
        else {
            text.setText(text.getText() + number);
            clearText = false;
        }

    }
    public void buttonDotClicked() {

        if(!dotUsed) {

            if(!power10) {
                if(clearText) text.setText("0");
                text.setText(text.getText() + ".");
                dotUsed = true;
                clearText = false;
            }

        }

    }
    public void buttonPiClicked() {

        text.clear();
        text.setText(text.getText() + Math.PI);
        clearText = true;

    }
    public void buttonSquareRootClicked() {
        try {
            setTextField(Calculator.sqrt(Double.parseDouble(text.getText())));
            clearText = true;
            dotUsed = false;
            hint.setText("0");
        } catch(ArithmeticException ex) {
            ex.getMessage();
        }
    }
    public void buttonCubeRootClicked() {

        setTextField(Calculator.cbrt(Double.parseDouble(text.getText())));
        clearText = true;
        dotUsed = false;
        hint.setText("0");

    }
    public void buttonPowerClicked() {

        setTextField(Calculator.power(Double.parseDouble(text.getText()),2));
        clearText = true;
        dotUsed = false;
        hint.setText("0");

    }
    public void buttonPower3Clicked() {

        setTextField(Calculator.power(Double.parseDouble(text.getText()),3));
        clearText = true;
        dotUsed = false;
        hint.setText("0");

    }
    public void button10powerClicked() {
        power10 = true;
    }
    public void buttonAddClicked() {
        equation(choice);
        choice = 1;
        clearText = true;
        dotUsed = false;
    }
    public void buttonSubtractClicked() {
        equation(choice);
        choice = 2;
        clearText = true;
        dotUsed = false;
    }
    public void buttonMultiplyClicked() {
        equation(choice);
        choice = 3;
        clearText = true;
        dotUsed = false;
    }
    public void buttonDivideClicked() {
        equation(choice);
        choice = 4;
        clearText = true;
        dotUsed = false;
    }
    public void buttonSignClicked() {
        setTextField(Double.parseDouble(text.getText())*-1);
    }
    public void buttonResultClicked() {

        switch(choice) {
            case 1:
                result = Calculator.add(memory, Double.parseDouble(text.getText()));
                break;
            case 2:
                result = Calculator.subtract(memory, Double.parseDouble(text.getText()));
                break;
            case 3:
                result = Calculator.multiply(memory, Double.parseDouble(text.getText()));
                break;
            case 4:
                if(memory !=0) {
                    try {
                        result = Calculator.divide(memory, Double.parseDouble(text.getText()));
                    }
                    catch(ArithmeticException ex) {
                        ex.getMessage();
                    }

                }
                break;
            default:
                result = Double.parseDouble(text.getText());
                break;
        }
        try {
            FileWriter myWriter = new FileWriter("out.txt");
            myWriter.write((int) result);
            myWriter.close();
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        choice = 0;
        memory = 0;
        setTextField(result);
        hint.setText("0");
        clearText = true;
        dotUsed = false;
    }
    public void buttonBackClicked() {

        if(text.getText().length() > 1) {
            text.setText(text.getText().substring(0, text.getText().length()-1));

        }
        else {
            text.setText("0");
            clearText = true;

        }

    }
    public void buttonClearClicked() {

        text.setText("0");
        hint.setText("0");
        clearText = true;

    }
    public void setTextField(double number) {

        if((int)number == number) {
            text.setText(String.valueOf((int)number));
        }
        else {
            text.setText(String.valueOf(number));
        }

    }
    public void setTextFieldHint(double number) {

        if((int)number == number) {
            hint.setText(String.valueOf((int)number));
        }
        else {
            hint.setText(String.valueOf(number));
        }

    }
    public void equation(int choice) {
        switch(choice) {
            case 0:
                memory = Double.parseDouble(text.getText());

                break;
            case 1:
                memory += Double.parseDouble(text.getText());
                setTextFieldHint(memory);
                setTextField(memory);
                break;
            case 2:
                memory -= Double.parseDouble(text.getText());
                setTextField(memory);
                setTextFieldHint(memory);
                break;
            case 3:
                memory *= Double.parseDouble(text.getText());
                setTextField(memory);
                setTextFieldHint(memory);
                break;
            case 4:
                memory /= Double.parseDouble(text.getText());
                setTextField(memory);
                setTextFieldHint(memory);
                break;
            default:
                break;
        }
    }
}

