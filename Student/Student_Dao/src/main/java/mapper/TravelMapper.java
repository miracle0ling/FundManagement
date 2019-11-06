package mapper;

import pojo.Travel;

import java.util.List;

public interface TravelMapper {
    //    0不用填写多余信息，1填写公出任务，2填写论文，作者
    void insert(Travel travel);
    List<Travel> sbyid(String pid);
    void repeal(int tid);
    //    查询对应项目有几条报销记录用于 拼接发票单id
    int selectnum(String pid);
    List<Travel> sbyname(String personid);
}
