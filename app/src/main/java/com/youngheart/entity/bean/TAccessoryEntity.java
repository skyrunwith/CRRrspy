package com.youngheart.entity.bean;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/26.
 */
public class TAccessoryEntity implements Serializable{
    private String materiallotid;
    private String accessorylotid;
    private String amount;

    public String getMateriallotid() {
        return materiallotid;
    }

    public void setMateriallotid(String materiallotid) {
        this.materiallotid = materiallotid;
    }

    public String getAccessorylotid() {
        return accessorylotid;
    }

    public void setAccessorylotid(String accessorylotid) {
        this.accessorylotid = accessorylotid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
