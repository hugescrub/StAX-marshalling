package prim.hugescrub.staxparsing;

import java.util.Date;

public class User {
    private String id;
    private String fullname;
    private String email;
    private String country;
    private String town;
    private Date registered;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("id:").append("\"").append(id).append("\"").append(",");
        sb.append("fullname:").append("\"").append(fullname).append("\"").append(",");
        sb.append("email:").append("\"").append(email).append("\"").append(",");
        sb.append("country:").append("\"").append(country).append("\"").append(",");
        sb.append("town:").append("\"").append(town).append("\"").append(",");
        sb.append("registered:").append("\"").append(registered).append("\"").append(",");
        sb.append("address:").append("\"").append(address).append("\"");
        sb.append("}");
        return sb.toString();
    }
}
