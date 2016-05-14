package com.youngheart.activity.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.infrastructure.net.RequestCallback;
import com.infrastructure.net.RequestParameter;
import com.youngheart.R;
import com.youngheart.base.AbstractRequestCallback;
import com.youngheart.base.AppBaseActivity;
import com.youngheart.engine.RemoteService;
import com.youngheart.engine.User;
import com.youngheart.entity.ProductComment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/8.
 */
public class MyCommentActivity extends AppBaseActivity{
    MyCommentAdapter adapter;
    ListView listView;
    private LinearLayout Back_LinearLayout;
    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.acitivyt_mycomment);
        //退出监听
        Back_LinearLayout = (LinearLayout) findViewById(R.id.Back_LinearLayout);
        Back_LinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listView = (ListView) findViewById(R.id.listView);
        adapter = new MyCommentAdapter();
        listView.setAdapter(adapter);
    }

    @Override
    protected void loadData() {
//        RequestCallback ProductDetailCallback = new AbstractRequestCallback() {
//            @Override
//            public void onSuccess(String content) {
//
//                adapter.notifyDataSetChanged();
//            }
//        };
//        ArrayList<RequestParameter> params = new ArrayList<>();
//        RequestParameter rp1 = new RequestParameter("userName", User.getInstance().getLoginname());
//        params.add(rp1);
//        RemoteService.getInstance().invoke(this, "getMyComment", params, ProductDetailCallback);
    }

    class MyCommentAdapter extends BaseAdapter{
        List<ProductComment> comments = User.getInstance().getCommentList();
        LayoutInflater mInflater = LayoutInflater.from(MyCommentActivity.this);
        @Override
        public int getCount() {
            if(comments != null){
                return comments.size();
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
            holder.comment_TextView.setText(comments.get(position).getUserip() + comments.get(position).getContent() +
                    "{" + comments.get(position).getCommentdate() + "}");
            return convertView;
        }

        public final class ViewHolder {
            public TextView comment_TextView;
        }
    }
}
