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

public class addHistory extends AppCompatActivity {
EditText user,medicine,type,dose,quantity,price,amount,date,time;
Button add;
    DatabaseReference reference;
    HistoryData historyData;
    long maxid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_history);
        user=findViewById(R.id.history_name);
        medicine=findViewById(R.id.history_medicine);
        type=findViewById(R.id.history_type);
        dose=findViewById(R.id.history_dose);
        quantity=findViewById(R.id.history_quantity);
        price=findViewById(R.id.history_price);
        amount=findViewById(R.id.history_amount);
        date=findViewById(R.id.history_date);
        time=findViewById(R.id.history_time);
        add=findViewById(R.id.addtodb_history);
        historyData=new HistoryData();
        reference= FirebaseDatabase.getInstance().getReference().child("HistoryData");
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
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyData.setUser(user.getText().toString().trim());
                historyData.setMedicine(medicine.getText().toString().trim());
                historyData.setType(type.getText().toString().trim());
                historyData.setDose(dose.getText().toString().trim());
                historyData.setQuantity(quantity.getText().toString().trim());
                historyData.setPrice(price.getText().toString().trim());
                historyData.setAmount(amount.getText().toString().trim());
                historyData.setDate(date.getText().toString().trim());
                historyData.setTime(time.getText().toString().trim());
                reference.child(String.valueOf(maxid+1)).setValue(historyData);
                Toast.makeText(addHistory.this,"History Data inserted successfully!",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void onBackPressed()
    {
        if(Login.userEmail.equals("admin@gmail.com")&&Login.userPaswd.equals("Admin@123")) {
            Intent intent = new Intent(addHistory.this, Page.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(addHistory.this, page1.class);
            startActivity(intent);
        }
    }
}
