package Utils;

import pojos.UserData;

public class TestDataBuild {

    public UserData validUser(){
        UserData ud = new UserData();
        ud.setEmail("eve.holt@reqres.in");
        ud.setPassword("pistol");
        return ud;
    }
    public UserData invalidUser(String email, String password){
        UserData ud = new UserData();
        ud.setEmail(email);
        ud.setPassword(password);
        return ud;
    }

    public UserData xxxUser(){
        return new UserData();

    }

}
