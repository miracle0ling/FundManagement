package service;

import mapper.ApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Bill;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    ApplyMapper applyMapper;

    @Override
    public void inserttype0(Bill bill) {
        applyMapper.type0(bill);
    }

    @Override
    public void inserttype1(Bill bill) {
        applyMapper.type1(bill);
    }

    @Override
    public void inserttype2(Bill bill) {
        applyMapper.type2(bill);
    }

    @Override
    public List<Bill> sbyid(String pid) {
        return applyMapper.sbyid(pid);
    }

    @Override
    public List<Bill> sbyname(String personid) {
        return applyMapper.sbyname(personid);
    }

    @Override
    public void repeal(int rid) {
        applyMapper.repeal(rid);
    }

    @Override
    public int selectnum(String pid) {
        return applyMapper.selectnum(pid);
    }
}
