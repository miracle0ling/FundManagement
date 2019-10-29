package pojo;

public class Bill {
    private String personid;
    private String pid;
    private String leibie;
    private String type;
    private String people;
    private String tel;
    private String method;
    private String mission;
    private String art;
    private String author;
    private float amoney;
    private String rid;
    private int status;
    private String baoxiao;
    private String time;

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBaoxiao() {
        return baoxiao;
    }

    public void setBaoxiao(String baoxiao) {
        this.baoxiao = baoxiao;
    }

    public String getPid() {
        return pid;
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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getAmoney() {
        return amoney;
    }

    public void setAmoney(float amoney) {
        this.amoney = amoney;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "pid='" + pid + '\'' +
                ", leibie='" + leibie + '\'' +
                ", type='" + type + '\'' +
                ", people='" + people + '\'' +
                ", tel='" + tel + '\'' +
                ", method='" + method + '\'' +
                ", mission='" + mission + '\'' +
                ", art='" + art + '\'' +
                ", author='" + author + '\'' +
                ", amoney=" + amoney +
                ", rid=" + rid +
                ", status=" + status +
                '}';
    }
}
