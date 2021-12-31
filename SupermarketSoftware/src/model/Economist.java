package model;

public class Economist extends User implements Checker {

    private String name, address;
    private MyDate bd;
    public Economist(String user, String pass, String name, String address, MyDate bd) {
        super(user, pass);
        this.name = name;
        this.address = address;
        this.bd = bd;
    }
    @Override
    public boolean checkUser(String user, String pass) {
        return user.equals(this.getUser())&&pass.equals(this.getPass());
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + name + ", address=" + address + ", bd=" + bd + "]";
    }

    @Override
    public void setName(String nm) {
        nm = name;
    }

    @Override
    public void setAddress(String add) {
        add =address;
    }

    @Override
    public void setBd(MyDate myDate) {
        myDate = bd;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public MyDate getBd() {
        return bd;
    }
}
