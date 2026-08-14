package com.visionx;

import javafx.application.Application;

// import com.visionx.view.Sign_Up;
// import com.visionx.view.suppliment_login.Dashboard;
// import com.visionx.view.super_admin.Dashboard;
// import com.visionx.view.user_login.LandingPageView;
import com.visionx.view.LoginPage;
import com.visionx.view.SplashScreen;

public class Main {
    public static void main(String[] args) {

        try{
            Class.forName("com.visionx.config.FirebaseConfig");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Hello world!");

        Application.launch(SplashScreen.class, args);

    }
}