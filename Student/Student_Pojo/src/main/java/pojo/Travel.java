package pojo;

public class Travel {
    private String tid;
    private String leibie;
    private String pid;
    private String startdate;
    private String enddate;
    private String mission;
    private String place;
    private String tel;
    private String people;
    private String personid;
    private String time;
    private float hmoney;
    private float mmoney;
    private float tmoney;
    private int status;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getLeibie() {
        return leibie;
    }

    public void setLeibie(String leibie) {
        this.leibie = leibie;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public float getHmoney() {
        return hmoney;
    }

    public void setHmoney(float hmoney) {
        this.hmoney = hmoney;
    }

    public float getMmoney() {
        return mmoney;
    }

    public void setMmoney(float mmoney) {
        this.mmoney = mmoney;
    }

    public float getTmoney() {
        return tmoney;
    }

    public void setTmoney(float tmoney) {
        this.tmoney = tmoney;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "tid='" + tid + '\'' +
                ", leibie='" + leibie + '\'' +
                ", pid='" + pid + '\'' +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", mission='" + mission + '\'' +
                ", place='" + place + '\'' +
                ", tel='" + tel + '\'' +
                ", people='" + people + '\'' +
                ", personid='" + personid + '\'' +
                ", hmoney=" + hmoney +
                ", mmoney=" + mmoney +
                ", tmoney=" + tmoney +
                ", status=" + status +
                '}';
    }
}
