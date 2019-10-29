package pojo;

public class Teacher {
    private String tid;
    private String tname;
    private String partment;
    private String password;

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", partment='" + partment + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPartment() {
        return partment;
    }

    public void setPartment(String partment) {
        this.partment = partment;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
