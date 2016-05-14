package com.youngheart.activity.login;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.infrastructure.net.RequestCallback;
import com.infrastructure.net.RequestParameter;
import com.youngheart.R;
import com.youngheart.activity.main.MainActivity;
import com.youngheart.base.AbstractRequestCallback;
import com.youngheart.engine.AppConstants;
import com.youngheart.engine.RemoteService;
import com.youngheart.base.AppBaseActivity;
import com.youngheart.engine.User;
import com.youngheart.entity.UserInfo;
import com.youngheart.utils.Utils;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * @Title: LoginActivity.java
 * @Package com.fzd.rrpsy
 * @Description: TODO
 * @author fzd
 * @date 2015��11��8�� ����8:43:48
 * @version V1.0
 */
public class LoginActivity extends AppBaseActivity{
	private EditText username;
	private String name;
	private String password;
	private EditText pwd;
	private Button loginButton;
	private TextView Regist_TextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
	}

	//初始化变量
	@Override
	protected void initVariables() {
		Bundle bundle = getIntent().getExtras();
		if(bundle == null)
			needCallback = false;
		else
			needCallback = bundle.getBoolean(AppConstants.NeedCallback, false);
	}

	//初始化View
	@Override
	protected void initViews(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		setContentView(R.layout.activity_login);
		Regist_TextView = (TextView) findViewById(R.id.Regist_TextView);
		Regist_TextView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
				startActivity(intent);
			}
		});
		loginButton = (Button) findViewById(R.id.Submit_Button);
		loginButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				name = ((EditText)findViewById(R.id.Account_EditText)).getText().toString();
				password = ((EditText)findViewById(R.id.Pwd_EditText)).getText().toString();
				goToMainActivity();
			}
		});
	}

	//加载数据
	@Override
	protected void loadData() {

	}

	private void goToMainActivity() {
//		Dialog dialog = Utils.createProgressDialog(this, "请稍后");
//		dialog.show();
		RequestCallback loginCallback = new AbstractRequestCallback() {
			@Override
			public void onSuccess(String content) {
				UserInfo userInfo = JSON.parseObject(content,
						UserInfo.class);
				if (userInfo != null) {
					User.getInstance().reset();
					User.getInstance().setLoginname(userInfo.getLoginname());
					User.getInstance().setLoginpass(userInfo.getLoginpass());
					User.getInstance().setStatus(userInfo.getStatus());
					User.getInstance().setActivationCode(userInfo.getActivationCode());
					User.getInstance().setEmail(userInfo.getEmail());
					User.getInstance().setGender(userInfo.getGender());
					User.getInstance().setImage(userInfo.getImage());
					User.getInstance().setUid(userInfo.getUid());
					User.getInstance().setAdmin(userInfo.getAdmin());
					User.getInstance().setCommentList(userInfo.gettProductcommentEntitySet());
					User.getInstance().save();
				}
				if(needCallback){
					setResult(Activity.RESULT_OK);
					finish();
				}else{
					Intent intent = new Intent();
					intent.setClass(LoginActivity.this, MainActivity.class);
					startActivity(intent);
				}
			}
		};
		loginCallback.createDialog(this);
		ArrayList<RequestParameter> params = new ArrayList<>();
		RequestParameter rp1= new RequestParameter("userName", name);
		RequestParameter rp2 = new RequestParameter("pwd", password);
		params.add(rp1);
		params.add(rp2);
		RemoteService.getInstance().invoke(this,"login",params,loginCallback);
	}
}
