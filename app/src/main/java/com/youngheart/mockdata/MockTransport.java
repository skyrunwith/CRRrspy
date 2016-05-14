package com.youngheart.mockdata;

import com.alibaba.fastjson.JSON;
import com.infrastructure.net.Response;
import com.youngheart.entity.Car;
import com.youngheart.entity.Employee;
import com.youngheart.entity.Saler;
import com.youngheart.entity.TProducerecord;
import com.youngheart.entity.Transport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/22.
 */
public class MockTransport extends MockService{
    @Override
    public String getJsonData() {
        List<Transport> transports = new ArrayList<>();

        for(int i = 0; i < 1; i++) {
            Transport transport = new Transport();
            transport.setCarid("苏A8888");
            transport.setCompany("江苏申通物流有限公司");
            transport.setDriverid("E004");
            transport.setImage("image");
            transport.setProductlotid("0001");
            transport.setRemark("remark");
            transport.setRoute("内江-成都");
            transport.setSalerid("S001");
            transport.setTransporttime("2015-12-20");

            Car car = new Car();
            car.setCarid("苏A8888");
            car.setTemperature("4");
            car.setType("冷链运输车");
            transport.setCar(car);

            Saler saler = new Saler();
            saler.setAddress("南京市雨花台区螺丝桥152号");
            saler.setCorporation("李四");
            saler.setName("世纪华联省教育连鑫店");
            saler.setPostcode("210019");
            saler.setProduction("production");
            saler.setRemark("remark");
            saler.setSalerid("S001");
            saler.setTelephone("18551652079");
            transport.setSaler(saler);

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
            transport.settProducerecord(tProducerecord);

            Employee employee = new Employee();
            employee.setAge("32");
            employee.setCompany("南京卫岗乳业有限公司");
            employee.setEmployeeid("E001");
            employee.setGender("男");
            employee.setImage("image");
            employee.setRemark("remark");
            employee.setName("刘备");
            employee.setRole("检验员");
            employee.setTelephone("15195984584");
            transport.setEmployee(employee);
            transports.add(transport);
        }
        Response response = getSuccessResponse();
        response.setResult(JSON.toJSONString(transports));
        return JSON.toJSONString(response);
    }
}
