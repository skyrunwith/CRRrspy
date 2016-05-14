package com.youngheart.fragment;

import android.os.Parcel;
import android.os.Parcelable;

import com.youngheart.entity.TProduct;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/7.
 */
public class TouSuEntity implements Serializable{

    private int id;
    private TProduct tProduct;
    private String name;
    private String idcard;
    private String tel;
    private String reason;

    protected TouSuEntity(Parcel in) {
        id = in.readInt();
        name = in.readString();
        idcard = in.readString();
        tel = in.readString();
        reason = in.readString();
    }

    public TouSuEntity() {
    }

    public TProduct gettProduct() {
        return tProduct;
    }

    public void settProduct(TProduct tProduct) {
        this.tProduct = tProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
}
