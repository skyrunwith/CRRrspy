package com.youngheart.activity.main;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Menu;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.youngheart.R;
import com.youngheart.base.AppBaseActivity;
import com.youngheart.engine.User;
import com.youngheart.fragment.BaseFragment;
import com.youngheart.fragment.BottomControlPanel;
import com.youngheart.fragment.BottomControlPanel.*;
import com.youngheart.fragment.Constant;
import com.youngheart.fragment.HeadControlPanel;

public class MainActivity extends AppBaseActivity implements BottomPanelCallback {
	BottomControlPanel bottomPanel = null;
	HeadControlPanel headPanel = null;
	private FragmentManager fragmentManager = null;
	private FragmentTransaction fragmentTransaction = null;

	private RelativeLayout rl_activity;
	private ImageView search;
	private float y;
	private int height;
	/*
	 * private MessageFragment messageFragment; private ContactsFragment
	 * contactsFragment; private NewsFragment newsFragment; private
	 * SettingFragment settingFragment;
	 */

	private Handler handler = null;
	public static String currFragTag = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void initVariables() {

	}

	@Override
	protected void initViews(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		//
		rl_activity = (RelativeLayout) findViewById(R.id.rl_activitya);
		bottomPanel = (BottomControlPanel) findViewById(R.id.bottom_layout);
		if (bottomPanel != null) {
			bottomPanel.initBottomPanel();
			bottomPanel.setBottomCallback(this);
			if(User.getInstance().getAdmin() == 0)
				bottomPanel.setmContactsBtn();
		}
		headPanel = (HeadControlPanel) findViewById(R.id.head_layout);
		if (headPanel != null) {
			headPanel.initHeadPanel();
		}

		fragmentManager = getFragmentManager();
		setDefaultFirstFragment(Constant.FRAGMENT_FLAG_MESSAGE);

	}

	@Override
	protected void loadData() {

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1 && resultCode == -1) {
			super.onActivityResult(requestCode, resultCode, data);
			Fragment f = fragmentManager.findFragmentByTag(Constant.FRAGMENT_FLAG_MESSAGE);
			f.onActivityResult(requestCode, resultCode, data); 
			Toast.makeText(this, "MainActivity", Toast.LENGTH_LONG).show();
		} else {
			TranslateAnimation animation = new TranslateAnimation(0, 0, -y, 0);
			animation.setDuration(500);
			animation.setFillAfter(true);
			rl_activity.startAnimation(animation);
			super.onActivityResult(requestCode, resultCode, data);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/*
	 * ����BottomControlPanel�Ļص�
	 *
	 * @see
	 * org.yanzi.ui.BottomControlPanel.BottomPanelCallback#onBottomPanelClick
	 * (int)
	 */
	@Override
	public void onBottomPanelClick(int itemId) {
		String tag = "";
		if ((itemId & Constant.BTN_FLAG_MESSAGE) != 0) {
			tag = Constant.FRAGMENT_FLAG_MESSAGE;
		} else if ((itemId & Constant.BTN_FLAG_CONTACTS) != 0) {
			tag = Constant.FRAGMENT_FLAG_CONTACTS;
		} else if ((itemId & Constant.BTN_FLAG_NEWS) != 0) {
			tag = Constant.FRAGMENT_FLAG_NEWS;
		}
		setTabSelection(tag);
		headPanel.setMiddleTitle(tag);
	}

	private void setDefaultFirstFragment(String tag) {
		setTabSelection(tag);
		bottomPanel.defaultBtnChecked();
	}

	private void commitTransactions(String tag) {
		if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
			fragmentTransaction.commit();
			currFragTag = tag;
			fragmentTransaction = null;
		}
	}

	private FragmentTransaction ensureTransaction() {
		if (fragmentTransaction == null) {
			fragmentTransaction = fragmentManager.beginTransaction();
			fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_NONE);
			// fragmentTransaction.setCustomAnimations(R.anim.animation_2,
			// R.anim.animation_1);
		}
		return fragmentTransaction;

	}

	private void attachFragment(int layout, Fragment f, String tag) {
		if (f != null) {
			if (f.isDetached()) {
				ensureTransaction();
				fragmentTransaction.attach(f);
			} else if (!f.isAdded()) {
				ensureTransaction();
				fragmentTransaction.add(layout, f, tag);
			}
		}
	}

	private Fragment getFragment(String tag) {

		Fragment f = fragmentManager.findFragmentByTag(tag);

		if (f == null) {
			f = BaseFragment.newInstance(getApplicationContext(), tag, handler);
		}
		return f;

	}

	private void detachFragment(Fragment f) {

		if (f != null && !f.isDetached()) {
			ensureTransaction();
			fragmentTransaction.detach(f);
		}
	}

	/**
	 * �л�fragment
	 *
	 * @param tag
	 */
	private void switchFragment(String tag) {
		if (TextUtils.equals(tag, currFragTag)) {
			return;
		}
		if (currFragTag != null && !currFragTag.equals("")) {
			detachFragment(getFragment(currFragTag));
		}
		attachFragment(R.id.fragment_content, getFragment(tag), tag);
		commitTransactions(tag);
	}

	/**
	 * ����ѡ�е�Tag
	 *
	 * @param tag
	 */
	public void setTabSelection(String tag) {
		fragmentTransaction = fragmentManager.beginTransaction();
		switchFragment(tag);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		currFragTag = "";
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
	}

}
