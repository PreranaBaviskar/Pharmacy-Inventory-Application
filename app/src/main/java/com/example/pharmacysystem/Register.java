package com.example.pharmacysystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class Register extends AppCompatActivity {
EditText name, signmail,signpass,signrepass;
Button signup;
ImageView backlogin;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.et_name);
        signmail=findViewById(R.id.et_email1);
        signpass=findViewById(R.id.et_password1);
        signrepass=findViewById(R.id.et_repassword1);
        signup=findViewById(R.id.btn_register);
        backlogin=findViewById(R.id.gotologin);
        firebaseAuth = FirebaseAuth.getInstance();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailID = signmail.getText().toString();
                String paswd = signpass.getText().toString();
                String repass=signrepass.getText().toString();
                String names=name.getText().toString();
                if (names.isEmpty()) {
                    name.setError("Enter your name");
                    name.requestFocus();
                }
               else if (emailID.isEmpty()) {
                    signmail.setError("Provide your Email first!");
                    signmail.requestFocus();
                } else if (paswd.isEmpty()) {
                    signpass.setError("Set your password");
                    signpass.requestFocus();
                }
                else if (repass.isEmpty()) {
                    signrepass.setError("Retype the password");
                    signrepass.requestFocus();
                }
                else if (emailID.isEmpty() && paswd.isEmpty()&&names.isEmpty()&&repass.isEmpty()) {
                    Toast.makeText(Register.this, "Fields are Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(emailID.isEmpty() && paswd.isEmpty())) {
                    firebaseAuth.createUserWithEmailAndPassword(emailID, paswd).addOnCompleteListener(Register.this, new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {

                            if (!task.isSuccessful()) {
                                Toast.makeText(Register.this.getApplicationContext(),
                                        "SignUp unsuccessful: " + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(Register.this, Login.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(Register.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
backlogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(Register.this, Login.class));
    }
});
    }
}
