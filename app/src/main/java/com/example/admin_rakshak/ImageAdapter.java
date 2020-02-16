package com.example.admin_rakshak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context context;
    private List<upload_post> list;

    public ImageAdapter(Context mcontext,List<upload_post> mlist){
        context = mcontext;
        list = mlist ;
    }

    @NonNull
    @Override
    public   ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_viewpost,parent,false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        upload_post uploadCurrent = list.get(position);
        holder.textView_Desc.setText(uploadCurrent.getDescription());
        Picasso.get()
                .load(uploadCurrent.getImageUrl())
                .fit()
                .centerCrop()
                .into(holder.image_ViewPost);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        public ImageView image_ViewPost;
        public TextView textView_Desc;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            image_ViewPost = itemView.findViewById(R.id.imageViewPost);
            textView_Desc = itemView.findViewById(R.id.textView_viewPost);
        }
    }
}
