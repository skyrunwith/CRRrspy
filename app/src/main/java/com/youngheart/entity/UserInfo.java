package com.youngheart.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/4/22.
 */
public class UserInfo implements Serializable{

    private String uid;

    private String loginname;


    private String loginpass;


    private String email;


    private String gender;


    private String image;


    private int status;


    private String activationCode;

    private List<ProductComment> tProductcommentEntitySet;

    private int admin;	//1为admin，2为普通用户

    public List<ProductComment> gettProductcommentEntitySet() {
        return tProductcommentEntitySet;
    }

    public void settProductcommentEntitySet(List<ProductComment> tProductcommentEntitySet) {
        this.tProductcommentEntitySet = tProductcommentEntitySet;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getLoginpass() {
        return loginpass;
    }

    public void setLoginpass(String loginpass) {
        this.loginpass = loginpass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }
}
