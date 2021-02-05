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

public class Invoice extends AppCompatActivity {
EditText id,date,patient,doctor,medication,total;
Button generate;
    DatabaseReference reference;
    InvoiceData invoiceData;
    public static String invoiceid,invoicedate,invoicepatient,invoicedoctor,invoicemedication,invoicetotal;
    long maxid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);
        id=findViewById(R.id.invoiceid);
        date=findViewById(R.id.invoicedate);
        patient=findViewById(R.id.invoicepatient);
        doctor=findViewById(R.id.invoicedoctor);
        medication=findViewById(R.id.invoicemedication);
        total=findViewById(R.id.invoicetotal);
        generate=findViewById(R.id.bill_button);
        invoiceData=new InvoiceData();
        reference= FirebaseDatabase.getInstance().getReference().child("InvoiceData");
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
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invoiceid=id.getText().toString();
                invoicedate=date.getText().toString();
                invoicepatient=patient.getText().toString();
                invoicedoctor=doctor.getText().toString();
                invoicemedication=medication.getText().toString();
                invoicetotal=total.getText().toString();
                invoiceData.setId(id.getText().toString().trim());
                invoiceData.setDate(date.getText().toString().trim());
                invoiceData.setPatient(patient.getText().toString().trim());
                invoiceData.setDoctor(doctor.getText().toString().trim());
                invoiceData.setMedication(medication.getText().toString().trim());
                invoiceData.setTotal(total.getText().toString().trim());
                reference.child(String.valueOf(maxid+1)).setValue(invoiceData);
                Toast.makeText(Invoice.this,"Invoice Data inserted successfully!",Toast.LENGTH_LONG).show();
                startActivity(new Intent(Invoice.this, Receipt.class));
            }
        });
    }
}
