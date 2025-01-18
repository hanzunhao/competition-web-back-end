package cn.edu.usst.competitionweb.service.impl;

import cn.edu.usst.competitionweb.mapper.UserMapper;
import cn.edu.usst.competitionweb.pojo.User;
import cn.edu.usst.competitionweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        return userMapper.selectByUsernameAndPassword(user);
    }
}
