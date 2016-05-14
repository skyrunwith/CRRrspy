package com.youngheart.activity.product;
import com.youngheart.R;
import com.youngheart.base.AppBaseActivity;
import com.youngheart.fragment.product.ProducerInfoFragment;
import com.youngheart.fragment.product.ProductDetailFragment;
import com.youngheart.fragment.product.ProductInspectFragment;
import com.youngheart.ui.viewpage.PagerSlidingTabStrip;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

/**
 * @Title: ProductDetailActivity.java
 * @Package com.fzd.rrpsy
 * @Description: TODO
 * @author fzd
 * @date 2016��3��9�� ����12:42:10
 * @version V1.0
 */
public class ProductDetailActivity extends AppBaseActivity {

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

		private final String[] TITLES = { "产品信息","厂商信息","质检信息"};

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		//
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
				return new ProductDetailFragment(position, traceCode);
			}
			else if(position == 1){
				return new ProducerInfoFragment(position, traceCode);
			}
			else if(position == 2){
				return new  ProductInspectFragment(position, traceCode);
			}
			return null;
		}

	}
}
