package com.youngheart.base;

import android.app.Fragment;
import android.os.Bundle;

import com.infrastructure.activity.BaseActivity;
import com.infrastructure.net.RequestManager;
import com.infrastructure.net.RequestParameter;

/**
 * Created by Administrator on 2016/4/24.
 */
public class ProductBaseFragment extends Fragment{
     RequestManager requestManager = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestManager = new RequestManager((BaseActivity) getActivity());
        super.onCreate(savedInstanceState);
    }
}
