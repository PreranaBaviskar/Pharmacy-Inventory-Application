package com.example.pharmacysystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    EditText email, password;
   ImageView signupbutton;
   public static String userEmail,userPaswd;
    private FirebaseAuth.AuthStateListener authStateListener;
   Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);
        signupbutton=findViewById(R.id.signupbutton);
        login=findViewById(R.id.btn_login);
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(Login.this, "User logged in ", Toast.LENGTH_SHORT).show();
                    Intent I = new Intent(Login.this, Page.class);
                    startActivity(I);
                } else {
                    Toast.makeText(Login.this, "Login to continue", Toast.LENGTH_SHORT).show();
                }
            }
        };
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userEmail = email.getText().toString();
              userPaswd = password.getText().toString();

                if (userEmail.isEmpty()) {
                    email.setError("Enter Email ID");
                    email.requestFocus();
                } else if (userPaswd.isEmpty()) {
                    password.setError("Enter Password");
                    password.requestFocus();
                } else if (userEmail.isEmpty() && userPaswd.isEmpty()) {
                    Toast.makeText(Login.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(userEmail.isEmpty() && userPaswd.isEmpty())) {
                    firebaseAuth.signInWithEmailAndPassword(userEmail, userPaswd).addOnCompleteListener(Login.this, new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Login.this, "Not successful", Toast.LENGTH_SHORT).show();
                            } else {
                                if(userEmail.equals("admin@gmail.com")&&userPaswd.equals("Admin@123"))
                                startActivity(new Intent(Login.this, Page.class));
                                else
                                    startActivity(new Intent(Login.this, page1.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(Login.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signupbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(Login.this, Register.class));
    }
});
    }
}
