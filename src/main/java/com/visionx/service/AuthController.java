package com.visionx.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.firebase.cloud.FirestoreClient;
import java.util.Map;
import java.util.HashMap;

public class AuthController {
    
    private String API_KEY = "AIzaSyDeuXcVxc5wIwKg57pZ4cb2jL2r3_--smM";

    public boolean signUp(String email, String password, String role, String name){
        JSONObject payload = new JSONObject()
            .put("email",email)
            .put("password", password);

        try{
            HttpClient client = HttpClient.newHttpClient();
            URI uri = URI.create("https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=" + API_KEY);

            HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(payload.toString()))
                .build();

            System.out.println(request);
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response);
            System.out.println(response.statusCode());
            System.out.println(response.body());

            if (response.statusCode() == 200) {
                JSONObject resJson = new JSONObject(response.body());
                String uid = resJson.getString("localId");
                
                Firestore db = FirestoreClient.getFirestore();
                Map<String, Object> data = new HashMap<>();
                data.put("email", email);
                data.put("role", role);
                data.put("name", name);
                db.collection("users").document(uid).set(data);

                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean signIn(String email, String password, String role){
        JSONObject payload = new JSONObject()
            .put("email",email)
            .put("password", password);

        try{
            HttpClient client = HttpClient.newHttpClient();
            URI uri = URI.create("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + API_KEY);

            HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(payload.toString()))
                .build();

            System.out.println(request);
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response);
            System.out.println(response.statusCode());
            System.out.println(response.body());

            if (response.statusCode() == 200) {
                JSONObject resJson = new JSONObject(response.body());
                String uid = resJson.getString("localId");
                
                Firestore db = FirestoreClient.getFirestore();
                DocumentSnapshot doc = db.collection("users").document(uid).get().get();
                if (doc.exists()) {
                    String dbRole = doc.getString("role");
                    if (role.equals(dbRole)) {
                        return true;
                    } else {
                        System.out.println("Role mismatch: Expected " + role + " but got " + dbRole);
                        return false;
                    }
                } else {
                    System.out.println("User record not found in Firestore.");
                    return false;
                }
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
