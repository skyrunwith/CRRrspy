package com.youngheart.mockdata;

import com.alibaba.fastjson.JSON;
import com.infrastructure.net.Response;
import com.youngheart.entity.UserInfo;

/**
 * Created by Administrator on 2016/4/22.
 */
public class MockUserInfo extends MockService {
    @Override
    public String getJsonData() {
        UserInfo userInfo = new UserInfo();
        userInfo.setActivationCode("123");
        userInfo.setEmail("58254nan7045@qq.com");
        userInfo.setGender("nan");
        userInfo.setImage("");
        userInfo.setLoginname("fzd");
        userInfo.setLoginpass("123456");
        userInfo.setStatus(1);
        userInfo.setUid("dsad");

        Response response = getSuccessResponse();
        response.setResult(JSON.toJSONString(userInfo));
        return JSON.toJSONString(response);
    }
}
