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

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/7.
 */
//投诉界面
public class TouSuActivity extends AppBaseActivity{
    private LinearLayout Back_LinearLayout;
    private EditText editText,editText2 ,editText3,editText4, editText5;
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
        setContentView(R.layout.activity_tsjb);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3  = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        Back_LinearLayout = (LinearLayout) findViewById(R.id.Back_LinearLayout);
        Back_LinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button = (Button) findViewById(R.id.sure);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String traceCode = editText.getText().toString().trim();
                String name = editText2.getText().toString().trim();
                String idCard = editText2.getText().toString().trim();
                String tel = editText2.getText().toString().trim();
                String tsLy = editText2.getText().toString().trim();
                if(traceCode.length() == 0){
                    Toast.makeText(TouSuActivity.this, "请输入溯源码", Toast.LENGTH_SHORT).show();
                }
                if(name.length() == 0){
                    Toast.makeText(TouSuActivity.this, "请输入评论", Toast.LENGTH_SHORT).show();
                }
                if(idCard.length() == 0){
                    Toast.makeText(TouSuActivity.this, "请输入姓名", Toast.LENGTH_SHORT).show();
                }
                if(tel.length() == 0){
                    Toast.makeText(TouSuActivity.this, "请输入身份证号", Toast.LENGTH_SHORT).show();
                }
                if(tsLy.length() == 0){
                    Toast.makeText(TouSuActivity.this, "请输投诉理由", Toast.LENGTH_SHORT).show();
                }
                if(traceCode.length() != 0 && name.length() != 0 && idCard.length() != 0 && tel.length() != 0 && tsLy.length() != 0){
                    addComment(traceCode, name, idCard, tel, tsLy);
                }
            }
        });
    }

    @Override
    protected void loadData() {

    }

    protected  void addComment(String traceCode, String name, String idCard, String tel, String tsLy){
        RequestCallback AddCallback = new AbstractRequestCallback() {
            @Override
            public void onSuccess(String content) {
                Toast.makeText(TouSuActivity.this, "评论成功", Toast.LENGTH_SHORT).show();
            }
        };
        ArrayList<RequestParameter> params = new ArrayList<>();
        RequestParameter rp1 = new RequestParameter("TraceCode", traceCode);
        RequestParameter rp2 = new RequestParameter("Name", name);
        RequestParameter rp3 = new RequestParameter("IdCard", idCard);
        RequestParameter rp4 = new RequestParameter("Tel", tel);
        RequestParameter rp5 = new RequestParameter("TsLy", tsLy);
        params.add(rp1);
        params.add(rp2);
        params.add(rp3);
        params.add(rp4);
        params.add(rp5);
        RemoteService.getInstance().invoke(this, "addTouSu", params, AddCallback);
    }
}
