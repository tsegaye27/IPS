package com.example.internsystemapp;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.*;
public class DBUtills {
    public static void signUpIntern(ActionEvent e,String fullName, String email, String password,int phoneNumber ,String field,String DOB, String gradYear, String location){
        Connection conn = null;
        PreparedStatement psCheckIntern = null;
        PreparedStatement psInsertIntern = null;
        ResultSet rst = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ois", "root", "");
            psCheckIntern = conn.prepareStatement("select * from stud where email = ?");
            psCheckIntern.setString(1, email);
            rst=psCheckIntern.executeQuery();
            if(rst.isBeforeFirst()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Email is already registered");
                alert.show();
            }else{
                psInsertIntern = conn.prepareStatement("insert into stud(fullName, email, pass, phone, dept, birth, gradYear, location) values (?, ?, ?, ?, ?, ?, ?, ?)");
                System.out.println(fullName+" "+email+" "+password+" "+phoneNumber+" "+field+" "+DOB+" "+gradYear+" "+location);
                psInsertIntern.setString(1, fullName);
                psInsertIntern.setString(2, email);
                psInsertIntern.setString(3, password);
                psInsertIntern.setInt(4, phoneNumber);
                psInsertIntern.setString(5, field);
                psInsertIntern.setString(6, DOB);
                psInsertIntern.setString(7, gradYear);
                psInsertIntern.setString(8, location);
                psInsertIntern.executeUpdate();
                System.out.println("db updated");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            if(rst!= null){
                try{
                    rst.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
            if(psCheckIntern!= null){
                try{
                    psCheckIntern.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
            if(psInsertIntern!= null){
                try{
                    psInsertIntern.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
            if(conn!= null){
                try{
                    conn.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    public static void loginIntern(ActionEvent e, String fullName, String email, String password){
        Connection conn=null;
        PreparedStatement psInternLogin = null;
        ResultSet rst = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ois", "root", "");
            psInternLogin= conn.prepareStatement("select email, pass from stud where email = ?");
            psInternLogin.setString(1, email);
            rst=psInternLogin.executeQuery();
           if(!rst.isBeforeFirst()){
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("User Does Not Exist");
               alert.show();
           }else{
               while(rst.next()){
                   String userPass = rst.getString("pass");
                   if(userPass.equals(password)){
                       InternApp.showInternHomePage();
                   }
                   else{
                       Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setContentText("Incorrect Credentials");
                       alert.show();
                   }
               }
           }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } finally{
            if (rst != null) {
                try {
                    rst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (psInternLogin != null) {
                try {
                    psInternLogin.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
