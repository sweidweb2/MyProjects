package com.example.demo3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Welcomepage {
    //main page
    private Button dctrbtn;
    private Button patientbtn;

    /*======================WELCOME PAGE======================*/
    public VBox getwelcomepage() {
        VBox welcomepage = new VBox();

        Text welcometext = new Text("Welcome to our PolyClinic");
        Font welcomefont = Font.font("Georgia", FontWeight.BOLD, FontPosture.ITALIC, 27);
        welcometext.setFont(welcomefont);
        welcometext.setFill(Color.RED);

        Text choosetext = new Text("Please Select type of user");
        Font choosefont = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 18);
        choosetext.setFont(choosefont);
        choosetext.setFill(Color.BLACK);

        ImageView imageView = new ImageView(new Image("file:/C:/Users/PCQQ/OneDrive/Desktop/prog3-project/hospital-logo.jpeg"));
        imageView.setFitWidth(300);
        imageView.setFitHeight(230);

        HBox welcomepagebuttons = new HBox();
        Font welcomefontbtn=Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,16);

        Button doctorbtn = new Button("Doctor");
        doctorbtn.setPadding(new Insets(10));
        doctorbtn.setFont(welcomefontbtn);
        doctorbtn.setTextFill(Color.WHITE);
        doctorbtn.setStyle("-fx-background-color: red;"+
                "-fx-background-radius: 100;");
        this.dctrbtn = doctorbtn;

        doctorbtn.setOnMouseEntered(e->{
            doctorbtn.setStyle("-fx-background-color: white;"+
                    "-fx-background-radius: 100;");
            doctorbtn.setTextFill(Color.RED);
        });

        doctorbtn.setOnMouseExited(e->{
            doctorbtn.setStyle("-fx-background-color: red;"+
                    "-fx-background-radius: 100;");
            doctorbtn.setTextFill(Color.WHITE);
        });


        Button patientbtn = new Button("Patient");
        patientbtn.setPadding(new Insets(10));
        patientbtn.setFont(welcomefontbtn);
        patientbtn.setTextFill(Color.WHITE);
        patientbtn.setStyle("-fx-background-color: red;"+
                "-fx-background-radius: 100;");
        this.patientbtn = patientbtn;

        patientbtn.setOnMouseEntered(e->{
            patientbtn.setStyle("-fx-background-color: white;"+
                    "-fx-background-radius: 100;");
            patientbtn.setTextFill(Color.RED);
        });

        patientbtn.setOnMouseExited(e->{
            patientbtn.setStyle("-fx-background-color: red;"+
                    "-fx-background-radius: 100;");
            patientbtn.setTextFill(Color.WHITE);
        });

        welcomepagebuttons.setAlignment(Pos.CENTER);
        welcomepagebuttons.setSpacing(20);
        welcomepagebuttons.getChildren().addAll(doctorbtn, patientbtn);

        welcomepage.getChildren().addAll(welcometext, imageView, choosetext, welcomepagebuttons);
        welcomepage.setSpacing(20);
        welcomepage.setAlignment(Pos.CENTER);
        welcomepage.setStyle("-fx-background-color: white;");
        return welcomepage;
    }

    /*======================WELCOME PAGE SETTERS/GETTERS======================*/
    public Button getdoctorbtn(){
        return dctrbtn;
    }
    public Button getpatientbtn(){
        return patientbtn;
    }
}
