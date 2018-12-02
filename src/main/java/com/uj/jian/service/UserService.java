package com.uj.jian.service;

import com.uj.jian.bean.User;
import com.uj.jian.bean.UserExample;
import com.uj.jian.dao.UserMapper;
import com.uj.jian.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUser(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /*检查密码和用户名*/
    public List<User> checkUserInfo( User user) {
        if (user.getPassword() == null || user.getUsername() == null) {
            return null;
        }
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPasswordEqualTo(user.getPassword());
        criteria.andUsernameEqualTo(user.getUsername());
        return userMapper.selectByExample(example);
    }

    /*检查重名*/
    public List<User> checkUserName(String userName) {
        if (userName == null) {
            return null;
        }
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userName);
        return userMapper.selectByExample(example);
    }

    public boolean saveUser(User registerUser) {
        return userMapper.insert(registerUser) > 0;
    }


    public void showHome(Integer userid) {
        userMapper.updateUserInfo(userid);
    }
}
