package com.example.pharmacysystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class page1 extends AppCompatActivity {
    Button medicines, company, expiry, history, invoice, users, purchase, sale;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        medicines=findViewById(R.id.medicines_button);
        company=findViewById(R.id.company_button);
        expiry=findViewById(R.id.expiry_button);
        history=findViewById(R.id.history_button);
        invoice=findViewById(R.id.invoice_button);
        purchase=findViewById(R.id.purchase_button);
        sale=findViewById(R.id.sale_button);
        dl=findViewById(R.id.page);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open,R.string.Close);
        t.setDrawerIndicatorEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dl.addDrawerListener(t);
        t.syncState();
        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.dashboard:
                        startActivity(new Intent(page1.this, page1.class));
                        Toast.makeText(page1.this, "My Dashboard",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.about:
                        startActivity(new Intent(page1.this, AboutUs.class));
                        Toast.makeText(page1.this, "About us",Toast.LENGTH_SHORT).show();break;
                    case R.id.logout:
                        startActivity(new Intent(page1.this, Login.class));
                        Toast.makeText(page1.this, "Successfully Logged out!",Toast.LENGTH_SHORT).show();break;
                    default:
                        return true;
                }


                return true;

            }
        });


        medicines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(page1.this, Medicines.class));
            }
        });
        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(page1.this, Company.class));
            }
        });
        expiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(page1.this, Expiry.class));
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(page1.this, History.class));
            }
        });
        invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(page1.this, Invoice.class));
            }
        });
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(page1.this, Purchase.class));
            }
        });
        sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(page1.this, Sale.class));
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
