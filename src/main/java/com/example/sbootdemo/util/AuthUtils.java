package com.example.sbootdemo.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by wuzh on 2018/8/19 0019.
 *
 * 工具类
 * 声明微信公众号测试号信息中的appID和appsecret
 * 从给定的url中获得响应，并从响应信息中获得json对象
 */
public class AuthUtils {
    public static final String APP_ID = "wxee50dea06b908f55";
    public static final String APP_SECRET = "ea00ca7171a081b2c234b6c321c43253";

    public static JSONObject doGetJson(String url) throws IOException {
        JSONObject jsonObject = null;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (entity != null){
            String result = EntityUtils.toString(entity, "UTF-8");
            jsonObject = JSONObject.parseObject(result);
        }
        httpGet.releaseConnection();
        return jsonObject;
    }
}
