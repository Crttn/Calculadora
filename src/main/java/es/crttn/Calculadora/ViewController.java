package es.crttn.Calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    private double num1 = 0;
    private double num2 = 0;
    private String operator = "";
    private boolean startNewInput = true;

    public static Stage primaryStage;

    @FXML
    private TextField resultTextField;

    @FXML
    private BorderPane root;

    public BorderPane getRoot() {
        return root;
    }

    public ViewController() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/calculatorView.fxml"));
            loader.setController(this);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    // Método auxiliar para agregar números al campo de texto
    private void appendNumber(String number) {
        if (startNewInput) {
            resultTextField.setText(number);
            startNewInput = false;
        } else {
            resultTextField.setText(resultTextField.getText() + number);
        }
    }

    private void setOperator(String op) {
        operator = op;
        num1 = Double.parseDouble(resultTextField.getText());
        startNewInput = true;
    }

    private double calculateResult() {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    return 0;  // Evitar división por cero
                }
            default:
                return 0;
        }
    }

    @FXML
    void onButtonClick0(ActionEvent event) {
        appendNumber("0");
    }

    @FXML
    void onButtonClick1(ActionEvent event) {
        appendNumber("1");
    }

    @FXML
    void onButtonClick2(ActionEvent event) {
        appendNumber("2");
    }

    @FXML
    void onButtonClick3(ActionEvent event) {
        appendNumber("3");
    }

    @FXML
    void onButtonClick4(ActionEvent event) {
        appendNumber("4");
    }

    @FXML
    void onButtonClick5(ActionEvent event) {
        appendNumber("5");
    }

    @FXML
    void onButtonClick6(ActionEvent event) {
        appendNumber("6");
    }

    @FXML
    void onButtonClick7(ActionEvent event) {
        appendNumber("7");
    }

    @FXML
    void onButtonClick8(ActionEvent event) {
        appendNumber("8");
    }

    @FXML
    void onButtonClick9(ActionEvent event) {
        appendNumber("9");
    }

    @FXML
    void onButtonClickPoint(ActionEvent event) {
        if (!resultTextField.getText().contains(".")) {
            resultTextField.setText(resultTextField.getText() + ".");
        }
    }

    @FXML
    void onButtonClickAdd(ActionEvent event) {
        setOperator("+");
    }

    @FXML
    void onButtonClickMinus(ActionEvent event) {
        setOperator("-");
    }

    @FXML
    void onButtonClickMulti(ActionEvent event) {
        setOperator("*");
    }

    @FXML
    void onButtonClickDiv(ActionEvent event) {
        setOperator("/");
    }

    @FXML
    void onButtonClickEqual(ActionEvent event) {
        num2 = Double.parseDouble(resultTextField.getText());
        double result = calculateResult();
        resultTextField.setText(String.valueOf(result));
        startNewInput = true;
    }

    @FXML
    void onButtonClickC(ActionEvent event) {
        resultTextField.setText("0");
        num1 = 0;
        num2 = 0;
        operator = "";
        startNewInput = true;
    }


}
