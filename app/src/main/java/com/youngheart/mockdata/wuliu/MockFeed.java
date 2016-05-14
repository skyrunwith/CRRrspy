package com.youngheart.mockdata.wuliu;

import com.alibaba.fastjson.JSON;
import com.infrastructure.net.Response;
import com.youngheart.entity.bean.TCowEntity;
import com.youngheart.entity.bean.TFarmEntity;
import com.youngheart.entity.bean.TFeedingEntity;
import com.youngheart.entity.bean.TFeedstuffEntity;
import com.youngheart.entity.wuliu.Feed;
import com.youngheart.mockdata.MockService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/27.
 */
public class MockFeed extends MockService{
    @Override
    public String getJsonData() {
        Feed feed = new Feed();
        TFarmEntity farm = new TFarmEntity();
        farm.setAddress("南京市江宁区淳化镇索墅村");
        farm.setCorporation("黄易");
        farm.setEnvironment("良好");
        farm.setName("南京市卫岗乳业淳化牧场");
        farm.setPostcode("210098");
        farm.setTelephone("15195984588");
        feed.setFarm(farm);

         List<TCowEntity> cows = new ArrayList<>();
         List<TFeedingEntity> feeds= new ArrayList<>();
         List<TFeedstuffEntity> feedStuffs= new ArrayList<>();
        for(int i = 0; i < 5; i ++){
            TCowEntity cow = new TCowEntity();
            cow.setAge("3");
            cow.setCowhouse("一号牛舍");
            cow.setCowid("C001");
            cow.setInspect("已免疫");
            cow.setStatus("正常");
            cow.setType("荷兰荷斯坦奶牛");
            cows.add(cow);
        }
        feed.setCows(cows);

        for (int i = 0; i < 5; i ++){
            TFeedingEntity feeding  = new TFeedingEntity();
            feeding.setCowid("ds");
            feeding.setDate("ds");
            feeding.setEmployName("ds");
            feeding.setFarmName("ds");
            TFeedstuffEntity tFeedstuffEntity = new TFeedstuffEntity();
            tFeedstuffEntity.setCompany("正大饲料公司南京代理商");
            tFeedstuffEntity.setFeedstuffid("FD01");
            tFeedstuffEntity.setName("正大牌奶牛饲料");
            tFeedstuffEntity.setSize("50千克/袋");
            feeding.setFeedstuffEntity(tFeedstuffEntity);
            feeding.setRemark("正常");
            feeds.add(feeding);
        }
        feed.setFeeds(feeds);

        for (int i = 0; i < 5; i ++) {
            TFeedstuffEntity tFeedstuffEntity = new TFeedstuffEntity();
            tFeedstuffEntity.setCompany("正大饲料公司南京代理商");
            tFeedstuffEntity.setFeedstuffid("FD01");
            tFeedstuffEntity.setName("正大牌奶牛饲料");
            tFeedstuffEntity.setSize("50千克/袋");
            feedStuffs.add(tFeedstuffEntity);
        }
        feed.setFeedStuffs(feedStuffs);

        Response response = getSuccessResponse();
        response.setResult(JSON.toJSONString(feed));
        return JSON.toJSONString(response);
    }
}
