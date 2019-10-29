package mapper;

import pojo.project;

import java.util.List;

public interface projectInfo {
    public project getInfo(String stunumber);
    public String getPro(String stunumber);
    public String pgetPro(String stunumber);
    public List<project> getNI();
}
