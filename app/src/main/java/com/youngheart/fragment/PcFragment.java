package com.youngheart.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.youngheart.R;
import com.youngheart.activity.login.LoginActivity;
import com.youngheart.activity.main.MainActivity;
import com.youngheart.activity.main.MyCommentActivity;
import com.youngheart.activity.main.UpdatePwdActivity;
import com.youngheart.engine.User;

//  个人中心
public class PcFragment extends BaseFragment {

	public static Fragment newInstance(){
		PcFragment fragment = new PcFragment();
		return fragment;
	}

	@Override
	public View onCreateView(final LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View newsLayout = inflater.inflate(
				R.layout.fragment_personal_information, container, false);
		TextView textView = (TextView) newsLayout.findViewById(R.id.user_number);
		textView.setText(User.getInstance().getLoginname());

		//退出按钮
		RelativeLayout rel = (RelativeLayout) newsLayout.findViewById(R.id.tuichu);
		rel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), LoginActivity.class);
				startActivity(intent);
			}
		});

		TextView updatePwd = (TextView) newsLayout.findViewById(R.id.updatePwd);
		TextView comments = (TextView) newsLayout.findViewById(R.id.comments);
		updatePwd.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), UpdatePwdActivity.class);
				startActivity(intent);
			}
		});
		comments.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), MyCommentActivity.class);
				startActivity(intent);
			}
		});
		return newsLayout;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		MainActivity.currFragTag = Constant.FRAGMENT_FLAG_NEWS;
	}

}
