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

public class addMedicine extends AppCompatActivity {
EditText name,type,dose, code,cp,sp,pdate,edate,company,place,quantity;
Button add;
    DatabaseReference reference;
    MedicineData medicineData;
    long maxid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);
        name=findViewById(R.id.medicine_name);
        type=findViewById(R.id.medicine_type);
        dose=findViewById(R.id.medicine_dose);
        code=findViewById(R.id.medicine_code);
        cp=findViewById(R.id.medicine_cp);
        sp=findViewById(R.id.medicine_sp);
        pdate=findViewById(R.id.pdate);
        edate=findViewById(R.id.edate);
        company=findViewById(R.id.medicine_company);
        place=findViewById(R.id.medicine_place);
        quantity=findViewById(R.id.medicine_quantity);
        add=findViewById(R.id.addtodb_medicine);
        medicineData=new MedicineData();
        reference= FirebaseDatabase.getInstance().getReference().child("MedicineData");
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
                medicineData.setName(name.getText().toString().trim());
                medicineData.setType(type.getText().toString().trim());
                medicineData.setDose(dose.getText().toString().trim());
                medicineData.setCode(code.getText().toString().trim());
                medicineData.setCp(cp.getText().toString().trim());
                medicineData.setSp(sp.getText().toString().trim());
                medicineData.setPdate(pdate.getText().toString().trim());
                medicineData.setEdate(edate.getText().toString().trim());
                medicineData.setCompany(company.getText().toString().trim());
                medicineData.setPlace(place.getText().toString().trim());
                medicineData.setQuantity(quantity.getText().toString().trim());
                reference.child(String.valueOf(maxid+1)).setValue(medicineData);
                Toast.makeText(addMedicine.this,"Medicine Data inserted successfully!",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void onBackPressed()
    {
        if(Login.userEmail.equals("admin@gmail.com")&&Login.userPaswd.equals("Admin@123")) {
            Intent intent = new Intent(addMedicine.this, Page.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(addMedicine.this, page1.class);
            startActivity(intent);
        }
    }
}
