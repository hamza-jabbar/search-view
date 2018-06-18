package com.hjabb.androidprojects.searchview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hjabb on 19/03/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    ArrayList<Hall> hallArray = new ArrayList<>();

    public RecyclerAdapter(ArrayList<Hall> hallArray) {
        this.hallArray = hallArray;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.halls.setImageResource(hallArray.get(position).getHallImg());
        holder.names.setText(hallArray.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return hallArray.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView halls;
        TextView names;

        public MyViewHolder(View itemView) {
            super(itemView);
            halls = (ImageView) itemView.findViewById(R.id.ivHall);
            names = (TextView) itemView.findViewById(R.id.tvName);
        }
    }

    public void setFilter(ArrayList<Hall> newList) {
        hallArray = new ArrayList<>();
        hallArray.addAll(newList);

        notifyDataSetChanged(); //refreshes the adapter
    }
}
