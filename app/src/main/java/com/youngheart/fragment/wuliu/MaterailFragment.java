package com.youngheart.fragment.wuliu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.infrastructure.activity.BaseActivity;
import com.infrastructure.net.RequestCallback;
import com.infrastructure.net.RequestParameter;
import com.youngheart.R;
import com.youngheart.base.AbstractRequestCallback;
import com.youngheart.engine.RemoteService;
import com.youngheart.entity.Package;
import com.youngheart.entity.bean.TMaterialEntity;
import com.youngheart.entity.bean.TMilkingEntity;
import com.youngheart.entity.bean.TOrderEntity;
import com.youngheart.entity.bean.TRawmilkEntity;
import com.youngheart.entity.wuliu.Material;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/29.
 */
public class MaterailFragment extends Fragment{
    private int position;
    private String traceCode;

    private final String[] materailTitle = {"原料订单","原奶进货信息","原奶挤奶信息","辅料进货信息","包装材料信息"};
    private final String[] Title1 = {"订单编号","原奶批次编号","辅料批次编号","包装批次编号","进货员","进货日期","验货状态"};
    private final String[] Title2 = {"原奶编号","原奶名称","供应奶站名称","原奶储罐编号","储放温度","原奶批量"};
    private final String[] Title3 = {"挤奶批次","奶牛编号","养殖场名称","挤奶日期","检验状态","挤奶批量"};
    private final String[] Title4 = {"物料编号","物料名称","进货批次","供应商名称","物料规格","物料用途","进货数量","验货状态"};
    private final String[] Title5 = {"物料编号","物料名称","供应商名称","物料规格","物料用途","材质","验货状态"};

    private LinearLayout SL_Linear;

    private LayoutInflater inflater;

    public static MaterailFragment newInstance(int position, String traceCode){
        MaterailFragment f  = new MaterailFragment();
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
        View view = inflater.inflate(R.layout.fragment_material, null);
        SL_Linear = (LinearLayout) view.findViewById(R.id.SL_Linear);

        this.inflater = inflater;
        loadData();
        return view;
    }

    private void loadData() {
        RequestCallback ProductDetailCallback = new AbstractRequestCallback() {
            @Override
            public void onSuccess(String content) {
                Material material = JSON.parseObject(content, Material.class);
                DrawOrderView(material.getOder());
                DrawRawMilkView(material.getRawMilk());
                DrawTRawmilkEntityView(material.getMilk());
                DrawMaterialsView(material.getMaterials());
                DrawPackageView(material.getaPackage());
            }
        };
        ArrayList<RequestParameter> params = new ArrayList<>();
        RequestParameter rp1 = new RequestParameter("TraceCode",traceCode);
        params.add(rp1);
        RemoteService.getInstance().invoke((BaseActivity) getActivity(), "getMaterial", params, ProductDetailCallback);
    }


    private void DrawTitleView(String MaterailName,final String[] title, View materailTable){
        //表格title
        TextView material_TextView = (TextView) materailTable.findViewById(R.id.material_TextView);
        //表格Table
        TableLayout material_TableLayout = (TableLayout) materailTable.findViewById(R.id.material_TableLayout);
        //设置表格的名字
        material_TextView.setText(MaterailName);
        //开始画表格第一行
        TableRow materailTitle = getMaterailTitleHolder();
        TitleHolder titleHolder = (TitleHolder) materailTitle.getTag();
        titleHolder.title1.setText(title[0]);
        titleHolder.title2.setText(title[1]);
        titleHolder.title3.setText(title[2]);
        titleHolder.title4.setText(title[3]);
        titleHolder.title5.setText(title[4]);
        titleHolder.title6.setText(title[5]);
        if(title.length >= 7)
            titleHolder.title7.setText(title[6]);
        else
            titleHolder.title7.setVisibility(View.GONE);
        if(title.length == 8)
            titleHolder.title8.setText(title[7]);
        else
            titleHolder.title8.setVisibility(View.GONE);
        //添加tabrow
        material_TableLayout.addView(materailTitle);
        //添加画好的表格
        SL_Linear.addView(materailTable);
    }

    private void DrawOrderView(TOrderEntity order) {
        View materailTable = inflater.inflate(R.layout.item_materailtable, null);   //包含表格和表格title的布局
        TableLayout material_TableLayout = (TableLayout) materailTable.findViewById(R.id.material_TableLayout);
        DrawTitleView(materailTitle[0], Title1, materailTable);

        TableRow materailContent = getMaterailTitleHolder();
        TitleHolder contentHolder = (TitleHolder) materailContent.getTag();
        materailContent.setBackgroundResource(R.drawable.shape_bottom_corner_no_top_line);
        contentHolder.title1.setText(order.getOrderid());
        contentHolder.title2.setText(order.getRawmilklotid());
        contentHolder.title3.setText(order.getAccessorylotid());
        contentHolder.title4.setText(order.getPackagelotid());
        contentHolder.title5.setText(order.getEmployeeName());
        contentHolder.title6.setText(order.getDate());
        contentHolder.title7.setText(order.getStatus());
        contentHolder.title8.setVisibility(View.GONE);
        //添加tabrow
        material_TableLayout.addView(materailContent);
    }

