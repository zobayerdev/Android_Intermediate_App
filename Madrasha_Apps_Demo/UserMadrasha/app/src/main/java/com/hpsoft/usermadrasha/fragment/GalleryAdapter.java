package com.hpsoft.usermadrasha.fragment;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hpsoft.usermadrasha.R;

import java.util.List;

public class GalleryAdapter  extends RecyclerView.Adapter<GalleryAdapter.GalleryViweAdapter> {

    private Context context;
    private List<String> images;

    public GalleryAdapter(Context context, List<String> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public GalleryViweAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.gallery_image,parent,false);



        return new GalleryViweAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViweAdapter holder, int position) {

        Glide.with(context).load(images.get(position)).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class  GalleryViweAdapter extends RecyclerView.ViewHolder {

        ImageView image;

        public GalleryViweAdapter(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);

        }
    }

}
