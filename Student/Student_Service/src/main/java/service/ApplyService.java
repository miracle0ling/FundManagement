package service;

import pojo.Bill;

import java.util.List;

public interface ApplyService {
    void inserttype0(Bill bill);
    void inserttype1(Bill bill);
    void inserttype2(Bill bill);
    List<Bill> sbyid(String pid);
//    通过姓名查询...报销人可以看到自己报销的内容（申请中）
    List<Bill> sbyname(String personid);
    void repeal(int rid);
    //    查询对应项目有几条报销记录用于 拼接发票单id
    int selectnum(String pid);
}
