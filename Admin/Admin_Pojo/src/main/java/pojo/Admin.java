package pojo;

public class Admin {
    int aid;

    public int getId() {
        return aid;
    }

    public void setId(int id) {
        this.aid = aid;
    }

    String anum;
    String apwd;

    public String getUsername() {
        return anum;
    }

    public void setUsername(String username) {
        this.anum = anum;
    }

    public String getPassword() {
        return apwd;
    }

    public void setPassword(String password) {
        this.apwd = apwd;
    }
}
