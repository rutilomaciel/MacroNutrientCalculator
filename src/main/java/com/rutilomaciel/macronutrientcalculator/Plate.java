package com.rutilomaciel.macronutrientcalculator;

public class Plate extends Food {

    //CONSTANT VARIABLES
    public static final double DEFAULT_CALORIES = 1000;
    public static final double DEFAULT_FATS = 15;
    public static final double DEFAULT_CARBS = 15;
    public static final double DEFAULT_PROTEIN = 15;

    public static final String DEFAULT_SIZE = "Plate";
    public static final String DEFAULT_CARBS_CHOICE = "Rice";
    public static final String DEFAULT_PROTEIN_CHOICE = "Steak";


    //Constructors
    public Plate(double calories, double fats, double carbs, double protein){
        super(calories, fats, carbs, protein);
    }

    public Plate(){
        this(Plate.DEFAULT_CALORIES, Plate.DEFAULT_FATS, Plate.DEFAULT_CARBS, Plate.DEFAULT_PROTEIN);
    }


    public Plate(double calories, double fats, double carbs, double protein, String choice_size, String choice_carbs, String choice_protein ){
        super(calories, fats, carbs, protein, choice_size, choice_carbs, choice_protein);
    }


}