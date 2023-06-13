package com.example.internsystemapp;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.*;

import static java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE;

public class DBUtills {

    private static int currentInternId;
    // Getter method
    public static int getCurrentInternId() {
        return currentInternId;
    }

    // Setter method
    public static void setCurrentInternId(int id) {
        currentInternId = id;
    }
    private static int currentCmpId;
    // Getter method
    public static int getCurrentCmpId() {
        return currentCmpId;
    }

    // Setter method
    public static void setCurrentCmpId(int id) {
        currentCmpId = id;
    }


    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet rst) {
        if (rst != null) {
            try {
                rst.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void closePreparedStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void signUpIntern(ActionEvent e, String fullName, String email, String password, int phoneNumber, String field, String DOB, String gradYear, String location) {
        Connection conn = null;
        PreparedStatement psCheckIntern = null;
        PreparedStatement psInsertIntern = null;
        ResultSet rst = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ois", "root", "");
            psCheckIntern = conn.prepareStatement("select * from stud where email = ?");
            psCheckIntern.setString(1, email);
            rst = psCheckIntern.executeQuery();
            if (rst.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Email is already registered");
                alert.show();
            } else {
                psInsertIntern = conn.prepareStatement("insert into stud(fullName, email, pass, phone, dept, birth, gradYear, location) values (?, ?, ?, ?, ?, ?, ?, ?)");
                System.out.println(fullName + " " + email + " " + password + " " + phoneNumber + " " + field + " " + DOB + " " + gradYear + " " + location);
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rst);
            closePreparedStatement(psCheckIntern);
            closePreparedStatement(psInsertIntern);
            closeConnection(conn);
        }
    }

    public static void loginIntern(ActionEvent e, String fullName, String email, String password) {
        Connection conn = null;
        PreparedStatement psInternLogin = null;
        ResultSet rst = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ois", "root", "");
            psInternLogin = conn.prepareStatement("select id email, pass from stud where email = ?");
            psInternLogin.setString(1, email);
            rst = psInternLogin.executeQuery();
            if (!rst.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User Does Not Exist");
                alert.show();
            } else {
                while (rst.next()) {
                    String userPass = rst.getString("pass");
                    if (userPass.equals(password)) {
                        setCurrentInternId(Integer.parseInt(rst.getString(1)));
                        InternApp.showInternHomePage();

                        System.out.println(getCurrentInternId());
                    } else {
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
        } finally {
            closeResultSet(rst);
            closePreparedStatement(psInternLogin);
            closeConnection(conn);
        }
    }

    public static void signUpCmp(ActionEvent e, String name, String email, String password, int phoneNumber, String location) {
        Connection conn = null;
        PreparedStatement psCheckCmp = null;
        PreparedStatement psInsertCmp = null;
        ResultSet rst = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ois", "root", "");
            psCheckCmp = conn.prepareStatement("select * from stud where email = ?");
            psCheckCmp.setString(1, email);
            rst = psCheckCmp.executeQuery();
            if (rst.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Email is already registered");
                alert.show();
            } else {
                psInsertCmp = conn.prepareStatement("insert into company(name, email, pass, phone, location) values (?, ?, ?, ?, ?)");
                System.out.println(name + " " + email + " " + password + " " + phoneNumber + " " + location);
                psInsertCmp.setString(1, name);
                psInsertCmp.setString(2, email);
                psInsertCmp.setString(3, password);
                psInsertCmp.setInt(4, phoneNumber);
                psInsertCmp.setString(5, location);
                psInsertCmp.executeUpdate();
                System.out.println("db updated");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rst);
            closePreparedStatement(psCheckCmp);
            closePreparedStatement(psInsertCmp);
            closeConnection(conn);

        }
    }

    public static void loginCmp(ActionEvent e, String name, String email, String password) {
        Connection conn = null;
        PreparedStatement psCmpLogin = null;
        ResultSet rst = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ois", "root", "");
            psCmpLogin = conn.prepareStatement("select id, email, pass from company where email = ?");
            psCmpLogin.setString(1, email);
            rst = psCmpLogin.executeQuery();
            if (!rst.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Company Does Not Exist");
                alert.show();
            } else {
                while (rst.next()) {
                    String userPass = rst.getString("pass");
                    if (userPass.equals(password)) {
                        setCurrentCmpId(Integer.parseInt(rst.getString(1)));
                        InternApp.showCmpHomePage();
                        System.out.println(getCurrentCmpId());
                    } else {
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
        } finally {
            closeResultSet(rst);
            closePreparedStatement(psCmpLogin);
            closeConnection(conn);
        }
    }
    public static ResultSet getFeaturedInternships() {
        Connection conn = null;
        Statement stSelectInternships = null;

//                PreparedStatement psSelectInternships = null;
        ResultSet rst = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ois", "root", "");
            stSelectInternships = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            psSelectInternships = conn.prepareStatement("SELECT internshipposts.id, internshipposts.title, internshipposts.duration, internshipposts.requirements, internshipposts.description, internshipposts.type, internshipposts.numberOfApplicantsNeeded, company.name, company.email,company.location FROM internshipposts INNER JOIN company ON internshipposts.company_id = company.id limit 4");
            rst = stSelectInternships.executeQuery("SELECT internshipposts.id, internshipposts.title, internshipposts.duration, internshipposts.requirements, internshipposts.description, internshipposts.type, internshipposts.numberOfApplicantsNeeded, company.name, company.email,company.location FROM internshipposts INNER JOIN company ON internshipposts.company_id = company.id limit 4");

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rst;
    }
    public static ResultSet searchInternships(String SQL){
        Connection conn = null;
        Statement stSearchInternships = null;
        ResultSet rst = null;

        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ois", "root", "");
            stSearchInternships = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rst = stSearchInternships.executeQuery(SQL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rst;
    }
    public static ResultSet getData(String SQL){
        Connection conn = null;
        Statement stGetData = null;
        ResultSet rst = null;

        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ois", "root", "");
            stGetData = conn.createStatement();
            rst = stGetData.executeQuery(SQL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rst;

    }
    public static void addApplication(ActionEvent e, int internId, int internshipId, int yearOfStudy, String university, String skill, String gitUrl, String interests, String experience) {
        Connection conn = null;
        PreparedStatement psCheckApp = null;
        PreparedStatement psAddApp = null;
        ResultSet rst = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ois", "root", "");
            psCheckApp = conn.prepareStatement("select * from application where internId = ? and internshipID = ?");
            psCheckApp.setInt(1, internId);
            psCheckApp.setInt(2, internshipId);
            rst = psCheckApp.executeQuery();
            if (rst.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Application Already Exists. please wait for the results");
                alert.show();
            } else {
                psAddApp = conn.prepareStatement("insert into application(internId, internshipId, yearOfStudy, universityName, skills, gitURL, interests, experience) values (?, ?, ?, ?, ?, ?, ?, ?)");
//                System.out.println(name + " " + email + " " + password + " " + phoneNumber + " " + location);
                psAddApp.setInt(1, internId);
                psAddApp.setInt(2, internshipId);
                psAddApp.setInt(3, yearOfStudy);
                psAddApp.setString(4, university);
                psAddApp.setString(5, skill);
                psAddApp.setString(6, gitUrl);
                psAddApp.setString(7, interests);
                psAddApp.setString(8, experience);

                psAddApp.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Your Application Has Been Sent");
                alert.show();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(rst);
            closePreparedStatement(psCheckApp);
            closePreparedStatement(psAddApp);
            closeConnection(conn);

        }
    }
    public static void postInternship(int companyId, String title, String duration, String requirements, String description, String type, int vacancies){
        Connection conn = null;
        PreparedStatement psPostInternship = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ois", "root", "");
            psPostInternship = conn.prepareStatement("insert into internshipposts(company_id, Title, duration, requirements, description, type, numberOfApplicantsNeeded) values (?, ?, ?, ?, ?, ?, ?)");
//                System.out.println(name + " " + email + " " + password + " " + phoneNumber + " " + location);
            psPostInternship.setInt(1, companyId);
            psPostInternship.setString(2, title);
            psPostInternship.setString(3, duration);
            psPostInternship.setString(4, requirements);
            psPostInternship.setString(5, description);
            psPostInternship.setString(6, type);
            psPostInternship.setInt(7, vacancies);

            psPostInternship.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Internship Posted");
            alert.show();
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closePreparedStatement(psPostInternship);
            closeConnection(conn);

        }
    }
    public static void acceptIntern(String email){
        Connection conn = null;
        PreparedStatement psAcceptIntern = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ois", "root", "");
            psAcceptIntern = conn.prepareStatement("update application set status = 'accepted' where internId in (select id from stud where email = '"+email+"')");
            psAcceptIntern.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("intern accepted");
            alert.show();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closePreparedStatement(psAcceptIntern);
            closeConnection(conn);
        }
    }
    public static void rejectIntern(String email){
        Connection conn = null;
        PreparedStatement psRejectIntern = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ois", "root", "");
            psRejectIntern = conn.prepareStatement("update application set status = 'rejected' where internId in (select id from stud where email = '"+email+"')");
            psRejectIntern.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("intern rejected");
            alert.show();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closePreparedStatement(psRejectIntern);
            closeConnection(conn);
        }
    }

}