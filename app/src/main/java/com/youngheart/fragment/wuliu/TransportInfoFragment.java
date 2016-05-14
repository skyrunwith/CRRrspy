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
import com.youngheart.adapter.CommentAdapter;
import com.youngheart.base.AbstractRequestCallback;
import com.youngheart.engine.AppConstants;
import com.youngheart.engine.RemoteService;
import com.youngheart.entity.Materil;
import com.youngheart.entity.TProduct;
import com.youngheart.entity.Transport;
import com.youngheart.entity.wuliu.TransportInfo;
import com.youngheart.ui.MyListView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/25.
 */
public class TransportInfoFragment extends Fragment{
    private int position;
    private String traceCode;

    private TextView producerName, productName, transportBatch, transportTime,
            transportCar, driver, temperature, salerName;
    private ImageView vp;
    public static TransportInfoFragment newInstance(int position, String traceCode){
        TransportInfoFragment f  = new TransportInfoFragment();
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
        View view = inflater.inflate(R.layout.fragment_transportinfo, null);
        vp = (ImageView) view.findViewById(R.id.vp);
        producerName = (TextView) view.findViewById(R.id.producerName);
        productName = (TextView) view.findViewById(R.id.productName);
        transportBatch = (TextView) view.findViewById(R.id.transportBatch);
        transportTime = (TextView) view.findViewById(R.id.transportTime);
        transportCar = (TextView) view.findViewById(R.id.transportCar);
        driver = (TextView) view.findViewById(R.id.driver);
        temperature = (TextView) view.findViewById(R.id.temperature);
        salerName = (TextView) view.findViewById(R.id.salerName);

        loadData();
        return view;
    }

    private void loadData() {
        RequestCallback ProductDetailCallback = new AbstractRequestCallback() {
            @Override
            public void onSuccess(String content) {
                TransportInfo transportInfo = JSON.parseObject(content, TransportInfo.class);
                displayImage(transportInfo.getImage());
                producerName.setText(transportInfo.getProducerName());
                productName.setText(transportInfo.getProductName());
                transportBatch.setText(transportInfo.getTransportBatch());
                transportTime.setText(transportInfo.getTransportTime());
                transportCar.setText(transportInfo.getTransportCar());
                driver.setText(transportInfo.getDriver());
                temperature.setText(transportInfo.getTemperature());
                salerName.setText(transportInfo.getSalerName());
            }
        };
        ArrayList<RequestParameter> params = new ArrayList<>();
        RequestParameter rp1 = new RequestParameter("TraceCode", traceCode);
        params.add(rp1);
        RemoteService.getInstance().invoke((BaseActivity) getActivity(), "getTransportInfo", params, ProductDetailCallback);
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
