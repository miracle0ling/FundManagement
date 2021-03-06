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
    private float hmoney;   //住宿费
    private float mmoney;   //会议费
    private float tmoney;   //交通费
    private float rmoney;   //退票费
    private float pmoney;   //保险费
    private float cmoney;   //培训费
    private float omoney;   //其他费用
    private int fbmoney;  //伙食补助费
    private int tbmoney;  //交通补助费
    private int status;
    private String method;

    public float getOmoney() {
        return omoney;
    }

    public void setOmoney(float omoney) {
        this.omoney = omoney;
    }

    public float getRmoney() {
        return rmoney;
    }

    public void setRmoney(float rmoney) {
        this.rmoney = rmoney;
    }

    public float getPmoney() {
        return pmoney;
    }

    public void setPmoney(float pmoney) {
        this.pmoney = pmoney;
    }

    public float getCmoney() {
        return cmoney;
    }

    public void setCmoney(float cmoney) {
        this.cmoney = cmoney;
    }

    public int getFbmoney() {
        return fbmoney;
    }

    public void setFbmoney(int fbmoney) {
        this.fbmoney = fbmoney;
    }

    public int getTbmoney() {
        return tbmoney;
    }

    public void setTbmoney(int tbmoney) {
        this.tbmoney = tbmoney;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

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
                ", time='" + time + '\'' +
                ", hmoney=" + hmoney +
                ", mmoney=" + mmoney +
                ", tmoney=" + tmoney +
                ", rmoney=" + rmoney +
                ", pmoney=" + pmoney +
                ", cmoney=" + cmoney +
                ", omoney=" + omoney +
                ", fbmoney=" + fbmoney +
                ", tbmoney=" + tbmoney +
                ", status=" + status +
                ", method='" + method + '\'' +
                '}';
    }
}
