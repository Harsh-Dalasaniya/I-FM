package com.example.indiasforestmatrix.Recyclerview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.indiasforestmatrix.R;

import java.util.List;

import javax.sql.RowSet;

public class Adapterr extends RecyclerView.Adapter<Adapterr.ViewHolder> implements adapter {

    private List<POJO> POJO;
    Context context;
    private static adapter adapterInterface;
    private ItemClickListener onItemClickListener;
    public Adapterr(List<POJO> POJO, Context context) {
        this.POJO = POJO;
        this.context= context;
        this.adapterInterface=adapterInterface;
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

        POJO d = POJO.get(i);
        holder.txt.setText(d.getListitem());
        holder.img.setImageResource(d.getImageId());
        holder.txt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v, i);
               // Log.d("CREATETEST", d.getWEB());
                //adapterInterface.onClickItem(d.getWEB());
            }
        });

    }
    @Override
    public int getItemCount() {
        return POJO.size();
    }

    public void setItemClickListener(ItemClickListener clickListener) {
        onItemClickListener = clickListener;
    }

    @Override
    public void onClickItem(String web) {

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
