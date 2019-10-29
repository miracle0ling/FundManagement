package mapper;

import pojo.Studio;

import java.util.List;

public interface StudioMapper {
    public Studio showinfo(String pnumber);
    public List<Studio> getNI();
}
