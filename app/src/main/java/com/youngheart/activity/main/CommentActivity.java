package com.youngheart.activity.main;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.infrastructure.activity.BaseActivity;
import com.infrastructure.net.RequestCallback;
import com.infrastructure.net.RequestParameter;
import com.youngheart.R;
import com.youngheart.adapter.CommentAdapter;
import com.youngheart.base.AbstractRequestCallback;
import com.youngheart.base.AppBaseActivity;
import com.youngheart.engine.RemoteService;
import com.youngheart.entity.TProduct;
import com.youngheart.ui.MyListView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/6.
 */
public class CommentActivity extends AppBaseActivity{
    private LinearLayout Back_LinearLayout;
    private TextView Name_TextView;
    private MyListView Comemnts_ListView;
    private CommentAdapter commentAdapter;
    private String traceCode;
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
        setContentView(R.layout.activity_comment);
        Name_TextView = (TextView) findViewById(R.id.Name_TextView);
        Comemnts_ListView = (MyListView) findViewById(R.id.Comemnts_ListView);

        commentAdapter = new CommentAdapter(this, null);
        Comemnts_ListView.setAdapter(commentAdapter);
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
        RequestCallback ProductDetailCallback = new AbstractRequestCallback() {
            @Override
            public void onSuccess(String content) {
                TProduct tProduct = JSON.parseObject(content, TProduct.class);
                Name_TextView.setText(tProduct.getProductname());
                commentAdapter.setProductCommentList(tProduct.getComments());
                commentAdapter.notifyDataSetChanged();
            }
        };
        ArrayList<RequestParameter> params = new ArrayList<>();
        RequestParameter rp1 = new RequestParameter("TraceCode", traceCode);
        params.add(rp1);
        RemoteService.getInstance().invoke(this, "getProductByTraceCode", params, ProductDetailCallback);
    }
}
