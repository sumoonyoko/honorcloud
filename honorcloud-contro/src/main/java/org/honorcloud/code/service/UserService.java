package org.honorcloud.code.service;

import org.honorcloud.code.entity.User;

import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User>{

    //通过openid得到用户信息
    User getOpenid( String openid);
   
  //添加信息
    int insertQQ(User userEntity);

   //修改信息
    int updateQQ(User userEntity);

   //QQ授权过之后会给一个openid，通过openid进行查找，如果没有就是首次登陆直接添，如果有先修改信息
 


}
