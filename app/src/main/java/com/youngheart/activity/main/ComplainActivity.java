package com.youngheart.activity.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.infrastructure.net.RequestCallback;
import com.infrastructure.net.RequestParameter;
import com.youngheart.R;
import com.youngheart.adapter.CommentAdapter;
import com.youngheart.base.AbstractRequestCallback;
import com.youngheart.base.AppBaseActivity;
import com.youngheart.engine.RemoteService;
import com.youngheart.engine.User;
import com.youngheart.entity.ProductComment;
import com.youngheart.entity.TProduct;
import com.youngheart.fragment.TouSuEntity;
import com.youngheart.ui.MyListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/9.
 */
//投诉详情
public class ComplainActivity  extends AppBaseActivity {
    private LinearLayout Back_LinearLayout;
    private TextView Name_TextView;
    private ListView listView;
    private MyCommentAdapter adapter;
    private ArrayList<TouSuEntity> touSuEntities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initVariables() {
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){

        }else{
            touSuEntities = (ArrayList<TouSuEntity>) bundle.getSerializable("tousu");
        }
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_complain);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new MyCommentAdapter();
        listView.setAdapter(adapter);
        Back_LinearLayout = (LinearLayout) findViewById(R.id.Back_LinearLayout);
        Back_LinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        loadData();
    }

    @Override
    protected void loadData() {
    }

    class MyCommentAdapter extends BaseAdapter {
        LayoutInflater mInflater = LayoutInflater.from(ComplainActivity.this);
        @Override
        public int getCount() {
            if(touSuEntities != null){
                return touSuEntities.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(
                        R.layout.item_comment, null);
                holder.comment_TextView = (TextView) convertView.findViewById(R.id.comment);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.comment_TextView.setText(touSuEntities.get(position).getName()+" : " + touSuEntities.get(position).getReason());
//                    "{" + comments.get(position).getCommentdate() + "}");
            return convertView;
        }

        public final class ViewHolder {
            public TextView comment_TextView;
        }
    }
}

