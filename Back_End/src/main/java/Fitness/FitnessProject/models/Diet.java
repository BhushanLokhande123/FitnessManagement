package Fitness.FitnessProject.models;

public class Diet {

    private int id;
    private String mon;
    private String tue;
    private String wed;
    private String thu;
    private String fri;
    private String sat;
    private String sun;
    public Diet()
    {

    }
    public Diet(int id, String sun, String mon, String tue, String wed, String thu, String fri, String sat) {
        this.id = id;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMon() {
        return mon;
    }
    public void setMon(String mon) {
        this.mon = mon;
    }
    public String getTue() {
        return tue;
    }
    public void setTue(String tue) {
        this.tue = tue;
    }
    public String getWed() {
        return wed;
    }
    public void setWed(String wed) {
        this.wed = wed;
    }
    public String getThu() {
        return thu;
    }
    public void setThu(String thu) {
        this.thu = thu;
    }
    public String getFri() {
        return fri;
    }
    public void setFri(String fri) {
        this.fri = fri;
    }
    public String getSat() {
        return sat;
    }
    public void setSat(String sat) {
        this.sat = sat;
    }
    public String getSun() {
        return sun;
    }
    public void setSun(String sun) {
        this.sun = sun;
    }


    
}
