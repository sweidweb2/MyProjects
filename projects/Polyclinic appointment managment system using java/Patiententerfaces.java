package com.example.demo3;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.skin.TableHeaderRow;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Patiententerfaces {
    //patient login
    private Button patientbackbtn;
    private Button patientregister;
    private Button pationtloginbtn;
    private TextField patientloginidtf;
    private TextField patientloginpasstf;

    //patient register
    private TextField pregfnametf;
    private TextField preglnametf;
    private TextField pregidgenerated;
    private TextField pregpasstf;
    private TextField pregcpasstf;
    private Button pregister;
    private Button pregsigninforward;
    private Button pregbackbtn;
    private ComboBox<Integer> pregagecombobox;
    private TextField pregphonenbinput;
    private RadioButton pregmalegeradiobtn;
    private RadioButton pregfemalegeradiobtn;
    private Text pregerrortext;

    //patient home page
    private HBox previosappointements;
    private HBox appointementreservation;
    private HBox accountsetting;
    private HBox accountsignout;
    private TableView table = new TableView();
    private ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
    private BorderPane patienthomepage;
    private HBox phomesidebaritem5;
    private String coco="-fx-background-color: linear-gradient(to right, #0766AD,#29ADB2);",
            dodo="-fx-background-color:linear-gradient(to right, #0766AD,#29ADB2);",
            soso="-fx-background-color:lightgrey;",
            lolo="-fx-background-color:#0766AD;";

    /*======================PATIENT LOGIN======================*/
    public BorderPane getpatientlogin(){
        BorderPane patientloginpage=new BorderPane();

        VBox leftpatientcontent=new VBox();
        leftpatientcontent.setAlignment(Pos.CENTER);

        Text patientlogintitle=new Text("Log In");
        Font patientloginfont = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30);
        patientlogintitle.setFont(patientloginfont);

        //id input
        VBox patientusernamelabel=new VBox();

        HBox patientusernamedesc=new HBox();
        ImageView usericon=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/icons8-user-48.png"));
        usericon.setFitWidth(15);
        usericon.setFitHeight(15);
        Text patientusernametext=new Text("ID:");
        Font usernameloginfont = Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 15);
        patientusernametext.setFont(usernameloginfont);

        patientusernamedesc.getChildren().addAll(usericon,patientusernametext);
        patientusernamedesc.setSpacing(5);

        TextField patientusernameinput=new TextField();
        this.patientloginidtf=patientusernameinput;
        patientusernameinput.setStyle(
                "-fx-border-color: black; " + // Border color
                "-fx-border-width: 0 0 1 0; " + // Bottom border only
                "-fx-background-color: transparent;" // Transparent background
        );

        patientusernamelabel.getChildren().addAll(patientusernamedesc,patientusernameinput);

        //password input
        VBox patientpasslabel=new VBox();

        HBox patientpassdesc=new HBox();
        ImageView passicon=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/red-icons8-password-50.png"));
        passicon.setFitWidth(15);
        passicon.setFitHeight(15);
        Text patientpasstext=new Text("Password");
        //passtext.setFill(Color.RED);
        Font patientpassloginfont = Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 15);
        patientpasstext.setFont(patientpassloginfont);

        patientpassdesc.getChildren().addAll(passicon,patientpasstext);
        patientpassdesc.setSpacing(5);

        TextField patientpassinput=new TextField();
        this.patientloginpasstf=patientpassinput;
        patientpassinput.setStyle(
                "-fx-border-color: black; " + // Border color
                "-fx-border-width: 0 0 1 0; " + // Bottom border only
                "-fx-background-color: transparent;" // Transparent background
        );

        patientpasslabel.getChildren().addAll(patientpassdesc,patientpassinput);

        //done left side
        leftpatientcontent.setSpacing(40);
        leftpatientcontent.setAlignment(Pos.CENTER);

        //right side
        ImageView rightimg=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/hospital-logo.jpeg"));
        VBox rightpatientcontent=new VBox(rightimg);
        rightpatientcontent.setAlignment(Pos.CENTER);

        //bottom login button
        Button patientloginpagebutton=new Button("Log In");
        this.pationtloginbtn=patientloginpagebutton;
        Font patientloginbtnfont = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 15);
        patientloginpagebutton.setFont(patientloginbtnfont);
        patientloginpagebutton.setPrefWidth(250);
        patientloginpagebutton.setStyle(
                "-fx-background-color: red;" +
                "-fx-text-fill: white;" +
                "-fx-border-color: transparent;" + // No borders
                "-fx-background-radius: 100;" + // Border radius of 30
                "-fx-padding: 10 20;" // Padding to give some space around the text
        );

        //top back btn
        Button patientloginbackbtn=new Button(" <- Back");
        patientloginbackbtn.setStyle(
                "-fx-background-color: white;" +
                        "-fx-text-fill: black;" +
                        "-fx-border-color: transparent;" + // No borders
                        "-fx-background-radius: 100;" + // Border radius of 30
                        "-fx-padding: 10 20;" // Padding to give some space around the text
        );
        this.patientbackbtn=patientloginbackbtn;
        ImageView returnfrompatientloginimg=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/backward-solid.svg"));
        HBox returnfrompatientlogin=new HBox(returnfrompatientloginimg,patientloginbackbtn);
        Insets margin = new Insets(10, 20, 10, 20);
        returnfrompatientlogin.setMargin(patientloginbackbtn, margin);

        //register new account
        Text signuptext=new Text("NEW? SIGN UP!");
        Button patientregisterhyperlink=new Button("sign up");
        patientregisterhyperlink.setStyle(
                "-fx-background-color: white;" +
                        "-fx-text-fill: red;" +
                        "-fx-border-color: transparent;"
        );
        this.patientregister=patientregisterhyperlink;
        patientregisterhyperlink.setTextFill(Color.RED);

        HBox signhb=new HBox();
        signhb.setAlignment(Pos.CENTER);
        signhb.setSpacing(20);
        signhb.getChildren().addAll(signuptext,patientregisterhyperlink);

        leftpatientcontent.getChildren().addAll(patientlogintitle,patientusernamelabel,patientpasslabel,patientloginpagebutton);
        patientloginpage.setCenter(leftpatientcontent);
        patientloginpage.setRight(rightpatientcontent);
        patientloginpage.setTop(returnfrompatientlogin);
        patientloginpage.setBottom(signhb);

        //borderpane style
        patientloginpage.setStyle("-fx-background-color: white;");
        patientloginpage.setMargin(leftpatientcontent, new Insets(30, 30, 30, 30));

        return  patientloginpage;
    }

    /*=============================================PATIENT REGISTER=============================================*/
    public BorderPane getpatientregister(){
        BorderPane patientregisterpage=new BorderPane();
        Font patientregisterfont=new Font(14);
        VBox patientregisterinputs=new VBox();
        patientregisterinputs.setPadding(new Insets(25));

        HBox registerpatientfullname=new HBox();
        registerpatientfullname.setSpacing(20);

        Font patientregistertitlefont=Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,24);
        Text patientregistertitle=new Text("Patient Register");
        patientregistertitle.setFont(patientregistertitlefont);


        VBox registerpatientfnamelabel=new VBox();
        Text registerpatientfname=new Text("First Name:");
        registerpatientfname.setFont(patientregisterfont);
        TextField registerpatientfnameinput=new TextField();
        this.pregfnametf=registerpatientfnameinput;
        registerpatientfnameinput.setPrefWidth(205);
        registerpatientfnameinput.setStyle(
                "-fx-border-color: black; " + // Border color
                        "-fx-border-width: 0 0 1 0; " + // Bottom border only
                        "-fx-background-color: transparent;" // Transparent background
        );
        registerpatientfnamelabel.getChildren().addAll(registerpatientfname,registerpatientfnameinput);

        VBox registerpatientlnamelabel=new VBox();
        Text registerpatientlname=new Text("Last Name:");
        registerpatientlname.setFont(patientregisterfont);
        TextField registerpatientlnameinput=new TextField();
        this.preglnametf=registerpatientlnameinput;
        registerpatientlnameinput.setPrefWidth(205);
        registerpatientlnameinput.setStyle(
                "-fx-border-color: black; " + // Border color
                        "-fx-border-width: 0 0 1 0; " + // Bottom border only
                        "-fx-background-color: transparent;" // Transparent background
        );
        registerpatientlnamelabel.getChildren().addAll(registerpatientlname,registerpatientlnameinput);

        registerpatientfullname.getChildren().addAll(registerpatientfnamelabel,registerpatientlnamelabel);

        //age__contact
        HBox patientagecontactcontainer=new HBox();

        VBox registerpatientagelabel=new VBox();
        Text registerpatientage=new Text("Age:");
        registerpatientage.setFont(patientregisterfont);

        ArrayList<Integer> patientagearraylist=new ArrayList<Integer>();
        for (int i=0;i<120;i++){
            patientagearraylist.add(i);
        }

        ComboBox<Integer> patientagecombobox=new ComboBox<>();
        patientagecombobox.setItems(FXCollections.observableList(patientagearraylist));
        this.pregagecombobox=patientagecombobox;
        patientagecombobox.show();
        patientagecombobox.setPrefWidth(205);

        registerpatientagelabel.getChildren().addAll(registerpatientage,patientagecombobox);

        VBox registerpatientphonenblabel=new VBox();
        Text registerpatientphonenb=new Text("Phone Number:");
        registerpatientphonenb.setFont(patientregisterfont);
        TextField registerpatientcontactinput=new TextField();
        registerpatientcontactinput.setPromptText("+961");
        this.pregphonenbinput=registerpatientcontactinput;
        registerpatientcontactinput.setPrefWidth(205);
        registerpatientcontactinput.setStyle(
                "-fx-border-color: black; " + // Border color
                        "-fx-border-width: 0 0 1 0; " + // Bottom border only
                        "-fx-background-color: transparent;" // Transparent background
        );
        registerpatientphonenblabel.getChildren().addAll(registerpatientphonenb,registerpatientcontactinput);
        patientagecontactcontainer.setSpacing(20);
        patientagecontactcontainer.getChildren().addAll(registerpatientagelabel,registerpatientphonenblabel);

        //id generator
        HBox registerpatientidcontainer=new HBox();

        VBox registeridgeneratorlabel=new VBox();
        Text registerpatientid=new Text("Generate:");
        registerpatientid.setFont(patientregisterfont);

        Button registerpatientidgeneratorbtn=new Button("Generator");
        registerpatientidgeneratorbtn.setPrefWidth(205);

        registeridgeneratorlabel.getChildren().addAll(registerpatientid,registerpatientidgeneratorbtn);

        VBox registerpatientidgeneratedlabel=new VBox();

        Text registerpatientidgenerated=new Text("ID:");
        registerpatientidgenerated.setFont(patientregisterfont);

        TextField registerpatientidgeneratedtf=new TextField();
        registerpatientidgeneratedtf.setPromptText("id of 8 characters");
        registerpatientidgeneratedtf.setEditable(false);
        //id variable
        int currentYear = LocalDate.now().getYear();
        Random random = new Random();
        registerpatientidgeneratedtf.setPrefWidth(205);
        registerpatientidgeneratedtf.setStyle(
                "-fx-border-color: black; " + // Border color
                "-fx-border-width: 0 0 1 0; " + // Bottom border only
                "-fx-background-color: transparent;" // Transparent background
        );
        //if generate is tapped
        registerpatientidgeneratorbtn.setOnAction(e->{
            int randomNumber=1000 + random.nextInt(9000);
            registerpatientidgeneratedtf.setText(String.valueOf(currentYear)+String.valueOf(randomNumber));

        });
        this.pregidgenerated=registerpatientidgeneratedtf;
        registerpatientidgeneratedlabel.getChildren().addAll(registerpatientidgenerated,registerpatientidgeneratedtf);
        registerpatientidcontainer.setSpacing(20);
        registerpatientidcontainer.getChildren().addAll(registeridgeneratorlabel,registerpatientidgeneratedlabel);

        //password input
        VBox registerpatientpasswordlabel=new VBox();
        Text registerpatientpassword=new Text("Password:");
        registerpatientpassword.setFont(patientregisterfont);
        TextField registerpatientpasswordinput=new TextField();
        this.pregpasstf=registerpatientpasswordinput;
        registerpatientpasswordinput.setStyle(
                "-fx-border-color: black; " + // Border color
                        "-fx-border-width: 0 0 1 0; " + // Bottom border only
                        "-fx-background-color: transparent;" // Transparent background
        );
        registerpatientpasswordlabel.getChildren().addAll(registerpatientpassword,registerpatientpasswordinput);

        //confirm password
        VBox registerpatientconfirmpasswordlabel=new VBox();
        Text registerpatientconfirmpassword=new Text("Confirm Password:");
        registerpatientconfirmpassword.setFont(patientregisterfont);
        TextField registerpatientconfirmpasswordinput=new TextField();
        this.pregcpasstf=registerpatientconfirmpasswordinput;
        registerpatientconfirmpasswordinput.setStyle(
                "-fx-border-color: black; " + // Border color
                        "-fx-border-width: 0 0 1 0; " + // Bottom border only
                        "-fx-background-color: transparent;" // Transparent background
        );
        registerpatientconfirmpasswordlabel.getChildren().addAll(registerpatientconfirmpassword,registerpatientconfirmpasswordinput);

        //gender checkboxes
        HBox patientgendertgcontainer=new HBox();
        ToggleGroup patientgendertg=new ToggleGroup();

        RadioButton patientgendermale=new RadioButton("Male");
        patientgendermale.setToggleGroup(patientgendertg);
        this.pregmalegeradiobtn=patientgendermale;

        RadioButton patientgenderfemale=new RadioButton("Female");
        patientgenderfemale.setToggleGroup(patientgendertg);
        this.pregfemalegeradiobtn=patientgenderfemale;

        patientgendertgcontainer.setSpacing(20);
        patientgendertgcontainer.getChildren().addAll(patientgendermale,patientgenderfemale);

        //error message
        HBox registerpatientpassworderror=new HBox();
        registerpatientpassworderror.setAlignment(Pos.CENTER);
        registerpatientpassworderror.setPadding(new Insets(5));
        registerpatientpassworderror.setPrefWidth(300);
        registerpatientpassworderror.setStyle("-fx-background-color: lightyellow;");
        Text registerpatientpassworderrortext=new Text("Create a strong password.The password" +
                " that you choose is used to unlock your" +
                " Desktop.com Password manager");
        this.pregerrortext=registerpatientpassworderrortext;
        registerpatientpassworderrortext.setWrappingWidth(300);
        registerpatientpassworderrortext.setFill(Color.BROWN);
        registerpatientpassworderror.getChildren().addAll(registerpatientpassworderrortext);

        //register button
        Button patirnregisterbtn=new Button("Register");
        this.pregister=patirnregisterbtn;
        patirnregisterbtn.setStyle("-fx-background-color: red;"+
                "-fx-background-radius: 100;");
        patirnregisterbtn.setTextFill(Color.WHITE);
        patirnregisterbtn.setPrefWidth(300);
        patirnregisterbtn.setPadding(new Insets(10));
        patirnregisterbtn.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,16));

        //sign in forward
        Text patientsigninforward=new Text("Already have an account?!");
        Button patientregistertopatientsignin=new Button("Sign In");
        this.pregsigninforward=patientregistertopatientsignin;
        patientregistertopatientsignin.setStyle(
                "-fx-background-color: white;" +
                "-fx-text-fill: red;" +
                "-fx-border-color: transparent;");
        patientregistertopatientsignin.setTextFill(Color.RED);

        HBox signhb=new HBox();
        signhb.setAlignment(Pos.CENTER);
        signhb.setSpacing(20);
        signhb.getChildren().addAll(patientsigninforward,patientregistertopatientsignin);

        //go backward
        Button pregbackbtn=new Button(" <- Back");
        pregbackbtn.setStyle(
                "-fx-background-color: white;" +
                "-fx-text-fill: black;" +
                "-fx-border-color: transparent;" + // No borders
                "-fx-background-radius: 100;" + // Border radius of 30
                "-fx-padding: 10 20;" // Padding to give some space around the text
        );
        this.pregbackbtn=pregbackbtn;
        HBox returnfrompatientregister=new HBox(pregbackbtn);
        Insets margin = new Insets(10, 20, 10, 20);
        returnfrompatientregister.setMargin(pregbackbtn, margin);

        //adding the right image
        ImageView registerpatientrightimg=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/hospital-logo.jpeg"));
        VBox rightpatientregisterpagecontent=new VBox(registerpatientrightimg);
        rightpatientregisterpagecontent.setAlignment(Pos.CENTER);

        //adding them to the input vbox
        //patientregisterinputs.setStyle("-fx-border-color: black; -fx-border-width: 2;");
        patientregisterinputs.setSpacing(30);
        patientregisterinputs.setAlignment(Pos.CENTER);
        patientregisterinputs.getChildren().addAll(
                patientregistertitle,
                registerpatientfullname,
                patientagecontactcontainer,
                registerpatientidcontainer,
                registerpatientpasswordlabel,
                registerpatientconfirmpasswordlabel,
                patientgendertgcontainer,
                registerpatientpassworderror,
                patirnregisterbtn,
                signhb);

        //give the vboxes location in the borderpane
        patientregisterpage.setStyle("-fx-background-color: white;");
        patientregisterpage.setCenter(patientregisterinputs);
        patientregisterpage.setRight(rightpatientregisterpagecontent);
        patientregisterpage.setTop(returnfrompatientregister);


        return patientregisterpage;
    }
    /*=============================================PATIENT home page=============================================*/
    Boolean center=true;
    public BorderPane getpatienthomepage(String patientid){
        Patientloginandsignup mypatientloginandsignup=new Patientloginandsignup();
        BorderPane patienthomepage=new BorderPane();
        this.patienthomepage=patienthomepage;

        HBox phomenav=new HBox();
        //styling my navbar
        phomenav.setStyle(dodo);
        phomenav.setAlignment(Pos.CENTER);
        phomenav.setSpacing(10);
        phomenav.setPadding(new Insets(10));

        //Text phomenavtext=new Text("Welcome, "+mypatientloginandsignup.getpatientbyid(patientid));
        //phomenavtext.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,16));
        ImageView phomenavimg=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/hospital-logo.jpeg"));
        phomenavimg.setFitWidth(55);
        phomenavimg.setFitHeight(45);

        //font for the items
        Font itemsfont=Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,16);
        //item 0 in my nav
        Font itemsfonttop=Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,13);
        HBox phomesidebaritem0=new HBox();

        Text phomesidebaritem0text=new Text("Dashboard Form");
        phomesidebaritem0text.setFill(Color.WHITE);
        phomesidebaritem0text.setFont(itemsfont);
        phomesidebaritem0.getChildren().addAll(phomesidebaritem0text);
            //styling item0
            phomesidebaritem0.setStyle("-fx-background-color: transparent;" +
                                        "-fx-background-radius: 10;"+
                                        "-fx-border-color: white;"+
                                        "-fx-border-width: 0 0 0 5;");
        phomesidebaritem0.setPadding(new Insets(10));

        phomenav.setHgrow(phomesidebaritem0, javafx.scene.layout.Priority.ALWAYS);

        //item01 in the top the clock
        HBox phomesidebaritem01=new HBox();
        Label dateLabel = new Label();
        // Get the current local date
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        // Create a DateTimeFormatter with a custom pattern for hours and minutes
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Format the current time using the formatter
        String formattedTime = currentTime.format(formatter);

        // Display the local date in the Label01
        dateLabel.setText(formattedTime.toString()+" | "+currentDate.toString());
        dateLabel.setFont(itemsfonttop);
        dateLabel.setTextFill(Color.WHITE);

        HBox activecontainer=new HBox();
        Text item01text1=new Text("Welcome, "+mypatientloginandsignup.getpatientbyid(patientid).toUpperCase());
        item01text1.setFont(itemsfonttop);
        item01text1.setFill(Color.WHITE);

        Circle item01circle=new Circle(5);
        item01circle.setFill(Color.GREEN);

        Text item01text=new Text("Active");
        item01text.setFont(itemsfont);
        item01text.setFill(Color.WHITE);

        ImageView phomesidebaritem0img=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/icons8-user-48white.png"));
        phomesidebaritem0img.setFitHeight(24);
        phomesidebaritem0img.setFitWidth(24);

        activecontainer.getChildren().addAll(phomesidebaritem0img,item01text,item01circle);
        activecontainer.setSpacing(5);
        activecontainer.setAlignment(Pos.CENTER);

        phomesidebaritem01.getChildren().addAll(dateLabel,item01text1,activecontainer);
        phomesidebaritem01.setSpacing(50);
        //styling item01
        phomesidebaritem01.setStyle("-fx-background-color: transparent;" +
                                    "-fx-background-radius: 10;");
        phomesidebaritem01.setAlignment(Pos.CENTER_RIGHT);
        phomesidebaritem01.setPadding(new Insets(10));

        phomenav.setHgrow(phomesidebaritem01, javafx.scene.layout.Priority.ALWAYS);


        //putting top in there parent
        phomenav.getChildren().addAll(phomesidebaritem0,phomesidebaritem01);

        //sidevar
        VBox phomesidebar=new VBox();
        phomesidebar.setMaxWidth(200);


        //item 1 in my sidebar
        HBox phomesidebaritem1=new HBox();
        Text phomesidebaritem1text=new Text("Previous Appointements");
        phomesidebaritem1text.setFill(Color.WHITE);
        phomesidebaritem1text.setFont(itemsfont);
        ImageView phomesidebaritem1img=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/icons8-previous-24.png"));
        phomesidebaritem1img.setFitWidth(24);
        phomesidebaritem1img.setFitHeight(24);
        phomesidebaritem1.getChildren().addAll(phomesidebaritem1img,phomesidebaritem1text);
        //styling item1
        phomesidebaritem1.setSpacing(10);
        phomesidebaritem1.setStyle(coco +
                                    "-fx-background-radius: 10;");
        phomesidebaritem1.setPadding(new Insets(30));
        phomesidebaritem1.setAlignment(Pos.CENTER);

        //hovering
        //when mouse hover the btn
        phomesidebaritem1.setOnMouseEntered(e->{
            phomesidebaritem1.setStyle("-fx-background-color: white;"+
                                        "-fx-background-radius: 10;");
            phomesidebaritem1text.setFill(Color.BLACK);
        });

        //when mouse leave hover the btn
        phomesidebaritem1.setOnMouseExited(e->{
            phomesidebaritem1.setStyle( coco+
                                    "-fx-background-radius: 10;");
            phomesidebaritem1text.setFill(Color.WHITE);
        });

        phomesidebaritem1.setOnMouseClicked(e->{
            center=false;
            patienthomepage.setCenter(null);
            patienthomepage.setCenter(getpatienmainhomepage(patientid));
        });


        //item 2 in my sidebar
        HBox phomesidebaritem2=new HBox();
        this.appointementreservation=phomesidebaritem2;
        Text phomesidebaritem2text=new Text("Appointment Booking");
        phomesidebaritem2text.setFill(Color.WHITE);
        phomesidebaritem2text.setFont(itemsfont);
        ImageView phomesidebaritem2img=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/icons8-reserve-30.png"));
        phomesidebaritem2img.setFitWidth(24);
        phomesidebaritem2img.setFitHeight(24);
        phomesidebaritem2.getChildren().addAll(phomesidebaritem2img,phomesidebaritem2text);
            //styling item2
        phomesidebaritem2.setSpacing(10);
            phomesidebaritem2.setStyle(coco +
                                        "-fx-background-radius: 10;");
            phomesidebaritem2.setPadding(new Insets(30));
            phomesidebaritem2.setAlignment(Pos.CENTER);
        //hovering
        //when mouse hover the btn
        phomesidebaritem2.setOnMouseEntered(e->{
            phomesidebaritem2.setStyle("-fx-background-color: white;"+
                    "-fx-background-radius: 10;");
            phomesidebaritem2text.setFill(Color.BLACK);
        });

        //when mouse leave hover the btn
        phomesidebaritem2.setOnMouseExited(e->{
            phomesidebaritem2.setStyle(coco +
                    "-fx-background-radius: 10;");
            phomesidebaritem2text.setFill(Color.WHITE);
        });

        //when clicked what center appear?

        phomesidebaritem2.setOnMouseClicked(e->{
            patienthomepage.setCenter(getbookreservationpage(patientid));
        });

        //item 3 in my sidebar
        HBox phomesidebaritem3=new HBox();
        Text phomesidebaritem3text=new Text("Adjust Information");
        phomesidebaritem3text.setFill(Color.WHITE);
        phomesidebaritem3text.setFont(itemsfont);
        ImageView phomesidebaritem3img=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/icons8-adjust-50.png"));
        phomesidebaritem3img.setFitWidth(24);
        phomesidebaritem3img.setFitHeight(24);
        phomesidebaritem3.getChildren().addAll(phomesidebaritem3img,phomesidebaritem3text);
            //styling item 3
        phomesidebaritem3.setSpacing(10);
            phomesidebaritem3.setStyle(coco +
                                        "-fx-background-radius: 10;");
            phomesidebaritem3.setPadding(new Insets(30));
            phomesidebaritem3.setAlignment(Pos.CENTER);

        //hovering
        //when mouse hover the btn
        phomesidebaritem3.setOnMouseEntered(e->{
            phomesidebaritem3.setStyle("-fx-background-color: white;"+
                    "-fx-background-radius: 10;");
            phomesidebaritem3text.setFill(Color.BLACK);
        });

        //when mouse leave hover the btn
        phomesidebaritem3.setOnMouseExited(e->{
            phomesidebaritem3.setStyle(coco +
                    "-fx-background-radius: 10;");
            phomesidebaritem3text.setFill(Color.WHITE);
        });

        phomesidebaritem3.setOnMouseClicked(e->{
            Patientadjustpage mypatientadjustpage=new Patientadjustpage();
            patienthomepage.setCenter(adjustpatientpage(patientid));
        });

        //item 4 in my sidebar
        HBox phomesidebaritem4=new HBox();
        Text phomesidebaritem4text=new Text("Profile");
        phomesidebaritem4text.setFill(Color.WHITE);
        phomesidebaritem4text.setFont(itemsfont);
        ImageView phomesidebaritem4img=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/icons8-test-account-30.png"));
        phomesidebaritem4img.setFitWidth(24);
        phomesidebaritem4img.setFitHeight(24);
        phomesidebaritem4.getChildren().addAll(phomesidebaritem4img,phomesidebaritem4text);
            //styling item 4
        phomesidebaritem4.setSpacing(10);
            phomesidebaritem4.setStyle(coco +
                                        "-fx-background-radius: 10;");
            phomesidebaritem4.setPadding(new Insets(30));
        phomesidebaritem4.setAlignment(Pos.CENTER);
        //hovering
        //when mouse hover the btn
        phomesidebaritem4.setOnMouseEntered(e->{
            phomesidebaritem4.setStyle("-fx-background-color: white;"+
                                        "-fx-background-radius: 10;");
            phomesidebaritem4text.setFill(Color.BLACK);
        });

        //when mouse leave hover the btn
        phomesidebaritem4.setOnMouseExited(e->{
            phomesidebaritem4.setStyle(coco +
                                        "-fx-background-radius: 10;");
            phomesidebaritem4text.setFill(Color.WHITE);
        });

        phomesidebaritem4.setOnMouseClicked(e->{
            patienthomepage.setCenter(getprofileinfo(patientid));
        });


        //item 5 in my sidebar
        HBox phomesidebaritem5=new HBox();
        this.phomesidebaritem5=phomesidebaritem5;
        Text phomesidebaritem5text=new Text("Sign out");
        phomesidebaritem5text.setFill(Color.WHITE);
        phomesidebaritem5text.setFont(itemsfont);
        ImageView phomesidebaritem5img=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/icons8-sign-out-30.png"));
        phomesidebaritem5img.setFitWidth(24);
        phomesidebaritem5img.setFitHeight(24);
        phomesidebaritem5.getChildren().addAll(phomesidebaritem5img,phomesidebaritem5text);
        //styling item 5
        phomesidebaritem5.setSpacing(10);
        phomesidebaritem5.setStyle(coco +
                                    "-fx-background-radius: 10;");
        phomesidebaritem5.setPadding(new Insets(30));
        phomesidebaritem5.setAlignment(Pos.CENTER);

        //hovering
        //when mouse hover the btn
        phomesidebaritem5.setOnMouseEntered(e->{
            phomesidebaritem5.setStyle("-fx-background-color: white;"+
                                        "-fx-background-radius: 10;");
            phomesidebaritem5text.setFill(Color.RED);
        });

        //when mouse leave hover the btn
        phomesidebaritem5.setOnMouseExited(e->{
            phomesidebaritem5.setStyle(coco +
                                        "-fx-background-radius: 10;");
            phomesidebaritem5text.setFill(Color.WHITE);
        });

        //item 6 in my sidebar
        HBox phomesidebaritem6=new HBox();
        Text phomesidebaritem6text=new Text("Coming soon...");
        phomesidebaritem6text.setFill(Color.WHITE);
        phomesidebaritem6text.setFont(itemsfont);
        ImageView phomesidebaritem6img=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/icons8-coming-soon-30.png"));
        phomesidebaritem6img.setFitWidth(24);
        phomesidebaritem6img.setFitHeight(24);
        phomesidebaritem6.getChildren().addAll(phomesidebaritem6img,phomesidebaritem6text);
        //styling item 6
        phomesidebaritem6.setSpacing(10);
        phomesidebaritem6.setStyle(coco +
                                    "-fx-background-radius: 10;");
        phomesidebaritem6.setPadding(new Insets(30));
        phomesidebaritem6.setAlignment(Pos.CENTER);

        //styling of my sdiebar
        phomesidebar.getChildren().addAll(

                                            phomesidebaritem1,
                                            phomesidebaritem2,
                                            phomesidebaritem3,
                                            phomesidebaritem4,
                                            phomesidebaritem6,
                                            phomesidebaritem5);
        phomesidebar.setSpacing(20);
        phomesidebar.setPadding(new Insets(20));
        phomesidebar.setStyle("-fx-background-color: white;");




        //patienthomepage.setCenter(availabledoctors);
        patienthomepage.setTop(phomenav);
        patienthomepage.setLeft(phomesidebar);
        if(center==true) {
            patienthomepage.setCenter(getpatienmainhomepage(patientid));
        }
        return patienthomepage;
    }

    /*======================PATIENT homepage=>previous appointement======================*/

    public BorderPane getpatienmainhomepage(String patientid){
        BorderPane patienmainhomepage=new BorderPane();
        //=================================================the bar graph
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        // Create data series
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        try {

            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");
            String selectDoctorQuery = "SELECT doctor_id, COUNT(*) as repetition_count FROM appointment " +
                    "GROUP BY doctor_id " +
                    "ORDER BY repetition_count DESC " +
                    "LIMIT 3;";

            Statement statement = connection.createStatement();
            ResultSet resulttest = statement.executeQuery(selectDoctorQuery);

            while (resulttest.next()){
                series.getData().add(new XYChart.Data<>(resulttest.getString("doctor_id"),resulttest.getInt("repetition_count")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Add the series to the chart
        barChart.getData().add(series);

        // Set chart title and axis labels
        barChart.setTitle("most appointemnets made by doctors");
        xAxis.setLabel("Categories");
        yAxis.setLabel("Values");
        barChart.setPrefSize(400, 300);

        barChart.setStyle("-fx-background-color: white;"+
                            "-fx-background-radius: 10;");

        // Set the style after the chart has been displayed(coloring bars of the bar graph)
        Platform.runLater(() -> {
            for (XYChart.Data<String, Number> data : series.getData()) {
                if (data.getNode() != null) {
                    data.getNode().setStyle("-fx-bar-fill: #0766AD;");
                }
            }
        });


        //=================================================graph
        NumberAxis xAxis1 = new NumberAxis();
        NumberAxis yAxis1 = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis1, yAxis1);

        // Create data series
        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();

        int k=0;
        //appointement
        try {

            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");
            String selectDoctorQuery = "SELECT * FROM appointment WHERE patient_id='"+patientid+"'";

            Statement statement = connection.createStatement();
            ResultSet resulttest = statement.executeQuery(selectDoctorQuery);

            while (resulttest.next()){
                k++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        series1.getData().add(new XYChart.Data<>(12, k));

        // Add the series to the chart
        lineChart.getData().add(series1);

        // Set chart title and axis labels
        lineChart.setTitle("number of appointments all over year");
        xAxis.setLabel("Doctor's ID");
        yAxis.setLabel("number of appointements");
        lineChart.setPrefSize(400, 300);
        lineChart.setStyle("-fx-background-color:white;"+
                            "-fx-background-radius: 10;");
        //=================================================adding table view
        table.getItems().clear();
        if (!table.getColumns().isEmpty()) {
            // Remove the last column
            table.getColumns().clear();
        }
        Javadbms myjavadbms=new Javadbms();
        this.data=myjavadbms.patientpreviousappointements(patientid);
        //initializeDataFromDatabase();
        // Assuming your columns are id and firstname
        TableColumn<ObservableList<String>, String> patientname = new TableColumn<>("Doctor");
        patientname.setMinWidth(50);
        patientname.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));

        TableColumn<ObservableList<String>, String> doctorname = new TableColumn<>("Patient");
        //doctorname.setMinWidth(150);  // Wider width to accommodate longer names
        doctorname.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));

        TableColumn<ObservableList<String>, String> appointementdate = new TableColumn<>("Date");
        //appointementdate.setMinWidth(150);  // Wider width to accommodate longer names
        appointementdate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));

        TableColumn<ObservableList<String>, String> appointementtime = new TableColumn<>("Appointement number");
        //appointementtime.setMinWidth(150);  // Wider width to accommodate longer names
        appointementtime.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));

        TableColumn<ObservableList<String>, String> appx = new TableColumn<>(" App");
        //appx.setMinWidth(150);  // Wider width to accommodate longer names
        appx.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)+":00"));

        table.setItems(data);
        table.getColumns().addAll(patientname, doctorname,appointementdate,appointementtime,appx);
        //adding my table view into the vbox
        VBox tablevbox=new VBox(table);
        tablevbox.setMargin(table, new javafx.geometry.Insets(10, 10, 10, 10));

        //styling table view
        table.setPrefHeight(610);
        //coloring table alternatively
        /*table.setRowFactory(tv -> new TableRow<Doctor>() {
            @Override
            protected void updateItem(Doctor dctr, boolean empty) {
                super.updateItem(dctr, empty);

                if (getIndex() % 2 == 0) {
                    // Apply style to even rows
                    setStyle("-fx-background-color: white;");
                } else {
                    // Apply style to odd rows
                    setStyle("-fx-background-color: lightblue;");
                }
            }
        });*/


        //adding bar and normal graph into a vbox
        VBox myvbox=new VBox(lineChart,barChart);
        myvbox.setPadding(new Insets(10,20,10,10));
        myvbox.setSpacing(10);
        myvbox.setMargin(table, new javafx.geometry.Insets(10, 10, 10, 10));

        patienmainhomepage.setRight(myvbox);
        patienmainhomepage.setCenter(tablevbox);
        patienmainhomepage.setStyle(soso);

        return patienmainhomepage;
    }

    /*======================PATIENT homepage=>booking appointement======================*/
    public ScrollPane getbookreservationpage(String patientid){
        Javadbms myjavadbms=new Javadbms();
        return myjavadbms.availablespecializationdoctors(patientid);
    }

    /*======================PATIENT homepage=>adjust profile======================*/
    public BorderPane adjustpatientpage(String patientid){
        BorderPane adjustpatientborderpane=new BorderPane();
        try {
            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");
            String selectDoctorQuery = "SELECT * FROM patient WHERE id='"+patientid+"'";

            Statement statement = connection.createStatement();
            ResultSet resulttest = statement.executeQuery(selectDoctorQuery);

            while (resulttest.next()){
                Font adjustfont=Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,16);
                VBox adjustcenterinputs=new VBox();

                HBox adjustaccnttitlehbox=new HBox();
                adjustaccnttitlehbox.setPadding(new Insets(20));
                adjustaccnttitlehbox.setStyle(coco);

                Text adjustaccnttitletext=new Text(resulttest.getString("fname")+" "+resulttest.getString("lname")+ " Adjust Account");
                adjustaccnttitletext.setFont(adjustfont);
                adjustaccnttitletext.setFill(Color.WHITE);

                adjustaccnttitlehbox.getChildren().addAll(adjustaccnttitletext);

                //info1
                HBox adjustinfo1hbox=new HBox();

                //fname
                VBox registerpatientfnamelabel=new VBox();
                Text registerpatientfname=new Text("First Name:");
                registerpatientfname.setFill(Color.DARKBLUE);
                registerpatientfname.setFont(adjustfont);
                TextField registerpatientfnameinput=new TextField();
                registerpatientfnameinput.setText(resulttest.getString("fname"));
                this.pregfnametf=registerpatientfnameinput;
                registerpatientfnameinput.setPrefWidth(205);
                registerpatientfnameinput.setStyle(
                                "-fx-border-color: #0766AD; " + // Border color
                                "-fx-border-width: 0 0 1 0; " + // Bottom border only
                                "-fx-background-color: transparent;" // Transparent background
                );
                registerpatientfnamelabel.getChildren().addAll(registerpatientfname,registerpatientfnameinput);

                //lname
                VBox registerpatientlnamelabel=new VBox();
                Text registerpatientlname=new Text("Last Name:");
                registerpatientlname.setFill(Color.DARKBLUE);
                registerpatientlname.setFont(adjustfont);
                TextField registerpatientlnameinput=new TextField();
                registerpatientlnameinput.setText(resulttest.getString("lname"));
                this.preglnametf=registerpatientlnameinput;
                registerpatientlnameinput.setPrefWidth(205);
                registerpatientlnameinput.setStyle(
                                "-fx-border-color: #0766AD; " + // Border color
                                "-fx-border-width: 0 0 1 0; " + // Bottom border only
                                "-fx-background-color: transparent;" // Transparent background
                );
                registerpatientlnamelabel.getChildren().addAll(registerpatientlname,registerpatientlnameinput);

                //contact
                VBox registerpatientphonenblabel=new VBox();
                Text registerpatientphonenb=new Text("Phone Number:");
                registerpatientphonenb.setFill(Color.DARKBLUE);
                registerpatientphonenb.setFont(adjustfont);
                TextField registerpatientcontactinput=new TextField();
                registerpatientcontactinput.setText(resulttest.getString("contact"));
                registerpatientcontactinput.setPromptText("+961");
                this.pregphonenbinput=registerpatientcontactinput;
                registerpatientcontactinput.setPrefWidth(205);
                registerpatientcontactinput.setStyle(
                                "-fx-border-color: #0766AD; " + // Border color
                                "-fx-border-width: 0 0 1 0; " + // Bottom border only
                                "-fx-background-color: transparent;" // Transparent background
                );
                registerpatientphonenblabel.getChildren().addAll(registerpatientphonenb,registerpatientcontactinput);

                adjustinfo1hbox.getChildren().addAll(registerpatientfnamelabel,registerpatientlnamelabel,registerpatientphonenblabel);
                adjustinfo1hbox.setSpacing(80);
                //info 2
                HBox adjustinfo2hbox=new HBox();

                //pass
                VBox registerpatientpasswordlabel=new VBox();
                Text registerpatientpassword=new Text("Password:");
                registerpatientpassword.setFill(Color.DARKBLUE);
                registerpatientpassword.setFont(adjustfont);
                TextField registerpatientpasswordinput=new TextField();
                registerpatientpasswordinput.setText(resulttest.getString("pass"));
                registerpatientpasswordinput.setPrefWidth(205);
                this.pregpasstf=registerpatientpasswordinput;
                registerpatientpasswordinput.setStyle(
                                "-fx-border-color: #0766AD; " + // Border color
                                "-fx-border-width: 0 0 1 0; " + // Bottom border only
                                "-fx-background-color: transparent;" // Transparent background
                );
                registerpatientpasswordlabel.getChildren().addAll(registerpatientpassword,registerpatientpasswordinput);

                //age
                VBox registerpatientagelabel=new VBox();
                registerpatientagelabel.setSpacing(10);
                Text registerpatientage=new Text("Age:");
                registerpatientage.setFill(Color.DARKBLUE);
                registerpatientage.setFont(adjustfont);

                ArrayList<Integer> patientagearraylist=new ArrayList<Integer>();
                for (int i=0;i<120;i++){
                    patientagearraylist.add(i);
                }

                ComboBox<Integer> patientagecombobox=new ComboBox<>();
                patientagecombobox.setValue(Integer.parseInt(resulttest.getString("age")));
                patientagecombobox.setItems(FXCollections.observableList(patientagearraylist));
                this.pregagecombobox=patientagecombobox;
                patientagecombobox.show();
                patientagecombobox.setPrefWidth(205);

                registerpatientagelabel.getChildren().addAll(registerpatientage,patientagecombobox);

                //id
                VBox registerpatientidlabel=new VBox();
                Text registerpatientid=new Text("ID:");
                registerpatientid.setFill(Color.DARKBLUE);
                registerpatientid.setFont(adjustfont);
                TextField registeridinput=new TextField();
                registeridinput.setText(resulttest.getString("id"));
                registeridinput.setEditable(false);
                registeridinput.setPrefWidth(205);
                this.pregcpasstf=registeridinput;
                registeridinput.setStyle(
                                "-fx-border-color: #0766AD; " + // Border color
                                "-fx-border-width: 0 0 1 0; " + // Bottom border only
                                "-fx-background-color: transparent;" // Transparent background
                );
                registerpatientidlabel.getChildren().addAll(registerpatientid,registeridinput);

                adjustinfo2hbox.getChildren().addAll(registerpatientpasswordlabel,registerpatientagelabel,registerpatientidlabel);
                adjustinfo2hbox.setSpacing(80);
                //info 3
                HBox adjustinfo3hbox=new HBox();


                //gender
                HBox patientgendertgcontainer=new HBox();
                ToggleGroup patientgendertg=new ToggleGroup();

                RadioButton patientgendermale=new RadioButton("male");
                patientgendermale.setToggleGroup(patientgendertg);
                this.pregmalegeradiobtn=patientgendermale;

                RadioButton patientgenderfemale=new RadioButton("female");
                patientgenderfemale.setToggleGroup(patientgendertg);
                this.pregfemalegeradiobtn=patientgenderfemale;

                if(resulttest.getString("gender").equals("male")){
                    patientgendermale.setSelected(true);
                }else if(resulttest.getString("gender").equals("female")){
                    patientgenderfemale.setSelected(true);
                }

                patientgendertgcontainer.setSpacing(20);
                patientgendertgcontainer.getChildren().addAll(patientgendermale,patientgenderfemale);

                adjustinfo3hbox.getChildren().addAll(patientgendertgcontainer);
                adjustinfo3hbox.setAlignment(Pos.CENTER);
                adjustinfo3hbox.setSpacing(80);

                //updatebtn
                HBox btncontaineradjust=new HBox();
                Button updateinfobtn=new Button("Update");
                btncontaineradjust.getChildren().addAll(updateinfobtn);
                btncontaineradjust.setAlignment(Pos.CENTER);

                updateinfobtn.setStyle(
                                coco +
                                "-fx-text-fill: white;" +
                                "-fx-border-color: transparent;" + // No borders
                                "-fx-background-radius: 100;" + // Border radius of 30
                                "-fx-padding: 10 20;" // Padding to give some space around the text
                );
                updateinfobtn.setTextFill(Color.WHITE);

                //if update button is tapped
                updateinfobtn.setOnAction(e->{
                    int k=0;

                    //checking fname
                    try {
                        validateAlphabeticalInput(registerpatientfnameinput.getText());
                    } catch (InputMismatchException ex) {
                        k++;
                    }

                    //checking lname
                    try {
                        validateAlphabeticalInput(registerpatientlnameinput.getText());
                    } catch (InputMismatchException ex) {
                        k++;
                    }
                    //checking age
                    if(patientagecombobox.getValue()==null){
                        k++;
                    }

                    //checking phone number
                    if(registerpatientcontactinput.getText().length()!=8){
                        k++;
                    }

                    //checking password
                    if(!isValidPassword(registerpatientpasswordinput.getText())){
                        k++;
                    }

                    String genderselected="no gender";
                    //checking gender radio buttons
                    if (!patientgendermale.isSelected() && !patientgenderfemale.isSelected()){
                        k++;
                    }else if (patientgendermale.isSelected()) {
                        genderselected="male";
                    }else if (patientgenderfemale.isSelected()) {
                        genderselected="female";
                    }

                    //if all information are correct go sign in with this account you created
                    if(k==0){
                        System.out.println("all good");

                        try {
                            String updateDoctorQuery = "UPDATE patient SET pass='"+registerpatientpasswordinput.getText()+"'," +
                                    "fname='"+registerpatientfnameinput.getText()+"'," +
                                    "lname='"+registerpatientlnameinput.getText()+"'," +
                                    "age='"+patientagecombobox.getValue()+"'," +
                                    "gender='"+genderselected+"'," +
                                    "contact='"+registerpatientcontactinput.getText()+"' WHERE id='"+patientid+"'";

                            try(PreparedStatement preparedStatement = connection.prepareStatement(updateDoctorQuery)) {

                                // Execute the insert statement
                                preparedStatement.executeUpdate();

                                System.out.println("your information is adjusted!");

                                //connection.close();
                                Javadbms myjavadbms=new Javadbms();
                                myjavadbms.alertbookingappointement("your information is successfully updates" +
                                        "\nrefresh your page");
                            }
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                //adding to center vbox
                adjustcenterinputs.getChildren().addAll(adjustinfo1hbox,adjustinfo2hbox,adjustinfo3hbox,btncontaineradjust);
                adjustcenterinputs.setPadding(new Insets(30));
                adjustcenterinputs.setSpacing(60);
                //adding to borderpane
                adjustpatientborderpane.setTop(adjustaccnttitlehbox);
                adjustpatientborderpane.setCenter(adjustcenterinputs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return adjustpatientborderpane;

    }

    public BorderPane getprofileinfo(String patientid){
        BorderPane profileinfoborderpane=new BorderPane();
        VBox profileinfo=new VBox();
        //top
        HBox myhbox=new HBox();
        myhbox.setPadding(new Insets(20));
        myhbox.setAlignment(Pos.CENTER);
        ImageView myimageview=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/icons8-account-80.png"));
        myimageview.setFitWidth(200);
        myimageview.setFitHeight(200);
        myhbox.getChildren().add(myimageview);
        //center

        try {
            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");
            String selectDoctorQuery = "SELECT * FROM patient WHERE id='"+patientid+"'";

            Statement statement = connection.createStatement();
            ResultSet resulttest = statement.executeQuery(selectDoctorQuery);

            while (resulttest.next()){
                Font profilefont=Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,16);

                //info1
                HBox profilefullname=new HBox();

                VBox profilefnamelabel=new VBox();
                Text profilepatientfname=new Text("Full Name");
                profilepatientfname.setFill(Color.DARKBLUE);
                profilepatientfname.setFont(profilefont);
                TextField profilepatientfnameinput=new TextField();
                profilepatientfnameinput.setEditable(false);
                profilepatientfnameinput.setText(resulttest.getString("fname")+" "+resulttest.getString("lname"));
                this.pregfnametf=profilepatientfnameinput;
                profilepatientfnameinput.setPrefWidth(205);
                profilepatientfnameinput.setStyle(
                                "-fx-border-color: #0766AD; " + // Border color
                                "-fx-border-width: 0 0 1 0; " + // Bottom border only
                                "-fx-background-color: transparent;" // Transparent background
                );

                profilefnamelabel.setAlignment(Pos.CENTER);
                profilefnamelabel.getChildren().addAll(profilepatientfname,profilepatientfnameinput);
                profilefullname.getChildren().add(profilefnamelabel);
                profilefullname.setAlignment(Pos.CENTER);

                //info 2
                HBox profileidpassphone=new HBox();

                //id
                VBox registerpatientidlabel=new VBox();
                registerpatientidlabel.setAlignment(Pos.CENTER);
                Text registerpatientid=new Text("ID");
                registerpatientid.setFill(Color.DARKBLUE);
                registerpatientid.setFont(profilefont);
                TextField registeridinput=new TextField();
                registeridinput.setEditable(false);
                registeridinput.setText(resulttest.getString("id"));
                registeridinput.setEditable(false);
                registeridinput.setPrefWidth(205);
                this.pregcpasstf=registeridinput;
                registeridinput.setStyle(
                                "-fx-border-color: #0766AD; " + // Border color
                                "-fx-border-width: 0 0 1 0; " + // Bottom border only
                                "-fx-background-color: transparent;" // Transparent background
                );
                registerpatientidlabel.getChildren().addAll(registerpatientid,registeridinput);

                //contact
                VBox registerpatientphonenblabel=new VBox();
                registerpatientphonenblabel.setAlignment(Pos.CENTER);
                Text registerpatientphonenb=new Text("Phone Number");
                registerpatientphonenb.setFill(Color.DARKBLUE);
                registerpatientphonenb.setFont(profilefont);
                TextField registerpatientcontactinput=new TextField();
                registerpatientcontactinput.setEditable(false);
                registerpatientcontactinput.setText(resulttest.getString("contact"));
                registerpatientcontactinput.setPromptText("+961");
                this.pregphonenbinput=registerpatientcontactinput;
                registerpatientcontactinput.setPrefWidth(205);
                registerpatientcontactinput.setStyle(
                        "-fx-border-color: #0766AD; " + // Border color
                                "-fx-border-width: 0 0 1 0; " + // Bottom border only
                                "-fx-background-color: transparent;" // Transparent background
                );
                registerpatientphonenblabel.getChildren().addAll(registerpatientphonenb,registerpatientcontactinput);

                //pass
                VBox registerpatientpasswordlabel=new VBox();
                registerpatientpasswordlabel.setAlignment(Pos.CENTER);
                Text registerpatientpassword=new Text("Password");
                registerpatientpassword.setFill(Color.DARKBLUE);
                registerpatientpassword.setFont(profilefont);
                TextField registerpatientpasswordinput=new TextField();
                registerpatientpasswordinput.setEditable(false);
                registerpatientpasswordinput.setText(resulttest.getString("pass"));
                registerpatientpasswordinput.setPrefWidth(205);
                this.pregpasstf=registerpatientpasswordinput;
                registerpatientpasswordinput.setStyle(
                                "-fx-border-color: #0766AD; " + // Border color
                                "-fx-border-width: 0 0 1 0; " + // Bottom border only
                                "-fx-background-color: transparent;" // Transparent background
                );
                registerpatientpasswordlabel.getChildren().addAll(registerpatientpassword,registerpatientpasswordinput);
                profileidpassphone.getChildren().addAll(registerpatientidlabel,registerpatientphonenblabel,registerpatientpasswordlabel);
                profileidpassphone.setSpacing(80);
                profileidpassphone.setAlignment(Pos.CENTER);

                //info 3
                HBox profileagegendercpass=new HBox();

                //age
                VBox registerpatientagelabel=new VBox();
                registerpatientagelabel.setAlignment(Pos.CENTER);
                registerpatientagelabel.setSpacing(10);
                Text registerpatientage=new Text("Age");
                registerpatientage.setFill(Color.DARKBLUE);
                registerpatientage.setFont(profilefont);

                ArrayList<Integer> patientagearraylist=new ArrayList<Integer>();
                for (int i=0;i<120;i++){
                    patientagearraylist.add(i);
                }

                ComboBox<Integer> patientagecombobox=new ComboBox<>();
                patientagecombobox.setDisable(true);
                patientagecombobox.setValue(Integer.parseInt(resulttest.getString("age")));
                patientagecombobox.setItems(FXCollections.observableList(patientagearraylist));
                this.pregagecombobox=patientagecombobox;
                patientagecombobox.show();
                patientagecombobox.setPrefWidth(205);

                registerpatientagelabel.getChildren().addAll(registerpatientage,patientagecombobox);

                //gender
                HBox patientgendertgcontainer=new HBox();
                ToggleGroup patientgendertg=new ToggleGroup();

                RadioButton patientgendermale=new RadioButton("male");
                patientgendermale.setDisable(true);
                patientgendermale.setToggleGroup(patientgendertg);
                this.pregmalegeradiobtn=patientgendermale;

                RadioButton patientgenderfemale=new RadioButton("female");
                patientgenderfemale.setDisable(true);
                patientgenderfemale.setToggleGroup(patientgendertg);
                this.pregfemalegeradiobtn=patientgenderfemale;

                if(resulttest.getString("gender").equals("male")){
                    patientgendermale.setSelected(true);
                }else if(resulttest.getString("gender").equals("female")){
                    patientgenderfemale.setSelected(true);
                }

                patientgendertgcontainer.setAlignment(Pos.CENTER);
                patientgendertgcontainer.setSpacing(20);
                patientgendertgcontainer.getChildren().addAll(patientgendermale,patientgenderfemale);
                int k=0;
                //appointement
                try {
                    String selectDoctorQuery1 = "SELECT * FROM appointment WHERE patient_id='"+patientid+"'";

                    Statement statement1 = connection.createStatement();
                    ResultSet resulttest1 = statement1.executeQuery(selectDoctorQuery1);

                    while (resulttest1.next()){
                        k++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //appointement
                //pass
                VBox registerpatientapplabel=new VBox();
                registerpatientapplabel.setAlignment(Pos.CENTER);
                Text registerpatientapp=new Text("Appointments");
                registerpatientapp.setFill(Color.DARKBLUE);
                registerpatientapp.setFont(profilefont);
                TextField registerpatientappinput=new TextField();
                registerpatientappinput.setEditable(false);
                registerpatientappinput.setText(String.valueOf(k));
                registerpatientappinput.setPrefWidth(205);
                registerpatientappinput.setStyle(
                        "-fx-border-color: #0766AD; " + // Border color
                                "-fx-border-width: 0 0 1 0; " + // Bottom border only
                                "-fx-background-color: transparent;" // Transparent background
                );
                registerpatientapplabel.getChildren().addAll(registerpatientapp,registerpatientappinput);

                profileagegendercpass.getChildren().addAll(registerpatientagelabel,patientgendertgcontainer,registerpatientapplabel);
                profileagegendercpass.setSpacing(130);
                profileagegendercpass.setAlignment(Pos.CENTER);

                profileinfo.getChildren().addAll(profilefullname,profileidpassphone,profileagegendercpass);
                profileinfo.setSpacing(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        //setting in borderpane
        profileinfoborderpane.setTop(myhbox);
        profileinfoborderpane.setCenter(profileinfo);



        return profileinfoborderpane;
    }

    /*====================== LOGIN SETTERS/GETTERS======================*/
    public Button getpatientbackbtn(){
        return patientbackbtn;
    }
    public Button getpatientsignuphl(){
        return patientregister;
    }
    public Button getpatientloginbtn(){return pationtloginbtn;}
    public TextField getpatientloginidtf(){
        return patientloginidtf;
    }
    public TextField getpatientloginpasstf(){
        return patientloginpasstf;
    }
    public TextField getpregfnametf(){
        return pregfnametf;
    }
    public TextField getpreglnametf(){
        return preglnametf;
    }
    public TextField getpregidtf(){
        return pregidgenerated;
    }
    public TextField getpregpasstf(){
        return pregpasstf;
    }
    public TextField getpregcpasstf(){
        return pregcpasstf;
    }
    public Text getpregerrortext(){
        return pregerrortext;
    }
    public Button getpregister(){
        return pregister;
    }
    public Button getpregsigninforward(){
        return pregsigninforward;
    }
    public Button getpregbackbtn(){
        return pregbackbtn;
    }
    public TextField getpregphonenbtf(){
        return  pregphonenbinput;
    }
    public ComboBox<Integer> getpregagecombobox(){
        return pregagecombobox;
    }
    public RadioButton getpregmaleradiobtn(){
        return pregmalegeradiobtn;
    }
    public RadioButton getpregfemaleradiobtn(){
        return pregfemalegeradiobtn;
    }
    public HBox getappointementreservation(){
        return appointementreservation;
    }
    public HBox getitem5signout(){return phomesidebaritem5;}
    /*=============================================*/
    //validation functions
    public void validateAlphabeticalInput(String input) throws InputMismatchException {
        if (!input.matches("^[a-zA-Z]+$") || input.equals("") ) {
            throw new InputMismatchException("Input contains non-alphabetical characters.");
        }
    }

    public void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    //==========================================================================================
    /*public void initializeDataFromDatabase() {
        // Load JDBC driver
        try {

            // Make connection
            String url = "jdbc:mysql://localhost:3306/uaex1";
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Create statement
            Statement statement = connection.createStatement();

            // Fetch data from the users table
            ResultSet resulttest = statement.executeQuery("SELECT * FROM dept");
            while (resulttest.next()) {
                ObservableList<String> row = FXCollections.observableArrayList(
                        resulttest.getString("nom"),
                        resulttest.getString("nodept")
                );

                // Add data to ObservableList
                data.add(row);
            }

            // Cleanup
            resulttest.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
