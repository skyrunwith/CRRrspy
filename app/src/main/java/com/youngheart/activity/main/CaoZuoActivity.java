package com.youngheart.activity.main;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.youngheart.R;
import com.youngheart.base.AppBaseActivity;

/**
 * Created by Administrator on 2016/5/10.
 */
public class CaoZuoActivity extends AppBaseActivity{
    private LinearLayout Back_LinearLayout;
    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_caozuo);
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
}
