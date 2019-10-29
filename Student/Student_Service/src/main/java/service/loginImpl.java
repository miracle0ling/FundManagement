package service;

import mapper.TeacherMapper;
import mapper.studentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Student;
import pojo.Teacher;


@Service
public class loginImpl implements login {
    @Autowired
    studentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public boolean judges(String snum, String password) {
        String spwd = studentMapper.login(snum);
        if(spwd!=null){
            if(spwd.equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean judget(String tid, String password) {
        String spwd = teacherMapper.login(tid);
        if(spwd!=null){
            if(spwd.equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Student selects(String snum) {
        return studentMapper.selectUser(snum);
    }

    @Override
    public Teacher selectt(String tid) {
        return teacherMapper.selectUser(tid);
    }

    @Override
    public boolean ifsexist(String snum) {
        String spwd = studentMapper.login(snum);
        if(!spwd.equals("")){
            return true;
        }
        return false;
    }

    @Override
    public boolean iftexist(String snum) {
        String spwd = teacherMapper.login(snum);
        if(!spwd.equals("")){
            return true;
        }
        return false;
    }

    @Override
    public boolean ifastudent(String snum) {
        Student student = studentMapper.selectUser(snum);
        if (!student.getSname().equals("")){
            return false;
        }
        return true;
    }

    @Override
    public void setspassword(Student student) {
        studentMapper.setpassword(student);
    }

    @Override
    public void settpassword(Teacher teacher) {
        teacherMapper.setpassword(teacher);
    }
}
