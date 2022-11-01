package com.rutilomaciel.macronutrientcalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;

public class Main extends Application implements EventHandler<ActionEvent>{

    //Variables
    Label mainLabel;
    Button startOverButtonSteakRicePl, startOverButtonSteakVeggPl, startOverButtonChknRicePl, startOverButtonChknVeggPl, startOverButtonSteakRiceBowl, startOverButtonSteakVeggBowl, startOverButtonChknRiceBowl, startOverButtonChknVeggBowl, startOverButtonSteakRiceMB, startOverButtonSteakVeggMB, startOverButtonChknRiceMB, startOverButtonChknVeggMB;
    VBox initialVBox, vbox2StkRicePl, vboxStkVeggPl, vbox3ChkRicePl, vbox4ChkVegPl, vboxStkRiceBowl, vboxStkVeggBowl, vboxChknRiceBowl, vboxChknVeggBowl, vboxStkRiceMB, vboxStkVeggMB, vboxChknRiceMB, vboxChknVeggMB;
    Scene initialScene, steakPlateRiceScene, steakVeggPlScene, chickenRicePlScene, chickenVegPlScene, steakRiceBowlScene, steakVeggBowlScene, chknRiceBowlScene, chknVeggBowlScene, steakRiceMBScene, steakVeggMBScene, chknRiceMBScene, chknVeggMBScene;
    FileInputStream inputFileObj = null;
    Image calcImage, steakRicePlateImage, steakPlateVeggImage, chickenPlateImage, chickenPlateVegImg, steakRiceBowlImage, steakVeggBowlImage, chknRiceBowlImage, chknVeggBowlImage, steakRiceMBImage, steakVeggMBImage, chknRiceMBImage, chknVeggMBImage;
    ImageView calcImageView, steakRicePlImageView, steakPlateVeggImageView, chickenRicePlateImageView, chickenVegPlateImgView, steakRiceBowlImageView, steakVeggBowlImageView, chknRiceBowlImageView, chknVeggBowlImageView, steakRiceMBImageView, steakVeggMBImageView, chknRiceMBImageView, chknVeggMBImageView;
    MenuButton mainMenuButton, carbsMenuButton, proteinMenuButton;
    MenuItem plateMenuItem, bowlMenuItem, miniBowlMenuItem, riceMenuItem, veggiesMenuItem, steakMenuItem, chickenMenuItem;
    Stage window;

    //Variables to keep track of button choices
    String choice_size = "";
    String choice_carbs = "";
    String choice_protein = "";
    int choice = 0;

    ArrayList<Food> chosenFood = new ArrayList<Food>();
    int numChosen = 0;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        // extracting image from file
        try{
            inputFileObj = new FileInputStream("./src/main/resources/calculatorImage.png");
            calcImage = new Image("calculatorImage.png");
            steakRicePlateImage = new Image("steakPlateNLabel.png");
            steakPlateVeggImage = new Image("steakPlateVegg.png");
            chickenPlateImage = new Image("chickenPlateNLabel.png");
            chickenPlateVegImg = new Image("chickenVegPlNLabel.png");
            steakRiceBowlImage = new Image("steakRiceBowl.png");
            steakVeggBowlImage = new Image("steakVeggBowl.png");
            chknRiceBowlImage = new Image("chknRiceBowl.png");
            chknVeggBowlImage = new Image("chknVeggBowl.png");
            steakRiceMBImage = new Image("steakRiceMB.png");
            steakVeggMBImage = new Image("steakVeggMB.png");
            chknRiceMBImage = new Image("chknRiceMB.png");
            chknVeggMBImage = new Image("chknVeggMB.png");
            calcImageView = new ImageView(calcImage);
            steakRicePlImageView = new ImageView(steakRicePlateImage);
            steakPlateVeggImageView = new ImageView(steakPlateVeggImage);
            chickenRicePlateImageView = new ImageView(chickenPlateImage);
            chickenVegPlateImgView = new ImageView(chickenPlateVegImg);
            steakRiceBowlImageView = new ImageView(steakRiceBowlImage);
            steakVeggBowlImageView = new ImageView(steakVeggBowlImage);
            chknRiceBowlImageView = new ImageView(chknRiceBowlImage);
            chknVeggBowlImageView = new ImageView(chknVeggBowlImage);
            steakRiceMBImageView = new ImageView(steakRiceMBImage);
            steakVeggMBImageView = new ImageView(steakVeggMBImage);
            chknRiceMBImageView = new ImageView(chknRiceMBImage);
            chknVeggMBImageView = new ImageView(chknVeggMBImage);
            inputFileObj.close();
        }catch(Exception e){
            System.err.println("Error: could not open file.");
            System.exit(0);
        }


