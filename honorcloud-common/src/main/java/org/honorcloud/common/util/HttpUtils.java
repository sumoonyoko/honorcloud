package org.honorcloud.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;
/**
 * post请求工具类
 */
@SuppressWarnings("unused")
public class HttpUtils {

	/**
	 * post请求(用于key-value格式的参数)
	 * @param url 请求地址.
	 * @param params 参数map.
	 * @return 返回请求url结果.
	 */
	public static String doPost(String url,final Map<String, String> params){
		
		BufferedReader in = null;  
        try {

            /**
             * 1. 定义HttpClient.  
             */
            HttpClient client = new DefaultHttpClient();  
            
            /**
             * 2. 实例化HTTP方法,并设置请求地址URL.  
             */
            HttpPost postRequest = new HttpPost();
            postRequest.setURI(new URI(url));
            
            /**
             * 3. 设置参数.
             */
            List<NameValuePair> nvps = new ArrayList<NameValuePair>(); 
            for (Map.Entry<String, String> entry : params.entrySet()) {
            	nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
	        }
           
            postRequest.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));
            
            //请求超时
            client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 100);
 		   //读取超时
            client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,3000);
            /**
             * 4. 发送请求.
             */
            HttpResponse response = client.execute(postRequest);
            
            /**
             * 5. 响应状态.
             */
            int code = response.getStatusLine().getStatusCode();
            if(code == 200){	//请求成功
            	
            	/**
            	 * 6. 接收响应结果内容.
            	 */
            	in = new BufferedReader(new InputStreamReader(response.getEntity()  
                        .getContent(),"utf-8"));
                StringBuffer sb = new StringBuffer("");  
                String line = "";  
                String NL = System.getProperty("line.separator");  
                while ((line = in.readLine()) != null) {  
                    sb.append(line + NL);  
                }
                in.close();  
                return sb.toString();

            } else {
            	System.out.println("状态码：" + code);
            	return null;
            }
            
        } catch(Exception e) {
        	e.printStackTrace();
        	return null;
        }
	}


	/**
	 * 判断字符串是否为空
	 */
	private static boolean isEmpty(String str) {
		if (str == null || "".equals(str))
			return true;
		return false;
	}
	
}
