package service;

import mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Bill;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillMapper billMapper;
    @Override
    public List<Bill> selectbill() {
        List<Bill> billList=billMapper.selectbill();
        return billList;
    }

    @Override
    public List<Bill> billindex(String pid) {
        List<Bill> billList=billMapper.billindex(pid);
        return billList;
    }

    @Override
    public Bill billindex1(String id) {
        Bill bill=billMapper.billindex1(id);
        return bill;
    }

    @Override
    public Bill billindex2(String rid) {
        Bill bill=billMapper.billindex2(rid);
        return bill;
    }

    @Override
    public void tongyiapplication(String status,String id) {
        billMapper.tongyiapplication(status,id);
    }

    @Override
    public void jujueapplication(String id) {
        billMapper.jujueapplication(id);
    }

    @Override
    public void updateapplication(String leibie, String type, String amoney, String people, String tel, String id) {
        billMapper.updateapplication(leibie,type,amoney,people,tel,id);
    }
}
