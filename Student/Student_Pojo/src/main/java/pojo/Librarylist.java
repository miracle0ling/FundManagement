package pojo;

public class Librarylist {
    private int lid;
    private String tname;
    private int quantity;
    private float money;
    private float tax;
    private String dw;
    private String rid;
    private float unitprice;
    private int id;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getId() {
        return lid;
    }

    public void setId(int id) {
        this.lid = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
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

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(float unitprice) {
        this.unitprice = unitprice;
    }

    @Override
    public String toString() {
        return "Librarylist{" +
                "id=" + lid +
                ", tname='" + tname + '\'' +
                ", quantity=" + quantity +
                ", money=" + money +
                ", tax=" + tax +
                ", dw='" + dw + '\'' +
                ", rid='" + rid + '\'' +
                ", unitprice=" + unitprice +
                '}';
    }
}
