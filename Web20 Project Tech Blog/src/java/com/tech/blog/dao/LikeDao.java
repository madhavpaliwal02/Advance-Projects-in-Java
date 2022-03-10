package com.tech.blog.dao;

import java.sql.*;

public class LikeDao {

    Connection con = null;

    public LikeDao(Connection con) {
        this.con = con;
    }

    public boolean insertLike(int pid, int uid) {
        boolean f = false;
        String q = "insert into liked (pid, uid) values (?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(q);

            ps.setInt(1, pid);
            ps.setInt(2, uid);

            ps.executeUpdate();
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public int countLikeOnPost(int pid) {
        int count = 0;

        String q = "select count(*) from liked where pid =" + pid + "";

        try {
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(q);

            if (rs.next()) {
                count = rs.getInt("count(*)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public boolean checkLike(int uid, int pid) {
        boolean f = false;

        String q = "select * from liked where uid = ? and pid = ?";

        try {
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, uid);
            ps.setInt(2, pid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
}
