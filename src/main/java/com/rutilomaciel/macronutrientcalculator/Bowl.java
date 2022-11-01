package com.rutilomaciel.macronutrientcalculator;

public class Bowl extends Food{

    //Constant Variables
    public static final double DEFAULT_CALORIES = 3000;
    public static final double DEFAULT_FATS = 20;
    public static final double DEFAULT_CARBS = 20;
    public static final double DEFAULT_PROTEIN = 20;

    //Constructors
    public Bowl(double calories, double fats, double carbs, double protein){
        super(calories, fats, carbs, protein);
    }

    public Bowl(){
        this(Bowl.DEFAULT_CALORIES, Bowl.DEFAULT_FATS, Bowl.DEFAULT_CARBS, Bowl.DEFAULT_PROTEIN);
    }

    public Bowl(double calories, double fats, double carbs, double protein, String choice_size, String choice_carbs, String choice_protein ){
        super(calories, fats, carbs, protein, choice_size, choice_carbs, choice_protein);
    }

}