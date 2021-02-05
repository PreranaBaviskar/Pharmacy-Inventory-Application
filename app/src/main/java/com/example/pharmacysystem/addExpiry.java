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

public class addExpiry extends AppCompatActivity {
EditText name,code,edate,quantity;
Button add;
    DatabaseReference reference;
    ExpiryData expiryData;
    long maxid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expiry);
        name=findViewById(R.id.expiryname);
        code=findViewById(R.id.expirycode);
        edate=findViewById(R.id.expirydate);
        quantity=findViewById(R.id.expiryquantity);
        add=findViewById(R.id.adddbexpiry_button);
        expiryData=new ExpiryData();
        reference= FirebaseDatabase.getInstance().getReference().child("ExpiryData");
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
                expiryData.setName(name.getText().toString().trim());
                expiryData.setCode(code.getText().toString().trim());
                expiryData.setEdate(edate.getText().toString().trim());
                expiryData.setQuantity(quantity.getText().toString().trim());
                reference.child(String.valueOf(maxid+1)).setValue(expiryData);
                Toast.makeText(addExpiry.this,"Expiry Data inserted successfully!",Toast.LENGTH_LONG).show();
            }
        });

    }
    public void onBackPressed()
    {
        if(Login.userEmail.equals("admin@gmail.com")&&Login.userPaswd.equals("Admin@123")) {
            Intent intent = new Intent(addExpiry.this, Page.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(addExpiry.this, page1.class);
            startActivity(intent);
        }
    }
}
