package org.honorcloud.code.service.impl;

import org.honorcloud.code.dao.UserDao;
import org.honorcloud.code.entity.User;
import org.honorcloud.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService{

    @Autowired
    private UserDao userDao;
    
    @Override
    public User getOpenid(String openid) {
        return userDao.getOpenid(openid);
    }

	@Override
	public int insertQQ(User userEntity) {
		return userDao.insertQQ(userEntity);
	}

	@Override
	public int updateQQ(User userEntity) {
		return userDao.updateQQ(userEntity);
	}
}
