package com.youngheart.base;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import com.infrastructure.activity.BaseActivity;
import com.infrastructure.net.RequestCallback;
import com.youngheart.activity.login.LoginActivity;
import com.youngheart.engine.AppConstants;
import com.youngheart.utils.Utils;

/**
 * Created by Administrator on 2016/4/23.
 */
public abstract class AbstractRequestCallback implements RequestCallback {

    private Dialog dlg;
    public abstract void onSuccess(String content);

    public void createDialog(final BaseActivity baseActivity){
//        dlg.show();
//        dlg.show();
//        this.dlg = dlg;
//        dlg = Utils.createProgressDialog(baseActivity, "请稍后");
//        dlg.show();
    }


    public void onFail(String errorMessage) {
//        dlg.dismiss();
        Toast.makeText(AppBaseActivity.instance, errorMessage, Toast.LENGTH_SHORT).show();
//        new AlertDialog.Builder(AppBaseActivity.instance).setTitle("出错啦")
//                .setMessage(errorMessage).setPositiveButton("确定", null)
//                .show();
    }

    public void onCookieExpired() {

//        Toast.makeText(AppBaseActivity.instance, , )
//        dlg.dismiss();

//        new AlertDialog.Builder(AppBaseActivity.instance)
//                .setTitle("出错啦")
//                .setMessage("Cookie过期，请重新登录")
//                .setPositiveButton("确定",
//                        new DialogInterface.OnClickListener() {
//
//                            @Override
//                            public void onClick(DialogInterface dialog,
//                                                int which) {
//                                Intent intent = new Intent(
//                                        AppBaseActivity.instance,
//                                        LoginActivity.class);
//                                intent.putExtra(AppConstants.NeedCallback,
//                                        true);
//                                AppBaseActivity.instance.startActivity(intent);
//                            }
//                        }).show();
    }
}
