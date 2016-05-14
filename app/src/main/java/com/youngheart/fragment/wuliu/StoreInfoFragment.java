package com.youngheart.fragment.wuliu;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.youngheart.entity.wuliu.StoreInfo;
import com.youngheart.entity.wuliu.TransportInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/25.
 */
public class StoreInfoFragment extends Fragment {
    private int position;
    private String traceCode;
    private ImageView vp;
    private TextView wearHouseName, traceCodeT, produceName, produceBatch, produceTime, room,
            inTime, outTime, temperature, account;

    public static StoreInfoFragment newInstance(int position, String traceCode){
        StoreInfoFragment f  = new StoreInfoFragment();
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
        View view = inflater.inflate(R.layout.fragment_storeinfo, null);
        wearHouseName = (TextView) view.findViewById(R.id.wearHouseName);
        traceCodeT = (TextView) view.findViewById(R.id.traceCode);
        produceName = (TextView) view.findViewById(R.id.produceName);
        produceBatch = (TextView) view.findViewById(R.id.produceBatch);
        produceTime = (TextView) view.findViewById(R.id.produceDate);
        room = (TextView) view.findViewById(R.id.room);
        temperature = (TextView) view.findViewById(R.id.temperature);
        inTime = (TextView) view.findViewById(R.id.inTime);
        outTime = (TextView) view.findViewById(R.id.outTime);
        account = (TextView) view.findViewById(R.id.account);
        vp = (ImageView) view.findViewById(R.id.vp);
        loadData();
        return view;
    }

    private void loadData() {
        RequestCallback ProductDetailCallback = new AbstractRequestCallback() {
            @Override
            public void onSuccess(String content) {
                StoreInfo storeInfo = JSON.parseObject(content, StoreInfo.class);
                displayImage(storeInfo.getImage());
                wearHouseName.setText(storeInfo.getWearHouseName());
                traceCodeT.setText(storeInfo.getTraceCode());
                produceName.setText(storeInfo.getProduceName());
                produceBatch.setText(storeInfo.getProduceBatch());
                produceTime.setText(storeInfo.getProduceTime());
                room.setText(storeInfo.getRoom());
                temperature.setText(storeInfo.getTemperature());
                inTime.setText(storeInfo.getInTime());
                outTime.setText(storeInfo.getOutTime());
                account.setText(storeInfo.getAccount());
            }
        };
        ArrayList<RequestParameter> params = new ArrayList<>();
        RequestParameter rp1 = new RequestParameter("TraceCode", traceCode);
        params.add(rp1);
        RemoteService.getInstance().invoke((BaseActivity) getActivity(), "getStoreInfo", params, ProductDetailCallback);
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
