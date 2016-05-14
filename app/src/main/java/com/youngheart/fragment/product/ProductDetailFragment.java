package com.youngheart.fragment.product;

/**
 * Created by Administrator on 2016/4/24.
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.infrastructure.activity.BaseActivity;
import com.infrastructure.net.RequestCallback;
import com.infrastructure.net.RequestParameter;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.youngheart.R;
import com.youngheart.activity.product.ProductDetailActivity;
import com.youngheart.adapter.CommentAdapter;
import com.youngheart.base.AbstractRequestCallback;
import com.youngheart.engine.AppConstants;
import com.youngheart.engine.RemoteService;
import com.youngheart.entity.Materil;
import com.youngheart.entity.ProductComment;
import com.youngheart.entity.TProduct;
import com.youngheart.ui.MyListView;

import java.util.ArrayList;

public class ProductDetailFragment extends Fragment {
    private int position;
    private String traceCode;

    private TextView TraceCode_TextView, productlotid_TextView, producedate_TextView, expiration_TextView, package_TextView, size_TextView, producer_TextView,
            protein_TextView, fat_TextView, vitamin_TextView, calcium_TextView, energy_TextView, disinfect_TextView, material_TextView, Name_TextView;
    private MyListView Comemnts_ListView;
    private CommentAdapter commentAdapter;
    private ImageView vp;
    public ProductDetailFragment(int position, String traceCode) {
        this.traceCode = traceCode;
        this.position = position;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_productdetail, null);
        vp = (ImageView) view.findViewById(R.id.vp);
        Name_TextView = (TextView) view.findViewById(R.id.Name_TextView);
        TraceCode_TextView = (TextView) view.findViewById(R.id.TraceCode_TextView);
        productlotid_TextView = (TextView) view.findViewById(R.id.productlotid_TextView);
        producedate_TextView = (TextView) view.findViewById(R.id.producedate_TextView);
        expiration_TextView = (TextView) view.findViewById(R.id.expiration_TextView);
        package_TextView = (TextView) view.findViewById(R.id.package_TextView);
        size_TextView = (TextView) view.findViewById(R.id.size_TextView);
        producer_TextView = (TextView) view.findViewById(R.id.producer_TextView);
        protein_TextView = (TextView) view.findViewById(R.id.protein_TextView);
        fat_TextView = (TextView) view.findViewById(R.id.fat_TextView);
        vitamin_TextView = (TextView) view.findViewById(R.id.vitamin_TextView);
        calcium_TextView = (TextView) view.findViewById(R.id.calcium_TextView);
        energy_TextView = (TextView) view.findViewById(R.id.energy_TextView);
        disinfect_TextView = (TextView) view.findViewById(R.id.disinfect_TextView);
        material_TextView = (TextView) view.findViewById(R.id.material_TextView);
        Comemnts_ListView = (MyListView) view.findViewById(R.id.Comemnts_ListView);


        commentAdapter = new CommentAdapter(getActivity(), null);
        Comemnts_ListView.setAdapter(commentAdapter);
        loadData();
        return view;
    }

    private void loadData() {
        RequestCallback ProductDetailCallback = new AbstractRequestCallback() {
            @Override
            public void onSuccess(String content) {
                TProduct tProduct = JSON.parseObject(content, TProduct.class);
                displayImage(tProduct.getImage());

                Name_TextView.setText(tProduct.getProductname());
                TraceCode_TextView.setText(tProduct.getTracecode());
                productlotid_TextView.setText(tProduct.getProductlotid());
                producedate_TextView.setText(tProduct.getProducedate());
                expiration_TextView.setText(tProduct.getExpiration());
                package_TextView.setText(tProduct.getPackageName());
                size_TextView.setText(tProduct.getSize());
                producer_TextView.setText(tProduct.getProduceName());

                protein_TextView.setText(tProduct.getProductInspect().getProtein() + "g");
                fat_TextView.setText(tProduct.getProductInspect().getFat() + "g");
                vitamin_TextView.setText(tProduct.getProductInspect().getVitamin() + "g");
                calcium_TextView.setText(tProduct.getProductInspect().getCalcium()+ "g");
                energy_TextView.setText(tProduct.getProductInspect().getEnergy() + "");
                disinfect_TextView.setText(tProduct.getProductInspect().getDisinfect() + "");

                String materilStr = "";
                for (Materil materil: tProduct.getMaterils()) {
                    materilStr += materil.getName();
                    materilStr += " ";
                }
                material_TextView.setText(materilStr);
                commentAdapter.setProductCommentList(tProduct.getComments());
                commentAdapter.notifyDataSetChanged();

            }
        };
        ArrayList<RequestParameter> params = new ArrayList<>();
        RequestParameter rp1 = new RequestParameter("TraceCode", traceCode);
        params.add(rp1);
        RemoteService.getInstance().invoke((BaseActivity) getActivity(), "getProductByTraceCode", params, ProductDetailCallback);
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