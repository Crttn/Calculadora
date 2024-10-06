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
    private String operator = "";  // Para almacenar el operador
    private boolean startNewInput = true;  // Para saber cuándo empezar a escribir un nuevo número


    public static Stage primaryStage;

    @FXML
    private Button button0;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonC;

    @FXML
    private Button buttonCE;

    @FXML
    private Button buttonDiv;

    @FXML
    private Button buttonEqual;

    @FXML
    private Button buttonMinus;

    @FXML
    private Button buttonMulti;

    @FXML
    private Button buttonPoint;

    @FXML
    private GridPane buttonsGridPane;

    @FXML
    private TextField resultTextField;

    @FXML
    private BorderPane root;


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

    // Establecer el operador y guardar el valor actual
    private void setOperator(String op) {
        operator = op;
        num1 = Double.parseDouble(resultTextField.getText());
        startNewInput = true;  // Preparar para el próximo número
    }

    public BorderPane getRoot() {
        return root;
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
    void onButtonClickAdd(ActionEvent event) {
        setOperator("+");
    }

    @FXML
    void onButtonClickC(ActionEvent event) {
        setOperator("C");
    }

    @FXML
    void onButtonClickDiv(ActionEvent event) {
        setOperator("/");
    }

    @FXML
    void onButtonClickEqual(ActionEvent event) {
        setOperator("=");
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
    void onButtonClickPoint(ActionEvent event) {
        // Agregar un punto decimal si no existe ya en el número actual
        if (!resultTextField.getText().contains(".")) {
            resultTextField.setText(resultTextField.getText() + ".");
        }
    }

}
