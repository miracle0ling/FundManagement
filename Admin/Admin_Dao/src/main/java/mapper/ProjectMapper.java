package mapper;


import org.apache.ibatis.annotations.Param;
import pojo.Project;

import java.util.List;


public interface ProjectMapper {
    List<Project> selectproject();

    Project projectindex(String proid);

    void updateused(@Param("amoney") float amoney,@Param("pid") String pid);

    void updateusable(@Param("amoney") float amoney,@Param("pid") String pid);
}
