package com.example.demo3;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Doctorinterfaces {

    //doctor login
    private Button doctorbackbtn;
    private Button doctorregister;
    private Button doctorloginbtn;
    private TextField doctoridinput;
    private TextField doctorpassinput;
    private doctorlogin mydocterloginvalidation=new doctorlogin();
    private HBox doctorhomesignout;
    private boolean center=true;
    private String coco="-fx-background-color: linear-gradient(to right, #0766AD,#29ADB2);",
            dodo="-fx-background-color:linear-gradient(to right, #0766AD,#29ADB2);",
            soso="-fx-background-color:lightgrey;",
            lolo="-fx-background-color:#0766AD;";
    /*======================DOCTOR LOGIN======================*/
    public BorderPane getdoctorlogin(){
        BorderPane doctorloginpage=new BorderPane();

        VBox leftdoctorcontent=new VBox();
        leftdoctorcontent.setAlignment(Pos.CENTER);

        Text doctorlogintitle=new Text("Log In");
        Font doctorloginfont = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30);
        doctorlogintitle.setFont(doctorloginfont);

        //id input
        VBox doctoridlabel=new VBox();

        HBox doctoriddesc=new HBox();
        ImageView idicon=new ImageView(new Image("file:/C:/Users/PCQQ/OneDrive/Desktop/prog3-project/icons8-id-48.png"));
        idicon.setFitWidth(15);
        idicon.setFitHeight(15);
        Text idtext=new Text("ID");
        Font doctoridloginfont = Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 15);
        idtext.setFont(doctoridloginfont);

        doctoriddesc.getChildren().addAll(idicon,idtext);
        doctoriddesc.setSpacing(5);

        TextField doctoridinput=new TextField();
        this.doctoridinput=doctoridinput;
        doctoridinput.setStyle(
                        "-fx-border-color: black; " + // Border color
                        "-fx-border-width: 0 0 1 0; " + // Bottom border only
                        "-fx-background-color: transparent;" // Transparent background
        );

        doctoridlabel.getChildren().addAll(doctoriddesc,doctoridinput);

        //password input
        VBox doctorpasslabel=new VBox();

        HBox doctorpassdesc=new HBox();
        ImageView passicon=new ImageView(new Image("file:/C:/Users/PCQQ/OneDrive/Desktop/prog3-project/red-icons8-password-50.png"));
        passicon.setFitWidth(15);
        passicon.setFitHeight(15);
        Text passtext=new Text("Password");
        //passtext.setFill(Color.RED);
        Font doctorpassloginfont = Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, 15);
        passtext.setFont(doctorpassloginfont);

        doctorpassdesc.getChildren().addAll(passicon,passtext);
        doctorpassdesc.setSpacing(5);

        TextField doctorpassinput=new TextField();
        this.doctorpassinput=doctorpassinput;
        doctorpassinput.setStyle(
                "-fx-border-color: black; " + // Border color
                        "-fx-border-width: 0 0 1 0; " + // Bottom border only
                        "-fx-background-color: transparent;" // Transparent background
        );

        doctorpasslabel.getChildren().addAll(doctorpassdesc,doctorpassinput);

        //done left side
        leftdoctorcontent.setSpacing(40);
        leftdoctorcontent.setAlignment(Pos.CENTER);

        //right side
        ImageView rightimg=new ImageView(new Image("file:/C:/Users/PCQQ/OneDrive/Desktop/prog3-project/hospital-logo.jpeg"));
        VBox rightdoctorcontent=new VBox(rightimg);
        rightdoctorcontent.setAlignment(Pos.CENTER);

        //bottom login button
        Button doctorloginpagebutton=new Button("Log In");
        this.doctorloginbtn=doctorloginpagebutton;
        Font doctorloginbtnfont = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 15);
        doctorloginpagebutton.setFont(doctorloginbtnfont);
        doctorloginpagebutton.setPrefWidth(250);
        doctorloginpagebutton.setStyle(
                "-fx-background-color: red;" +
                "-fx-text-fill: white;" +
                "-fx-border-color: transparent;" + // No borders
                "-fx-background-radius: 100;" + // Border radius of 30
                "-fx-padding: 10 20;" // Padding to give some space around the text
        );

        //top back btn
        Button doctoreloginbackbtn=new Button(" <- Back");

        doctoreloginbackbtn.setStyle(
                "-fx-background-color: white;" +
                "-fx-text-fill: black;" +
                "-fx-border-color: transparent;" + // No borders
                "-fx-background-radius: 100;" + // Border radius of 30
                "-fx-padding: 10 20;" // Padding to give some space around the text
        );
        this.doctorbackbtn=doctoreloginbackbtn;
        HBox returnfromdoctorlogin=new HBox(doctoreloginbackbtn);
        Insets margin = new Insets(10, 20, 10, 20);
        returnfromdoctorlogin.setMargin(doctoreloginbackbtn, margin);

        //fit in borderpane
        leftdoctorcontent.getChildren().addAll(doctorlogintitle,doctoridlabel,doctorpasslabel,doctorloginpagebutton);
        doctorloginpage.setCenter(leftdoctorcontent);
        doctorloginpage.setRight(rightdoctorcontent);
        doctorloginpage.setTop(returnfromdoctorlogin);

        //borderpane style
        doctorloginpage.setStyle("-fx-background-color: white;");
        doctorloginpage.setMargin(leftdoctorcontent, new Insets(30, 30, 30, 30));

        return  doctorloginpage;
    }

    private HBox phomesidebaritem3;
    private HBox phomesidebaritem1;
    //private HBox phomesidebaritem3;

    public BorderPane getdoctorhomepage(String doctorid){
        BorderPane doctorhomepage=new BorderPane();
        doctorhomepage.setCenter(getdoctormainhomepage(doctorid));
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
        Text item01text1=new Text("Welcome, "+mydocterloginvalidation.getpdoctorbyid(doctorid).toUpperCase());
        item01text1.setFont(itemsfonttop);
        item01text1.setFill(Color.WHITE);

        Circle item01circle=new Circle(5);
        item01circle.setFill(Color.GREEN);

        Text item01text=new Text("Active");
        item01text.setFont(itemsfont);
        item01text.setFill(Color.WHITE);
        ImageView item0iv=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/icons8-user-48white.png"));
        item0iv.setFitHeight(24);
        item0iv.setFitWidth(24);
        activecontainer.getChildren().addAll(item0iv,item01text,item01circle);
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
        this.phomesidebaritem1=phomesidebaritem1;
        Text phomesidebaritem1text=new Text("Previous Appointements");
        phomesidebaritem1text.setFill(Color.WHITE);
        phomesidebaritem1text.setFont(itemsfont);
        ImageView phomesidebaritem1img=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/icons8-previous-24.png"));
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
            doctorhomepage.setCenter(getdoctormainhomepage(doctorid));
        });

        //item 3 in my sidebar
        HBox phomesidebaritem3=new HBox();
        this.phomesidebaritem3=phomesidebaritem3;
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
            doctorhomepage.setCenter(adjustdoctorpage(doctorid));
        });

        //item 2 in my sidebar
        HBox phomesidebaritem2=new HBox();
        Text phomesidebaritem2text=new Text("Search Appointements");
        phomesidebaritem2text.setFill(Color.WHITE);
        phomesidebaritem2text.setFont(itemsfont);
        ImageView phomesidebaritem2img=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/icons8-search-50.png"));
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
            doctorhomepage.setCenter(getdoctorsearchpage(doctorid));
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
            doctorhomepage.setCenter(getprofileinfo(doctorid));
        });


        //item 5 in my sidebar
        HBox phomesidebaritem5=new HBox();
        this.doctorhomesignout=phomesidebaritem5;
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
        doctorhomepage.setTop(phomenav);
        doctorhomepage.setLeft(phomesidebar);


        return doctorhomepage;
    }
    private TableView table = new TableView();
    private ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
    public BorderPane getdoctormainhomepage(String doctorid){
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
            String selectDoctorQuery = "SELECT * FROM appointment WHERE doctor_id='"+doctorid+"'";

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
        this.data=mydocterloginvalidation.filldoctortabledata(doctorid);
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
    private ObservableList<ObservableList<String>> data1 = FXCollections.observableArrayList();
    private TableView searchtable = new TableView();
    public BorderPane getdoctorsearchpage(String doctorid){

        BorderPane searchborderpane=new BorderPane();

        //adding combobox and serach btn

        HBox containersearchbar=new HBox();
        containersearchbar.setPadding(new Insets(20));

        ComboBox<String> dayComboBox = new ComboBox<>();
        dayComboBox.setPrefWidth(200);
        for (int day = 0; day <= 31; day++) {
            dayComboBox.getItems().add(Integer.toString(day));
        }

        Button searchbtn=new Button("Search");
        searchbtn.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,16));
        searchbtn.setStyle(
                coco +
                        "-fx-text-fill: white;" +
                        "-fx-border-color: transparent;" + // No borders
                        "-fx-background-radius: 100;" + // Border radius of 30
                        "-fx-padding: 10 20;" // Padding to give some space around the text
        );
        containersearchbar.getChildren().addAll(dayComboBox,searchbtn);
        containersearchbar.setSpacing(550);


        //=================================================adding table view
        searchbtn.setOnAction(e->{
            searchtable.getItems().clear();
            if (!searchtable.getColumns().isEmpty()) {
                // Remove the last column
                searchtable.getColumns().clear();
            }


            this.data1=mydocterloginvalidation.filldoctortablesearchdata(doctorid,dayComboBox.getValue());
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

            searchtable.setItems(data1);
            searchtable.getColumns().addAll(patientname, doctorname,appointementdate,appointementtime,appx);
            //adding my table view into the vbox
            VBox tablevbox=new VBox(searchtable);
            tablevbox.setMargin(searchtable, new javafx.geometry.Insets(10, 10, 10, 10));

            //styling table view
            searchtable.setPrefHeight(610);
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
            searchborderpane.setCenter(tablevbox);
        });

        searchborderpane.setTop(containersearchbar);
        searchborderpane.setStyle(soso);

        return searchborderpane;
    }

    public BorderPane adjustdoctorpage(String doctorid){
        BorderPane adjustpatientborderpane=new BorderPane();
        try {
            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");
            String selectDoctorQuery = "SELECT * FROM doctor WHERE id='"+doctorid+"'";

            Statement statement = connection.createStatement();
            ResultSet resulttest = statement.executeQuery(selectDoctorQuery);

            while (resulttest.next()){
                Font adjustfont=Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,16);
                VBox adjustcenterinputs=new VBox();
                String specialization=resulttest.getString("specialization");

                HBox adjustaccnttitlehbox=new HBox();
                adjustaccnttitlehbox.setPadding(new Insets(20));
                adjustaccnttitlehbox.setStyle(coco);

                Text adjustaccnttitletext=new Text(resulttest.getString("fname")+resulttest.getString("lname")+ "Adjust Account");
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
                registerpatientpasswordinput.setEditable(false);
                registerpatientpasswordinput.setText(resulttest.getString("pass"));
                registerpatientpasswordinput.setPrefWidth(205);
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
                patientagecombobox.setDisable(true);
                patientagecombobox.setValue(Integer.parseInt(resulttest.getString("age")));
                patientagecombobox.setItems(FXCollections.observableList(patientagearraylist));
                patientagecombobox.show();
                patientagecombobox.setPrefWidth(205);

                registerpatientagelabel.getChildren().addAll(registerpatientage,patientagecombobox);

                //id
                VBox registerpatientidlabel=new VBox();
                Text registerpatientid=new Text("ID:");
                registerpatientid.setFill(Color.DARKBLUE);
                registerpatientid.setFont(adjustfont);
                TextField registeridinput=new TextField();
                registeridinput.setEditable(false);
                registeridinput.setText(resulttest.getString("id"));
                registeridinput.setEditable(false);
                registeridinput.setPrefWidth(205);
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

                RadioButton patientgenderfemale=new RadioButton("female");
                patientgenderfemale.setToggleGroup(patientgendertg);
                System.out.println(resulttest.getString("gender"));
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
                        System.out.println("fname");
                    }

                    //checking lname
                    try {
                        validateAlphabeticalInput(registerpatientlnameinput.getText());
                    } catch (InputMismatchException ex) {
                        k++;
                        System.out.println("lname");
                    }
                    //checking age
                    if(patientagecombobox.getValue()==null){
                        k++;
                        System.out.println("age");
                    }

                    //checking phone number
                    /*if(registerpatientcontactinput.getText().length()!=8){
                        k++;
                    }*/

                    /*//checking password
                    if(!isValidPassword(registerpatientpasswordinput.getText())){
                        k++;
                    }*/

                    String genderselected="no gender";
                    //checking gender radio buttons
                    if (!patientgendermale.isSelected() && !patientgenderfemale.isSelected()){
                        k++;
                        System.out.println("gender");
                    }else if (patientgendermale.isSelected()) {
                        genderselected="male";
                    }else if (patientgenderfemale.isSelected()) {
                        genderselected="female";
                    }

                    if(k!=0){
                        alertdoctormessage("enter your information correctly!");
                    }
                    //if all information are correct go sign in with this account you created
                    if(k==0){
                        System.out.println("all good");

                        try {
                            String updateDoctorQuery = "UPDATE doctor SET pass='"+registerpatientpasswordinput.getText()+"'," +
                                    "fname='"+registerpatientfnameinput.getText()+"'," +
                                    "lname='"+registerpatientlnameinput.getText()+"'," +
                                    "age='"+patientagecombobox.getValue()+"'," +
                                    "gender='"+genderselected+"'," +
                                    "contact='"+registerpatientcontactinput.getText()+"'," +
                                    "specialization='"+specialization+"' "+
                                    "WHERE id='"+doctorid+"'";

                            try(PreparedStatement preparedStatement = connection.prepareStatement(updateDoctorQuery)) {

                                // Execute the insert statement
                                preparedStatement.executeUpdate();

                                System.out.println("your information is adjusted!");

                                //connection.close();
                                alertdoctormessage("your information is successfully updates" +
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

    public BorderPane getprofileinfo(String doctorid){
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
            String selectDoctorQuery = "SELECT * FROM doctor WHERE id='"+doctorid+"'";

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
                patientagecombobox.show();
                patientagecombobox.setPrefWidth(205);

                registerpatientagelabel.getChildren().addAll(registerpatientage,patientagecombobox);

                //gender
                HBox patientgendertgcontainer=new HBox();
                ToggleGroup patientgendertg=new ToggleGroup();

                RadioButton patientgendermale=new RadioButton("male");
                patientgendermale.setDisable(true);
                patientgendermale.setToggleGroup(patientgendertg);

                RadioButton patientgenderfemale=new RadioButton("female");
                patientgenderfemale.setDisable(true);
                patientgenderfemale.setToggleGroup(patientgendertg);

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
                    String selectDoctorQuery1 = "SELECT * FROM appointment WHERE doctor_id='"+doctorid+"'";

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

    public void alertdoctormessage(String message){
        // Create an Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header
        alert.setContentText(message);

        // Show the Alert
        alert.showAndWait();
    }

    /*======================DOCTOR LOGIN SEETERS/GETTERS======================*/
    public Button getdoctorbackbtn(){
        return doctorbackbtn;
    }
    public Button getdoctorsignuphl(){
        return doctorregister;
    }

    public HBox getPhomesidebaritem3() {
        return phomesidebaritem3;
    }

    public HBox getPhomesidebaritem1() {
        return phomesidebaritem1;
    }

    public Button getDoctorloginbtn() {
        return doctorloginbtn;
    }

    public TextField getDoctoridinput() {
        return doctoridinput;
    }

    public HBox getDoctorhomesignout() {
        return doctorhomesignout;
    }

    public TextField getDoctorpassinput() {
        return doctorpassinput;
    }
    public void validateAlphabeticalInput(String input) throws InputMismatchException {
        if (!input.matches("^[a-zA-Z]+$") || input.equals("") ) {
            throw new InputMismatchException("Input contains non-alphabetical characters.");
        }
    }
    public boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
