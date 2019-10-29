package service;

import mapper.projectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.project;

import java.util.List;

@Service
public class ProjectServiceimpl implements ProjectService {
    @Autowired
    projectInfo projectInfo;

    @Override
    public List<project> getNI() {
        return projectInfo.getNI();
    }

    @Override
    public project PgetIfno(String stunumber) {
        return projectInfo.getInfo(stunumber);
    }

    @Override
    public String getPro(String stunumber) {
        return projectInfo.getPro(stunumber);
    }

    @Override
    public String pgetPro(String stunumber) {
        return projectInfo.pgetPro(stunumber);
    }

    @Override
    public boolean ifpri(String stunumber) {
        String s = projectInfo.pgetPro(stunumber);
        if (s!=null){
            return true;
        }
        return false;
    }

    @Override
    public boolean ifhave(String stunumber) {
        String pro = projectInfo.getPro(stunumber);
        if (pro!=null){
            return true;
        }else {
            if(ifpri(stunumber)){
                return  true;
            }
            else {
                return false;
            }
        }
    }
}
