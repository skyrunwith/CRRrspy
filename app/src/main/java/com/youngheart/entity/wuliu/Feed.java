package com.youngheart.entity.wuliu;

import com.youngheart.entity.TProducer;
import com.youngheart.entity.bean.TCowEntity;
import com.youngheart.entity.bean.TFarmEntity;
import com.youngheart.entity.bean.TFeedingEntity;
import com.youngheart.entity.bean.TFeedstuffEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/4/27.
 */
public class Feed implements Serializable{
    private TFarmEntity farm;
    private List<TCowEntity> cows;
    private List<TFeedingEntity> feeds;
    private List<TFeedstuffEntity> feedStuffs;

    public TFarmEntity getFarm() {
        return farm;
    }

    public void setFarm(TFarmEntity farm) {
        this.farm = farm;
    }

    public List<TCowEntity> getCows() {
        return cows;
    }

    public void setCows(List<TCowEntity> cows) {
        this.cows = cows;
    }

    public List<TFeedingEntity> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<TFeedingEntity> feeds) {
        this.feeds = feeds;
    }

    public List<TFeedstuffEntity> getFeedStuffs() {
        return feedStuffs;
    }

    public void setFeedStuffs(List<TFeedstuffEntity> feedStuffs) {
        this.feedStuffs = feedStuffs;
    }
}
