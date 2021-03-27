package com.shuttle.feign.fallback;

import com.shuttle.feign.entity.Ads;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fetch.AdsFetch;
import com.shuttle.feign.utils.ReturnMessageUtil;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/27 09:30
 */
public class AdsFallback implements AdsFetch {
    @Override
    public ReturnMessage<Object> insert(Ads ads, int expired) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> delete(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> update(Ads ads) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findAll() {
        return ReturnMessageUtil.error(-1, "系统错误");
    }
}