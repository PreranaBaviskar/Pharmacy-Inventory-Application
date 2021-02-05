package com.example.pharmacysystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Company extends AppCompatActivity {
    ImageView add;
    private List<CompanyData> companyData;
    private RecyclerView rv;
    private AdapterCompany adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        rv=(RecyclerView)findViewById(R.id.recycler_company);
        add=findViewById(R.id.addcompany_button);
        rv.setLayoutManager(new LinearLayoutManager(this));
        companyData=new ArrayList<>();
        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("CompanyData");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                        CompanyData l=npsnapshot.getValue(CompanyData.class);
                        companyData.add(l);
                    }
                    adapter=new AdapterCompany(companyData);
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
                startActivity(new Intent(Company.this, addCompany.class));
            }
        });
    }
}
