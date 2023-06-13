/**
 * @VivianiKipper
 */

package com.example.currencyconverter02;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrencyController implements Initializable {//a class that implements "initializable" interface.

    @FXML
    private TextField enterAmount; // User enter amount to be converted

    @FXML
    private TextField result; // Display the result of the amount converted
    @FXML
    private ComboBox<String> baseCurrency;//The user can select currency from comboBox

    @FXML
    private ComboBox<String> targetCurrency;//The user can select currency from comboBox
    @FXML
    private Text errorMessage; //if the user do some mistake, will be visible an Error Message.

    ObservableList<String> currencyOptions = FXCollections.observableArrayList("BRL", "EUR", "USD");//An observable list to store the collection of string values

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) { // to initialize the javaFx controller and set up the initial state
        baseCurrency.setItems(currencyOptions);//populating ComboBox with string values.
        targetCurrency.setItems(currencyOptions);//populating ComboBox with string values.
    }

    @FXML
    protected void calculateCurrency() { //method to calculate currency conversion

        double amount = Double.parseDouble(enterAmount.getText());//returns a double value represented by the string argument.
        double conRate = getconRate(baseCurrency.getValue(), targetCurrency.getValue());//Getting values when user select currencies.
        double resultValue = amount * conRate;//Calculating currencies rate conversion

        result.setText(String.valueOf(resultValue));//Display conversion result.
    }

    private double getconRate(String baseCurrency, String targetCurrency) {//Calculate the conversion rate based on pairs of currencies.


        try {
            if (baseCurrency == null || targetCurrency == null) {//handling an error, if the user forget to select all currencies.
                errorMessage.setVisible(true);//Set the error message visible.
            }

            if (baseCurrency.equals("USD") && targetCurrency.equals("BRL")) {//if both conditions are true then return this value.
                return 5.25;
            }
            if (baseCurrency.equals("BRL") && targetCurrency.equals("USD")) {
                return 0.19;
            }

            if (baseCurrency.equals("USD") && targetCurrency.equals("EUR")) {
                return 0.82;
            }

            if (baseCurrency.equals("EUR") && targetCurrency.equals("USD")) {
                return 1.22;
            }

            if (baseCurrency.equals("EUR") && targetCurrency.equals("BRL")) {
                return 6.32;
            }
            if (baseCurrency.equals("BRL") && targetCurrency.equals("EUR")) {
                return 0.158;
            }

        } catch (IllegalArgumentException e) {//handling an error using try and catch block

        }

        return 0;
    }
}