package com.youngheart.activity.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.infrastructure.net.RequestCallback;
import com.infrastructure.net.RequestParameter;
import com.youngheart.R;
import com.youngheart.base.AbstractRequestCallback;
import com.youngheart.base.AppBaseActivity;
import com.youngheart.engine.RemoteService;
import com.youngheart.engine.User;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/7.
 */
public class AddCommentActivity extends AppBaseActivity{
    private LinearLayout Back_LinearLayout;
    private EditText editText,editText2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_addcomment);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.sure);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String traceCode = editText.getText().toString().trim();
                String comment = editText2.getText().toString().trim();
                if(traceCode.length() == 0){
                    Toast.makeText(AddCommentActivity.this, "请输入溯源码", Toast.LENGTH_SHORT).show();
                }
                if(comment.length() == 0){
                    Toast.makeText(AddCommentActivity.this, "请输入评论", Toast.LENGTH_SHORT).show();
                }
                if(traceCode.length() != 0 && comment.length() != 0){
                    addComment(traceCode, comment);
                }
            }
        });
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

    protected  void addComment(String traceCode, String comment){
        RequestCallback AddCallback = new AbstractRequestCallback() {
            @Override
            public void onSuccess(String content) {
                Toast.makeText(AddCommentActivity.this, "评论成功", Toast.LENGTH_SHORT).show();
            }
        };
        ArrayList<RequestParameter> params = new ArrayList<>();
        RequestParameter rp1 = new RequestParameter("TraceCode", traceCode);
        RequestParameter rp2 = new RequestParameter("Comment", comment);
        RequestParameter rp3 = new RequestParameter("userName", User.getInstance().getLoginname());
        params.add(rp1);
        params.add(rp2);
        params.add(rp3);
        RemoteService.getInstance().invoke(this, "addComment", params, AddCallback);
    }
}
