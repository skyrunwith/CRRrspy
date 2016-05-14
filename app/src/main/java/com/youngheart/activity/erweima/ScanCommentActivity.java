package com.youngheart.activity.erweima;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.youngheart.R;
import com.youngheart.activity.main.CommentActivity;
import com.youngheart.activity.product.ProductDetailActivity;
import com.youngheart.base.AppBaseActivity;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zbar.ZBarView;

public class ScanCommentActivity extends AppBaseActivity implements QRCodeView.Delegate {
    private static final String TAG = ScanCommentActivity.class.getSimpleName();
    private QRCodeView mQRCodeView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        mQRCodeView = (ZBarView) findViewById(R.id.zbarview);
        mQRCodeView.setResultHandler(this);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        mQRCodeView.startCamera();
        mQRCodeView.startSpotAndShowRect();
    }

    @Override
    protected void onStop() {
        mQRCodeView.stopCamera();
        super.onStop();
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("TraceCode", result);
        intent.putExtras(bundle);
        intent.setClass(ScanCommentActivity.this, CommentActivity.class);
        startActivity(intent);
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.e(TAG, "打开相机出错");
    }
}