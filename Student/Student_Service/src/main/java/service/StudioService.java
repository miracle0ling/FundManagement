package service;

import pojo.Studio;

import java.util.List;

public interface StudioService {
    public Studio showinfo(String pnumber);
    public List<Studio> getNI();
}
