package service;

import mapper.StudioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Studio;

import java.util.List;

@Service
public class StudioServiceImpl implements StudioService {
    @Autowired
    StudioMapper studioMapper;
    @Override
    public Studio showinfo(String pnumber) {
        return studioMapper.showinfo(pnumber);
    }

    @Override
    public List<Studio> getNI() {
        return studioMapper.getNI();
    }
}
