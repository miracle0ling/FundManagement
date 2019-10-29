package service;

import pojo.Admin;
import pojo.Bill;

import java.util.List;

public interface AdminService {
    boolean selectUser(String anum, String apwd);

    Admin selectAllUser(String anum, String apwd);

    List<Bill> selectleibieregistry(String leibie);

}
