package com.example.pharmacysystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class addUser extends AppCompatActivity {
    EditText name, dob, address, phone, salary, password;
    Button addtodb;
    DatabaseReference reference;
    UserData userData;
    long maxid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        name=findViewById(R.id.name);
        dob=findViewById(R.id.dob);
        address=findViewById(R.id.user_address);
        phone=findViewById(R.id.phone);
        salary=findViewById(R.id.salary);
        password=findViewById(R.id.password);
        addtodb=findViewById(R.id.add_button);
        userData=new UserData();
        reference= FirebaseDatabase.getInstance().getReference().child("UserData");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        addtodb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userData.setName(name.getText().toString().trim());
                userData.setDob(dob.getText().toString().trim());
                userData.setAddress(address.getText().toString().trim());
                userData.setPhone(phone.getText().toString().trim());
                userData.setSalary(salary.getText().toString().trim());
                userData.setPassword(password.getText().toString().trim());
                reference.child(String.valueOf(maxid+1)).setValue(userData);
                Toast.makeText(addUser.this,"User Data inserted successfully!",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void onBackPressed()
    {
        if(Login.userEmail.equals("admin@gmail.com")&&Login.userPaswd.equals("Admin@123")) {
            Intent intent = new Intent(addUser.this, Page.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(addUser.this, page1.class);
            startActivity(intent);
        }
    }
}
