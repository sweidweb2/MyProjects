package com.example.demo3;

import javafx.animation.*;
import java.io.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.geometry.HPos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Rectangle;
import javafx.animation.RotateTransition;
import javafx.util.Duration;
import javafx.scene.control.ComboBox;
import java.util.ArrayList;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javafx.application.Application.launch;

public class Main2 extends Application{

    public void start(Stage primaryStage) {

        //class create interfaces
        Welcomepage mywelcomepage=new Welcomepage();
        Patiententerfaces mypatientinterfaces=new Patiententerfaces();
        Doctorinterfaces mydoctorinterfaces=new Doctorinterfaces();
        Javadbms myjavadbms=new Javadbms();
        doctorlogin mydctrlogincheckup=new doctorlogin();
        Patientloginandsignup mypatientloginandsignupcheck=new Patientloginandsignup();
        //myloginandsignupcheck.addpatients();



        //========================================WELCOME PAGE========================================\\
        Scene welcomescene = new Scene(mywelcomepage.getwelcomepage(), 450, 400);
        primaryStage.setScene(welcomescene);
        primaryStage.setTitle("Welcome page");
        //Scene phomepage=new Scene(mypatientinterfaces.getpatienthomepage("20231009"),1200,690);
        //primaryStage.setScene(phomepage);
        //Scene dhomepage=new Scene(mydoctorinterfaces.getdoctorhomepage("1"),1200,690);
        //primaryStage.setScene(dhomepage);


        primaryStage.show();

        //========================================PATIENT PAGES========================================\\
        mywelcomepage.getpatientbtn().setOnAction(e->{
            Scene patientloginscene=new Scene(mypatientinterfaces.getpatientlogin(), 600, 430);
            primaryStage.setScene(patientloginscene);

            //back button is tapped(from patient login to welcome page)
            mypatientinterfaces.getpatientbackbtn().setOnAction(e1->{
                primaryStage.setScene(welcomescene);
            });

            //login btn is tapped in the login page
            mypatientinterfaces.getpatientloginbtn().setOnAction(e3->{

                if(mypatientloginandsignupcheck.checkpatientfromlogin(mypatientinterfaces.getpatientloginidtf().getText(),mypatientinterfaces.getpatientloginpasstf().getText())){
                    Scene patienthomepagescene=new Scene(mypatientinterfaces.getpatienthomepage(mypatientinterfaces.getpatientloginidtf().getText()),1250,700);
                    primaryStage.setScene(patienthomepagescene);
                    mypatientinterfaces.getitem5signout().setOnMouseClicked(e1->{
                    primaryStage.setScene(patientloginscene);
                    primaryStage.show();
                    });

                }else{
                    System.out.println("not found");
                }

            });

            //forwarded from patient signin to patient register
            mypatientinterfaces.getpatientsignuphl().setOnAction(e2->{
                Scene patientregisterscene=new Scene(mypatientinterfaces.getpatientregister(), 750, 800);
                primaryStage.setScene(patientregisterscene);

                //returned from patient register to patient signin
                mypatientinterfaces.getpregbackbtn().setOnAction(e3->{
                    primaryStage.setScene(patientloginscene);
                });

                //patient register forwarded to sign in
                mypatientinterfaces.getpregsigninforward().setOnAction(e4->{
                    primaryStage.setScene(patientloginscene);
                });

                //patient register btn is tapped
                mypatientinterfaces.getpregister().setOnAction(e3->{
                        mypatientinterfaces.getpregerrortext().setText("");
                        int k=0;

                        //checking fname
                        try {
                            mypatientinterfaces.validateAlphabeticalInput(mypatientinterfaces.getpregfnametf().getText());
                        } catch (InputMismatchException ex) {
                            mypatientinterfaces.getpregfnametf().clear();
                            mypatientinterfaces.getpregerrortext().setText("Enter your first name correctly! ");
                            k++;
                        }

                        //checking lname
                        try {
                            mypatientinterfaces.validateAlphabeticalInput(mypatientinterfaces.getpreglnametf().getText());
                        } catch (InputMismatchException ex) {
                            mypatientinterfaces.getpreglnametf().clear();
                            mypatientinterfaces.getpregerrortext().setText(mypatientinterfaces.getpregerrortext().getText()+"\nEnter your last name correctly!");
                            k++;
                        }
                        //checking age
                        if(mypatientinterfaces.getpregagecombobox().getValue()==null){
                            mypatientinterfaces.getpregerrortext().setText(mypatientinterfaces.getpregerrortext().getText()+"\nEnter your age correctly!");
                            k++;
                        }

                        //checking phone number
                        if(mypatientinterfaces.getpregphonenbtf().getText().length()!=8){
                            mypatientinterfaces.getpregerrortext().setText(mypatientinterfaces.getpregerrortext().getText()+"\nEnter your phone number correctly!");
                            k++;
                        }

                        //checking id
                        if(mypatientinterfaces.getpregidtf().getText().isEmpty()){
                            mypatientinterfaces.getpregerrortext().setText(mypatientinterfaces.getpregerrortext().getText()+"\nGenerate your id!");
                            k++;
                        }

                        //checking password
                        if(!mypatientinterfaces.isValidPassword(mypatientinterfaces.getpregpasstf().getText())){
                            mypatientinterfaces.getpregerrortext().setText(mypatientinterfaces.getpregerrortext().getText()+"\nEnter your password correctly!");
                            k++;
                        }

                        //checking confirm password
                        if(!mypatientinterfaces.getpregpasstf().getText().equals(mypatientinterfaces.getpregcpasstf().getText())){
                            mypatientinterfaces.getpregerrortext().setText(mypatientinterfaces.getpregerrortext().getText()+"\nEnter your confirm password correctly!");
                            k++;
                        }

                        //checking gender radio buttons
                        String genderselected="male";
                        if (!mypatientinterfaces.getpregmaleradiobtn().isSelected() && !mypatientinterfaces.getpregfemaleradiobtn().isSelected()){
                            mypatientinterfaces.getpregerrortext().setText(mypatientinterfaces.getpregerrortext().getText()+"\nEnter your gender correctly!");
                            k++;
                        } else if (mypatientinterfaces.getpregmaleradiobtn().isSelected()) {
                            genderselected="male";
                        }else if (mypatientinterfaces.getpregfemaleradiobtn().isSelected()) {
                            genderselected="female";
                        }

                        //if all information are correct go sign in with this account you created
                        if(k==0){
                            primaryStage.setScene(patientloginscene);
                            mypatientloginandsignupcheck.addpatients(mypatientinterfaces.getpregidtf().getText(),
                                                                        mypatientinterfaces.getpregpasstf().getText(),
                                                                        mypatientinterfaces.getpregfnametf().getText(),
                                                                        mypatientinterfaces.getpreglnametf().getText(),
                                                                        mypatientinterfaces.getpregagecombobox().getValue(),
                                                                        genderselected,
                                                                        mypatientinterfaces.getpregphonenbtf().getText());

                        }
                });

            });

        });

        //========================================DOCTOR PAGES========================================\\
        mywelcomepage.getdoctorbtn().setOnAction(e->{
            Scene doctorloginscene=new Scene(mydoctorinterfaces.getdoctorlogin(), 600, 520);
            primaryStage.setScene(doctorloginscene);

            //back button is tapped(from doctor login to welcome page)
            mydoctorinterfaces.getdoctorbackbtn().setOnAction(e1->{
                primaryStage.setScene(welcomescene);
            });

            //login btn is tapped in the login page
            mydoctorinterfaces.getDoctorloginbtn().setOnAction(e3->{

                if(mydctrlogincheckup.checkdoctorfromlogin(mydoctorinterfaces.getDoctoridinput().getText(),mydoctorinterfaces.getDoctorpassinput().getText())){
                    Scene doctorhomepagescene=new Scene(mydoctorinterfaces.getdoctorhomepage(mydoctorinterfaces.getDoctoridinput().getText()),1250,700);
                    primaryStage.setScene(doctorhomepagescene);

                    mydoctorinterfaces.getDoctorhomesignout().setOnMouseClicked(e1->{
                        primaryStage.setScene(doctorloginscene);
                        primaryStage.show();
                    });

                    /*mydoctorinterfaces.getPhomesidebaritem1().setOnMouseClicked(e1->{
                        Scene doctorhomepagescenemain=new Scene(mydoctorinterfaces.getdoctorhomepage(mydoctorinterfaces.getDoctoridinput().getText(),mydoctorinterfaces.getdoctormainhomepage(mydoctorinterfaces.getDoctoridinput().getText())),1200,690);
                        primaryStage.setScene(doctorhomepagescenemain);
                    });*/

                    /*mydoctorinterfaces.getPhomesidebaritem3().setOnMouseClicked(e1->{
                        Scene doctorhomepagescenemain=new Scene(mydoctorinterfaces.getdoctorhomepage(mydoctorinterfaces.getDoctoridinput().getText(),mydoctorinterfaces.adjustpatientpage(mydoctorinterfaces.getDoctoridinput().getText())),1200,690);
                        primaryStage.setScene(doctorhomepagescenemain);
                    });*/

                }else{
                    System.out.println("not found");
                }

            });

        });

    }
    public static void main(String[] args) {
        launch(args);
    }
}

