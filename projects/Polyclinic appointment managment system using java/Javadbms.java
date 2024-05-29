package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.sql.*;
import java.time.LocalDate;
import java.time.YearMonth;

//appointemet resrvation option
public class Javadbms {
    private Button reserveappbtn;
    private Patiententerfaces mypatientinerface=new Patiententerfaces();
    private ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
    public ObservableList<ObservableList<String>> patientpreviousappointements(String patientid) {
        // Load JDBC driver
        try {

            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Create statement
            Statement statement = connection.createStatement();

            // Fetch data from the users table
            ResultSet resulttest = statement.executeQuery("SELECT * FROM appointment WHERE patient_id='"+patientid+"'");
            while (resulttest.next()) {
                ObservableList<String> row = FXCollections.observableArrayList(
                        resulttest.getString("doctor_id"),
                        resulttest.getString("patient_id"),
                        resulttest.getString("date"),
                        resulttest.getString("appointment_number")
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
        return data;
    }
    private String patientid;
    public ScrollPane availablespecializationdoctors(String patientid) {
        this.patientid=patientid;
        ScrollPane availabalescrollpane=new ScrollPane();
        VBox availabledoctors=new VBox();
        availabalescrollpane.setContent(availabledoctors);
        // Load JDBC driver
        try {

            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Create statement
            Statement statement = connection.createStatement();

            // Fetch data from the users table
            ResultSet resulttest = statement.executeQuery("SELECT * FROM doctor");
            while (resulttest.next()) {
                /*resulttest.getString("doctor_id"),id/pass/fname/lname/age/gender/contact/specialization
                resulttest.getString("patient_id"),
                resulttest.getString("date"),
                resulttest.getString("appointment_number")*/
                HBox myhbox=new HBox();
                String myspecil=resulttest.getString("specialization");
                Text mytxt1=new Text(myspecil+" Doctors");
                mytxt1.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC,20));
                mytxt1.setFill(Color.WHITE);

                Text mytxt2=new Text("1 Doctor Available");
                mytxt2.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.ITALIC,12));
                mytxt2.setFill(Color.WHITE);

                HBox bookanapphbox=new HBox();
                ImageView bookanappimageview=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/icons8-next-50.png"));
                bookanappimageview.setFitWidth(24);
                bookanappimageview.setFitHeight(24);
                Text mytxt3=new Text("Book an Appointement");
                mytxt3.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.ITALIC,20));
                mytxt3.setFill(Color.WHITE);
                bookanapphbox.getChildren().addAll(mytxt3,bookanappimageview);
                bookanapphbox.setSpacing(5);

                myhbox.getChildren().addAll(mytxt1,mytxt2,bookanapphbox);
                myhbox.setStyle("-fx-background-color: #29ADB2;"+
                                "-fx-border-width: 0;"+
                                "-fx-background-radius: 10;"+
                                "-fx-text-fill: white;");
                myhbox.setPadding(new Insets(20,10,20,10));
                myhbox.setPrefWidth(885);
                myhbox.setAlignment(Pos.CENTER);
                myhbox.setSpacing(150);

                availabledoctors.setMargin(myhbox,new Insets(10));
                availabledoctors.getChildren().add(myhbox);

