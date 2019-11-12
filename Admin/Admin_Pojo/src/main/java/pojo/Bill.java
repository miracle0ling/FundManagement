package pojo;

public class Bill {
    private String id;
    private String pid;//报销编号

    public String getZid() {
        return zid;
    }

    public void setZid(String zid) {
        this.zid = zid;
    }

    private String zid;//报销编号

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String leibie;
    private String type;
    private String people;
    private String baoxiao;
    public String getPid() {
        return pid;
    }
    private String tname;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getBaoxiao() {
        return baoxiao;
    }

    public void setBaoxiao(String baoxiao) {
        this.baoxiao = baoxiao;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getLeibie() {
        return leibie;
    }

    public void setLeibie(String leibie) {
        this.leibie = leibie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public float getAmoney() {
        return amoney;
    }

    public void setAmoney(float amoney) {
        this.amoney = amoney;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String tel;
    private float amoney=.3f;
    private String method;//报销方式
    private String rid;
    private String mission;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String author;
    private String time;

}
