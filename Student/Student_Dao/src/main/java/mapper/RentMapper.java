package mapper;

import pojo.Rent;

import java.util.List;

public interface RentMapper {
    //    0不用填写多余信息，1填写公出任务，2填写论文，作者
    void insert(Rent rent);
    List<Rent> sbyid(String pid);
    void repeal(int id);
    //    查询对应项目有几条报销记录用于 拼接发票单id
    int selectnum(String pid);
    List<Rent> sbyname(String personid);
}
