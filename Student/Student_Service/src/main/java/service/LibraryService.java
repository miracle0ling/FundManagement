package service;

import pojo.Librarylist;

import java.util.List;

public interface LibraryService {
    //    获取全部
    List<Librarylist> selectall();
    //    插入
    void insert(Librarylist librarylist);
    List<Librarylist> selectbyrid(String rid);
}
