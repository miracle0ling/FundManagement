package mapper;

import pojo.Teacher;

public interface TeacherMapper {
    Teacher selectUser(String tid);
    String login(String tid);
    void setpassword(Teacher teacher);
}
