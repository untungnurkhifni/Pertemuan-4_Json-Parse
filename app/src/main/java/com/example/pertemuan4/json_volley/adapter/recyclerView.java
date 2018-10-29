package com.example.pertemuan4.json_volley.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.pertemuan4.json_volley.model.imdb_ind_film;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.pertemuan4.json_volley.R;

import java.util.List;

public class recyclerView  extends RecyclerView.Adapter<recyclerView.MyViewHolder>{

    RequestOptions options;
    private Context mContext;
    private List<imdb_ind_film> mData;

    public recyclerView(Context mContext, List firstLst) {
        this.mContext = mContext;
        this.mData = firstLst;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_img)
                .error(R.drawable.loading_img);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.imdb_list_film,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {

        myViewHolder.tv_judul.setText(mData.get(position).getJudul());
        myViewHolder.tv_deskripsi.setText(mData.get(position).getDeskripsi());
        myViewHolder.tv_rate.setText(mData.get(position).getRate());
        myViewHolder.tv_sutradara.setText(mData.get(position).getSutradara());
        myViewHolder.tv_kategori.setText(mData.get(position).getKategori());

        //load gambar dari web make glide
        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(options).into(myViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_judul;
        TextView tv_deskripsi;
        TextView tv_rate;
        TextView tv_kategori;
        TextView tv_sutradara;
        ImageView img;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_judul = itemView.findViewById(R.id.judul);
            tv_deskripsi = itemView.findViewById(R.id.deskripsi);
            tv_rate = itemView.findViewById(R.id.rating);
            tv_kategori = itemView.findViewById(R.id.kategori);
            tv_sutradara = itemView.findViewById(R.id.sutradara);
            img = itemView.findViewById(R.id.thumbnail);

        }
    }
}
