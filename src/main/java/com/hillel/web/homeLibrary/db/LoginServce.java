package com.hillel.web.homeLibrary.db;

import com.hillel.web.homeLibrary.staff.User;

public class LoginServce {
    WorkDB dbWork = new WorkDB();



    public User login(String username, String password) {

        User user = dbWork.findUser(username, password);

        if (user != null) {
            return user;
        } else {
            return new User("New User", "");
        }
    }

}
