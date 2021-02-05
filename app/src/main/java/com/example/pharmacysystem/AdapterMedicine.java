package com.example.pharmacysystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterMedicine extends RecyclerView.Adapter<AdapterMedicine.ViewHolder>{
    private List<MedicineData> medicineData;

    public AdapterMedicine(List<MedicineData> medicineData) {
        this.medicineData = medicineData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MedicineData ld=medicineData.get(position);
        holder.name.setText(ld.getName());
        holder.type.setText(ld.getType());
        holder.dose.setText(ld.getDose());
        holder.code.setText(ld.getCode());
        holder.cp.setText(ld.getCp());
        holder.sp.setText(ld.getSp());
        holder.company.setText(ld.getCompany());
        holder.pdate.setText(ld.getPdate());
        holder.edate.setText(ld.getEdate());
        holder.place.setText(ld.getPlace());
        holder.quantity.setText(ld.getQuantity());
    }

    @Override
    public int getItemCount() {
        return medicineData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name,type,dose,code,cp,sp,company,pdate,edate,place,quantity;
        public ViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.dbnamemedicine);
            type=(TextView)itemView.findViewById(R.id.dbtypemedicine);
            dose=(TextView)itemView.findViewById(R.id.dbdosemedicine);
            code=(TextView)itemView.findViewById(R.id.dbcodemedicine);
            cp=(TextView)itemView.findViewById(R.id.dbcpmedicine);
            sp=(TextView)itemView.findViewById(R.id.dbspmedicine);
            company=(TextView)itemView.findViewById(R.id.dbcompanymedicine);
            pdate=(TextView)itemView.findViewById(R.id.dbpdatemdicine);
            edate=(TextView)itemView.findViewById(R.id.dbedatemedicine);
            place=(TextView)itemView.findViewById(R.id.dbplacemedicine);
            quantity=(TextView)itemView.findViewById(R.id.dbquantitymedicine);


        }
    }
}
