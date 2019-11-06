package pojo;

public class People {
    private String tid;
    private String pname;
    private String transport;
    private float price;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "People{" +
                "tid='" + tid + '\'' +
                ", pname='" + pname + '\'' +
                ", transport='" + transport + '\'' +
                ", price=" + price +
                '}';
    }
}
