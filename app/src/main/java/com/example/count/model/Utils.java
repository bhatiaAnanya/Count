package com.example.count.model;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.count.view.Counter;
import com.example.count.view.LoginActivity;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Utils {

    private static final Utils ourInstance = new Utils();
//    private ArrayList<Counter> counterArrayList;

    public static Utils getInstance() {
        return ourInstance;
    }

    private Utils() {
    }

    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private FirebaseFirestore db;
    private GoogleSignInClient googleSignInClient;

    public void setGoogleSignInClient(GoogleSignInClient googleSignInClient) {
        this.googleSignInClient = googleSignInClient;
    }

//    public void setCounterList(ArrayList<Counter> counterArrayList) {
//        this.counterArrayList = counterArrayList;
//    }



    public FirebaseFirestore getDb() {
        return db;
    }

    public void setDb(FirebaseFirestore db) {
        this.db = db;
    }

    public FirebaseUser getUser() {
        return user;
    }

    public void setUser(FirebaseUser user) {
        this.user = user;
    }

    public void init() {
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();
    }

    public void signOut() {
        googleSignInClient.signOut();
        FirebaseAuth.getInstance().signOut();
    }

//    public ArrayList<Counter> getCounterList() {
//        return this.counterArrayList;
//    }
}
