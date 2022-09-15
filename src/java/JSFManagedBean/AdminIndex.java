/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package JSFManagedBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author admin
 */
@Named(value = "adminIndex")
@Dependent
public class AdminIndex {

    /**
     * Creates a new instance of AdminIndex
     */
    public AdminIndex() {
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/shoesfactory", "root", "root");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return con;
    }

    public Integer countbrand() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from brand");
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Total Brand = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }

    public Integer countcat() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from category");
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Total category = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }

    public Integer countsubcat() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from subcategory");
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Total subcategory = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }

    public Integer countproduct() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from product");
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Total product = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }

    public Integer countuser() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from users");
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Total user = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }

    public Integer countroles() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from roles");
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Total role = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }

    public Integer countorder() {
        int acount = 0;
        try {
            Connection con = getConnection();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select count(*) from order");
            ResultSet rs = ps.executeQuery();
            rs.next();
            acount = rs.getInt(1);
            System.out.println("Total order = " + acount);
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return acount;
    }

}
