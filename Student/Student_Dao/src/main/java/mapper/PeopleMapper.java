package mapper;

import pojo.People;
import java.util.List;

public interface PeopleMapper {
        //    获取全部
        List<People> selectall();
        //    插入
        void insert(People people);
        //    通过rid获取
        List<People> selectbyrid(String tid);

}
