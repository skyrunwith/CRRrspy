package com.youngheart.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.infrastructure.activity.BaseActivity;
import com.infrastructure.net.RequestCallback;
import com.youngheart.R;
import com.youngheart.activity.login.LoginActivity;
import com.youngheart.engine.AppConstants;
import com.youngheart.utils.Utils;

public abstract class AppBaseActivity extends BaseActivity {
	protected boolean needCallback;
	public static AppBaseActivity instance;
	public static ProgressDialog dlg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;
	}
}
