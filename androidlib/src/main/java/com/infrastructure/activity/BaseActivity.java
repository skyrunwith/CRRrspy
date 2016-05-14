package com.infrastructure.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.infrastructure.net.RequestManager;

public abstract class BaseActivity extends FragmentActivity {
	/**
	 * 请求列表管理器
	 */
	protected RequestManager requestManager = null;

	public BaseActivity instance;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestManager = new RequestManager(this);
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		initVariables();
		initViews(savedInstanceState);
		loadData();
	}

	protected abstract void initVariables();

	protected abstract void initViews(Bundle savedInstanceState);

	protected abstract void loadData();

	protected void onDestroy() {
		/**
		 * 在activity销毁的时候同时设置停止请求，停止线程请求回调
		 */
		if (requestManager != null) {
			requestManager.cancelRequest();
		}
		super.onDestroy();
	}

	protected void onPause() {
		/**
		 * 在activity停止的时候同时设置停止请求，停止线程请求回调
		 */
		if (requestManager != null) {
			requestManager.cancelRequest();
		}
		super.onPause();
	}

	public RequestManager getRequestManager() {
		return requestManager;
	}
}