package com.gmail.artsiombaranau.utils;

import javax.servlet.http.HttpSession;

public class AuthorizationUtil {

    public static boolean isLogined(HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        return userName != null;
    }

}
