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
import com.youngheart.entity.wuliu.ProduceInfo;
import com.youngheart.entity.wuliu.TransportInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/25.
 */
public class ProduceInfoFragment extends Fragment{
    private int position;
    private String traceCode;

    private TextView workShop, traceCodeT, produceBatch, produceDate,
                     employName, account, status, produceName, productName,
                     step1, step2, step3, step4, step5, step6, step7, step8,
                     step9, step10;
    private ImageView vp;
    public static ProduceInfoFragment newInstance(int position, String traceCode){
        ProduceInfoFragment f  = new ProduceInfoFragment();
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
        View view = inflater.inflate(R.layout.fragment_produceinfo, null);
        workShop = (TextView) view.findViewById(R.id.workShop);
        productName = (TextView) view.findViewById(R.id.productName);
        traceCodeT = (TextView) view.findViewById(R.id.traceCode);
        produceBatch = (TextView) view.findViewById(R.id.produceBatch);
        produceDate = (TextView) view.findViewById(R.id.produceDate);
        vp = (ImageView) view.findViewById(R.id.vp);
        employName = (TextView) view.findViewById(R.id.employName);
        account = (TextView) view.findViewById(R.id.account);
        status = (TextView) view.findViewById(R.id.status);
        produceName = (TextView) view.findViewById(R.id.produceName);

        step1 = (TextView) view.findViewById(R.id.step1);
        step2 = (TextView) view.findViewById(R.id.step2);
        step3 = (TextView) view.findViewById(R.id.step3);
        step4 = (TextView) view.findViewById(R.id.step4);
        step5 = (TextView) view.findViewById(R.id.step5);
        step6 = (TextView) view.findViewById(R.id.step6);
        step7 = (TextView) view.findViewById(R.id.step7);
        step8 = (TextView) view.findViewById(R.id.step8);
        step9 = (TextView) view.findViewById(R.id.step9);
        step10 = (TextView) view.findViewById(R.id.step10);
        loadData();
        return view;
    }

    private void loadData() {
        RequestCallback ProductDetailCallback = new AbstractRequestCallback() {
            @Override
            public void onSuccess(String content) {
                ProduceInfo produceInfo = JSON.parseObject(content, ProduceInfo.class);
                displayImage(produceInfo.getImage());
                workShop.setText(produceInfo.getWorkShop());
                productName.setText(produceInfo.getProductName());
                traceCodeT.setText(produceInfo.getTraceCode());
                produceBatch.setText(produceInfo.getProduceBatch());
                produceDate.setText(produceInfo.getProduceDate());
                employName.setText(produceInfo.getEmployName());
                account.setText(produceInfo.getAccount());
                status.setText(produceInfo.getStatus());
                produceName.setText(produceInfo.getProduceName());

                step1.setText(produceInfo.getProcess().getStep1());
                step2.setText(produceInfo.getProcess().getStep2());
                step3.setText(produceInfo.getProcess().getStep3());
                step4.setText(produceInfo.getProcess().getStep4());
                step5.setText(produceInfo.getProcess().getStep5());
                step6.setText(produceInfo.getProcess().getStep6());
                step7.setText(produceInfo.getProcess().getStep7());
                step8.setText(produceInfo.getProcess().getStep9());
                step9.setText(produceInfo.getProcess().getStep9());
                step10.setText(produceInfo.getProcess().getStep10());
            }
        };
        ArrayList<RequestParameter> params = new ArrayList<>();
        RequestParameter rp1 = new RequestParameter("TraceCode", traceCode);
        params.add(rp1);
        RemoteService.getInstance().invoke((BaseActivity) getActivity(), "getProduceInfo", params, ProductDetailCallback);
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
