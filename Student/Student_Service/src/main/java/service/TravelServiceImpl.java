package service;

import mapper.TravelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Travel;
import java.util.List;

@Service
public class TravelServiceImpl implements TravelService{

    @Autowired
    TravelMapper travelMapper;

    @Override
    public void insert(Travel travel) {
        travelMapper.insert(travel);
    }

    @Override
    public List<Travel> sbyid(String pid) {
        return travelMapper.sbyid(pid);
    }

    @Override
    public void repeal(int tid) {
        travelMapper.repeal(tid);
    }

    @Override
    public int selectnum(String pid) {
        return travelMapper.selectnum(pid);
    }

    @Override
    public List<Travel> sbyname(String personid) {
        return travelMapper.sbyname(personid);
    }
}
