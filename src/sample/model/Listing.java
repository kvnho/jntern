package sample.model;

public class Listing {
    private String company;
    private String position;
    private String location;
    private String link;

    public Listing(){

    }

    public Listing(String company, String position, String location, String link){
        this.company = company;
        this.position = position;
        this.location = location;
        this.link = link;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
