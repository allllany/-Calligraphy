package com.example.ts.news.Bean;

/**
 * Created by ts on 18-8-20.
 */

/**
 * 用于保存用户登录信息(已被SharedPreferences取代)
 */
//用户对应的Java类
public class User {
    private static String username;
    private static String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        User.password = password;
    }

    private static User user = new User();

    private User() {
    }

    public static User getInstance() {
        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        User.username = username;
    }
}
