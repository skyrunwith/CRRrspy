package com.youngheart.mockdata.wuliu;

import com.alibaba.fastjson.JSON;
import com.infrastructure.net.Response;
import com.youngheart.entity.wuliu.TransportInfo;
import com.youngheart.mockdata.MockService;

/**
 * Created by Administrator on 2016/4/25.
 */
public class MockTransportInfo extends MockService{
    @Override
    public String getJsonData() {
        TransportInfo transportInfo = new TransportInfo();
        transportInfo.setDriver("马东");
        transportInfo.setProducerName("南京卫岗乳业有限公司配送部");
        transportInfo.setSalerName("世界华联省教育连锁店");
        transportInfo.setProductName("浓香型高钙奶");
        transportInfo.setTemperature("4.0摄氏度");
        transportInfo.setTransportBatch("0001-2015-12-20-S001");
        transportInfo.setTransportCar("冷链运输车-苏A8888");
        transportInfo.setTransportTime("2015-12-20");

        Response response = getSuccessResponse();
        response.setResult(JSON.toJSONString(transportInfo));
        return JSON.toJSONString(response);
    }
}
