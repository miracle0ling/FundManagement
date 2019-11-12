package service;

import mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.People;

import java.util.List;
@Service
public class PeopleServiceImpl implements PeopleService{

    @Autowired
    PeopleMapper peopleMapper;

    @Override
    public List<People> selectall() {
        return peopleMapper.selectall();
    }

    @Override
    public void insert(People people) {
        peopleMapper.insert(people);
    }

    @Override
    public List<People> selectbyrid(String tid) {
        return peopleMapper.selectbyrid(tid);
    }
}
