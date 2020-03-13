package org.honorcloud.common.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSONObject;

public class QQHttpClient {
//注意修改
    public static final String APPID = "APPID";

    public static final String APPKEY = "APPKEY";
    //注册的时候会给你的  例子如下但是是错误的
   /* public static final String APPID = "100008777";

    public static final String APPKEY = "1010121f2a41efe310101205cb31020";*/

    private static JSONObject parseJSONP(String jsonp){
        int startIndex = jsonp.indexOf("(");
        int endIndex = jsonp.lastIndexOf(")");
        String json = jsonp.substring(startIndex + 1, endIndex);
        return JSONObject.parseObject(json);
    }

    /**
     * 获取 Access_Token
     * @param url
     * @return
     * @throws IOException
     */
    public static String getAccessToken(String url) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        String token = null;

        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            String result = EntityUtils.toString(entity, "UTF-8");
            if (result.indexOf("access_token") >= 0) {
                String[] array = result.split("&");
                for (String str: array)
                    if (str.indexOf("access_token") >= 0) {
                        token = str.substring(str.indexOf("=") + 1);
                        break;
                    }
            }
        }

        httpGet.releaseConnection();
        return token;
    }

    /**
     * 获取 OpenID
     * @param url
     * @return
     * @throws IOException
     */
    public static String getOpenID(String url) throws IOException {
        JSONObject jsonObject = null;
        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            String result = EntityUtils.toString(entity, "UTF-8");
            jsonObject = parseJSONP(result);
        }

        httpGet.releaseConnection();
        if (jsonObject != null)
            return jsonObject.getString("openid");
        else
            return null;
    }

    /**
     * 获取用户信息
     * @param url
     * @return
     * @throws IOException
     */
    public static JSONObject getUserInfo(String url) throws IOException {
        JSONObject jsonObject = null;
        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            String result = EntityUtils.toString(entity, "UTF-8");
            jsonObject = JSONObject.parseObject(result);
        }

        httpGet.releaseConnection();
        return jsonObject;
    }

}
