package service;

import pojo.Student;
import pojo.Teacher;

public interface login {
    boolean judges(String snum, String password); //判断学生账号密码
    boolean judget(String tid, String password); //判断老师账号密码
    Student selects(String snum); //查学生
    Teacher selectt(String tid); //查老师
    boolean ifsexist(String snum);
    boolean iftexist(String snum);
    boolean ifastudent(String snum);
    void setspassword(Student student); //学生注册
    void settpassword(Teacher teacher); //老师注册

}
