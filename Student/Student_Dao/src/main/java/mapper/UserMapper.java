package mapper;


import pojo.User;

public interface UserMapper {
    User selectUser(String username);
}
