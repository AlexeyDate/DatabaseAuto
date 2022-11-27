package com.example.database;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.TasksViewHolder> {

    private Context mCtx;
    private List<Cars> carList;

    public CarsAdapter(Context mCtx, List<Cars> carList) {
        this.mCtx = mCtx;
        this.carList = carList;
    }


    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.list_item, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        Cars c = carList.get(position);
     //   holder.textViewTask.setText(c.getId());
        holder.textViewCar.setText(c.getCar());
        holder.textViewModel.setText(c.getModel());
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder {

        TextView textViewCar, textViewModel;

        public TasksViewHolder(View itemView) {
            super(itemView);

            textViewCar = itemView.findViewById(R.id.text1);
            textViewModel = itemView.findViewById(R.id.text2);
        }
    }
}
