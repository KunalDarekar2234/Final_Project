package com.visionx;

import javafx.application.Application;

import com.visionx.view.AboutView;
import com.visionx.view.AccountSettingsView;
import com.visionx.view.AiMentorView;
// import com.visionx.view.AthleteDashboard;
import com.visionx.view.AthleteDashboardUI;
import com.visionx.view.ContactUsView;
import com.visionx.view.DietPlannerView;
// import com.visionx.view.PlannerView;
import com.visionx.view.PlatformOverviewView;
import com.visionx.view.WeeklyPlannerUI;
import com.visionx.view.WorkoutExecutionView;
// import com.visionx.view.FitVerseApp;
import com.visionx.view.page;
import com.visionx.view.GymFinderView;
import com.visionx.view.GymTrainerView;
import com.visionx.view.LandingPageView;
// import com.visionx.view.MarketplaceView;
import com.visionx.view.PageNotFoundView;
import com.visionx.view.ProgressAnalyticsView;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Application.launch(AthleteDashboardUI.class, args);

    }
}