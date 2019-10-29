package service;

import mapper.projectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.project;

public class showinfoImpl implements showinfo {
    @Autowired
    projectInfo projectInfo;

    @Override
    public project PgetIfno(String stunumber) {
        return projectInfo.getInfo(stunumber);
    }

    @Override
    public String getPro(String stunumber) {
        return getPro(stunumber);
    }
}
