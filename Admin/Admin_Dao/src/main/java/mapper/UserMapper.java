package mapper;


import pojo.Admin;
import pojo.Bill;

import java.util.List;

public interface UserMapper {
    Admin selectUser(String anum);

    List<Bill> selectleibieregistry(String leibie);
}