        // Creating MenuItems

        plateMenuItem = new MenuItem("Plate");
        bowlMenuItem = new MenuItem("Bowl");
        miniBowlMenuItem = new MenuItem("Mini Bowl");
        riceMenuItem = new MenuItem("Rice");
        veggiesMenuItem = new MenuItem("Veggies");
        steakMenuItem = new MenuItem("Steak");
        chickenMenuItem = new MenuItem("Chicken");

        // Go Back button
        startOverButtonSteakRicePl = new Button("Start Over");
        startOverButtonSteakVeggPl = new Button("Start Over");
        startOverButtonChknRicePl = new Button("Start Over");
        startOverButtonChknVeggPl = new Button("Start Over");
        startOverButtonSteakRiceBowl = new Button("Start Over");
        startOverButtonSteakVeggBowl = new Button("Start Over");
        startOverButtonChknRiceBowl = new Button("Start Over");
        startOverButtonChknVeggBowl = new Button("Start Over");
        startOverButtonSteakRiceMB = new Button("Start Over");
        startOverButtonSteakVeggMB = new Button("Start Over");
        startOverButtonChknRiceMB = new Button("Start Over");
        startOverButtonChknVeggMB = new Button("Start Over");


        // MenuButtons and StartOver Actions
        mainMenuButton = new MenuButton ("Options", null, plateMenuItem, bowlMenuItem, miniBowlMenuItem);
        plateMenuItem.setOnAction(this);
        bowlMenuItem.setOnAction(this);
        miniBowlMenuItem.setOnAction(this);
        carbsMenuButton = new MenuButton ("Side", null, riceMenuItem, veggiesMenuItem);
        riceMenuItem.setOnAction(this);
        veggiesMenuItem.setOnAction(this);
        carbsMenuButton.setVisible(false);
        proteinMenuButton = new MenuButton ("Protein", null, steakMenuItem, chickenMenuItem);
        steakMenuItem.setOnAction(this);
        chickenMenuItem.setOnAction(this);
        proteinMenuButton.setVisible(false);
        startOverButtonSteakRicePl.setOnAction(this);
        startOverButtonSteakVeggPl.setOnAction(this);
        startOverButtonChknRicePl.setOnAction(this);
        startOverButtonChknVeggPl.setOnAction(this);
        startOverButtonSteakRiceBowl.setOnAction(this);
        startOverButtonSteakVeggBowl.setOnAction(this);
        startOverButtonChknRiceBowl.setOnAction(this);
        startOverButtonChknVeggBowl.setOnAction(this);
        startOverButtonSteakRiceMB.setOnAction(this);
        startOverButtonSteakVeggMB.setOnAction(this);
        startOverButtonChknRiceMB.setOnAction(this);
        startOverButtonChknVeggMB.setOnAction(this);

        //Boxes in Stage
        mainLabel = new Label("Nutrition Calculator");