    private  void DrawRawMilkView(TRawmilkEntity rawmilkEntity){
        View materailTable = inflater.inflate(R.layout.item_materailtable, null);   //包含表格和表格title的布局
        TableLayout material_TableLayout = (TableLayout) materailTable.findViewById(R.id.material_TableLayout);
        DrawTitleView(materailTitle[1], Title2, materailTable);

        TableRow materailContent = getMaterailTitleHolder();
        TitleHolder contentHolder = (TitleHolder) materailContent.getTag();
        materailContent.setBackgroundResource(R.drawable.shape_bottom_corner_no_top_line);
        contentHolder.title1.setText(rawmilkEntity.getRawmilklotid());
        contentHolder.title2.setText(rawmilkEntity.getName());
        contentHolder.title3.setText(rawmilkEntity.getMilkStationName());
        contentHolder.title4.setText(rawmilkEntity.getTank());
        contentHolder.title5.setText(rawmilkEntity.getTemperature());
        contentHolder.title6.setText(rawmilkEntity.getSize());
        contentHolder.title7.setVisibility(View.GONE);
        contentHolder.title8.setVisibility(View.GONE);
        //添加tabrow
        material_TableLayout.addView(materailContent);
    }

    private void DrawTRawmilkEntityView(TMilkingEntity milking) {
        View materailTable = inflater.inflate(R.layout.item_materailtable, null);   //包含表格和表格title的布局
        TableLayout material_TableLayout = (TableLayout) materailTable.findViewById(R.id.material_TableLayout);
        DrawTitleView(materailTitle[2], Title3, materailTable);

        TableRow materailContent = getMaterailTitleHolder();
        TitleHolder contentHolder = (TitleHolder) materailContent.getTag();
        materailContent.setBackgroundResource(R.drawable.shape_bottom_corner_no_top_line);
        contentHolder.title1.setText(milking.getRawmilklotid());
        contentHolder.title2.setText(milking.getCowid());
        contentHolder.title3.setText(milking.getFarmName());
        contentHolder.title4.setText(milking.getDate());
        contentHolder.title5.setText(milking.getStatus());
        contentHolder.title6.setText(milking.getAmount());
        contentHolder.title7.setVisibility(View.GONE);
        contentHolder.title8.setVisibility(View.GONE);
        //添加tabrow
        material_TableLayout.addView(materailContent);
    }

    private void DrawMaterialsView(List<TMaterialEntity> materials) {
        View materailTable = inflater.inflate(R.layout.item_materailtable, null);   //包含表格和表格title的布局
        TableLayout material_TableLayout = (TableLayout) materailTable.findViewById(R.id.material_TableLayout);
        DrawTitleView(materailTitle[3], Title4, materailTable);

        for(int index = 0; index < materials.size(); index++){
            TableRow materailContent = getMaterailTitleHolder();
            TitleHolder contentHolder = (TitleHolder) materailContent.getTag();
            TMaterialEntity materialEntity = materials.get(index);
            contentHolder.title1.setText(materialEntity.getMateriallotid());
            contentHolder.title2.setText(materialEntity.getName());
            contentHolder.title3.setText(materialEntity.getAccessId());
            contentHolder.title4.setText(materialEntity.getSupplierName());
            contentHolder.title5.setText(materialEntity.getSize());
            contentHolder.title6.setText(materialEntity.getUseness());
            contentHolder.title7.setText(materialEntity.getAmount() + " 千克");
            contentHolder.title8.setText(materialEntity.getStatus());
            if(index < materials.size() - 1)
                materailContent.setBackgroundResource(R.drawable.shape_no_corner_without_bottom);
            else
                materailContent.setBackgroundResource(R.drawable.shape_bottom_corner_no_top_line);
            //添加tabrow
            material_TableLayout.addView(materailContent);
        }
    }

    private void DrawPackageView(Package aPackage) {
        View materailTable = inflater.inflate(R.layout.item_materailtable, null);   //包含表格和表格title的布局
        TableLayout material_TableLayout = (TableLayout) materailTable.findViewById(R.id.material_TableLayout);
        DrawTitleView(materailTitle[4], Title5, materailTable);
        TableRow materailContent = getMaterailTitleHolder();
        TitleHolder contentHolder = (TitleHolder) materailContent.getTag();
        contentHolder.title1.setText(aPackage.getPackagelotid());
        contentHolder.title2.setText(aPackage.getName());
        contentHolder.title3.setText(aPackage.getSupplierName());
        contentHolder.title4.setText(aPackage.getSize());
        contentHolder.title5.setText(aPackage.getUsefor());
        contentHolder.title6.setText(aPackage.getMaterial());
        contentHolder.title7.setText(aPackage.getInspection());
        contentHolder.title8.setVisibility(View.GONE);
        materailContent.setBackgroundResource(R.drawable.shape_bottom_corner_no_top_line);
        //添加tabrow
        material_TableLayout.addView(materailContent);
    }

    private TableRow getMaterailTitleHolder(){
        TitleHolder titleHolder = new TitleHolder();
        TableRow materailTitle = (TableRow) inflater.inflate(R.layout.item_materialtitle, null);
        titleHolder.title1 = (TextView) materailTitle.findViewById(R.id.title1);
        titleHolder.title2 = (TextView) materailTitle.findViewById(R.id.title2);
        titleHolder.title3 = (TextView) materailTitle.findViewById(R.id.title3);
        titleHolder.title4 = (TextView) materailTitle.findViewById(R.id.title4);
        titleHolder.title5 = (TextView) materailTitle.findViewById(R.id.title5);
        titleHolder.title6 = (TextView) materailTitle.findViewById(R.id.title6);
        titleHolder.title7 = (TextView) materailTitle.findViewById(R.id.title7);
        titleHolder.title8 = (TextView) materailTitle.findViewById(R.id.title8);
        materailTitle.setTag(titleHolder);
        return materailTitle;
    }

    private class TitleHolder{
        private  TextView title1;
        private  TextView title2;
        private  TextView title3;
        private  TextView title4;
        private  TextView title5;
        private  TextView title6;
        private  TextView title7;
        private  TextView title8;
    }

    private class TableHolder{
        private TextView material_TextView;
        private TableLayout material_TableLayout;
    }
}
