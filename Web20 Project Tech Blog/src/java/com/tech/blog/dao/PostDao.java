package com.tech.blog.dao;

import com.tech.blog.entities.Categories;
import com.tech.blog.entities.Posts;
import com.tech.blog.helper.ConnectionProvider;
import java.sql.*;
import java.util.ArrayList;

public class PostDao {
    Connection con;
    
    public PostDao(Connection con){
        this.con = con;
    }
    
    public ArrayList<Categories> getCategories(){
        ArrayList<Categories> list = new ArrayList<>();
        
        try{
            String q = "select * from categories";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            
            while(rs.next()){
                int cid = rs.getInt("cid");
                String name = rs.getString("name");
                String desc = rs.getString("description");
                
                Categories c = new Categories(cid, name, desc);
                list.add(c);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    
    public boolean addPost(Posts p){
        boolean flag = false;
        try{
            String q = "insert into posts (ptitle, pcontent, pcode, ppic, catId, uid) values (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, p.getpTitle());
            ps.setString(2, p.getpContent());
            ps.setString(3, p.getpCode());
            ps.setString(4, p.getpPic());
            ps.setInt(5, p.getCatId());
            ps.setInt(6, p.getuId());
            
            ps.executeUpdate();
            flag = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
