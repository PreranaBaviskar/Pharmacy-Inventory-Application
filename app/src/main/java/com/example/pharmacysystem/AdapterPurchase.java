package com.example.pharmacysystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterPurchase extends RecyclerView.Adapter<AdapterPurchase.ViewHolder>{
    private List<PurchaseData> purchaseData;

    public AdapterPurchase(List<PurchaseData> purchaseData) {
        this.purchaseData = purchaseData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.purchase_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PurchaseData ld=purchaseData.get(position);
        holder.type.setText(ld.getPurchase_type());
        holder.address.setText(ld.getPurchase_address());
        holder.company.setText(ld.getPurchase_company());
        holder.quantity.setText(ld.getPurchase_quantity());
        holder.price.setText(ld.getPurchase_price());
        holder.amount.setText(ld.getPurchase_amount());

    }

    @Override
    public int getItemCount() {
        return purchaseData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView type,address,company,quantity,price,amount;
        public ViewHolder(View itemView) {
            super(itemView);
            type=(TextView)itemView.findViewById(R.id.userdbtypepurchase);
            address=(TextView)itemView.findViewById(R.id.userdbaddresspurchase);
            company=(TextView)itemView.findViewById(R.id.userdbcompanypurchase);
            quantity=(TextView)itemView.findViewById(R.id.userdbquantitypurchase);
            price=(TextView)itemView.findViewById(R.id.userdbpricepurchase);
            amount=(TextView)itemView.findViewById(R.id.userdbamountpurchase);

        }
    }
}
