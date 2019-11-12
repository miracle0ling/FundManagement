package service;

import mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Type;

import java.util.List;

@Service
public class TypeServerImpl implements TypeService {

    @Autowired
    TypeMapper typeMapper;

    @Override
    public List<Type> select() {
        return typeMapper.select();
    }
//  只考虑project
    @Override
    public List<Type> selectgroup() {
        return typeMapper.selectgroup();
    }
}
