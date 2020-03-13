package org.honorcloud.code.controller.base;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.honorcloud.code.entity.User;
import org.honorcloud.code.service.UserService;
import org.honorcloud.common.util.QQHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/qq")
public class QQController {

  //自己的域名
    private String http="http://www.sumoon.top";

    @Autowired
    private UserService userService;

    /**
     * QQ 授权
     * @return
     */
    @RequestMapping("/oauth")
    public String qq(HttpSession session) {
    	// 自己注册的回调地址  第一个qq为项目名 第二个qq为QQController定义的@RequestMapping("/qq")第三个为方法  @RequestMapping("/callback")
    	String backUrl = http +"/qq/qq/callback";
    

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        session.setAttribute("state", uuid);

        // Step1: 获取Authorization Code
        String url = "https://graph.qq.com/oauth2.0/authorize?response_type=code" +
                     "&client_id=" + QQHttpClient.APPID +
                     "&redirect_uri=" + URLEncoder.encode(backUrl) +
                     "&state=" + uuid;
     
        return "redirect:" + url;
    }

    /**
     * QQ 回调
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/callback")
    public String qqcallback(HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        String uuid = (String) session.getAttribute("state");

        if (uuid != null) {
            if (!uuid.equals(state)) {
                System.out.println("TOKEN错误, 防止CSRF攻击, 业务异常处理......");
                return null;
            }
        }

        // Step2: 通过Authorization Code获取Access Token
        String backUrl = http + "/qq/qq/callback";
        String url = "https://graph.qq.com/oauth2.0/token?grant_type=authorization_code" +
                     "&client_id=" + QQHttpClient.APPID +
                     "&client_secret=" + QQHttpClient.APPKEY +
                     "&code=" + code +
                     "&redirect_uri=" + backUrl;
        String access_token = QQHttpClient.getAccessToken(url);

        // Step3: 获取回调后的 openid 值
        url = "https://graph.qq.com/oauth2.0/me?access_token=" + access_token;
        String openid = QQHttpClient.getOpenID(url);


        // Step4: 获取QQ用户信息
        url = "https://graph.qq.com/user/get_user_info?access_token=" + access_token +
               "&oauth_consumer_key=" + QQHttpClient.APPID +
               "&openid=" + openid;
        JSONObject jsonObject = QQHttpClient.getUserInfo(url);

        /*
        // 也可以放到Redis中或MySQL中
        session.setAttribute("openid", openid);
        session.setAttribute("nickname", (String)jsonObject.get("nickname"));
        session.setAttribute("figureurl_qq_2", (String)jsonObject.get("figureurl_qq_2"));
        */

        // 绑定数据库， 如果没有QQ授权过的注册一个帐号
        User userEntity = userService.getOpenid(openid);
        if (userEntity == null) {
            userEntity = new User();
            userEntity.setId(UUID.randomUUID().toString());
            userEntity.setOpenid(openid);
            userEntity.setName((String)jsonObject.get("name"));
            userEntity.setImage((String)jsonObject.get("figureurl_qq_2"));
            userService.insertQQ(userEntity);
        } else {
            userEntity.setName((String)jsonObject.get("name"));
            userEntity.setImage((String)jsonObject.get("figureurl_qq_2"));
            userService.updateQQ(userEntity);
        }

        session.setAttribute("openid", userEntity.getOpenid());
        return home(session,request);
    }
    @RequestMapping("/home")
    public String home(HttpSession session,HttpServletRequest request) {
    	 
        String openid = (String)session.getAttribute("openid");
        if (openid != null) {
            User userEntity = userService.getOpenid(openid);
           
            if (StringUtils.isEmpty(userEntity.getPassword())) {
             //看看是否有密码，如果没有到register可以在给这个qq登陆这只一个密码，添加邮箱。。。
                return register(openid,request);
            }
        
            request.setAttribute("userEntity", userEntity);
        }
       
        return "login/home";
    }
    
    @RequestMapping("/register")
    public String register(String openid,HttpServletRequest request) {
        User userEntity = userService.getOpenid(openid);
        request.setAttribute("userEntity", userEntity);
        return "login/register";
    }

}
