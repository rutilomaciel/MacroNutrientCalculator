package com.rutilomaciel.macronutrientcalculator;

public abstract class Food{

    //CONSTANT VARIABLES
    public static final double DEFAULT_CALORIES = 100;
    public static final double DEFAULT_FATS = 5;
    public static final double DEFAULT_CARBS = 5;
    public static final double DEFAULT_PROTEIN = 5;

    //INSTANCE VARIABLES
    private double calories;
    private double fats;
    private double carbs;
    private double protein;

    private String choice_size = "";
    private String choice_carbs = "";
    private String choice_protein = "";


    //CONSTRUCTORS
    public Food(double calories, double fats, double carbs, double protein)throws IllegalArgumentException{
        if(!this.setAll(calories, fats, carbs, protein)) {
            throw new IllegalArgumentException("ERROR: Food full constructor illegal argument passed. Exiting program.");
        }
    }

    public Food(){
        this(DEFAULT_CALORIES, DEFAULT_FATS, DEFAULT_CARBS, DEFAULT_PROTEIN);
    }

    public Food(double calories, double fats, double carbs, double protein, String choice_size, String choice_carbs, String choice_protein){
        this.calories = calories;
        this.fats = fats;
        this.carbs = carbs;
        this.protein = protein;
        this.choice_size = choice_size;
        this.choice_carbs = choice_carbs;
        this.choice_protein = choice_protein;
    }

    public Food(Food original){
        if (original == null){
            System.out.println("Error in copy const Food");
            System.exit(0);
        }else{
            this.setAll(original.calories, original.fats, original.carbs, original.protein);
        }
    }


    //MUTATORS
    public boolean setCalories(double calories){
        if (calories >= 0){
            this.calories = calories;
            return true;
        }else{
            return false;
        }
    }

    public boolean setFats(double fats){
        if (fats >= 0){
            this.fats = fats;
            return true;
        }else{
            return false;
        }
    }
    public boolean setCarbs(double carbs){
        if (carbs >= 0){
            this.carbs = carbs;
            return true;
        }else{
            return false;
        }
    }

    public boolean setProtein(double protein){
        if (protein >= 0){
            this.protein = protein;
            return true;
        }else{
            return false;
        }
    }

    public boolean setChoiceSize(String choice_size){
        if (choice_size != null){
            this.choice_size = choice_size;
            return true;
        }else{
            return false;
        }
    }

    public boolean setChoiceCarbs(String choice_carbs){
        if (choice_carbs != null){
            this.choice_carbs = choice_carbs;
            return true;
        }else{
            return false;
        }
    }

    public boolean setChoiceProtein(String choice_protein){
        if (choice_protein != null){
            this.choice_protein = choice_protein;
            return true;
        }else{
            return false;
        }
    }

    public boolean setAll(double calories, double fats, double carbs, double protein) {
        return this.setCalories(calories) && this.setFats(fats) && this.setCarbs(carbs) && this.setProtein(protein);
    }

    //ACCESSORS
    public double getCalories(){
        return this.calories;
    }

    public double getFats(){
        return this.fats;
    }

    public double getCarbs(){
        return this.carbs;
    }

    public double getProtein(){
        return this.protein;
    }

    public String getChoiceSize(){
        return this.choice_size;
    }

    public String getChoiceCarbs(){
        return this.choice_carbs;
    }

    public String getChoiceProtein(){
        return this.choice_protein;
    }


    @Override
    public String toString(){

        return String.format("\nYour Food:\n Calories = %.0f\n Fats = %.0f\n Carbohydrates = %.0f\n Protein = %.0f\n Size = %s\n Side = %s\n Protein = %s\n", this.calories, this.fats, this.carbs, this.protein, choice_size, choice_carbs, choice_protein);
    }


}