                //if a specific hbox is clicked
                myhbox.setOnMouseClicked(e->{
                    availabalescrollpane.setContent(specializationavailabledoctors(myspecil));
                });
            }

            // Cleanup
            resulttest.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return availabalescrollpane;
    }
    /*=======================================available doctors for this specialization=======================================*/
    public VBox specializationavailabledoctors(String myspecil) {
        VBox availabledoctors=new VBox();
        // Load JDBC driver
        try {

            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Create statement
            Statement statement = connection.createStatement();

            // Fetch data from the users table
            ResultSet resulttest = statement.executeQuery("SELECT * FROM doctor WHERE specialization = '" + myspecil + "'");

            while (resulttest.next()) {

                HBox avmyhbox=new HBox();
                String myspecil1=resulttest.getString("specialization");
                Text mytxt1=new Text(myspecil1+" Doctors");
                mytxt1.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC,20));
                mytxt1.setFill(Color.WHITE);

                String dctrfname=resulttest.getString("fname");
                String dctrlname=resulttest.getString("lname");
                Text mytxt2=new Text("DR."+dctrfname+" "+dctrlname);
                mytxt2.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.ITALIC,12));
                mytxt2.setFill(Color.WHITE);

                HBox bookanapphbox=new HBox();
                ImageView bookanappimageview=new ImageView(new Image("file:/D:/prog-3/project/prog3-project/icons8-next-50.png"));
                bookanappimageview.setFitWidth(24);
                bookanappimageview.setFitHeight(24);
                Text mytxt3=new Text("Book an Appointement");
                mytxt3.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.ITALIC,20));
                mytxt3.setFill(Color.WHITE);
                bookanapphbox.getChildren().addAll(mytxt3,bookanappimageview);
                bookanapphbox.setSpacing(5);
                avmyhbox.getChildren().addAll(mytxt1,mytxt2,bookanapphbox);
                avmyhbox.setStyle("-fx-background-color: #29ADB2;"+
                        "-fx-border-width: 0;"+
                        "-fx-background-radius: 10;"+
                        "-fx-text-fill: white;");
                avmyhbox.setPadding(new Insets(20,10,20,10));
                avmyhbox.setPrefWidth(885);
                avmyhbox.setAlignment(Pos.CENTER);
                avmyhbox.setSpacing(150);

                availabledoctors.setMargin(avmyhbox,new Insets(10));
                availabledoctors.getChildren().add(avmyhbox);

                String doctorphonenb=resulttest.getString("contact");
                String doctorid=resulttest.getString("id");

                avmyhbox.setOnMouseClicked(e->{
                    availabledoctors.getChildren().clear();
                    availabledoctors.getChildren().addAll(dayofreservation(myspecil1,dctrfname,dctrlname,doctorphonenb,doctorid));
                });

            }

            // Cleanup
            resulttest.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return availabledoctors;
    }


    /*=======================================available days for this month with this doctor=======================================*/
    public  BorderPane dayofreservation(String myspecil,String dctrfname,String dctrlname,String doctorphonenb,String doctorid){
        BorderPane availableappointementsborderpane=new BorderPane();


        //setting the top of border pane
        VBox topavailableappbp=new VBox();
        topavailableappbp.setPadding(new Insets(20));
        topavailableappbp.setSpacing(20);

        //docter choosen
        HBox choosendoctorhbox=new HBox();
        Text mytxt1=new Text(myspecil);
        mytxt1.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC,20));
        mytxt1.setFill(Color.WHITE);

        Text mytxt2=new Text("DR."+dctrfname+" "+dctrlname);
        mytxt2.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.ITALIC,12));
        mytxt2.setFill(Color.WHITE);

        Text mytxt3=new Text(doctorphonenb);
        mytxt3.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.ITALIC,20));
        mytxt3.setFill(Color.WHITE);

        choosendoctorhbox.getChildren().addAll(mytxt1,mytxt2,mytxt3);
        choosendoctorhbox.setStyle("-fx-background-color: #29ADB2;"+
                                    "-fx-border-width: 0;"+
                                    "-fx-background-radius: 10;"+
                                    "-fx-text-fill: white;");
        choosendoctorhbox.setPadding(new Insets(20,10,20,10));
        choosendoctorhbox.setPrefWidth(855);
        choosendoctorhbox.setAlignment(Pos.CENTER);
        choosendoctorhbox.setSpacing(150);


        //dates
        HBox datecomboboxes=new HBox();

        //======year combo box
        ComboBox<String> yearComboBox = new ComboBox<>();
        for (int year = 2023; year <= 3000; year++) {
            yearComboBox.getItems().add(Integer.toString(year));
        }

        // Set the default value to appear as 2023
        yearComboBox.setValue("2023");

        // Make the ComboBox uneditable
        yearComboBox.setEditable(false);
        yearComboBox.setDisable(true);

        //======month combo box
        ComboBox<String> monthComboBox = new ComboBox<>();
        for (int month = 1; month <= 12; month++) {
            monthComboBox.getItems().add(Integer.toString(month));
        }

        // Set the default value to appear as 12
        monthComboBox.setValue("12");

        // Make the ComboBox uneditable
        monthComboBox.setEditable(false);
        monthComboBox.setDisable(true);

        //======day combo box
        // Get the current local date
        LocalDate localDate = LocalDate.now();

        // Get the day of the month and display it in a label
        int dayOfMonth = localDate.getDayOfMonth();

        ComboBox<String> dayComboBox = new ComboBox<>();
        for (int day = dayOfMonth; day <= 31; day++) {
            dayComboBox.getItems().add(Integer.toString(day));
        }
        datecomboboxes.getChildren().addAll(yearComboBox,monthComboBox,dayComboBox);
        datecomboboxes.setSpacing(80);

        //putting in the top vbox
        topavailableappbp.getChildren().addAll(choosendoctorhbox,datecomboboxes);

        //putting in center and bottom in my borderpane
        dayComboBox.setOnAction(e->{


            if(isdayofbookingexists(doctorid,dayComboBox.getValue())){
                availableappointementsborderpane.setCenter(givemeavailabletime(doctorid,dayComboBox.getValue()));
                System.out.println("i am created before");
            }else{
                createdayofbookingindb(doctorid,dayComboBox.getValue());
                availableappointementsborderpane.setCenter(givemeavailabletime(doctorid,dayComboBox.getValue()));
            }
        });


        //putting in borderpane
        availableappointementsborderpane.setTop(topavailableappbp);
        return availableappointementsborderpane;
    }
    /*=======================================available appoiuntements for this day=======================================*/
    public VBox givemeavailabletime(String doctorid,String day){
        VBox availabletimes=new VBox();
        availabletimes.setPadding(new Insets(0,0,0,80));
        availabletimes.setSpacing(30);

        //togglegroup
        ToggleGroup availabletimestg=new ToggleGroup();

        //submit btn
        HBox submitreservation =new HBox();
        Button submitreservationbtn=new Button("Submit");
        submitreservationbtn.setStyle(
                        "-fx-background-color: linear-gradient(to right, #0766AD, #29ADB2);" +
                        "-fx-text-fill: white;" +
                        "-fx-border-color: transparent;" + // No borders
                        "-fx-background-radius: 100;" + // Border radius of 30
                        "-fx-padding: 10 20;" // Padding to give some space around the text
        );
        submitreservationbtn.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,16));


        submitreservation.getChildren().add(submitreservationbtn);

        try {

            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Create statement
            Statement statement = connection.createStatement();
            String date1="2023-12-"+day;
            // Fetch data from the users table
            ResultSet resulttest = statement.executeQuery(
                    "SELECT * FROM dayofbooking WHERE doctor_id = '"+doctorid+"' AND date='"+date1+"'");


            while (resulttest.next()) {
                RadioButton availabletimesradio1=new RadioButton(resulttest.getString("appointment1"));
                availabletimesradio1.setStyle("-fx-scale-x: 2.0; -fx-scale-y: 2.0;");

                RadioButton availabletimesradio2=new RadioButton(resulttest.getString("appointment2"));
                availabletimesradio2.setStyle("-fx-scale-x: 2.0; -fx-scale-y: 2.0;");

                RadioButton availabletimesradio3=new RadioButton(resulttest.getString("appointment3"));
                availabletimesradio3.setStyle("-fx-scale-x: 2.0; -fx-scale-y: 2.0;");

                RadioButton availabletimesradio4=new RadioButton(resulttest.getString("appointment4"));
                availabletimesradio4.setStyle("-fx-scale-x: 2.0; -fx-scale-y: 2.0;");

                RadioButton availabletimesradio5=new RadioButton(resulttest.getString("appointment5"));
                availabletimesradio5.setStyle("-fx-scale-x: 2.0; -fx-scale-y: 2.0;");

                availabletimesradio1.setToggleGroup(availabletimestg);
                availabletimesradio2.setToggleGroup(availabletimestg);
                availabletimesradio3.setToggleGroup(availabletimestg);
                availabletimesradio4.setToggleGroup(availabletimestg);
                availabletimesradio5.setToggleGroup(availabletimestg);

                availabletimes.getChildren().addAll(availabletimesradio1,
                                                    availabletimesradio2,
                                                    availabletimesradio3,
                                                    availabletimesradio4,
                                                    availabletimesradio5,
                                                    submitreservation);

                submitreservationbtn.setOnAction(e->{


                    if(availabletimesradio1.isSelected() && !checkIfAttributeIsNull(doctorid,day,"appointment1")){
                        if(!checkappointementiffound(doctorid,patientid,date1)){
                            createnewappointement(doctorid,patientid,date1,1);
                            turnappintonull(doctorid,date1,"appointment1");
                            this.reserveappbtn=submitreservationbtn;
                            alertbookingappointement("Your appointement is created!");
                        }else{
                            alertbookingappointement("appointement not created!" +
                                    "\neither you took an appointement with doctor before" +
                                    "\nor the appointement is already booked by someone else");
                        }
                    }else if(availabletimesradio2.isSelected() && !checkIfAttributeIsNull(doctorid,day,"appointment2")){
                        if(!checkappointementiffound(doctorid,patientid,date1)){
                            createnewappointement(doctorid,patientid,date1,2);
                            turnappintonull(doctorid,date1,"appointment2");
                            this.reserveappbtn=submitreservationbtn;
                            alertbookingappointement("Your appointement is created!");
                        }else{
                            alertbookingappointement("appointement not created!" +
                                    "\neither you took an appointement with doctor before" +
                                    "\nor the appointement is already booked by someone else");
                        }
                    }else if(availabletimesradio3.isSelected() && !checkIfAttributeIsNull(doctorid,day,"appointment3")) {
                        if(!checkappointementiffound(doctorid,patientid,date1)){
                            createnewappointement(doctorid,patientid,date1,3);
                            turnappintonull(doctorid,date1,"appointment3");
                            this.reserveappbtn=submitreservationbtn;
                            alertbookingappointement("Your appointement is created!");
                        }else{
                            alertbookingappointement("appointement not created!" +
                                    "\neither you took an appointement with doctor before" +
                                    "\nor the appointement is already booked by someone else");
                        }
                    }else if(availabletimesradio4.isSelected() && !checkIfAttributeIsNull(doctorid,day,"appointment4")) {
                        if(!checkappointementiffound(doctorid,patientid,date1)){
                            createnewappointement(doctorid,patientid,date1,4);
                            turnappintonull(doctorid,date1,"appointment4");
                            this.reserveappbtn=submitreservationbtn;
                            alertbookingappointement("Your appointement is created!");
                        }else{
                            alertbookingappointement("appointement not created!" +
                                    "\neither you took an appointement with doctor before" +
                                    "\nor the appointement is already booked by someone else");
                        }
                    }else if(availabletimesradio5.isSelected() && !checkIfAttributeIsNull(doctorid,day,"appointment5")) {
                        if(!checkappointementiffound(doctorid,patientid,date1)){
                            createnewappointement(doctorid,patientid,date1,5);
                            turnappintonull(doctorid,date1,"appointment5");
                            this.reserveappbtn=submitreservationbtn;
                            alertbookingappointement("Your appointement is created!");
                        }else{
                            alertbookingappointement("appointement not created!" +
                                    "\neither you took an appointement with doctor before" +
                                    "\nor the appointement is already booked by someone else");
                        }
                    }
                });
            }

            // Cleanup
            resulttest.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return availabletimes;
    }

    public Button getreservebtn(){
        return reserveappbtn;
    }

    //alert
    public void alertbookingappointement(String message){
        // Create an Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null); // No header
        alert.setContentText(message);

        // Show the Alert
        alert.showAndWait();
    }

    /*=======================================adding dayofbooking into database=======================================*/

    public void createdayofbookingindb(String doctorid,String date){
        try {
            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            String insertDoctorQuery = "INSERT INTO dayofbooking (doctor_id," +
                                                                " date," +
                                                                " appointment1," +
                                                                " appointment2," +
                                                                " appointment3," +
                                                                " appointment4," +
                                                                " appointment5) " +
                                                                "VALUES (?, ?, ?, ?, ?, ?, ?)";

            try(PreparedStatement preparedStatement = connection.prepareStatement(insertDoctorQuery)) {


                // Set values for the prepared statement
                preparedStatement.setString(1, doctorid);
                preparedStatement.setString(2, "2023-12-"+date);
                preparedStatement.setString(3, "1:00");
                preparedStatement.setString(4, "2:00");
                preparedStatement.setString(5, "3:00");
                preparedStatement.setString(6, "4:00");
                preparedStatement.setString(7, "5:00");

                // Execute the insert statement
                preparedStatement.executeUpdate();

                System.out.println("day of booking created!");

                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*=======================================checking day of booking id found=======================================*/
    public boolean isdayofbookingexists(String doctorid,String day) {
        Boolean isfound=false;
        try {
            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Create statement
            Statement statement = connection.createStatement();
            String date1="2023-12-"+day;
            // Fetch data from the users table
            ResultSet resulttest = statement.executeQuery(
                    "SELECT * FROM dayofbooking WHERE doctor_id = '"+doctorid+"' AND date='"+date1+"'");

            while (resulttest.next()) {
                isfound=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isfound;

    }

    /*=======================================Creating new appointement in database=======================================*/

    public void createnewappointement(String dctrid,String patientid,String date,int appnb){
        try {
            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            String insertDoctorQuery = "INSERT INTO appointment (doctor_id, patient_id, date, appointment_number) VALUES (?, ?, ?, ?)";

            try(PreparedStatement preparedStatement = connection.prepareStatement(insertDoctorQuery)) {


                // Set values for the prepared statement
                preparedStatement.setString(1, dctrid);
                preparedStatement.setString(2, patientid);
                preparedStatement.setString(3, date);
                preparedStatement.setInt(4, appnb);

                // Execute the insert statement
                preparedStatement.executeUpdate();

                System.out.println("new appointement created succesfully!");

                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*=======================================check If Attribute Is Null=======================================*/
    private Boolean checkIfAttributeIsNull(String doctorid, String day,String app) {
        boolean isnull=false;
        try {

            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Create statement
            Statement statement = connection.createStatement();
            String date1="2023-12-"+day;
            // Fetch data from the users table
            ResultSet resulttest = statement.executeQuery(
                    "SELECT * FROM dayofbooking WHERE doctor_id = '"+doctorid+"' AND date='"+date1+"'");


            while (resulttest.next()) {
                if(resulttest.getString(app)==null){
                    System.out.println("null");
                    isnull=true;
                }else{
                    System.out.println("not-null");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isnull;
    }

    /*=======================================turn appointement into null=======================================*/

   public void turnappintonull(String doctorid,String day,String app){
       try {
           // Make connection
           String url = "jdbc:mysql://localhost:3306/clinic";
           Connection connection = DriverManager.getConnection(url, "root", "");
           String updateDoctorQuery = "UPDATE dayofbooking SET "+app+"= NULL WHERE doctor_id='"+doctorid+"' AND date='"+day+"'";

           try(PreparedStatement preparedStatement = connection.prepareStatement(updateDoctorQuery)) {

               // Execute the insert statement
               preparedStatement.executeUpdate();

               System.out.println("appointment you choosed turned to null!");

               connection.close();
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    /*=======================================check appointement if found before=======================================*/
    public Boolean checkappointementiffound(String doctorid,String patientid,String date){
        Boolean isfound=false;
        try {

            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Create statement
            Statement statement = connection.createStatement();

            // Fetch data from the users table
            ResultSet resulttest = statement.executeQuery(
                    "SELECT * FROM appointment WHERE doctor_id='"+doctorid+"' AND patient_id='"+patientid+"' AND date='"+date+"'");
            while (resulttest.next()) {
                isfound=true;
                System.out.println("yes this appointment is found");
            }

            // Cleanup
            resulttest.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {

            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Create statement
            Statement statement = connection.createStatement();

            // Fetch data from the users table
            ResultSet resulttest = statement.executeQuery(
                    "SELECT * FROM appointment WHERE doctor_id='"+doctorid+"' AND patient_id='"+patientid+"'");
            while (resulttest.next()) {
                isfound=true;
                System.out.println("you cant take 2 appointments with same doctor");
            }

            // Cleanup
            resulttest.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isfound;
    }








}

























































