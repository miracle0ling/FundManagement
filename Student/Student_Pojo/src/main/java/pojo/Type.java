package pojo;

public class Type {
    private String id;
    private String project;
    private String cproject;
    private String ttype;

    public String getTtype() {
        return ttype;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getCproject() {
        return cproject;
    }

    public void setCproject(String cproject) {
        this.cproject = cproject;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id='" + id + '\'' +
                ", project='" + project + '\'' +
                ", cproject='" + cproject + '\'' +
                ", ttype='" + ttype + '\'' +
                '}';
    }
}
