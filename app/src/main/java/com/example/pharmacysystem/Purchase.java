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

public class Purchase extends AppCompatActivity {
    private List<PurchaseData> purchaseData;
    private RecyclerView rv;
    private AdapterPurchase adapter;
    ImageView add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        rv=(RecyclerView)findViewById(R.id.recycler_purchase);
        add=findViewById(R.id.addpurchase_button);
        rv.setLayoutManager(new LinearLayoutManager(this));
        purchaseData=new ArrayList<>();

        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("PurchaseData");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                        PurchaseData l=npsnapshot.getValue(PurchaseData.class);
                        purchaseData.add(l);
                    }
                    adapter=new AdapterPurchase(purchaseData);
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
                startActivity(new Intent(Purchase.this, addPurchase.class));
            }
        });
    }
}
