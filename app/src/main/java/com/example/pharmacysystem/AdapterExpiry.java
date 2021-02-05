package com.example.pharmacysystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterExpiry extends RecyclerView.Adapter<AdapterExpiry.ViewHolder>{
    private List<ExpiryData> expiryData;

    public AdapterExpiry(List<ExpiryData> expiryData) {
        this.expiryData = expiryData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.expiry_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExpiryData ld=expiryData.get(position);
        holder.name.setText(ld.getName());
        holder.code.setText(ld.getCode());
        holder.edate.setText(ld.getEdate());
        holder.quantity.setText(ld.getQuantity());

    }

    @Override
    public int getItemCount() {
        return expiryData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name,code,edate,quantity;
        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.expirydbname);
            code=(TextView)itemView.findViewById(R.id.expirydbcode);
            edate=(TextView)itemView.findViewById(R.id.expirydbedate);
            quantity=(TextView)itemView.findViewById(R.id.expirydbquantity);

        }
    }
}
