package com.tech.blog.dao;

import com.tech.blog.entities.User;
import java.sql.*;
import com.tech.blog.entities.User;

public class UserDao {
    
    private Connection con;

    public UserDao(Connection con) {
        this.con = con;
    }
    
    // Inserting
    
    public boolean saveUser(User u){
        boolean flag = false;
        try{
            // User --> Database
            
            String q = "insert into user (name, email, password, gender, about) values (?,?,?,?,?)";
            
            PreparedStatement ps = this.con.prepareStatement(q);
            
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getGender());
            ps.setString(5, u.getAbout());
            
            ps.executeUpdate();
            flag = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    
}
