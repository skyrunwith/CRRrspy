package com.youngheart.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.infrastructure.activity.BaseActivity;
import com.infrastructure.net.RequestCallback;
import com.youngheart.R;
import com.youngheart.activity.main.MainActivity;
import com.youngheart.activity.wuliu.WuLiuDetailActivity;
import com.youngheart.base.AbstractRequestCallback;
import com.youngheart.engine.RemoteService;
import com.youngheart.entity.Transport;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zbar.ZBarView;

public class WuliuFragment extends BaseFragment implements QRCodeView.Delegate {


	private Context context;
	private QRCodeView mQRCodeView;

	public static Fragment newInstance(){
		WuliuFragment fg = new WuliuFragment();
		return fg;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View wuliuLayout = inflater.inflate(R.layout.wuliu_layout,
				container, false);
		mQRCodeView = (ZBarView) wuliuLayout.findViewById(R.id.zbarview);
		mQRCodeView.setResultHandler(this);
		RequestCallback wuliuCallback = new AbstractRequestCallback() {
			@Override
			public void onSuccess(String content) {
				loadData(content);
			}
		};
		RemoteService.getInstance().invoke((BaseActivity) getActivity(), "getTransport", null, wuliuCallback);
		return wuliuLayout;
	}

	@Override
	public void onStart() {
		super.onStart();
		mQRCodeView.startCamera();
	}

	@Override
	public void onStop() {
		mQRCodeView.stopCamera();
		super.onStop();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mQRCodeView.startSpotAndShowRect();
		MainActivity.currFragTag = Constant.FRAGMENT_FLAG_CONTACTS;
	}

	@Override
	public void loadData(String str){
	}

	@Override
	public void onScanQRCodeSuccess(String result) {
		Intent intent = new Intent();
		intent.setClass(getActivity(), WuLiuDetailActivity.class);
		intent.putExtra("TraceCode", result);
		startActivity(intent);
	}

	@Override
	public void onScanQRCodeOpenCameraError() {
		Log.e("debug", "打开相机出错");
	}

	
}
