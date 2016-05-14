package com.youngheart.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/24.
 */
public class ProductComment implements Serializable{
    private int commentid;
    private String producttypeid;
    private String content;
    private String userip;
    private String commentdate;
    private TProduct tProduct;

    public TProduct gettProduct() {
        return tProduct;
    }

    public void settProduct(TProduct tProduct) {
        this.tProduct = tProduct;
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public String getProducttypeid() {
        return producttypeid;
    }

    public void setProducttypeid(String producttypeid) {
        this.producttypeid = producttypeid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip;
    }

    public String getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(String commentdate) {
        this.commentdate = commentdate;
    }
}
