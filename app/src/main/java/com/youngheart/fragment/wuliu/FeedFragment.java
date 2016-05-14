package com.youngheart.fragment.wuliu;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.infrastructure.activity.BaseActivity;
import com.infrastructure.net.RequestCallback;
import com.infrastructure.net.RequestParameter;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.youngheart.R;
import com.youngheart.base.AbstractRequestCallback;
import com.youngheart.engine.AppConstants;
import com.youngheart.engine.RemoteService;
import com.youngheart.entity.bean.TCowEntity;
import com.youngheart.entity.bean.TFarmEntity;
import com.youngheart.entity.bean.TFeedingEntity;
import com.youngheart.entity.bean.TFeedstuffEntity;
import com.youngheart.entity.wuliu.Feed;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/29.
 */
public class FeedFragment extends Fragment {
    private int position;
    private String traceCode;

    private final String[] materailTitle = {"奶牛信息","饲养信息","饲料信息"};
    private final String[] Title1 = {"奶牛编号","品种","牛舍","年龄","生理状态","是否免疫"};
    private final String[] Title2 = {"奶牛编号","饲养日期","牧场名称","饲料","饲料批次","饲养员","营养状态"};
    private final String[] Title3 = {"饲料编号","饲料品名","规格","供应商"};

    private LinearLayout SL_Linear;

    private LayoutInflater inflater;

