package com.youngheart.mockdata;

import com.alibaba.fastjson.JSON;
import com.infrastructure.net.Response;
import com.youngheart.entity.Employee;
import com.youngheart.entity.ProductInspect;
import com.youngheart.entity.TProducerecord;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/24.
 */
public class MockProductRecord extends MockService{
    @Override
    public String getJsonData() {
        TProducerecord tProducerecord = new TProducerecord();
        tProducerecord.setAccessorylotid("AC01");
        tProducerecord.setImage("image");
        tProducerecord.setAmount("500");
        tProducerecord.setOperatorid("E002");
        tProducerecord.setProducedate("2015-12-12");
        tProducerecord.setPackagelotid("PA01");
        tProducerecord.setProcessid("P1");
        tProducerecord.setProductlotid("0001");
        tProducerecord.setRawmilklotid("RA01");
        tProducerecord.setStatus("合格");
        tProducerecord.setRemark("remark");
        tProducerecord.setWorkshop("一号车间");

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
        tProducerecord.setProductInspect(productInspect);

        Employee employee = new Employee();
        employee.setName("刘备");
        employee.setAge("32");
        employee.setCompany("南京卫岗乳业有限公司");
        employee.setEmployeeid("E001");
        employee.setGender("男");
        employee.setImage("");
        employee.setRemark("");
        employee.setRole("检验员");
        employee.setTelephone("15195984584");
        tProducerecord.setEmployee(employee);

        Response response = getSuccessResponse();
        response.setResult(JSON.toJSONString(tProducerecord));
        return JSON.toJSONString(response);
    }
}
