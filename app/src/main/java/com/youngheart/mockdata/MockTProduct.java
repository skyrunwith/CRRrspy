package com.youngheart.mockdata;

import com.alibaba.fastjson.JSON;
import com.infrastructure.net.Response;
import com.youngheart.entity.Materil;
import com.youngheart.entity.Package;
import com.youngheart.entity.ProductComment;
import com.youngheart.entity.ProductInspect;
import com.youngheart.entity.TProducer;
import com.youngheart.entity.TProducerecord;
import com.youngheart.entity.TProduct;
import com.youngheart.entity.TProducttype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/22.
 */
public class MockTProduct extends MockService{
    @Override
    public String getJsonData() {
        TProduct tProduct = new TProduct();
        tProduct.setExpiration("21天");
        tProduct.setImage("image");
        tProduct.setIntroduction("introduction");
        tProduct.setProducerid("00001");
        tProduct.setProductid("00001");
        tProduct.setProductlotid("0001");
        tProduct.setProductname("浓香型高钙奶");
        tProduct.setProducttypeid("PT01");
        tProduct.setRemark("remark");
        tProduct.setSize("250ml");
        tProduct.setTracecode("123");

        ProductInspect productInspect = new ProductInspect();
        productInspect.setCalcium(400f);
        productInspect.setDisinfect("已杀菌");
        productInspect.setEnergy(484f);
        productInspect.setFat(3.1f);
        productInspect.setInspectorid("E001");
        productInspect.setProductlotid("0001");
        productInspect.setVitamin(272f);
        productInspect.setProtein(2.9f);
        productInspect.setRemark("");
        tProduct.setProductInspect(productInspect);

        List<ProductComment> comments = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            ProductComment productComment = new ProductComment();
            productComment.setCommentdate("2016-01-13 00:48:01");
            productComment.setCommentid(59);
            productComment.setContent("太好了。");
            productComment.setProducttypeid("PT01");
            productComment.setUserip("0:0:0:0:0:0:0:1");
            comments.add(productComment);
        }
        tProduct.setComments(comments);

        List<Materil> materils = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            Materil materil = new Materil();
            materil.setMateriallotid("M001");
            materil.setName("乳酸");
            materil.setSize("25千克/袋");
            materil.setStatus("合格");
            materil.setSupplierid("SP04");
            materil.setUseness("乳制品");
            materils.add(materil);
        }
        tProduct.setMaterils(materils);

        Response response = getSuccessResponse();
        response.setResult(JSON.toJSONString(tProduct));
        return JSON.toJSONString(response);
    }
}
