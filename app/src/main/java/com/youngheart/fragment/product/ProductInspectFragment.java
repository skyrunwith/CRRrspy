package com.youngheart.fragment.product;

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
import com.youngheart.entity.TProducer;
import com.youngheart.entity.TProducerecord;
import com.youngheart.entity.TProduct;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/24.
 */
public class ProductInspectFragment extends Fragment {

    private int position;
    private  String traceCode;

    private TextView productlotid_TextView, producedate_TextView, gender_TextView, age_TextView,
            telephone_TextView,company_TextView,protein_TextView, fat_TextView, vitamin_TextView,
            calcium_TextView, energy_TextView, disinfect_TextView, employname_TextView, Name_TextView;
    private ImageView vp;
    public ProductInspectFragment(int position, String traceCode){
        this.traceCode = traceCode;
        this.position = position;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_productinspect,null);
        vp = (ImageView) view.findViewById(R.id.vp);
        Name_TextView = (TextView) view.findViewById(R.id.Name_TextView);
        employname_TextView = (TextView) view.findViewById(R.id.employname_TextView);
        productlotid_TextView = (TextView) view.findViewById(R.id.productlotid_TextView);
        producedate_TextView = (TextView) view.findViewById(R.id.producedate_TextView);
        gender_TextView = (TextView) view.findViewById(R.id.gender_TextView);
        age_TextView = (TextView) view.findViewById(R.id.age_TextView);
        telephone_TextView = (TextView) view.findViewById(R.id.telephone_TextView);
        company_TextView = (TextView) view.findViewById(R.id.company_TextView);
        protein_TextView = (TextView) view.findViewById(R.id.protein_TextView);
        fat_TextView = (TextView) view.findViewById(R.id.fat_TextView);
        vitamin_TextView = (TextView) view.findViewById(R.id.vitamin_TextView);
        calcium_TextView = (TextView) view.findViewById(R.id.calcium_TextView);
        energy_TextView = (TextView) view.findViewById(R.id.energy_TextView);
        disinfect_TextView = (TextView) view.findViewById(R.id.disinfect_TextView);
        loadData();
        return view;
    }

    private void loadData(){
        RequestCallback ProductInspectCallback = new AbstractRequestCallback() {
            @Override
            public void onSuccess(String content) {
                TProducerecord tProducerecord = JSON.parseObject(content, TProducerecord.class);
                productlotid_TextView.setText(tProducerecord.getProductlotid());
                producedate_TextView.setText(tProducerecord.getProducedate());
                employname_TextView.setText(tProducerecord.getEmployee().getName());
                gender_TextView.setText(tProducerecord.getEmployee().getGender());
                age_TextView.setText(tProducerecord.getEmployee().getAge());
                telephone_TextView.setText(tProducerecord.getEmployee().getTelephone());
                company_TextView.setText(tProducerecord.getEmployee().getCompany());

                protein_TextView.setText(tProducerecord.getProductInspect().getProtein() + "g");
                fat_TextView.setText(tProducerecord.getProductInspect().getFat() + "g");
                vitamin_TextView.setText(tProducerecord.getProductInspect().getVitamin() + "g");
                calcium_TextView.setText(tProducerecord.getProductInspect().getCalcium() + "g");
                energy_TextView.setText(tProducerecord.getProductInspect().getEnergy() + "千克");
                disinfect_TextView.setText(tProducerecord.getProductInspect().getDisinfect());
                displayImage(tProducerecord.getImage());
            }
        };
        ArrayList<RequestParameter> params = new ArrayList<>();
        RequestParameter rp1 = new RequestParameter("TraceCode", traceCode);
        params.add(rp1);
        RemoteService.getInstance().invoke((BaseActivity) getActivity(), "getProductRecord", params, ProductInspectCallback);
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
