package service;

import pojo.Project;

import java.util.List;

public interface ProjectService {
    List<Project> selectproject();

    Project projectindex(String proid);

    void updateused(float amoney,String pid);

    void updateusable(float amoney,String pid);
}
