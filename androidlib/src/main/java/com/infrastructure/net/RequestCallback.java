package com.infrastructure.net;

import android.app.Dialog;

import com.infrastructure.activity.BaseActivity;

public interface RequestCallback
{
	public void onSuccess(String content);

	public void onFail(String errorMessage);

	public void onCookieExpired();

	public void createDialog(final BaseActivity baseActivity);
}
