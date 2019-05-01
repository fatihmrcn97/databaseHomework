package Controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;

public class ModelTable {
    String title;
    String description;
    String skills;
    String price;
    String phoeNum;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhoeNum() {
        return phoeNum;
    }

    public void setPhoeNum(String phoeNum) {
        this.phoeNum = phoeNum;
    }

    public ModelTable(String title, String description, String skills, String price, String phoeNum){
        this.description=description;
        this.title=title;
        this.skills=skills;
        this.price=price;
        this.phoeNum=phoeNum;
    }

}
