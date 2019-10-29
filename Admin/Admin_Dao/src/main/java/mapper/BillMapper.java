package mapper;


import pojo.Bill;

import java.util.List;


public interface BillMapper {
    List<Bill> selectbill();

    List<Bill> billindex(String pid);

    Bill billindex1(String id);

    Bill billindex2(String rid);

    public void tongyiapplication(String status,String id);

    public void jujueapplication(String id);

    public void updateapplication(String leibie,String type,String amoney,String people,String tel,String id);
}
