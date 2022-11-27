package com.example.database;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CitizensAdapter extends RecyclerView.Adapter<CitizensAdapter.TasksViewHolder> {

    private Context mCtx;
    private List<Citizens> citizenList;

    public CitizensAdapter(Context mCtx, List<Citizens> citizenList) {
        this.mCtx = mCtx;
        this.citizenList = citizenList;
    }


    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.list_item, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        Citizens t = citizenList.get(position);
      //  holder.textViewTask.setText(t.getId());
        holder.textViewName.setText(t.getName());
        holder.textViewSurname.setText(t.getSurname());
    }

    @Override
    public int getItemCount() {
        return citizenList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewSurname;

        public TasksViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text1);
            textViewSurname = itemView.findViewById(R.id.text2);
        }
    }
}
