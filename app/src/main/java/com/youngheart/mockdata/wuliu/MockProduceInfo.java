package com.youngheart.mockdata.wuliu;

import com.alibaba.fastjson.JSON;
import com.infrastructure.net.Response;
import com.youngheart.entity.wuliu.Process;
import com.youngheart.entity.wuliu.ProduceInfo;
import com.youngheart.mockdata.MockService;

/**
 * Created by Administrator on 2016/4/25.
 */
public class MockProduceInfo extends MockService{
    @Override
    public String getJsonData() {
        ProduceInfo produceInfo = new ProduceInfo();
        produceInfo.setTraceCode("454554");
        produceInfo.setProduceName("南京卫岗乳业有限公司");
        produceInfo.setAccount("500(盒/瓶/袋)");
        produceInfo.setEmployName("关羽");
        produceInfo.setProduceBatch("0001");
        produceInfo.setProduceDate("2015-12-12");
        produceInfo.setProductName("浓香型高钙奶");
        produceInfo.setStatus("合格");
        produceInfo.setWorkShop("一号车间");

        Process process = new Process();
        process.setStep1("原奶检验");
        process.setStep2("收奶存储");
        process.setStep3("冷却过滤");
        process.setStep4("净乳");
        process.setStep5("均质");
        process.setStep6("理化检验");
        process.setStep7("巴氏杀菌");
        process.setStep8("配料");
        process.setStep9("超高温灭菌");
        process.setStep10("无菌灌装");

        produceInfo.setProcess(process);
        Response response = getSuccessResponse();
        response.setResult(JSON.toJSONString(produceInfo));
        return JSON.toJSONString(response);
    }
}
