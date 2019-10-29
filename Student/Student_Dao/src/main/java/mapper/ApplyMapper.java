package mapper;

import pojo.Bill;

import java.util.List;

public interface ApplyMapper {
//    0不用填写多余信息，1填写公出任务，2填写论文，作者
    void type0(Bill bill);
    void type1(Bill bill);
    void type2(Bill bill);
    List<Bill> sbyid(String pid);
    void repeal(int rid);
//    查询对应项目有几条报销记录用于 拼接发票单id
    int selectnum(String pid);
    List<Bill> sbyname(String personid);
}
