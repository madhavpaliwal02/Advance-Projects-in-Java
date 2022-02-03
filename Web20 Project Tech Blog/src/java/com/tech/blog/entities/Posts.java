/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.entities;

import java.sql.Timestamp;

/**
 *
 * @author Nayan
 */
public class Posts {
    private int pId, catId, uId;
    private String pContent, pTitle, pCode, pPic;
    private Timestamp pDate;

    public Posts(int pId, int catId, String pTitle, String pContent, String pCode, String pPic, int uId) {
        this.pId = pId;
        this.catId = catId;
        this.pContent = pContent;
        this.pTitle = pTitle;
        this.pCode = pCode;
        this.pPic = pPic;
        this.uId = uId;
    }

    public Posts() {
    }

    public Posts(int catId, String pTitle, String pContent, String pCode, String pPic, int uId) {
        this.catId = catId;
        this.pContent = pContent;
        this.pTitle = pTitle;
        this.pCode = pCode;
        this.pPic = pPic;
        this.uId = uId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getpContent() {
        return pContent;
    }

    public void setpContent(String pContent) {
        this.pContent = pContent;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getpPic() {
        return pPic;
    }

    public void setpPic(String pPic) {
        this.pPic = pPic;
    }

    public Timestamp getpDate() {
        return pDate;
    }

    public void setpDate(Timestamp pDate) {
        this.pDate = pDate;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }
    
}