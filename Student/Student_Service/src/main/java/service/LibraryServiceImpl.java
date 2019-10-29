package service;

import mapper.LibraryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Librarylist;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    LibraryMapper libraryMapper;

    @Override
    public List<Librarylist> selectall() {
        return libraryMapper.selectall();
    }

    @Override
    public void insert(Librarylist librarylist) {
        libraryMapper.insert(librarylist);
    }

    @Override
    public List<Librarylist> selectbyrid(String rid) {
        return libraryMapper.selectbyrid(rid);
    }
}
