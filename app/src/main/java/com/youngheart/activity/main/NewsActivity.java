package com.youngheart.activity.main;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.youngheart.R;
import com.youngheart.base.AppBaseActivity;
import com.youngheart.engine.AppConstants;
import com.youngheart.engine.User;
import com.youngheart.entity.ProductComment;
import com.youngheart.entity.TNews;
import com.youngheart.fragment.TouSuEntity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/9.
 */
public class NewsActivity extends AppBaseActivity {
    private LinearLayout Back_LinearLayout;
    private TextView title, content;
    private TNews tNews;
    private ImageView vp;
    @Override
    protected void initVariables() {
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){

        }else{
            tNews = (TNews) bundle.getSerializable("tNews");
        }
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_news);
        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);
        title.setText(tNews.getTitle());
        content.setText(tNews.getContent());
        vp = (ImageView) findViewById(R.id.vp);
        displayImage(tNews.getImage());
        //退出监听
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
}
