package com.example.pharmacysystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Users extends AppCompatActivity {
    private List<UserData> userData;
    private RecyclerView rv;
    private MyAdapter adapter;
ImageView add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        rv=(RecyclerView)findViewById(R.id.recycler1);
        add=findViewById(R.id.adduser_button);
        rv.setLayoutManager(new LinearLayoutManager(this));
        userData=new ArrayList<>();

        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("UserData");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                        UserData l=npsnapshot.getValue(UserData.class);
                        userData.add(l);
                    }
                    adapter=new MyAdapter(userData);
                    rv.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Users.this, addUser.class));
            }
        });
    }
}
