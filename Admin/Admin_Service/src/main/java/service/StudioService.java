package service;

import pojo.Project;
import pojo.Studio;

import java.util.List;

public interface StudioService {
    List<Studio> selectstudio();

    Studio studioindex(String sid);

    void updateused(float amoney,String pid);

    void updateusable(float amoney,String pid);
}
