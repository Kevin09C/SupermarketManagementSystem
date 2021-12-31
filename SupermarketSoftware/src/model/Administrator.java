package model;

public class Administrator extends User implements Checker {

    public Administrator(String user, String pass) {
        super(user, pass);
    }

    @Override
    public void setName(String nm) {

    }

    @Override
    public void setAddress(String add) {

    }

    @Override
    public void setBd(MyDate myDate) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getAddress() {
        return null;
    }

    @Override
    public MyDate getBd() {
        return null;
    }

    @Override
    public boolean checkUser(String user, String pass) {
        return user.equals(this.getUser())&&pass.equals(this.getPass());
    }
}
