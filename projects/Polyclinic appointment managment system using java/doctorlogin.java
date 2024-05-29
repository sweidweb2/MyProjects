package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.sql.*;

public class doctorlogin {



    /*=========================validation of patient from login=========================*/
    public Boolean checkdoctorfromlogin(String id,String pass){
        Boolean isfound=false;
        try {
            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Create statement
            Statement statement = connection.createStatement();

            // Fetch data from the users table
            ResultSet resulttest = statement.executeQuery(
                    "SELECT * FROM doctor WHERE id='"+id+"' AND pass='"+pass+"'");
            while (resulttest.next()) {
                isfound=true;
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

    /*get doctor by id*/
    private String patientname;
    public String getpdoctorbyid(String id){

        try {

            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Create statement
            Statement statement = connection.createStatement();

            // Fetch data from the users table
            ResultSet resulttest = statement.executeQuery(
                    "SELECT fname FROM doctor WHERE id='"+id+"'");
            while (resulttest.next()) {
                this.patientname =resulttest.getString("fname");
            }

            // Cleanup
            resulttest.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientname;
    }

    /*fill data in doctor table view*/
    private ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
    public ObservableList<ObservableList<String>> filldoctortabledata(String doctorid){
        try {

            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Create statement
            Statement statement = connection.createStatement();

            // Fetch data from the users table
            ResultSet resulttest = statement.executeQuery("SELECT * FROM appointment WHERE doctor_id='"+doctorid+"'");
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

    private ObservableList<ObservableList<String>> searchdata = FXCollections.observableArrayList();
    public ObservableList<ObservableList<String>> filldoctortablesearchdata(String doctorid,String daynb){
        try {

            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Create statement
            Statement statement = connection.createStatement();
            String date="2023-12-"+daynb;
            // Fetch data from the users table
            ResultSet resulttest = statement.executeQuery("SELECT * FROM appointment " +
                    "WHERE doctor_id='"+doctorid+"' " +
                    "AND date='"+date+"'");
            while (resulttest.next()) {
                ObservableList<String> row = FXCollections.observableArrayList(
                        resulttest.getString("doctor_id"),
                        resulttest.getString("patient_id"),
                        resulttest.getString("date"),
                        resulttest.getString("appointment_number")
                );

                // Add data to ObservableList
                searchdata.add(row);
            }

            // Cleanup
            resulttest.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchdata;
    }





}
