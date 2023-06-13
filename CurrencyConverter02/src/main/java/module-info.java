module com.example.currencyconverter02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.currencyconverter02 to javafx.fxml;
    exports com.example.currencyconverter02;
}