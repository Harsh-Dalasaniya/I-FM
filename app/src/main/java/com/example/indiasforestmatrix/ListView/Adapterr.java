package com.example.indiasforestmatrix.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indiasforestmatrix.R;

import java.util.List;

public class Adapterr extends RecyclerView.Adapter<Adapterr.ViewHolder> {

    private List<POJO> POJO;
    Context mcontext;

    public Adapterr(List<POJO> POJO,Context mcontext) {
        this.POJO = POJO;
        this.mcontext= mcontext;
    }

    @NonNull
    @Override
    public Adapterr.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listlayout,null);
        ViewHolder viewHolder=new ViewHolder(itemview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterr.ViewHolder holder, int i) {

        POJO d=POJO.get(i);
        holder.txt.setText(d.getListitem());
        holder.img.setImageResource(d.getImageId());
    }

    @Override
    public int getItemCount() {
        return POJO.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txt;
        public ImageView img;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt=(TextView) itemView.findViewById(R.id.t1);
            img=(ImageView) itemView.findViewById(R.id.i1);
        }
    }
}