        initialVBox = new VBox(mainLabel, calcImageView, mainMenuButton, carbsMenuButton, proteinMenuButton);
        initialVBox.setSpacing(20);
        initialVBox.setAlignment(Pos.CENTER);
        vbox2StkRicePl = new VBox(mainLabel, steakRicePlImageView, startOverButtonSteakRicePl);
        vbox2StkRicePl.setSpacing(20);
        vbox2StkRicePl.setAlignment(Pos.CENTER);
        steakRicePlImageView.setPreserveRatio(true);
        steakRicePlImageView.setFitHeight(400);
        vboxStkVeggPl = new VBox (mainLabel, steakPlateVeggImageView, startOverButtonSteakVeggPl);
        vboxStkVeggPl.setSpacing(20);
        vboxStkVeggPl.setAlignment(Pos.CENTER);
        steakPlateVeggImageView.setPreserveRatio(true);
        steakPlateVeggImageView.setFitHeight(400);
        vbox3ChkRicePl = new VBox (mainLabel, chickenRicePlateImageView, startOverButtonChknRicePl);
        vbox3ChkRicePl.setSpacing(20);
        vbox3ChkRicePl.setAlignment(Pos.CENTER);
        chickenRicePlateImageView.setPreserveRatio(true);
        chickenRicePlateImageView.setFitHeight(400);
        vbox4ChkVegPl = new VBox (mainLabel, chickenVegPlateImgView, startOverButtonChknVeggPl);
        vbox4ChkVegPl.setSpacing(20);
        vbox4ChkVegPl.setAlignment(Pos.CENTER);
        chickenVegPlateImgView.setPreserveRatio(true);
        chickenVegPlateImgView.setFitHeight(400);
        vboxStkRiceBowl = new VBox (mainLabel, steakRiceBowlImageView, startOverButtonSteakRiceBowl);
        vboxStkRiceBowl.setSpacing(20);
        vboxStkRiceBowl.setAlignment(Pos.CENTER);
        steakRiceBowlImageView.setPreserveRatio(true);
        steakRiceBowlImageView.setFitHeight(400);
        vboxStkVeggBowl = new VBox(mainLabel, steakVeggBowlImageView, startOverButtonSteakVeggBowl);
        vboxStkVeggBowl.setSpacing(20);
        vboxStkVeggBowl.setAlignment(Pos.CENTER);
        steakVeggBowlImageView.setPreserveRatio(true);
        steakVeggBowlImageView.setFitHeight(400);
        vboxChknRiceBowl = new VBox(mainLabel, chknRiceBowlImageView, startOverButtonChknRiceBowl);
        vboxChknRiceBowl.setSpacing(20);
        vboxChknRiceBowl.setAlignment(Pos.CENTER);
        chknRiceBowlImageView.setPreserveRatio(true);
        chknRiceBowlImageView.setFitHeight(400);
        vboxChknVeggBowl = new VBox(mainLabel, chknVeggBowlImageView, startOverButtonChknVeggBowl);
        vboxChknVeggBowl.setSpacing(20);
        vboxChknVeggBowl.setAlignment(Pos.CENTER);
        chknVeggBowlImageView.setPreserveRatio(true);
        chknVeggBowlImageView.setFitHeight(400);
        vboxStkRiceMB = new VBox (mainLabel, steakRiceMBImageView, startOverButtonSteakRiceMB);
        vboxStkRiceMB.setSpacing(20);
        vboxStkRiceMB.setAlignment(Pos.CENTER);
        steakRiceMBImageView.setPreserveRatio(true);
        steakRiceMBImageView.setFitHeight(400);
        vboxStkVeggMB = new VBox (mainLabel, steakVeggMBImageView, startOverButtonSteakVeggMB);
        vboxStkVeggMB.setSpacing(20);
        vboxStkVeggMB.setAlignment(Pos.CENTER);
        steakVeggMBImageView.setPreserveRatio(true);
        steakVeggMBImageView.setFitHeight(400);
        vboxChknRiceMB = new VBox (mainLabel, chknRiceMBImageView, startOverButtonChknRiceMB);
        vboxChknRiceMB.setSpacing(20);
        vboxChknRiceMB.setAlignment(Pos.CENTER);
        chknRiceMBImageView.setPreserveRatio(true);
        chknRiceMBImageView.setFitHeight(400);
        vboxChknVeggMB = new VBox (mainLabel, chknVeggMBImageView, startOverButtonChknVeggMB);
        vboxChknVeggMB.setSpacing(20);
        vboxChknVeggMB.setAlignment(Pos.CENTER);
        chknVeggMBImageView.setPreserveRatio(true);
        chknVeggMBImageView.setFitHeight(400);


