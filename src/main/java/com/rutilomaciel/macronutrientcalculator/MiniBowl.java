package com.rutilomaciel.macronutrientcalculator;

public class MiniBowl extends Food{

    //Constant Variables
    public static final double DEFAULT_CALORIES = 3000;
    public static final double DEFAULT_FATS = 30;
    public static final double DEFAULT_CARBS = 30;
    public static final double DEFAULT_PROTEIN = 30;

    //Constructors
    public MiniBowl(double calories, double fats, double carbs, double protein){
        super(calories, fats, carbs, protein);
    }

    public MiniBowl(){
        this(MiniBowl.DEFAULT_CALORIES, MiniBowl.DEFAULT_FATS, MiniBowl.DEFAULT_CARBS, MiniBowl.DEFAULT_PROTEIN);
    }

    public MiniBowl(double calories, double fats, double carbs, double protein, String choice_size, String choice_carbs, String choice_protein ){
        super(calories, fats, carbs, protein, choice_size, choice_carbs, choice_protein);
    }

}