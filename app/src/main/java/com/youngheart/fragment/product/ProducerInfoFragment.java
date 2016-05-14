package com.youngheart.fragment.product;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
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

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/24.
 */
public class ProducerInfoFragment extends Fragment {

    private int position;
    private String traceCode;
    private TextView producerid_TextView, corporation_TextView, brand_TextView, address_TextView,
            telephone_TextView, postcode_TextView;
    private TableLayout Inspect_TableLayout;
    private ImageView vp;
    private LayoutInflater layoutInflater;
    public ProducerInfoFragment(int position, String traceCode){
        this.position = position;
        this.traceCode = traceCode;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_producerinfo,null);
        vp = (ImageView) view.findViewById(R.id.vp);
        producerid_TextView = (TextView) view.findViewById(R.id.producerid_TextView);
        corporation_TextView = (TextView) view.findViewById(R.id.corporation_TextView);
        brand_TextView = (TextView) view.findViewById(R.id.brand_TextView);
        address_TextView = (TextView) view.findViewById(R.id.address_TextView);
        telephone_TextView = (TextView) view.findViewById(R.id.telephone_TextView);
        postcode_TextView = (TextView) view.findViewById(R.id.postcode_TextView);
        Inspect_TableLayout = (TableLayout) view.findViewById(R.id.Inspect_TableLayout);

        layoutInflater = inflater;

        loadData();
        return view;
    }

    private void loadData() {
        RequestCallback ProducerCallback = new AbstractRequestCallback() {
            @Override
            public void onSuccess(String content) {
                TProducer tProducer = JSON.parseObject(content, TProducer.class);
                displayImage(tProducer.getImage());
                producerid_TextView.setText(tProducer.getProducerid());
                corporation_TextView.setText(tProducer.getCorporation());
                brand_TextView.setText(tProducer.getBrand());
                address_TextView.setText(tProducer.getAddress());
                telephone_TextView.setText(tProducer.getTelephone());
                postcode_TextView.setText(tProducer.getPostcode());
                for(int index = 0; index < tProducer.getCredentials().size(); index++){
                    TableRow rootTableRow = (TableRow) layoutInflater.inflate(R.layout.item_producerinfo,null);
                    TextView credentialid, name, issuedby, issuetime, expirytime, scope, status;
                    credentialid = (TextView) rootTableRow.findViewById(R.id.credentialid);
                    name = (TextView) rootTableRow.findViewById(R.id.name);
                    issuedby = (TextView) rootTableRow.findViewById(R.id.issuedby);
                    issuetime = (TextView) rootTableRow.findViewById(R.id.issuetime);
                    expirytime = (TextView) rootTableRow.findViewById(R.id.expirytime);
                    scope = (TextView) rootTableRow.findViewById(R.id.scope);
                    status = (TextView) rootTableRow.findViewById(R.id.status);

                    credentialid.setText(tProducer.getCredentials().get(index).getCredentialid());
                    name.setText(tProducer.getCredentials().get(index).getName());
                    issuedby.setText(tProducer.getCredentials().get(index).getIssuedby());
                    issuetime.setText(tProducer.getCredentials().get(index).getIssuetime());
                    expirytime.setText(tProducer.getCredentials().get(index).getExpirytime());
                    scope.setText(tProducer.getCredentials().get(index).getScope());
                    status.setText(tProducer.getCredentials().get(index).getStatus());

                    if(index == tProducer.getCredentials().size() - 1){
                        rootTableRow.setBackgroundResource(R.drawable.shape_bottom_corner_no_top_line);
                    }else{
                        rootTableRow.setBackgroundResource(R.drawable.shape_no_corner_without_bottom);
                    }
                    Inspect_TableLayout.addView(rootTableRow);
                }
            }
        };
        ArrayList<RequestParameter> params = new ArrayList<>();
        RequestParameter rp1 = new RequestParameter("TraceCode", traceCode);
        params.add(rp1);
        RemoteService.getInstance().invoke((BaseActivity) getActivity(), "getProducer", params, ProducerCallback);
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
