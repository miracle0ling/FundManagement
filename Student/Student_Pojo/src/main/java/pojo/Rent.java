package pojo;

public class Rent {
    private float money;
    private String dw;
    private String bank;
    private String account;
    private String province;
    private String city;
    private String leibie;
    private String pid;
    private String type;
    private String people;
    private String tel;
    private String personid;
    private String time;
    private int status;
    private String method;
    private String mission;

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    @Override
    public String toString() {
        return "Rent{" +
                "money=" + money +
                ", dw='" + dw + '\'' +
                ", bank='" + bank + '\'' +
                ", account='" + account + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", leibie='" + leibie + '\'' +
                ", pid='" + pid + '\'' +
                ", type='" + type + '\'' +
                ", people='" + people + '\'' +
                ", tel='" + tel + '\'' +
                ", personid='" + personid + '\'' +
                ", status=" + status +
                '}';
    }
}
