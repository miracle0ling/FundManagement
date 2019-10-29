package service;

import mapper.registryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.registry;

public class applyImpl implements apply{
    @Autowired
    registryMapper registryMapper;

    @Override
    public boolean insert(float usable, registry registry) {
        if (registry.getMoney()<=usable){
            registryMapper.apply(registry);
            return true;
        }else {
            return false;
        }
    }
}
