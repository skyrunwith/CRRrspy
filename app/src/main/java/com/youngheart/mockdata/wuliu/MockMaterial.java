package com.youngheart.mockdata.wuliu;

        import com.alibaba.fastjson.JSON;
        import com.infrastructure.net.Response;
        import com.youngheart.entity.Materil;
        import com.youngheart.entity.Package;
        import com.youngheart.entity.bean.TMaterialEntity;
        import com.youngheart.entity.bean.TMilkingEntity;
        import com.youngheart.entity.bean.TOrderEntity;
        import com.youngheart.entity.bean.TRawmilkEntity;
        import com.youngheart.entity.wuliu.Material;
        import com.youngheart.mockdata.MockService;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by Administrator on 2016/4/27.
 */
public class MockMaterial extends MockService{
    @Override
    public String getJsonData() {
        Material material = new Material();

        TOrderEntity oder = new TOrderEntity();
        oder.setRemark("");
        oder.setAccessorylotid("AC01");
        oder.setDate("2015-12-03");
        oder.setEmployeeName("丁香");
        oder.setOrderid("O001");
        oder.setPackagelotid("PA01");
        oder.setRawmilklotid("RA01");
        oder.setStatus("合格");
        material.setOder(oder);

        TRawmilkEntity rawMilk = new TRawmilkEntity();
        rawMilk.setRawmilklotid("RA01");
        rawMilk.setMilkStationName("1111");
        rawMilk.setName("生鲜奶");
        rawMilk.setSize("500L");
        rawMilk.setTank("一号储罐");
        rawMilk.setTemperature("2");
        material.setRawMilk(rawMilk);

        TMilkingEntity tMilkingEntity = new TMilkingEntity();
        tMilkingEntity.setRawmilklotid("RA01");
        tMilkingEntity.setAmount("500");
        tMilkingEntity.setCowid("C001 C002");
        tMilkingEntity.setDate("2015-12-01");
        tMilkingEntity.setFarmName("F001");
        tMilkingEntity.setStatus("合格");
        material.setMilk(tMilkingEntity);

        List<TMaterialEntity> materils = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            TMaterialEntity materil = new TMaterialEntity();
            materil.setMateriallotid("M001");
            materil.setName("乳酸");
            materil.setSize("25千克/袋");
            materil.setStatus("合格");
            materil.setSupplierName("dsad");
            materil.setUseness("乳制品");
            materil.setAmount("500.0千克");
            materil.setAccessId("AC01");
            materils.add(materil);
        }
        material.setMaterials(materils);

        Package aPackage = new Package();
        aPackage.setName("聚乙烯牛奶塑料瓶");
        aPackage.setInspection("正常");
        aPackage.setMaterial("优质牛皮纸");
        aPackage.setPackagelotid("PA01");
        aPackage.setRemark("");
        aPackage.setUsefor("奶产品");
        aPackage.setSupplierName("有限公司");
        aPackage.setSize("250克");
        material.setaPackage(aPackage);

        Response response = getSuccessResponse();
        response.setResult(JSON.toJSONString(material));
        return JSON.toJSONString(response);
    }
}
