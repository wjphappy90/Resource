package com.itheima._05Dom4j解析案例;

public class Contact {
    private int id ;
    private boolean vip;
    private String name;
    private String gender;
    private String email;

    public Contact() {
    }

    public Contact(int id, boolean vip, String name, String gender, String email) {
        this.id = id;
        this.vip = vip;
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", vip=" + vip +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}'+"\n";
    }
}