    private TextView name,address,environment, corporation,
                    telephone, postcode;
    private ImageView vp;
    public static FeedFragment newInstance(int position, String traceCode){
        FeedFragment f  = new FeedFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putString("traceCode", traceCode);
        f.setArguments(bundle);
        return  f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        this.position = b.getInt("position");
        this.traceCode = b.getString("traceCode");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed, null);
        SL_Linear = (LinearLayout) view.findViewById(R.id.SL_Linear);
        name = (TextView) view.findViewById(R.id.name);
        address = (TextView) view.findViewById(R.id.address);
        environment = (TextView) view.findViewById(R.id.environment);
        corporation = (TextView) view.findViewById(R.id.corporation);
        telephone = (TextView) view.findViewById(R.id.telephone);
        postcode = (TextView) view.findViewById(R.id.postcode);
        vp = (ImageView) view.findViewById(R.id.vp);
        this.inflater = inflater;
        loadData();
        return view;
    }
    private void displayImage(String url) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_launcher)
                .showImageOnFail(R.drawable.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(false)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        ImageSize imageSize = new ImageSize(100,100);
        ImageLoader.getInstance().displayImage(AppConstants.URL + url,vp,options);
    }
    private void loadData() {
        RequestCallback ProductDetailCallback = new AbstractRequestCallback() {
            @Override
            public void onSuccess(String content) {
                Feed feed = JSON.parseObject(content, Feed.class);
                displayImage(feed.getFarm().getImage());
                DrawFarmView(feed.getFarm());
                DrawCowView(feed.getCows());
                DrawFeedingView(feed.getFeeds());
                DrawFeedStuffView(feed.getFeedStuffs());
            }
        };
        ArrayList<RequestParameter> params = new ArrayList<>();
        RequestParameter rp1 = new RequestParameter("TraceCode", traceCode);
        params.add(rp1);
        RemoteService.getInstance().invoke((BaseActivity) getActivity(), "getFeed", params, ProductDetailCallback);
    }

    private void DrawFeedStuffView(List<TFeedstuffEntity> feedStuffs) {
        View materailTable = inflater.inflate(R.layout.item_materailtable, null);   //包含表格和表格title的布局
        TableLayout material_TableLayout = (TableLayout) materailTable.findViewById(R.id.material_TableLayout);
        DrawTitleView(materailTitle[2], Title3, materailTable);


        for (int index = 0; index < feedStuffs.size(); index++) {
            TableRow materailContent = getFeedTitleHolder();
            TitleHolder contentHolder = (TitleHolder) materailContent.getTag();
            TFeedstuffEntity feed = feedStuffs.get(index);
            contentHolder.title1.setText(feed.getFeedstuffid());
            contentHolder.title2.setText(feed.getName());
            contentHolder.title3.setText(feed.getSize());
            contentHolder.title4.setText(feed.getCompany());
            contentHolder.title5.setVisibility(View.GONE);
            contentHolder.title6.setVisibility(View.GONE);
            contentHolder.title7.setVisibility(View.GONE);
            contentHolder.title8.setVisibility(View.GONE);
            if(index < feedStuffs.size() - 1)
                materailContent.setBackgroundResource(R.drawable.shape_no_corner_without_bottom);
            else
                materailContent.setBackgroundResource(R.drawable.shape_bottom_corner_no_top_line);
            //添加tabrow
            material_TableLayout.addView(materailContent);
        }
    }

    private void DrawFeedingView(List<TFeedingEntity> feeds) {
        View materailTable = inflater.inflate(R.layout.item_materailtable, null);   //包含表格和表格title的布局
        TableLayout material_TableLayout = (TableLayout) materailTable.findViewById(R.id.material_TableLayout);
        DrawTitleView(materailTitle[1], Title2, materailTable);

        for (int index = 0; index < feeds.size(); index++) {
            TableRow materailContent = getFeedTitleHolder();
            TitleHolder contentHolder = (TitleHolder) materailContent.getTag();
            TFeedingEntity feed = feeds.get(index);
            contentHolder.title1.setText(feed.getCowid());
            contentHolder.title2.setText(feed.getDate());
            contentHolder.title3.setText(feed.getFarmName());
            contentHolder.title4.setText(feed.getFeedstuffEntity().getName());
            contentHolder.title5.setText(feed.getFeedstuffEntity().getFeedstuffid());
            contentHolder.title6.setText(feed.getEmployName());
            contentHolder.title7.setText(feed.getRemark());
            contentHolder.title8.setVisibility(View.GONE);
            if(index < feeds.size() - 1)
                materailContent.setBackgroundResource(R.drawable.shape_no_corner_without_bottom);
            else
                materailContent.setBackgroundResource(R.drawable.shape_bottom_corner_no_top_line);
            //添加tabrow
            material_TableLayout.addView(materailContent);
        }
    }


    private void DrawFarmView(TFarmEntity farm) {
        name.setText(farm.getName());
        address.setText(farm.getAddress());
        corporation.setText(farm.getCorporation());
        environment.setText(farm.getEnvironment());
        telephone.setText(farm.getTelephone());
        postcode.setText(farm.getPostcode());
    }

    private void DrawCowView(List<TCowEntity> cows) {
        View materailTable = inflater.inflate(R.layout.item_materailtable, null);   //包含表格和表格title的布局
        TableLayout material_TableLayout = (TableLayout) materailTable.findViewById(R.id.material_TableLayout);
        DrawTitleView(materailTitle[0], Title1, materailTable);


        for (int index = 0; index < cows.size(); index++) {
            TableRow materailContent = getFeedTitleHolder();
            TitleHolder contentHolder = (TitleHolder) materailContent.getTag();
            TCowEntity cow = cows.get(index);
            contentHolder.title1.setText(cow.getCowid());
            contentHolder.title2.setText(cow.getType());
            contentHolder.title3.setText(cow.getCowhouse());
            contentHolder.title4.setText(cow.getAge());
            contentHolder.title5.setText(cow.getStatus());
            contentHolder.title6.setText(cow.getInspect());
            contentHolder.title7.setVisibility(View.GONE);
            contentHolder.title8.setVisibility(View.GONE);
            if(index < cows.size() - 1)
                materailContent.setBackgroundResource(R.drawable.shape_no_corner_without_bottom);
            else
                materailContent.setBackgroundResource(R.drawable.shape_bottom_corner_no_top_line);
            //添加tabrow
            material_TableLayout.addView(materailContent);
        }
    }


    private void DrawTitleView(String MaterailName,final String[] title, View materailTable){
        //表格title
        TextView material_TextView = (TextView) materailTable.findViewById(R.id.material_TextView);
        //表格Table
        TableLayout material_TableLayout = (TableLayout) materailTable.findViewById(R.id.material_TableLayout);
        //设置表格的名字
        material_TextView.setText(MaterailName);
        //开始画表格第一行
        TableRow materailTitle = getFeedTitleHolder();
        TitleHolder titleHolder = (TitleHolder) materailTitle.getTag();
        titleHolder.title1.setText(title[0]);
        titleHolder.title2.setText(title[1]);
        titleHolder.title3.setText(title[2]);
        titleHolder.title4.setText(title[3]);

        if(title.length >= 5)
            titleHolder.title5.setText(title[4]);
        else
            titleHolder.title5.setVisibility(View.GONE);

        if(title.length >= 6)
            titleHolder.title6.setText(title[5]);
        else
            titleHolder.title6.setVisibility(View.GONE);

        if(title.length >= 7)
            titleHolder.title7.setText(title[6]);
        else
            titleHolder.title7.setVisibility(View.GONE);

        if(title.length == 8)
            titleHolder.title8.setText(title[7]);
        else
            titleHolder.title8.setVisibility(View.GONE);
        //添加tabrow
        material_TableLayout.addView(materailTitle);
        //添加画好的表格
        SL_Linear.addView(materailTable);
    }

    private TableRow getFeedTitleHolder(){
        TitleHolder titleHolder = new TitleHolder();
        TableRow FeedTitle = (TableRow) inflater.inflate(R.layout.item_materialtitle, null);
        titleHolder.title1 = (TextView) FeedTitle.findViewById(R.id.title1);
        titleHolder.title2 = (TextView) FeedTitle.findViewById(R.id.title2);
        titleHolder.title3 = (TextView) FeedTitle.findViewById(R.id.title3);
        titleHolder.title4 = (TextView) FeedTitle.findViewById(R.id.title4);
        titleHolder.title5 = (TextView) FeedTitle.findViewById(R.id.title5);
        titleHolder.title6 = (TextView) FeedTitle.findViewById(R.id.title6);
        titleHolder.title7 = (TextView) FeedTitle.findViewById(R.id.title7);
        titleHolder.title8 = (TextView) FeedTitle.findViewById(R.id.title8);
        FeedTitle.setTag(titleHolder);
        return FeedTitle;
    }

    private class TitleHolder{
        private  TextView title1;
        private  TextView title2;
        private  TextView title3;
        private  TextView title4;
        private  TextView title5;
        private  TextView title6;
        private  TextView title7;
        private  TextView title8;
    }

    private class TableHolder{
        private TextView material_TextView;
        private TableLayout material_TableLayout;
    }
}
