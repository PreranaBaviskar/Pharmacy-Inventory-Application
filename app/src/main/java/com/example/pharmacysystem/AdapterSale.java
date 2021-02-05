package com.example.pharmacysystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterSale extends RecyclerView.Adapter<AdapterSale.ViewHolder>{
    private List<SaleData> saleData;

    public AdapterSale(List<SaleData> saleData) {
        this.saleData = saleData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sale_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SaleData ld=saleData.get(position);
        holder.medicine.setText(ld.getMedicine());
        holder.type.setText(ld.getType());
        holder.dose.setText(ld.getDose());
        holder.quantity.setText(ld.getQuantity());
        holder.price.setText(ld.getPrice());
        holder.amount.setText(ld.getAmount());
        holder.date.setText(ld.getDate());
    }

    @Override
    public int getItemCount() {
        return saleData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView medicine,type,dose,quantity,price,amount,date;
        public ViewHolder(View itemView) {
            super(itemView);
            medicine=(TextView)itemView.findViewById(R.id.saledbmedicine);
            type=(TextView)itemView.findViewById(R.id.saledbtype);
            dose=(TextView)itemView.findViewById(R.id.saledbdose);
            quantity=(TextView)itemView.findViewById(R.id.saledbquantity);
            price=(TextView)itemView.findViewById(R.id.saledbprice);
            amount=(TextView)itemView.findViewById(R.id.saledbamount);
            date=(TextView)itemView.findViewById(R.id.saledbdate);
        }
    }
}
