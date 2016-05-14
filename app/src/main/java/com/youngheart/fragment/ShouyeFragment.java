package com.youngheart.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.infrastructure.activity.BaseActivity;
import com.infrastructure.net.RequestCallback;
import com.infrastructure.net.RequestParameter;
import com.youngheart.R;
import com.youngheart.activity.erweima.ScanActivity;
import com.youngheart.activity.erweima.ScanCommentActivity;
import com.youngheart.activity.main.AddCommentActivity;
import com.youngheart.activity.main.AddProductActivity;
import com.youngheart.activity.main.CaoZuoActivity;
import com.youngheart.activity.main.CommentActivity;
import com.youngheart.activity.main.ComplainActivity;
import com.youngheart.activity.main.MainActivity;
import com.youngheart.activity.main.NewsActivity;
import com.youngheart.activity.main.TouSuActivity;
import com.youngheart.activity.product.ProductDetailActivity;
import com.youngheart.base.AbstractRequestCallback;
import com.youngheart.engine.RemoteService;
import com.youngheart.engine.User;
import com.youngheart.entity.TNews;
import com.youngheart.entity.risk;
import com.youngheart.ui.ExpandableLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShouyeFragment extends BaseFragment implements OnClickListener {

	private ImageView search;
	private ImageView EwmImg;
	private static final String TAG = "ShouyeFragment";
	private MainActivity mMainActivity;
	private BounceScrollView scrollview;
	private int[] expand = { R.id.first, R.id.second, R.id.three, R.id.four };
	private String[] expandHearName = { "新闻动态", "产品区域", "统计分析", "风险预警" };
	private Drawable hideImg, expandImg;
	private EditText traceCode;
	private View headerSearch;
	private LinearLayout scrollLinear;

	//显示界面
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//获取界面
		View shouyeLayout = inflater.inflate(R.layout.home, container, false);

		scrollLinear = new LinearLayout(getActivity());
		scrollLinear.setOrientation(LinearLayout.VERTICAL);
		scrollview = (BounceScrollView) shouyeLayout
				.findViewById(R.id.ScrollView);
		headerSearch = inflater.inflate(R.layout.home_layout, container,
				false);
		//跳转到评论扫描二维码界面
		ImageView Pljl = (ImageView) headerSearch.findViewById(R.id.Pljl);
		Pljl.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), ScanCommentActivity.class);
				startActivity(intent);
			}
		});

		ImageView GmdjImg = (ImageView) headerSearch.findViewById(R.id.GmdjImg);
		GmdjImg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), AddCommentActivity.class);
				startActivity(intent);
			}
		});


		ImageView CzzyImg = (ImageView) headerSearch.findViewById(R.id.CzzyImg);
		CzzyImg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), CaoZuoActivity.class);
				startActivity(intent);
			}
		});

		ImageView TsjbImg = (ImageView) headerSearch.findViewById(R.id.TsjbImg);
		TsjbImg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), TouSuActivity.class);
				startActivity(intent);
			}
		});

		if(User.getInstance().getAdmin() == 0){
			RelativeLayout sptjRl = (RelativeLayout) headerSearch.findViewById(R.id.sptjRl);
			sptjRl.setVisibility(View.GONE);
		}else{
			ImageView SptjImg = (ImageView) headerSearch.findViewById(R.id.SptjImg);
			SptjImg.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(getActivity(), AddProductActivity.class);
					startActivity(intent);
				}
			});
		}

		LinearLayout EwmLL = (LinearLayout) headerSearch
				.findViewById(R.id.EwmLL);
		EwmImg = (ImageView) EwmLL.findViewById(R.id.EwmImg);
		EwmImg.setOnClickListener(this);
		RelativeLayout searchRL = (RelativeLayout) headerSearch
				.findViewById(R.id.searchRLL);
		search = (ImageView) headerSearch.findViewById(R.id.searchImg);
		search.setOnClickListener(this);
		// 溯源码
		traceCode = (EditText) headerSearch
				.findViewById(R.id.TraceCode_EditText);

		for (int i = 0; i < expand.length; i++) {
			ExpandableLayout item = (ExpandableLayout) headerSearch
					.findViewById(expand[i]);
			FrameLayout frame = item.getHeaderLayout();
			final TextView text = (TextView) ((RelativeLayout) frame
					.getChildAt(0)).getChildAt(0);
			text.setText(expandHearName[i]);
			item.setOnDrawableState(new ExpandableLayout.OnDrawableState() {
				@Override
				public void setExpande() {
					text.setCompoundDrawables(expandImg, null, null, null);
				}

				@Override
				public void setCollapse() {
					text.setCompoundDrawables(hideImg, null, null, null);
				}
			});
		}
		scrollLinear.addView(headerSearch);
		scrollview.addView(scrollLinear);
		loadData();
		return shouyeLayout;
	}

	private void loadData(){
		//获取统计分析
		RequestCallback AddCallback = new AbstractRequestCallback() {
			@Override
			public void onSuccess(String content) {
				List<risk>  risks = JSON.parseArray(content, risk.class);
				ExpandableLayout item = (ExpandableLayout) headerSearch
						.findViewById(expand[2]);
				FrameLayout frame = item.getHeaderLayout();
				final TextView text = (TextView) ((RelativeLayout) frame
						.getChildAt(0)).getChildAt(0);
				text.setText(expandHearName[2]);
				FrameLayout contentFm = item.getContentLayout();
				LinearLayout tjfxLl = (LinearLayout) contentFm.getChildAt(0);
				for(final risk r: risks){
					LayoutInflater inflater = LayoutInflater.from(getActivity());
					RelativeLayout rL = (RelativeLayout) inflater.inflate(R.layout.item_tjfx, null);
					tjfxLl.addView(rL);
					TextView title = (TextView) rL.findViewById(R.id.title);
					TextView contentTx = (TextView) rL.findViewById(R.id.content);
					title.setText(r.gettProduct().getProductname());
					contentTx.setText("投诉次数：" + r.getTouSuEntities().size());

					rL.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							Intent intent = new Intent();
							Bundle bundle = new Bundle();
							bundle.putSerializable("tousu", (Serializable) r.getTouSuEntities());
							intent.putExtras(bundle);
							intent.setClass(getActivity(), ComplainActivity.class);
							startActivity(intent);
						}
					});
				}
				item.setOnDrawableState(new ExpandableLayout.OnDrawableState() {
					@Override
					public void setExpande() {
						text.setCompoundDrawables(expandImg, null, null, null);
					}

					@Override
					public void setCollapse() {
						text.setCompoundDrawables(hideImg, null, null, null);
					}
				});
			}
		};
		ArrayList<RequestParameter> params = new ArrayList<>();
		RemoteService.getInstance().invoke((BaseActivity) getActivity(), "getTouSus", params, AddCallback);


		//获取新闻列表
		RequestCallback NewCallback = new AbstractRequestCallback() {
			@Override
			public void onSuccess(String content) {
				List<TNews>  news = JSON.parseArray(content, TNews.class);
				ExpandableLayout item = (ExpandableLayout) headerSearch
						.findViewById(expand[0]);
				FrameLayout frame = item.getHeaderLayout();
				final TextView text = (TextView) ((RelativeLayout) frame
						.getChildAt(0)).getChildAt(0);
				text.setText(expandHearName[0]);
				FrameLayout contentFm = item.getContentLayout();
				LinearLayout tjfxLl = (LinearLayout) contentFm.getChildAt(0);
				for(final TNews n: news){
					LayoutInflater inflater = LayoutInflater.from(getActivity());
					RelativeLayout rL = (RelativeLayout) inflater.inflate(R.layout.item_tjfx, null);
					tjfxLl.addView(rL);
					TextView title = (TextView) rL.findViewById(R.id.title);
					TextView contentTx = (TextView) rL.findViewById(R.id.content);
					title.setText(n.getTitle());
					contentTx.setText(n.getContent());

					rL.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							Intent intent = new Intent();
							Bundle bundle = new Bundle();
							bundle.putSerializable("tNews", n);
							intent.putExtras(bundle);
							intent.setClass(getActivity(), NewsActivity.class);
							startActivity(intent);
						}
					});
				}
				item.setOnDrawableState(new ExpandableLayout.OnDrawableState() {
					@Override
					public void setExpande() {
						text.setCompoundDrawables(expandImg, null, null, null);
					}

					@Override
					public void setCollapse() {
						text.setCompoundDrawables(hideImg, null, null, null);
					}
				});
			}
		};
		ArrayList<RequestParameter> newparams = new ArrayList<>();
		RemoteService.getInstance().invoke((BaseActivity) getActivity(), "getNews", newparams, NewCallback);
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		Log.e(TAG, "onAttach-----");

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Resources res = getResources();
		expandImg = res.getDrawable(R.drawable.xiala_expand);
		expandImg.setBounds(0, 0, expandImg.getMinimumWidth(),
				expandImg.getMinimumHeight());
		hideImg = res.getDrawable(R.drawable.xiala_normal);
		hideImg.setBounds(0, 0, hideImg.getMinimumWidth(),
				hideImg.getMinimumHeight());
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.e(TAG, "onresume---->");
		MainActivity.currFragTag = Constant.FRAGMENT_FLAG_MESSAGE;
	}

	@Override
	public void onClick(View v) {
		if (v == search) {
			String traceCodeStr = traceCode.getText().toString();
			Intent intent = new Intent();
			Bundle bundle = new Bundle();
			bundle.putString("TraceCode", traceCodeStr);
			intent.putExtras(bundle);
			intent.setClass(getActivity(), ProductDetailActivity.class);
			startActivity(intent);
		}else if(v == EwmImg)
		{
			Intent intent = new Intent(getActivity(), ScanActivity.class);
			startActivity(intent);
		}
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1 && resultCode == -1) {
			Bundle bundle = data.getExtras();
			String result = bundle.getString("result");
		}

	}

	@Override
	public void loadData(String str){

	}

	public static Fragment newInstance() {
		ShouyeFragment fg = new ShouyeFragment();
		return fg;
	}
}
