package pojo;

public class Studio {
    private int snumber;
    private String sid;
    private String category;
    private String sname;
    private String principal;
    private String pnumber;
    private String position;
    private float dalymoney;
    private float submoney;

    public int getSnumber() {
        return snumber;
    }

    public void setSnumber(int snumber) {
        this.snumber = snumber;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getDalymoney() {
        return dalymoney;
    }

    public void setDalymoney(float dalymoney) {
        this.dalymoney = dalymoney;
    }

    public float getSubmoney() {
        return submoney;
    }

    public void setSubmoney(float submoney) {
        this.submoney = submoney;
    }

    @Override
    public String toString() {
        return "Studio{" +
                "snumber=" + snumber +
                ", sid='" + sid + '\'' +
                ", category='" + category + '\'' +
                ", sname='" + sname + '\'' +
                ", principal='" + principal + '\'' +
                ", pnumber='" + pnumber + '\'' +
                ", position='" + position + '\'' +
                ", dalymoney=" + dalymoney +
                ", submoney=" + submoney +
                '}';
    }
}
