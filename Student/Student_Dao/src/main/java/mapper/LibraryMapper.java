package mapper;

import pojo.Librarylist;

import java.util.List;

public interface LibraryMapper {
//    获取全部
    List<Librarylist> selectall();
//    插入
    void insert(Librarylist librarylist);
//    通过rid获取
    List<Librarylist> selectbyrid(String rid);
}
