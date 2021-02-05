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

public class addPurchase extends AppCompatActivity {
EditText type,address,company,quantity,price,amount;
Button addtodb_purchase;
    DatabaseReference reference;
    PurchaseData purchaseData;
    long maxid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_purchase);
        type=findViewById(R.id.purchase_type);
        address=findViewById(R.id.purchase_address);
        company=findViewById(R.id.purchase_company_name);
        quantity=findViewById(R.id.purchase_quantity);
        price=findViewById(R.id.purchase_price);
        amount=findViewById(R.id.purchase_amount);
        addtodb_purchase=findViewById(R.id.addtodb_purchase);
        purchaseData=new PurchaseData();
        reference= FirebaseDatabase.getInstance().getReference().child("PurchaseData");
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
        addtodb_purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                purchaseData.setPurchase_type(type.getText().toString().trim());
                purchaseData.setPurchase_address(address.getText().toString().trim());
                purchaseData.setPurchase_company(company.getText().toString().trim());
                purchaseData.setPurchase_quantity(quantity.getText().toString().trim());
                purchaseData.setPurchase_price(price.getText().toString().trim());
                purchaseData.setPurchase_amount(amount.getText().toString().trim());
                reference.child(String.valueOf(maxid+1)).setValue(purchaseData);
                Toast.makeText(addPurchase.this,"Purchase Data inserted successfully!",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void onBackPressed()
    {
        if(Login.userEmail.equals("admin@gmail.com")&&Login.userPaswd.equals("Admin@123")) {
            Intent intent = new Intent(addPurchase.this, Page.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(addPurchase.this, page1.class);
            startActivity(intent);
        }
    }
}
