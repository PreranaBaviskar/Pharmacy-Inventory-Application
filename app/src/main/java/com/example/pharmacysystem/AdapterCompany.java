package com.example.pharmacysystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCompany extends RecyclerView.Adapter<AdapterCompany.ViewHolder>{
    private List<CompanyData> companyData;

    public AdapterCompany(List<CompanyData> companyData) {
        this.companyData = companyData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.company_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CompanyData ld=companyData.get(position);
        holder.companydbname.setText(ld.getCompany_name());
        holder.companydbaddress.setText(ld.getCompany_address());
        holder.companydbphone.setText(ld.getCompany_phone());
    }

    @Override
    public int getItemCount() {
        return companyData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView companydbname,companydbaddress,companydbphone;
        public ViewHolder(View itemView) {
            super(itemView);
            companydbname=(TextView)itemView.findViewById(R.id.companydbname);
            companydbaddress=(TextView)itemView.findViewById(R.id.companydbaddress);
            companydbphone=(TextView)itemView.findViewById(R.id.companydbphone);
        }
    }
}
