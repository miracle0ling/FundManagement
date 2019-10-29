package service;

import mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Project;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectMapper projectMapper;
    @Override
    public List<Project> selectproject() {
        List<Project> projectList=projectMapper.selectproject();
        return projectList;
    }

    @Override
    public Project projectindex(String proid) {
        Project project=projectMapper.projectindex(proid);
        return project;
    }

    @Override
    public void updateused(float amoney, String pid) {
        projectMapper.updateused(amoney,pid);
    }

    @Override
    public void updateusable(float amoney, String pid) {
        projectMapper.updateusable(amoney,pid);
    }
}
