package mapper;


import org.apache.ibatis.annotations.Param;
import pojo.Project;
import pojo.Studio;

import java.util.List;


public interface StudioMapper {
    List<Studio> selectstudio();

    Studio studioindex(String sid);

    void updateused(@Param("amoney") float amoney, @Param("pid") String pid);

    void updateusable(@Param("amoney") float amoney,@Param("pid") String pid);
}
