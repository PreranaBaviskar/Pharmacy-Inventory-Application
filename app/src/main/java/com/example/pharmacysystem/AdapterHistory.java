package com.example.pharmacysystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.ViewHolder>{
    private List<HistoryData> historyData;

    public AdapterHistory(List<HistoryData> historyData) {
        this.historyData = historyData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.history,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HistoryData ld=historyData.get(position);
        holder.user.setText(ld.getUser());
        holder.medicine.setText(ld.getMedicine());
        holder.type.setText(ld.getType());
        holder.dose.setText(ld.getDose());
        holder.quantity.setText(ld.getQuantity());
        holder.price.setText(ld.getPrice());
        holder.amount.setText(ld.getAmount());
        holder.date.setText(ld.getDate());
        holder.time.setText(ld.getTime());
    }

    @Override
    public int getItemCount() {
        return historyData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView user,medicine,type,dose,quantity,price,amount,date,time;
        public ViewHolder(View itemView) {
            super(itemView);
            user=(TextView)itemView.findViewById(R.id.historydbuser);
            medicine=(TextView)itemView.findViewById(R.id.historydbmedicine);
            type=(TextView)itemView.findViewById(R.id.historydbtype);
            dose=(TextView)itemView.findViewById(R.id.historydbdose);
            quantity=(TextView)itemView.findViewById(R.id.historydbquantity);
            price=(TextView)itemView.findViewById(R.id.historydbprice);
            amount=(TextView)itemView.findViewById(R.id.historydbamount);
            date=(TextView)itemView.findViewById(R.id.historydbdate);
            time=(TextView)itemView.findViewById(R.id.historydbtime);
        }
    }
}
