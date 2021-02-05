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

public class addSale extends AppCompatActivity {
    EditText medicine,type,dose,quantity,price,amount,date;
    Button add;
    DatabaseReference reference;
    SaleData saleData;
    long maxid=0;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sale);
        medicine=findViewById(R.id.sale_medicine);
        type=findViewById(R.id.sale_type);
        dose=findViewById(R.id.sale_dose);
        quantity=findViewById(R.id.sale_quantity);
        price=findViewById(R.id.sale_price);
        amount=findViewById(R.id.sale_amount);
        date=findViewById(R.id.sale_date);
        add=findViewById(R.id.addtodb_sale);
        saleData=new SaleData();
        reference= FirebaseDatabase.getInstance().getReference().child("SaleData");
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
                saleData.setMedicine(medicine.getText().toString().trim());
                saleData.setType(type.getText().toString().trim());
                saleData.setDose(dose.getText().toString().trim());
                saleData.setQuantity(quantity.getText().toString().trim());
                saleData.setPrice(price.getText().toString().trim());
                saleData.setAmount(amount.getText().toString().trim());
                saleData.setDate(date.getText().toString().trim());
                reference.child(String.valueOf(maxid+1)).setValue(saleData);
                Toast.makeText(addSale.this,"Sale Data inserted successfully!",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void onBackPressed()
    {
        if(Login.userEmail.equals("admin@gmail.com")&&Login.userPaswd.equals("Admin@123")) {
            Intent intent = new Intent(addSale.this, Page.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(addSale.this, page1.class);
            startActivity(intent);
        }
    }
}
