package com.youngheart.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.infrastructure.net.RequestCallback;
import com.infrastructure.net.RequestParameter;
import com.youngheart.R;
import com.youngheart.activity.login.LoginActivity;
import com.youngheart.base.AbstractRequestCallback;
import com.youngheart.base.AppBaseActivity;
import com.youngheart.engine.RemoteService;
import com.youngheart.engine.User;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/8.
 */
public class UpdatePwdActivity extends AppBaseActivity{

    private LinearLayout Back_LinearLayout;
    private Button button;
    private EditText oldEt, newEt, sureNewEt;
    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_updatepwd);
        oldEt = (EditText) findViewById(R.id.oldPwd);
        newEt = (EditText) findViewById(R.id.newPwd);
        sureNewEt = (EditText) findViewById(R.id.surenewPwd);
        //退出监听
        Back_LinearLayout = (LinearLayout) findViewById(R.id.Back_LinearLayout);
        Back_LinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        button = (Button) findViewById(R.id.sure);
        //修改密码
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPwd = oldEt.getText().toString().trim();
                String newPwd = newEt.getText().toString().trim();
                String surePwd = newEt.getText().toString().trim();
                if(oldPwd.length() == 0){
                    Toast.makeText(UpdatePwdActivity.this, "请输入原密码", Toast.LENGTH_SHORT).show();
                }
                if(newPwd.length() == 0){
                    Toast.makeText(UpdatePwdActivity.this, "请输入新密码", Toast.LENGTH_SHORT).show();
                }
                if(surePwd.length() == 0){
                    Toast.makeText(UpdatePwdActivity.this, "请确认新密码", Toast.LENGTH_SHORT).show();
                }
                if(oldPwd.length() != 0 && newPwd.length() != 0 && surePwd.length() != 0){
                    if(newPwd.equals(surePwd)){
                        RequestCallback AddCallback = new AbstractRequestCallback() {
                            @Override
                            public void onSuccess(String content) {
                                Toast.makeText(UpdatePwdActivity.this, "修改密码成功", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent();
                                intent.setClass(UpdatePwdActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                        };
                        ArrayList<RequestParameter> params = new ArrayList<>();
                        RequestParameter rp1 = new RequestParameter("userName", User.getInstance().getLoginname());
                        RequestParameter rp2 = new RequestParameter("pwd", newPwd);
                        params.add(rp1);
                        params.add(rp2);
                        RemoteService.getInstance().invoke(UpdatePwdActivity.this, "updatePwd", params, AddCallback);
                    }else{
                        Toast.makeText(UpdatePwdActivity.this, "新密码和旧密码不一致", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