        //Setting and showing scenes
        initialScene = new Scene(initialVBox, 600, 600);
        steakPlateRiceScene = new Scene(vbox2StkRicePl, 600, 600);
        steakVeggPlScene = new Scene(vboxStkVeggPl, 600, 600);
        chickenRicePlScene = new Scene (vbox3ChkRicePl, 600, 600);
        chickenVegPlScene = new Scene (vbox4ChkVegPl, 600, 600);
        steakRiceBowlScene = new Scene (vboxStkRiceBowl, 600, 600);
        steakVeggBowlScene = new Scene (vboxStkVeggBowl, 600, 600);
        chknRiceBowlScene = new Scene (vboxChknRiceBowl, 600, 600);
        chknVeggBowlScene = new Scene (vboxChknVeggBowl, 600, 600);
        steakRiceMBScene = new Scene (vboxStkRiceMB, 600, 600);
        steakVeggMBScene = new Scene (vboxStkVeggMB, 600, 600);
        chknRiceMBScene = new Scene(vboxChknRiceMB, 600, 600);
        chknVeggMBScene = new Scene(vboxChknVeggMB, 600, 600);

        window.setTitle("Nutrition Calculator");
        window.setScene(initialScene);
        window.show();
    }

    @Override
    public void handle(ActionEvent event){

        //Utilizing if-else statements for multiple actions when buttons are pressed
        //Will display nutrition label with caloric values
        //Information will be stored in an ArrayList and printed onto the console

        if (event.getSource() == plateMenuItem){
            System.out.println("Plate chosen");
            choice_size = "Plate";
            carbsMenuButton.setVisible(true);
        }else if (event.getSource() == startOverButtonSteakRicePl){
            window.setScene(initialScene);
        }else if (event.getSource() == startOverButtonSteakVeggPl){
            window.setScene(initialScene);
        }else if (event.getSource() == startOverButtonChknRicePl){
            window.setScene(initialScene);
        }else if (event.getSource() == startOverButtonChknVeggPl){
            window.setScene(initialScene);
        }else if (event.getSource() == startOverButtonSteakRiceBowl){
            window.setScene(initialScene);
        }else if (event.getSource() == startOverButtonSteakVeggBowl){
            window.setScene(initialScene);
        }else if (event.getSource() == startOverButtonChknRiceBowl){
            window.setScene(initialScene);
        }else if (event.getSource() == startOverButtonChknVeggBowl){
            window.setScene(initialScene);
        }else if (event.getSource() == startOverButtonSteakRiceMB){
            window.setScene(initialScene);
        }else if (event.getSource() == startOverButtonSteakVeggMB){
            window.setScene(initialScene);
        }else if (event.getSource() == startOverButtonChknRiceMB){
            window.setScene(initialScene);
        }else if (event.getSource() == startOverButtonChknVeggMB){
            window.setScene(initialScene);
        }else if (event.getSource() == bowlMenuItem){
            System.out.println("Bowl chosen");
            choice_size = "Bowl";
            carbsMenuButton.setVisible(true);
        }else if (event.getSource() == miniBowlMenuItem){
            System.out.println("Mini Bowl chosen");
            choice_size = "Mini Bowl";
            carbsMenuButton.setVisible(true);
        }else if (event.getSource() == riceMenuItem){
            System.out.println("Rice chosen");
            choice_carbs = "Rice";
            proteinMenuButton.setVisible(true);
        }else if (event.getSource() == veggiesMenuItem){
            System.out.println("Veggies chosen");
            choice_carbs = "Veggies";
            proteinMenuButton.setVisible(true);
        }else if (event.getSource() == steakMenuItem){
            System.out.println("Steak chosen");
            choice_protein = "Steak";

            if( choice_size == "Plate" && choice_carbs == "Rice"){
                window.setScene(steakPlateRiceScene);
                System.out.println(choice_size + " " + choice_carbs + " " + choice_protein);
                Food steakRicePlate = new Plate(850, 15, 126, 57, "Plate", "Rice", "Steak");
                chosenFood.add(steakRicePlate);
                System.out.println(chosenFood);
            } else if ( choice_size == "Plate" && choice_carbs == "Veggies"){
                window.setScene(steakVeggPlScene);
                System.out.println(choice_size + " " + choice_carbs + " " + choice_protein);
                Food steakVeggiePlate = new Plate(560, 14, 57, 54, "Plate", "Veggies", "Steak");
                chosenFood.add(steakVeggiePlate);
                System.out.println(chosenFood);
            }else if ( choice_size == "Bowl" && choice_carbs == "Rice"){
                window.setScene(steakRiceBowlScene);
                System.out.println(choice_size + " " + choice_carbs + " " + choice_protein);
                Food steakRiceBowl = new Bowl(660, 10, 103, 42, "Bowl", "Rice", "Steak");
                chosenFood.add(steakRiceBowl);
                System.out.println(chosenFood);
            }else if ( choice_size == "Bowl" && choice_carbs == "Veggies"){
                window.setScene(steakVeggBowlScene);
                System.out.println(choice_size + " " + choice_carbs + " " + choice_protein);
                Food steakVeggieBowl = new Bowl(360, 9, 34, 38, "Bowl", "Veggies", "Steak");
                chosenFood.add(steakVeggieBowl);
                System.out.println(chosenFood);
            }else if ( choice_size == "Mini Bowl" && choice_carbs == "Rice"){
                window.setScene(steakRiceMBScene);
                System.out.println(choice_size + " " + choice_carbs + " " + choice_protein);
                Food steakRiceMiniBowl = new MiniBowl(400, 6, 64, 25, "Mini Bowl", "Rice", "Steak");
                chosenFood.add(steakRiceMiniBowl);
                System.out.println(chosenFood);
            }else if ( choice_size == "Mini Bowl" && choice_carbs == "Veggies"){
                window.setScene(steakVeggMBScene);
                System.out.println(choice_size + " " + choice_carbs + " " + choice_protein);
                Food steakVeggieMiniBowl = new MiniBowl(220, 6, 21, 23, "Mini Bowl", "Veggies", "Steak");
                chosenFood.add(steakVeggieMiniBowl);
                System.out.println(chosenFood);
            }

        }else if (event.getSource() == chickenMenuItem){
            System.out.println("Chicken chosen");
            choice_protein = "Chicken";
            if( choice_size == "Plate" && choice_carbs == "Rice"){
                window.setScene(chickenRicePlScene);
                System.out.println(choice_size + " " + choice_carbs + " " + choice_protein);
                Food chknRicePlate = new Plate(840, 17, 105, 70, "Plate", "Rice", "Chicken");
                chosenFood.add(chknRicePlate);
                System.out.println(chosenFood);
            } else if ( choice_size == "Plate" && choice_carbs == "Veggies"){
                window.setScene(chickenVegPlScene);
                System.out.println(choice_size + " " + choice_carbs + " " + choice_protein);
                Food chknVeggiesPlate = new Plate(540, 16, 36, 67, "Plate", "Veggies", "Chicken");
                chosenFood.add(chknVeggiesPlate);
                System.out.println(chosenFood);
            }else if ( choice_size == "Bowl" && choice_carbs == "Rice"){
                window.setScene(chknRiceBowlScene);
                System.out.println(choice_size + " " + choice_carbs + " " + choice_protein);
                Food chknRiceBowl = new Bowl(650, 11, 88, 51, "Bowl", "Rice", "Chicken");
                chosenFood.add(chknRiceBowl);
                System.out.println(chosenFood);
            }else if ( choice_size == "Bowl" && choice_carbs == "Veggies"){
                window.setScene(chknVeggBowlScene);
                System.out.println(choice_size + " " + choice_carbs + " " + choice_protein);
                Food chknVeggiesBowl = new Bowl(350, 10, 19, 48, "Bowl", "Veggies", "Chicken");
                chosenFood.add(chknVeggiesBowl);
                System.out.println(chosenFood);
            }else if ( choice_size == "Mini Bowl" && choice_carbs == "Rice"){
                window.setScene(chknRiceMBScene);
                System.out.println(choice_size + " " + choice_carbs + " " + choice_protein);
                Food chknRiceMiniBowl = new MiniBowl(400, 7, 55, 31, "Mini Bowl", "Rice", "Chicken");
                chosenFood.add(chknRiceMiniBowl);
                System.out.println(chosenFood);
            }else if ( choice_size == "Mini Bowl" && choice_carbs == "Veggies"){
                window.setScene(chknVeggMBScene);
                System.out.println(choice_size + " " + choice_carbs + " " + choice_protein);
                Food chknVeggiesMiniBowl = new MiniBowl(210, 6, 12, 29, "Mini Bowl", "Veggies", "Chicken");
                chosenFood.add(chknVeggiesMiniBowl);
                System.out.println(chosenFood);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

