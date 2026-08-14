package com.visionx.config;

import java.io.FileInputStream;

import com.google.auth.oauth2.GoogleCredentials;
// import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class FirebaseConfig {

    static {
        getFirebaseConfig();
    }

    private static void getFirebaseConfig(){
        try{
            FileInputStream serviceAccount =
            new FileInputStream("src/main/resources/serviceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
  .build();

        FirebaseApp.initializeApp(options);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static FirebaseApp getFirebaseApp() {
        return FirebaseApp.getInstance();
    }
}