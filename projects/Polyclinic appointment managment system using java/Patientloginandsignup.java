package com.example.demo3;

import java.sql.*;

public class Patientloginandsignup {

    public void addpatients(String id,
                            String pass,
                            String fname,
                            String lname,
                            int age,
                            String gender,
                            String contact){
        try {
            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            String insertDoctorQuery = "INSERT INTO patient (id, pass, fname, lname, age, gender, contact) " +
                                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            try(PreparedStatement preparedStatement = connection.prepareStatement(insertDoctorQuery)) {


                // Set values for the prepared statement
                preparedStatement.setString(1, id);
                preparedStatement.setString(2, pass);
                preparedStatement.setString(3, fname);
                preparedStatement.setString(4, lname);
                preparedStatement.setInt(5, age);
                preparedStatement.setString(6, gender);
                preparedStatement.setString(7, contact);

                // Execute the insert statement
                preparedStatement.executeUpdate();

                System.out.println("Data inserted successfully!");

                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*=========================validation of patient from login=========================*/
    public Boolean checkpatientfromlogin(String id,String pass){
        Boolean isfound=false;
        try {

            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Create statement
            Statement statement = connection.createStatement();

            // Fetch data from the users table
            ResultSet resulttest = statement.executeQuery(
                    "SELECT * FROM patient WHERE id='"+id+"' AND pass='"+pass+"'");
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

    /*get patient by id*/
    private String patientname;
    public String getpatientbyid(String id){

        try {

            // Make connection
            String url = "jdbc:mysql://localhost:3306/clinic";
            Connection connection = DriverManager.getConnection(url, "root", "");

            // Create statement
            Statement statement = connection.createStatement();

            // Fetch data from the users table
            ResultSet resulttest = statement.executeQuery(
                    "SELECT fname FROM patient WHERE id='"+id+"'");
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

}
