package mapper;


import pojo.Library;
import pojo.Project;

import java.util.List;


public interface LibraryMapper {
    List<Library> selectallLibrary();

    List<Library> selectridlist(String rid);

    Library  selectrid(String rid);

    public void updatelibrary(String tname,String dw,String unitprice,String money,String quantity,String zid);

    void deletelibrary(String rid);
}
