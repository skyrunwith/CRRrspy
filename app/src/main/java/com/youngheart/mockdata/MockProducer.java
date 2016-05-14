package com.youngheart.mockdata;

import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.infrastructure.net.Response;
import com.youngheart.entity.Credential;
import com.youngheart.entity.Materil;
import com.youngheart.entity.TProducer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/24.
 */
public class MockProducer extends MockService{
    @Override
    public String getJsonData() {
        TProducer tProducer = new TProducer();
        tProducer.setAddress("南京市卫岗一号");
        tProducer.setImage("image");
        tProducer.setBrand("乳制品");
        tProducer.setCorporation("民营公司");
        tProducer.setName("南京卫岗乳业有限公司");
        tProducer.setPostcode("210095");
        tProducer.setProducerid("00001");
        tProducer.setProduction("production");
        tProducer.setTelephone("02582542903");
        tProducer.setRemark("remark");

        List<Credential> credentials = new ArrayList<>();
        for(int index = 0; index < 5; index ++){
            Credential credential = new Credential();
            credential.setRemark("");
            credential.setCredentialid("CR01");
            credential.setExpirytime("2017-12-10");
            credential.setIssuedby("南京市标记质量认证咨询公司");
            credential.setName("00001");
            credential.setOrganizationid("00001");
            credential.setScope("乳制品");
            credential.setStatus("有效");
            credential.setIssuetime("2014-12-10");
            credentials.add(credential);
        }
        tProducer.setCredentials(credentials);

        Response response = getSuccessResponse();
        response.setResult(JSON.toJSONString(tProducer));
        return JSON.toJSONString(response);
    }
}
