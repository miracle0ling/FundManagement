package service;


import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Admin;
import pojo.Bill;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UserMapper userMapper;
    @Override
    public boolean selectUser(String anum, String apwd) {
        Admin user=userMapper.selectUser(anum);
        if(user!=null){
            if(user.getUsername().equals(anum)&&user.getPassword().equals(apwd)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Admin selectAllUser(String anum, String apwd) {
        Admin admin=userMapper.selectUser(anum);
        return admin;
    }

    @Override
    public List<Bill> selectleibieregistry(String leibie) {
        List<Bill> selectleibieproject=userMapper.selectleibieregistry(leibie);
        return selectleibieproject;
    }

}
