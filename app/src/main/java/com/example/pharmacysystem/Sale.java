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

public class Sale extends AppCompatActivity {
    private List<SaleData> saleData;
    private RecyclerView rv;
    private AdapterSale adapter;
    ImageView add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
        add=findViewById(R.id.addsale_button);
        rv=(RecyclerView)findViewById(R.id.recycler_sale);
        rv.setLayoutManager(new LinearLayoutManager(this));
        saleData=new ArrayList<>();

        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("SaleData");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                        SaleData l=npsnapshot.getValue(SaleData.class);
                        saleData.add(l);
                    }
                    adapter=new AdapterSale(saleData);
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
                startActivity(new Intent(Sale.this, addSale.class));
            }
        });
    }
}
