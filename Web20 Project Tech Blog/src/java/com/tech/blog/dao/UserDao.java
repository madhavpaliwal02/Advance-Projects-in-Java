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
    public boolean saveUser(User u) {
        boolean flag = false;
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    // Get user by email and password
    public User getUserByEmailAndPassword(String email, String pass) {
        User u = null;

        try {
            String q = "select * from user where email=? and password=?";

            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, email);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setGender(rs.getString("gender"));
                u.setAbout(rs.getString("about"));
                u.setDateTime(rs.getTimestamp("rdate"));
                u.setProfile(rs.getString("profile"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    // Edit details of user
    public boolean editUser(User u) {
        boolean flag = false;
        try {
            String q = "update user set name=?, email=?, password=?, about=?, profile=? where id=?";

            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getAbout());
            ps.setString(5, u.getProfile());
            ps.setInt(6, u.getId());

            ps.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    // Get user by user id
    public User getUserByUserId(int userId) {
        User u = null;

        try {
            String q = "select * from user where id = ?";

            PreparedStatement ps = con.prepareStatement(q);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setGender(rs.getString("gender"));
                u.setAbout(rs.getString("about"));
                u.setDateTime(rs.getTimestamp("rdate"));
                u.setProfile(rs.getString("profile"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }

}
