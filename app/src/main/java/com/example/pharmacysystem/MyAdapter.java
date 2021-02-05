package com.example.pharmacysystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<UserData> userData;

    public MyAdapter(List<UserData> userData) {
        this.userData = userData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserData ld=userData.get(position);
        holder.userdbname.setText(ld.getName());
       holder.userdbdob.setText(ld.getDob());
       holder.userdbaddress.setText(ld.getAddress());
       holder.userdbphone.setText(ld.getPhone());
       holder.userdbsalary.setText(ld.getSalary());
       holder.userdbpassword.setText(ld.getPassword());
    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView userdbname,userdbdob,userdbaddress,userdbphone,userdbsalary,userdbpassword;
        public ViewHolder(View itemView) {
            super(itemView);
            userdbname=(TextView)itemView.findViewById(R.id.userdbname);
            userdbdob=(TextView)itemView.findViewById(R.id.userdbdob);
            userdbaddress=(TextView)itemView.findViewById(R.id.userdbaddress);
            userdbphone=(TextView)itemView.findViewById(R.id.userdbphone);
            userdbsalary=(TextView)itemView.findViewById(R.id.userdbsalary);
            userdbpassword=(TextView)itemView.findViewById(R.id.userdbpassword);
        }
    }
}
