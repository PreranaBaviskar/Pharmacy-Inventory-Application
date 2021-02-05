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

public class History extends AppCompatActivity {
    private List<HistoryData> historyData;
    private RecyclerView rv;
    private AdapterHistory adapter;
    ImageView add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        add=findViewById(R.id.addhistory_button);
        rv=(RecyclerView)findViewById(R.id.recycler_history);
        rv.setLayoutManager(new LinearLayoutManager(this));
        historyData=new ArrayList<>();

        final DatabaseReference nm= FirebaseDatabase.getInstance().getReference("HistoryData");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                        HistoryData l=npsnapshot.getValue(HistoryData.class);
                        historyData.add(l);
                    }
                    adapter=new AdapterHistory(historyData);
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
                startActivity(new Intent(History.this, addHistory.class));
            }
        });
    }
}
