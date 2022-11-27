package com.example.database;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.TasksViewHolder> {

    private Context mCtx;
    private List<Addresses> addressList;

    public AddressesAdapter(Context mCtx, List<Addresses> addressList) {
        this.mCtx = mCtx;
        this.addressList = addressList;
    }


    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.list_item, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        Addresses a = addressList.get(position);
      //  holder.textViewTask.setText(a.getId());
        holder.textViewCountry.setText(a.getCountry());
        holder.textViewCity.setText(a.getCity());
        holder.textViewStreet.setText(a.getStreet());
    }

    @Override
    public int getItemCount() {
        return addressList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCountry, textViewCity, textViewStreet;

        public TasksViewHolder(View itemView) {
            super(itemView);

            textViewCountry = itemView.findViewById(R.id.text1);
            textViewCity = itemView.findViewById(R.id.text2);
            textViewStreet = itemView.findViewById(R.id.text3);
        }
    }
}
