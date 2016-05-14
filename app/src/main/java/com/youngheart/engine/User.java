// JSON Java Class Generator
// Written by Bruce Bao
// Used for API: http://www.weather.com.cn/data/sk/101010100.html
package com.youngheart.engine;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;

import com.youngheart.entity.ProductComment;
import com.youngheart.utils.Utils;

public class User implements Serializable, Cloneable {
	/**
	 * @Fields: serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private static User instance;

	private User() {

	}

	public static User getInstance() {
		if (instance == null) {
			Object object = Utils.restoreObject(AppConstants.CACHEDIR + TAG);
			if (object == null) { // App第一次启动，文件不存在，则新建之
				object = new User();
				Utils.saveObject(AppConstants.CACHEDIR + TAG, object);
			}

			instance = (User) object;
		}

		return instance;
	}

	public final static String TAG = "User";


	private String uid;

	private String loginname;


	private String loginpass;


	private String email;


	private String gender;


	private String image;


	private int status;


	private String activationCode;

	private List<ProductComment> commentList;

	public List<ProductComment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<ProductComment> commentList) {
		this.commentList = commentList;
	}

	private int admin;	//1为admin，2为普通用户

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

	public void reset() {
		loginname = null;
		loginpass = null;
		email = null;
		gender = null;
		image = null;
		status = 0;
		activationCode = null;
	}

	public void save() {
		Utils.saveObject(AppConstants.CACHEDIR + TAG, this);
	}
	
	// -----------以下3个方法用于序列化-----------------
	public User readResolve() throws ObjectStreamException, CloneNotSupportedException {
		instance = (User) this.clone();
		return instance;
	}

	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject();
	}

	public Object Clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
