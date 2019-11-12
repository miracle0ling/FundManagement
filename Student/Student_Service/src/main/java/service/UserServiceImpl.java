package service;


import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public boolean selectUser(String username, String password) {
        User user=userMapper.selectUser(username);
        if(user!=null){
            if(user.getUsername().equals(username)&&user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
