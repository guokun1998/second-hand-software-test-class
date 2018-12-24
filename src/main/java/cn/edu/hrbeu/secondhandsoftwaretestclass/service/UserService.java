package cn.edu.hrbeu.secondhandsoftwaretestclass.service;

import cn.edu.hrbeu.secondhandsoftwaretestclass.bean.User;
import cn.edu.hrbeu.secondhandsoftwaretestclass.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User insertUser(User user){
        userMapper.insertUser(user);
        return user;
    }

    public User findUserByUserId(Integer userId){
        return userMapper.findUserByUserId(userId);
    }

    public User findUserByPhoneNumber(String userPhoneNumber){
        return userMapper.findUserByPhoneNumber(userPhoneNumber);
    }

    public void updateUserByUserId(User user){
        userMapper.updateUser(user);
    }

    public void updateUserPowerByUserId(User user){
        userMapper.updateUserPower(user);
    }

    public User findUserByPhoneAndStudentId(User user){
        User user1 = userMapper.findUserByPhoneAndStudentId(user);
        return user1;
    }
    public User findUserByStudentIdAndPassword(User user){
        return userMapper.findUserByStudentIdAndPassword(user);
    }
}
