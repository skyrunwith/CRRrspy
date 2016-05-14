package com.youngheart.activity.login;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.infrastructure.net.RequestCallback;
import com.infrastructure.net.RequestParameter;
import com.youngheart.R;
import com.youngheart.activity.main.MainActivity;
import com.youngheart.base.AbstractRequestCallback;
import com.youngheart.base.AppBaseActivity;
import com.youngheart.engine.RemoteService;
import com.youngheart.engine.User;
import com.youngheart.entity.UserInfo;

import java.util.ArrayList;

public class RegistActivity extends AppBaseActivity implements OnClickListener {
	private EditText mCount_EditText;
	private EditText mPwd_EditText;
	private Button registButton;
	private LinearLayout back_LinearLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	protected void initVariables() {

	}

	@Override
	protected void initViews(Bundle savedInstanceState) {
		setContentView(R.layout.activity_regist);
		mCount_EditText = (EditText) findViewById(R.id.Account_EditText);
		mPwd_EditText = (EditText) findViewById(R.id.Pwd_EditText);
		registButton = (Button) findViewById(R.id.login_Button);
		back_LinearLayout = (LinearLayout) findViewById(R.id.Back_LinearLayout);
		registButton.setOnClickListener(this);
		back_LinearLayout.setOnClickListener(this);
	}

	@Override
	protected void loadData() {

	}

	@Override
	public void onClick(View v) {
		// 注册
		int i = 0;
		if (registButton == v) {
			if (!"".equals(mCount_EditText.getText().toString())
					&& !"".equals(mPwd_EditText.getText().toString())) {
				//提交注册
				RequestCallback registCallback = new AbstractRequestCallback() {
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
							Intent intent = new Intent();
							intent.setClass(RegistActivity.this, MainActivity.class);
							startActivity(intent);
						}
				};
				ArrayList<RequestParameter> params = new ArrayList<>();
				RequestParameter rp1= new RequestParameter("userName", mCount_EditText.getText().toString());
				RequestParameter rp2 = new RequestParameter("pwd", mPwd_EditText.getText().toString());
				params.add(rp1);
				params.add(rp2);
				RemoteService.getInstance().invoke(this,"regist",params,registCallback);
			} else {
				Toast.makeText(this, "账号密码格式不正确", Toast.LENGTH_SHORT).show();
			}
		} else if (back_LinearLayout == v) {
			finish();
		}
	}
}
