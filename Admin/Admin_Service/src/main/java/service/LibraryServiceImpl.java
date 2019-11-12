package service;

import mapper.LibraryMapper;
import mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Library;
import pojo.Project;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    LibraryMapper libraryMapper;

    @Override
    public List<Library> selectallLibrary() {
        List<Library> libraryList=libraryMapper.selectallLibrary();
        return libraryList;
    }


    @Override
    public List<Library> selectridlist(String rid) {
        List<Library> selectridlist=libraryMapper.selectridlist(rid);
        return selectridlist;
    }

    @Override
    public Library  selectrid(String rid) {
        Library library=libraryMapper.selectrid(rid);
        return library;
    }

    @Override
    public void updatelibrary(String tname, String dw, String unitprice, String money, String quantity, String zid) {
        libraryMapper.updatelibrary(tname,dw,unitprice,money,quantity,zid);
    }

    @Override
    public void deletelibrary(String rid) {
        libraryMapper.deletelibrary(rid);
    }
}
