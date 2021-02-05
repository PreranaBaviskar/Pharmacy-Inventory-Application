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

public class addCompany extends AppCompatActivity {
EditText company,address,phone;
    Button addtodb;
    DatabaseReference reference;
   CompanyData companyData;
    long maxid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_company);
        company=findViewById(R.id.company_name);
        address=findViewById(R.id.company_address);
        phone=findViewById(R.id.company_phone);
        addtodb=findViewById(R.id.addcompany);
        companyData=new CompanyData();
        reference= FirebaseDatabase.getInstance().getReference().child("CompanyData");
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
        addtodb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companyData.setCompany_name(company.getText().toString().trim());
                companyData.setCompany_address(address.getText().toString().trim());
                companyData.setCompany_phone(phone.getText().toString().trim());
                reference.child(String.valueOf(maxid+1)).setValue(companyData);
                Toast.makeText(addCompany.this,"Company Data inserted successfully!",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void onBackPressed()
    {
        if(Login.userEmail.equals("admin@gmail.com")&&Login.userPaswd.equals("Admin@123")) {
            Intent intent = new Intent(addCompany.this, Page.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(addCompany.this, page1.class);
            startActivity(intent);
        }
    }
}
