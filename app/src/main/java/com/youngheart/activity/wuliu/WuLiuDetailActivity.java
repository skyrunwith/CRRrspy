package com.youngheart.activity.wuliu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.youngheart.R;
import com.youngheart.base.AppBaseActivity;
import com.youngheart.entity.Car;
import com.youngheart.entity.Employee;
import com.youngheart.entity.Saler;
import com.youngheart.entity.Transport;
import com.youngheart.fragment.product.ProducerInfoFragment;
import com.youngheart.fragment.product.ProductDetailFragment;
import com.youngheart.fragment.product.ProductInspectFragment;
import com.youngheart.fragment.wuliu.FeedFragment;
import com.youngheart.fragment.wuliu.MaterailFragment;
import com.youngheart.fragment.wuliu.ProduceInfoFragment;
import com.youngheart.fragment.wuliu.StoreInfoFragment;
import com.youngheart.fragment.wuliu.TransportInfoFragment;
import com.youngheart.ui.viewpage.PagerSlidingTabStrip;

/**
 * @Title: WuLiuDetailActivity.java
 * @Package com.fzd.rrpsy
 * @Description: TODO
 * @author fzd
 * @date 2016��3��10�� ����1:06:54
 * @version V1.0
 */
public class WuLiuDetailActivity extends AppBaseActivity{

	private PagerSlidingTabStrip tabs;
	private ViewPager pager;
	private MyPagerAdapter adapter;
	private String traceCode;
	private LinearLayout Back_LinearLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void initVariables() {
		Bundle bundle = getIntent().getExtras();
		if(bundle == null){
			traceCode = "";
		}else{
			traceCode = bundle.getString("TraceCode");
		}
	}

	@Override
	protected void initViews(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_productdetail);

		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		pager = (ViewPager) findViewById(R.id.pager);
		adapter = new MyPagerAdapter(getSupportFragmentManager());

		pager.setAdapter(adapter);

		final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources()
				.getDisplayMetrics());
		pager.setPageMargin(pageMargin);

		tabs.setIndicatorColor(getResources().getColor(R.color.lightblue));
		tabs.setDividerColor(getResources().getColor(R.color.lightblue));
		tabs.setShouldExpand(true);
		tabs.setViewPager(pager);

		Back_LinearLayout = (LinearLayout) findViewById(R.id.Back_LinearLayout);
		Back_LinearLayout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	@Override
	protected void loadData() {

	}

	public class MyPagerAdapter extends FragmentPagerAdapter {

		private final String[] TITLES = { "流通信息","仓储信息","加工信息","原料进货信息","奶牛养殖信息"};

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public Fragment getItem(int position) {
			if(position == 0) {
				return  TransportInfoFragment.newInstance(position, traceCode);
			}
			else if(position == 1){
				return  StoreInfoFragment.newInstance(position, traceCode);
			}
			else if(position == 2){
				return ProduceInfoFragment.newInstance(position, traceCode);
			}else if(position == 3){
				return MaterailFragment.newInstance(position,traceCode);
			}else if(position == 4){
				return FeedFragment.newInstance(position,traceCode);
			}
			return null;
		}

	}
}
