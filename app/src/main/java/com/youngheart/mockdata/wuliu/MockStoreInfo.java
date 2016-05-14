package com.youngheart.mockdata.wuliu;

import com.alibaba.fastjson.JSON;
import com.infrastructure.net.Response;
import com.youngheart.entity.wuliu.StoreInfo;
import com.youngheart.mockdata.MockService;

/**
 * Created by Administrator on 2016/4/25.
 */
public class MockStoreInfo extends MockService{
    @Override
    public String getJsonData() {
        StoreInfo storeInfo = new StoreInfo();
        storeInfo.setTemperature("4.0摄氏度");
        storeInfo.setAccount("500(盒/瓶/袋)");
        storeInfo.setInTime("2015-12-15");
        storeInfo.setOutTime("2015-12-20");
        storeInfo.setProduceBatch("0001");
        storeInfo.setProduceName("南京卫岗乳业有限公司");
        storeInfo.setProduceTime("2015-12-12");
        storeInfo.setRoom("一号仓库3号货架");
        storeInfo.setTraceCode("45468748");
        storeInfo.setWearHouseName("卫岗乳业成品奶冷冻仓库");

        Response response = getSuccessResponse();
        response.setResult(JSON.toJSONString(storeInfo));
        return JSON.toJSONString(response);
    }
}
