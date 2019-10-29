package service;

import pojo.project;

import java.util.List;

public interface ProjectService {
    public List<project> getNI();
    public project PgetIfno(String stunumber);
    public String getPro(String stunumber);
    public String pgetPro(String stunumber);
    public boolean ifpri(String stunumber);
    public boolean ifhave(String stunumber);
}
