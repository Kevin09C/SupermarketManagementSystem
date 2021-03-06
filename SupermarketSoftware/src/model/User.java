package model;

import java.io.Serializable;


public abstract class User implements Serializable {
    public int id;
    public String user, pass;
    private static int nrUsers=0;
    public User(String user, String pass) {
        this.id=nrUsers++;
        this.user = user;
        this.pass = pass;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public int getId() {
        return id;
    }
    public String getUser() {
        return user;
    }
    public static void setNr(int x) {
        nrUsers=x;
    }

    public abstract void setName(String nm);

    public abstract void setAddress(String add);

    public abstract void setBd(MyDate myDate);

    public abstract String getName();

    public abstract String getAddress();

    public abstract MyDate getBd();
}
