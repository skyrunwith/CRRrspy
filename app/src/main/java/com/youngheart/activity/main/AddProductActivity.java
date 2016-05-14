package com.youngheart.activity.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.infrastructure.net.RequestCallback;
import com.infrastructure.net.RequestParameter;
import com.youngheart.R;
import com.youngheart.base.AbstractRequestCallback;
import com.youngheart.base.AppBaseActivity;
import com.youngheart.engine.RemoteService;
import com.youngheart.entity.AddProduct;
import com.youngheart.entity.TProduct;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/9.
 */
public class AddProductActivity extends AppBaseActivity{
    private EditText editText,editText3,editText4,editText5,editText6,editText7,editText8,editText9,editText10,editText11;
    private Button sure;
	private LinearLayout Back_LinearLayout;
    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_addproduct);
        editText = (EditText) findViewById(R.id.editText);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText11 = (EditText) findViewById(R.id.editText11);
        sure = (Button) findViewById(R.id.sure);
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddProduct tproduct = new AddProduct();
                tproduct.setProductid(editText3.getText().toString().trim());
                tproduct.setExpiration(editText11.getText().toString().trim());
                tproduct.setIntroduction(editText6.getText().toString().trim());
                tproduct.setSize(editText9.getText().toString().trim());
                tproduct.setProducedate(new Date());
                tproduct.setProductname(editText.getText().toString().trim());
                tproduct.setProducttypeid(editText5.getText().toString().trim());
                tproduct.setProducerid(editText8.getText().toString().trim());
                tproduct.setTracecode(editText7.getText().toString().trim());
                tproduct.setProductlotid(editText4.getText().toString().trim());
				if(editText3.getText().toString().trim().length() != 5){
					Toast.makeText(AddProductActivity.this, "请输入五位产品id", Toast.LENGTH_LONG).show();
				}
				else{
					addProduct(tproduct);
				}
            }
        });
		
		 //退出监听
        Back_LinearLayout = (LinearLayout) findViewById(R.id.Back_LinearLayout);
        Back_LinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addProduct(AddProduct tproduct) {
        RequestCallback AddCallback = new AbstractRequestCallback() {
            @Override
            public void onSuccess(String content) {
                Toast.makeText(AddProductActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        };
        ArrayList<RequestParameter> params = new ArrayList<>();
        RequestParameter rp1 = new RequestParameter("tproduct", JSON.toJSONString(tproduct));
        params.add(rp1);
        RemoteService.getInstance().invoke(this, "addTProduct", params, AddCallback);
    }

    @Override
    protected void loadData() {

    }
}
