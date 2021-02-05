package com.example.pharmacysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Receipt extends AppCompatActivity {
TextView id,date,patient,doctor,medication,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        id=findViewById(R.id.invoiceid);
        date=findViewById(R.id.date);
        patient=findViewById(R.id.ptname);
        doctor=findViewById(R.id.docname);
        medication=findViewById(R.id.medication);
        total=findViewById(R.id.totamt);
        id.setText(Invoice.invoiceid);
        date.setText(Invoice.invoicedate);
        patient.setText(Invoice.invoicepatient);
        doctor.setText(Invoice.invoicedoctor);
        medication.setText(Invoice.invoicemedication);
        total.setText(Invoice.invoicetotal);

    }
    public void onBackPressed()
    {
        if(Login.userEmail.equals("admin@gmail.com")&&Login.userPaswd.equals("Admin@123")) {
            Intent intent = new Intent(Receipt.this, Page.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(Receipt.this, page1.class);
            startActivity(intent);
        }
    }
}
