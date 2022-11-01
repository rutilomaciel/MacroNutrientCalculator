module com.rutilomaciel.macronutrientcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.rutilomaciel.macronutrientcalculator to javafx.fxml;
    exports com.rutilomaciel.macronutrientcalculator;
}