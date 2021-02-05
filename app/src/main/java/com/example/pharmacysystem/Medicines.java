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

public class Medicines extends AppCompatActivity {
    private List<MedicineData> medicineData;
    private RecyclerView rv;
    private AdapterMedicine adapter;
    ImageView add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicines);
        rv=(RecyclerView)findViewById(R.id.recycler_medicine);
        add=findViewById(R.id.addmedicine_button);
        rv.setLayoutManager(new LinearLayoutManager(this));
        medicineData=new ArrayList<>();

        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("MedicineData");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                        MedicineData l=npsnapshot.getValue(MedicineData.class);
                        medicineData.add(l);
                    }
                    adapter=new AdapterMedicine(medicineData);
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
                startActivity(new Intent(Medicines.this, addMedicine.class));
            }
        });
    }
}
