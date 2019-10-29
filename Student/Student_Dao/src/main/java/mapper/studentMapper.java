package mapper;


import pojo.Student;


public interface studentMapper {
    Student selectUser(String snum);
    String login(String snum);
    void setpassword(Student student);
}
