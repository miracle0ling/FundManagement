package service;

import mapper.ProjectMapper;
import mapper.StudioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Project;
import pojo.Studio;

import java.util.List;

@Service
public class StudioServiceImpl implements StudioService{
    @Autowired
    StudioMapper studioMapper;
    @Override
    public List<Studio> selectstudio() {
        List<Studio> studioList=studioMapper.selectstudio();
        return studioList;
    }

    @Override
    public Studio studioindex(String sid) {
        Studio studio=studioMapper.studioindex(sid);
        return studio;
    }

    @Override
    public void updateused(float amoney, String pid) {
        studioMapper.updateused(amoney,pid);
    }

    @Override
    public void updateusable(float amoney, String pid) {
        studioMapper.updateusable(amoney,pid);
    }

}
