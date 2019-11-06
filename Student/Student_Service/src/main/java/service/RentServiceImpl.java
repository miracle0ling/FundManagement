package service;

import mapper.RentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Rent;

import java.util.List;
@Service
public class RentServiceImpl implements RentService{

    @Autowired
    RentMapper rentMapper;

    @Override
    public void insert(Rent rent) {
        rentMapper.insert(rent);
    }

    @Override
    public List<Rent> sbyid(String pid) {
        return rentMapper.sbyid(pid);
    }

    @Override
    public void repeal(int id) {
        rentMapper.repeal(id);
    }

    @Override
    public int selectnum(String pid) {
        return rentMapper.selectnum(pid);
    }

    @Override
    public List<Rent> sbyname(String personid) {
        return rentMapper.sbyname(personid);
    }
}
